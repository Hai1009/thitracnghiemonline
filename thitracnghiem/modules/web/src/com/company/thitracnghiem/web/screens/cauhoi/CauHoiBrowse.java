package com.company.thitracnghiem.web.screens.cauhoi;

import com.company.thitracnghiem.entity.Khoa;
import com.haulmont.cuba.gui.actions.list.EditAction;
import com.haulmont.cuba.gui.screen.*;
import com.company.thitracnghiem.entity.CauHoi;

import javax.inject.Named;

@UiController("thitracnghiem_CauHoi.browse")
@UiDescriptor("cau-hoi-browse.xml")
@LookupComponent("cauHoisTable")
@LoadDataBeforeShow
public class CauHoiBrowse extends StandardLookup<CauHoi> {
    @Named("cauHoisTable.edit")
    private EditAction<Khoa> cauHoisTable;

    @Subscribe
    public void onInit(InitEvent event) { cauHoisTable.setOpenMode(OpenMode.DIALOG);
    }
}