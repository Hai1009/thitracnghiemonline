package com.company.thitracnghiem.web.screens.thi;

import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;

@UiController("thitracnghiem_ChiTietScreen")
@UiDescriptor("chi-tiet-screen.xml")
public class ChiTietScreen extends Screen {

    @Inject
    private Screens screens;

    @Subscribe("exitButton")
    protected void onExitButtonClick(Button.ClickEvent event) {
        screens.removeAll();
    }
}