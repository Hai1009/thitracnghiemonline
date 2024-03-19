package com.company.thitracnghiem.web.screens.dapan;

import com.company.thitracnghiem.entity.Khoa;
import com.haulmont.cuba.gui.actions.list.EditAction;
import com.haulmont.cuba.gui.screen.*;
import com.company.thitracnghiem.entity.DapAn;

import javax.inject.Named;

@UiController("thitracnghiem_DapAn.edit")
@UiDescriptor("dap-an-edit.xml")
@EditedEntityContainer("dapAnDc")
@LoadDataBeforeShow
public class DapAnEdit extends StandardEditor<DapAn> {
}