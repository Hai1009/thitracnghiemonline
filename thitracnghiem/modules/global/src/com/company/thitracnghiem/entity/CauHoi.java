package com.company.thitracnghiem.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseStringIdEntity;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DdlGeneration;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@DdlGeneration(value = DdlGeneration.DbScriptGenerationMode.CREATE_ONLY)
@Table(name = "CauHoi")
@Entity(name = "thitracnghiem_CauHoi")
@NamePattern("%s|maCH")
public class CauHoi extends BaseStringIdEntity {
    private static final long serialVersionUID = -547892516656780157L;
    @Id
    @Column(name = "MaCH", nullable = false, length = 10)
    private String maCH = generateMaKhoa();
    @Column(name = "NoiDung", length = 300)
    private String noiDung;

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
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

    private String generateMaKhoa() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}