package com.company.thitracnghiem.web.screens.thi;

import com.company.thitracnghiem.entity.CauHoi;
import com.company.thitracnghiem.entity.DapAn;
import com.company.thitracnghiem.entity.DeThi;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.RandomUtils;

import javax.inject.Inject;
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

    private List<CauHoi> loadCauHoisForDeThi(DeThi deThi) {
        return dataManager.load(CauHoi.class)
                .query("select c from thitracnghiem_CauHoi c where c.maDT = :maDT")
                .parameter("maDT", deThi)
                .list();
    }

    private DeThi loadRandomDeThi() {
        List<DeThi> deThis = dataManager.load(DeThi.class).list();
        int numDeThis = deThis.size();
        if (numDeThis > 0) {
            int randomIndex = RandomUtils.nextInt(0, numDeThis);
            return deThis.get(randomIndex);
        }
        return null;
    }

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
        DeThi deThi = loadRandomDeThi();
        if (deThi != null) {
            List<CauHoi> cauHois = loadCauHoisForDeThi(deThi);

            for (CauHoi cauHoi : cauHois) {
                createGroupBox(cauHoi);
                groupBoxCount++;
            }
        }
    }
}