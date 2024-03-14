package com.company.thitracnghiem.web.screens.lop;

import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.components.ValidationException;
import com.haulmont.cuba.gui.screen.*;
import com.company.thitracnghiem.entity.Lop;

import javax.inject.Inject;
import java.util.regex.Pattern;

@UiController("thitracnghiem_Lop.edit")
@UiDescriptor("lop-edit.xml")
@EditedEntityContainer("lopDc")
@LoadDataBeforeShow
public class LopEdit extends StandardEditor<Lop> {
    @Inject
    private TextField<String> tenLopField;

    @Subscribe
    private void onInit(InitEvent event) {
        tenLopField.addValidator(value -> {
            if (value != null && !value.isEmpty()) {
                String pattern = "^[a-zA-Z0-9]+$";
                if (!Pattern.matches(pattern, value)) {
                    throw new ValidationException("Only numbers and character(upper/lower) are allowed");
                }
            }
        });
    }

}