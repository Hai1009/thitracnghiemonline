package com.company.thitracnghiem.web.screens.dethi;

import com.haulmont.cuba.gui.screen.*;
import com.company.thitracnghiem.entity.DeThi;

@UiController("thitracnghiem_DeThi.edit")
@UiDescriptor("de-thi-edit.xml")
@EditedEntityContainer("deThiDc")
@LoadDataBeforeShow
public class DeThiEdit extends StandardEditor<DeThi> {
}