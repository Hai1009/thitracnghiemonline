package com.company.thitracnghiem.web.screens.thi;

import com.company.thitracnghiem.entity.CauHoi;
import com.company.thitracnghiem.entity.DapAn;
import com.company.thitracnghiem.entity.DeThi;
import com.company.thitracnghiem.entity.KetQua;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


@UiController("thitracnghiem_")
@UiDescriptor("new-screen.xml")
public class NewScreen extends Screen {

    @Inject
    private VBoxLayout mainLayout;

    @Inject
    private DataManager dataManager;

    @Inject
    private UiComponents uiComponents;

    private int groupBoxCount = 0;
    @Inject
    private TimeSource timeSource;

    @Inject
    private ScreenBuilders screenBuilders;

    private DeThi displayedDeThi; // Đề thi được hiển thị trên màn hình

    private void displayAnswersForQuestion(GroupBoxLayout groupBox, CauHoi cauHoi) {
        List<DapAn> answers = loadDapAnsForCauHoi(cauHoi);
        RadioButtonGroup<DapAn> radioButtonGroup = uiComponents.create(RadioButtonGroup.class);
        radioButtonGroup.setOrientation(RadioButtonGroup.Orientation.VERTICAL);
        radioButtonGroup.setOptionsList(answers);
        groupBox.add(radioButtonGroup);
    }

    private List<DapAn> loadDapAnsForCauHoi(CauHoi cauHoi) {
        return dataManager.load(DapAn.class)
                .query("select d from thitracnghiem_DapAn d where d.maCH = :cauHoi")
                .parameter("cauHoi", cauHoi)
                .list();
    }

    private void createGroupBox(CauHoi cauHoi) {
        GroupBoxLayout groupBox = uiComponents.create(GroupBoxLayout.class);
        groupBox.setCaption("Câu " + (groupBoxCount + 1));
        groupBox.setWidth("100%");

        Label<String> questionLabel = uiComponents.create(Label.TYPE_STRING);
        questionLabel.setWidth("100%");
        questionLabel.setValue(cauHoi.getNoiDung());

        groupBox.add(questionLabel);

        displayAnswersForQuestion(groupBox, cauHoi);

        mainLayout.add(groupBox);
    }

    @Subscribe
    protected void onInit(InitEvent event) {
        displayedDeThi = loadRandomDeThi();
        if (displayedDeThi != null) {
            List<CauHoi> cauHois = loadCauHoisForDeThi(displayedDeThi);

            for (CauHoi cauHoi : cauHois) {
                createGroupBox(cauHoi);
                groupBoxCount++;
            }
        }
        calculateRemainingTime();
    }

    private List<CauHoi> loadCauHoisForDeThi(DeThi deThi) {
        int numberOfQuestions = deThi.getSoLuong();

        List<CauHoi> allCauHois = dataManager.load(CauHoi.class)
                .query("select c from thitracnghiem_CauHoi c where c.maDT = :maDT")
                .parameter("maDT", deThi)
                .list();

        List<CauHoi> randomCauHois = new ArrayList<>();
        if (numberOfQuestions <= allCauHois.size()) {
            List<CauHoi> shuffledCauHois = new ArrayList<>(allCauHois);
            Collections.shuffle(shuffledCauHois);
            randomCauHois = shuffledCauHois.subList(0, numberOfQuestions);
        }
        return randomCauHois;
    }

    private DeThi loadRandomDeThi() {
        List<DeThi> deThis = dataManager.load(DeThi.class).list();
        if (!deThis.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(deThis.size());
            return deThis.get(randomIndex);
        }
        return null;
    }

    @Subscribe("submitBtn")
    protected void onSubmitBtnClick(Button.ClickEvent event) {
        int diem = 0;
        for (Component component : mainLayout.getComponents()) {
            if (component instanceof GroupBoxLayout) {
                GroupBoxLayout groupBox = (GroupBoxLayout) component;
                for (Component innerComponent : groupBox.getComponents()) {
                    if (innerComponent instanceof RadioButtonGroup) {
                        RadioButtonGroup<DapAn> radioButtonGroup = (RadioButtonGroup<DapAn>) innerComponent;
                        DapAn selectedAnswer = radioButtonGroup.getValue();
                        if (selectedAnswer != null && selectedAnswer.getDapAnDung() != null && selectedAnswer.getDapAnDung()) {
                            diem++; // Tăng điểm nếu đáp án được chọn là đúng
                        }
                    }
                }
            }
        }

        // Lưu kết quả vào cơ sở dữ liệu
        if (displayedDeThi != null) {
            KetQua ketQua = dataManager.create(KetQua.class);
            ketQua.setDiem(diem);
            ketQua.setMaDT(displayedDeThi);

            ketQua.setNgayThi(timeSource.currentTimestamp());
            dataManager.commit(ketQua);
        }

        screenBuilders.screen(this)
                .withScreenClass(KqScreen.class)
                .show();
    }
    @Inject
    private TextField<String> countdownTextField;

    @Inject
    protected Timer countdownTimer;

    private int remainingTimeInSeconds;

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event) {
        calculateRemainingTime(); // Calculate the initial remaining time
        updateCountdownTextField(); // Update the countdown text field
        countdownTimer.start(); // Start the timer to update UI every second
    }

    private void calculateRemainingTime() {
        // Assuming displayedDeThi is properly initialized with the exam data
        if (displayedDeThi != null && displayedDeThi.getThoiLuongThi() != null) {
            // Extract hours, minutes, and seconds from the duration of the exam
            LocalTime thoiLuong = displayedDeThi.getThoiLuongThi().toLocalTime();
            int hours = thoiLuong.getHour();
            int minutes = thoiLuong.getMinute();
            int seconds = thoiLuong.getSecond();

            remainingTimeInSeconds = hours * 3600 + minutes * 60 + seconds;
        } else {
            remainingTimeInSeconds = 0;
        }
    }

    private void updateCountdownTextField() {
        long hours = remainingTimeInSeconds / 3600;
        long minutes = (remainingTimeInSeconds % 3600) / 60;
        long seconds = remainingTimeInSeconds % 60;

        String formattedTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        countdownTextField.setValue(formattedTime);
    }

    protected void submitAndCalculateScore() {
        int diem = 0;
        if (displayedDeThi != null) {
            KetQua ketQua = dataManager.create(KetQua.class);
            ketQua.setDiem(diem);
            ketQua.setMaDT(displayedDeThi);

            ketQua.setNgayThi(timeSource.currentTimestamp());
            dataManager.commit(ketQua);
        }

        // Chuyển sang màn hình kết quả
        screenBuilders.screen(this)
                .withScreenClass(KqScreen.class)
                .show();
    }

    @Subscribe
    public void onTimerTick(Timer source) {
        if (remainingTimeInSeconds > 0) {
            remainingTimeInSeconds--; // Decrease remaining time by 1 second
            updateCountdownTextField(); // Update the countdown text field
        } else {
            // If remaining time is zero or negative, stop the timer
            countdownTimer.stop();
            submitAndCalculateScore(); // Submit and calculate score
        }
    }
}