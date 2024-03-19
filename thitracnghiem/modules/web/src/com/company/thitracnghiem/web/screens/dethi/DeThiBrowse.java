package com.company.thitracnghiem.web.screens.dethi;

import com.haulmont.cuba.gui.screen.*;
import com.company.thitracnghiem.entity.DeThi;

@UiController("thitracnghiem_DeThi.browse")
@UiDescriptor("de-thi-browse.xml")
@LookupComponent("deThisTable")
@LoadDataBeforeShow
public class DeThiBrowse extends StandardLookup<DeThi> {
}