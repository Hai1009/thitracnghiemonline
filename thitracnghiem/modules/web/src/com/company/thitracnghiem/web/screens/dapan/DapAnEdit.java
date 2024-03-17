package com.company.thitracnghiem.web.screens.dapan;

import com.haulmont.cuba.gui.screen.*;
import com.company.thitracnghiem.entity.DapAn;

@UiController("thitracnghiem_DapAn.edit")
@UiDescriptor("dap-an-edit.xml")
@EditedEntityContainer("dapAnDc")
@LoadDataBeforeShow
public class DapAnEdit extends StandardEditor<DapAn> {
}