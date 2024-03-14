package com.company.thitracnghiem.web.screens.main;

import com.haulmont.addon.helium.web.theme.HeliumThemeVariantsManager;
import com.haulmont.cuba.gui.components.Action.ActionPerformedEvent;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.main.MainScreen;
import com.vaadin.server.Page;

import javax.inject.Inject;


@UiController("extMainScreen")
@UiDescriptor("ext-main-screen.xml")
public class ExtMainScreen extends MainScreen {
    @Inject
    protected HeliumThemeVariantsManager heliumThemeVariantsManager;
    @Inject
    protected Button switchThemeModeBtn;

    @Subscribe
    protected void initMainMenu(AfterShowEvent event) {
        final HeliumThemeSwitchBtnMode currentThemeMode = HeliumThemeSwitchBtnMode
                .fromId(heliumThemeVariantsManager.loadUserAppThemeModeSettingOrDefault());
        updateHeliumSwitchBtn(currentThemeMode);
    }

    private void updateHeliumSwitchBtn(HeliumThemeSwitchBtnMode mode) {
        switchThemeModeBtn.setIconFromSet(mode.getIcon());
        switchThemeModeBtn.setStyleName(mode.getStyleName());
    }

    @Subscribe("switchThemeMode")
    protected void onSwitchThemeMode(ActionPerformedEvent event) {

        final HeliumThemeSwitchBtnMode newTargetThemeMode = newTargetThemeMode();

        heliumThemeVariantsManager.setUserAppThemeMode(newTargetThemeMode.getName());
        Page.getCurrent().reload();
        updateHeliumSwitchBtn(newTargetThemeMode);
    }

    private HeliumThemeSwitchBtnMode newTargetThemeMode() {

        return HeliumThemeSwitchBtnMode.fromId(
                heliumThemeVariantsManager
                        .getAppThemeModeList()
                        .stream()
                        .filter(mode -> !mode.equals(
                                heliumThemeVariantsManager.loadUserAppThemeModeSettingOrDefault())
                        )
                        .findFirst()
                        .orElse("light")
        );
    }
}