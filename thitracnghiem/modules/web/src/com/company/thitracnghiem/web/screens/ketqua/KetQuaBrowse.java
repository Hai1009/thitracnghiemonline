package com.company.thitracnghiem.web.screens.ketqua;

import com.haulmont.cuba.gui.screen.*;
import com.company.thitracnghiem.entity.KetQua;

@UiController("thitracnghiem_KetQua.browse")
@UiDescriptor("ket-qua-browse.xml")
@LookupComponent("ketQuasTable")
@LoadDataBeforeShow
public class KetQuaBrowse extends StandardLookup<KetQua> {
}