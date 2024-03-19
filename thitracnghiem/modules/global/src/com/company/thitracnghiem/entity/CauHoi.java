package com.company.thitracnghiem.entity;

import com.haulmont.cuba.core.entity.BaseStringIdEntity;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DdlGeneration;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.*;

@DdlGeneration(value = DdlGeneration.DbScriptGenerationMode.CREATE_ONLY)
@Table(name = "CauHoi")
@Entity(name = "thitracnghiem_CauHoi")
public class CauHoi extends BaseStringIdEntity {
    private static final long serialVersionUID = -1242403573732770675L;
    @Id
    @Column(name = "MaCH", nullable = false, length = 10)
    private String maCH= generatemaCH();
    private String generatemaCH() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaDT")
    private DeThi maDT;
    @Column(name = "NoiDung", length = 300)
    private String noiDung;

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public DeThi getMaDT() {
        return maDT;
    }

    public void setMaDT(DeThi maDT) {
        this.maDT = maDT;
    }

    @Override
    public void setId(String id) {
        this.maCH = id;
    }

    @Override
    public String getId() {
        return maCH;
    }

    public String getMaCH() {
        return maCH;
    }

    public void setMaCH(String maCH) {
        this.maCH = maCH;
    }
}