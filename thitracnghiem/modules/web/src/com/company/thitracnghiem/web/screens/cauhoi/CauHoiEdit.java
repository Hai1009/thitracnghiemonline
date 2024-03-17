package com.company.thitracnghiem.web.screens.cauhoi;

import com.haulmont.cuba.gui.screen.*;
import com.company.thitracnghiem.entity.CauHoi;

@UiController("thitracnghiem_CauHoi.edit")
@UiDescriptor("cau-hoi-edit.xml")
@EditedEntityContainer("cauHoiDc")
@LoadDataBeforeShow
public class CauHoiEdit extends StandardEditor<CauHoi> {
}