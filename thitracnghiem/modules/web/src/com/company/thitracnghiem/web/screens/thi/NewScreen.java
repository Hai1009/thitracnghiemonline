package com.company.thitracnghiem.web.screens.thi;

import com.company.thitracnghiem.entity.CauHoi;
import com.company.thitracnghiem.entity.DapAn;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;
import java.util.List;


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

    @Subscribe
    protected void onInit(InitEvent event) {
        List<CauHoi> cauHois = loadAllCauHois();

        for (CauHoi cauHoi : cauHois) {
            createGroupBoxForQuestion(cauHoi);
            groupBoxCount++;
        }
    }

    private List<CauHoi> loadAllCauHois() {
        return dataManager.load(CauHoi.class)
                .list();
    }

    private void createGroupBoxForQuestion(CauHoi cauHoi) {
        GroupBoxLayout groupBox = uiComponents.create(GroupBoxLayout.class);
        groupBox.setCaption("Câu " + (groupBoxCount + 1));
        groupBox.setWidth("100%");

        Label<String> questionLabel = uiComponents.create(Label.TYPE_STRING);
        questionLabel.setWidth("100%");
        questionLabel.setValue(cauHoi.getNoiDung());

        groupBox.add(questionLabel);

        List<DapAn> dapAns = loadDapAnsForCauHoi(cauHoi);
        for (DapAn dapAn : dapAns) {
            Label<String> dapAnLabel = uiComponents.create(Label.TYPE_STRING);
            dapAnLabel.setWidth("100%");
            dapAnLabel.setValue(dapAn.getNoiDung());

            groupBox.add(dapAnLabel);
        }

        mainLayout.add(groupBox);
    }

    private List<DapAn> loadDapAnsForCauHoi(CauHoi cauHoi) {
        return dataManager.load(DapAn.class)
                .query("select d from thitracnghiem_DapAn d where d.maCH = :cauHoiId")
                .parameter("cauHoiId", cauHoi.getMaCH())
                .list();
    }
}