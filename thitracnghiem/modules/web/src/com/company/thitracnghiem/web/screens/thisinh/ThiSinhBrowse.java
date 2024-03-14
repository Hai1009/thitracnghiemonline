package com.company.thitracnghiem.web.screens.thisinh;

import com.haulmont.cuba.gui.actions.list.EditAction;
import com.haulmont.cuba.gui.screen.*;
import com.company.thitracnghiem.entity.ThiSinh;

import javax.inject.Named;

@UiController("thitracnghiem_ThiSinh.browse")
@UiDescriptor("thi-sinh-browse.xml")
@LookupComponent("thiSinhsTable")
@LoadDataBeforeShow
public class ThiSinhBrowse extends StandardLookup<ThiSinh> {
    @Named("thiSinhsTable.edit")
    private EditAction<ThiSinh> thiSinhsTableEdit;

    @Subscribe
    public void onInit(InitEvent event) {
        thiSinhsTableEdit.setOpenMode(OpenMode.DIALOG);
    }
}