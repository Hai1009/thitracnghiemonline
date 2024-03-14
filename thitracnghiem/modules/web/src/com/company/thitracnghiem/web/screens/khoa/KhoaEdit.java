package com.company.thitracnghiem.web.screens.khoa;

import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.components.ValidationException;
import com.haulmont.cuba.gui.screen.*;
import com.company.thitracnghiem.entity.Khoa;

import javax.inject.Inject;
import java.util.regex.Pattern;

@UiController("thitracnghiem_Khoa.edit")
@UiDescriptor("khoa-edit.xml")
@EditedEntityContainer("khoaDc")
@LoadDataBeforeShow
public class KhoaEdit extends StandardEditor<Khoa> {
}