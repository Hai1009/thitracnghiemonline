package com.company.thitracnghiem.web.screens.thi;

import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Window;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;

@UiController("thitracnghiem_StartScreen")
@UiDescriptor("start-screen.xml")
public class StartScreen extends Screen {

    @Inject
    private ScreenBuilders screenBuilders;

    @Subscribe("button")
    protected void onButtonClick(Button.ClickEvent event) {
        screenBuilders.screen(this)
                .withScreenClass(NewScreen.class)
                .show();
    }
}