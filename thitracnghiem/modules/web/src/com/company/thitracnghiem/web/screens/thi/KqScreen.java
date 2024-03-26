package com.company.thitracnghiem.web.screens.thi;

import com.company.thitracnghiem.entity.DeThi;
import com.company.thitracnghiem.entity.KetQua;
import com.company.thitracnghiem.web.screens.main.ExtMainScreen;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.cuba.web.app.mainwindow.AppMainWindow;
import org.apache.commons.collections4.CollectionUtils;

import javax.inject.Inject;
import java.util.List;

@UiController("thitracnghiem_KqScreen")
@UiDescriptor("kq-screen.xml")
public class KqScreen extends Screen {
    @Inject
    private Label<String> resultLabel;

    @Inject
    private DataManager dataManager;

    @Inject
    private Screens screens;

    private KetQua ketQua(){
        return  dataManager.load(KetQua.class)
                .query("SELECT kq FROM thitracnghiem_KetQua kq ORDER BY kq.ngayThi DESC").one();
    }

    @Subscribe
    protected void onAfterShow(AfterShowEvent event) {
        resultLabel.setValue("Kết Quả: " + ketQua().getDiem());
    }

    @Subscribe("exitButton")
    protected void onExitButtonClick(Button.ClickEvent event) {
        screens.removeAll();
    }

}