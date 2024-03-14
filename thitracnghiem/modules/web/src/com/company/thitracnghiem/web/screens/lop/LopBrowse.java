package com.company.thitracnghiem.web.screens.lop;

import com.haulmont.cuba.gui.actions.list.EditAction;
import com.haulmont.cuba.gui.screen.*;
import com.company.thitracnghiem.entity.Lop;

import javax.inject.Named;

@UiController("thitracnghiem_Lop.browse")
@UiDescriptor("lop-browse.xml")
@LookupComponent("lopsTable")
@LoadDataBeforeShow
public class LopBrowse extends StandardLookup<Lop> {
    @Named("lopsTable.edit")
    private EditAction<Lop> lopsTableEdit;

    @Subscribe
    public void onInit(InitEvent event) {
        lopsTableEdit.setOpenMode(OpenMode.DIALOG);
    }

}