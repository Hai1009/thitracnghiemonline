package com.company.thitracnghiem.web.screens.dapan;

import com.company.thitracnghiem.entity.Khoa;
import com.haulmont.cuba.gui.actions.list.EditAction;
import com.haulmont.cuba.gui.screen.*;
import com.company.thitracnghiem.entity.DapAn;

import javax.inject.Named;

@UiController("thitracnghiem_DapAn.browse")
@UiDescriptor("dap-an-browse.xml")
@LookupComponent("dapAnsTable")
@LoadDataBeforeShow
public class DapAnBrowse extends StandardLookup<DapAn> {
    @Named("dapAnsTable.edit")
    private EditAction<Khoa> dapAnsTable;

    @Subscribe
    public void onInit(InitEvent event) { dapAnsTable.setOpenMode(OpenMode.DIALOG);
    }
}