package com.company.thitracnghiem.entity.key;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.cuba.core.entity.EmbeddableEntity;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DdlGeneration;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.util.Objects;

@DdlGeneration(value = DdlGeneration.DbScriptGenerationMode.CREATE_ONLY)
@MetaClass(name = "thitracnghiem_DeThiCompKey")
@Embeddable
public class DeThiCompKey extends EmbeddableEntity {
    private static final long serialVersionUID = -3669685590101490035L;
    @Column(name = "MaCH", nullable = false, length = 10)
    private String maCH;
    @Column(name = "MaDT", nullable = false, length = 10)
    private String maDT;

    @Override
    public int hashCode() {
        return Objects.hash(maDT, maCH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeThiCompKey entity = (DeThiCompKey) o;
        return Objects.equals(this.maDT, entity.maDT) &&
                Objects.equals(this.maCH, entity.maCH);
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public String getMaCH() {
        return maCH;
    }

    public void setMaCH(String maCH) {
        this.maCH = maCH;
    }
}