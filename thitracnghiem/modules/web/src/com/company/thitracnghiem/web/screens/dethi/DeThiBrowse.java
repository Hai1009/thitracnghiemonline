package com.company.thitracnghiem.web.screens.dethi;

import com.company.thitracnghiem.entity.Khoa;
import com.haulmont.cuba.gui.actions.list.EditAction;
import com.haulmont.cuba.gui.screen.*;
import com.company.thitracnghiem.entity.DeThi;

import javax.inject.Named;

@UiController("thitracnghiem_DeThi.browse")
@UiDescriptor("de-thi-browse.xml")
@LookupComponent("deThisTable")
@LoadDataBeforeShow
public class DeThiBrowse extends StandardLookup<DeThi> {
    @Named("deThisTable.edit")
    private EditAction<DeThi> deThisTableEdit;

    @Subscribe
    public void onInit(InitEvent event) { deThisTableEdit.setOpenMode(OpenMode.DIALOG);
    }
}