package com.company.thitracnghiem.web.screens.khoa;

import com.haulmont.cuba.gui.actions.list.EditAction;
import com.haulmont.cuba.gui.screen.*;
import com.company.thitracnghiem.entity.Khoa;

import javax.inject.Named;

@UiController("thitracnghiem_Khoa.browse")
@UiDescriptor("khoa-browse.xml")
@LookupComponent("khoasTable")
@LoadDataBeforeShow
public class KhoaBrowse extends StandardLookup<Khoa> {
    @Named("khoasTable.edit")
    private EditAction<Khoa> khoasTableEdit;

    @Subscribe
    public void onInit(InitEvent event) { khoasTableEdit.setOpenMode(OpenMode.DIALOG);
    }

}