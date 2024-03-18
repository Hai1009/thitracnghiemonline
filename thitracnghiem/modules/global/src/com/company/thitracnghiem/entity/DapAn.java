package com.company.thitracnghiem.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseStringIdEntity;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DdlGeneration;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.*;

@DdlGeneration(value = DdlGeneration.DbScriptGenerationMode.CREATE_ONLY)
@Table(name = "DapAn")
@Entity(name = "thitracnghiem_DapAn")
@NamePattern("%s|noiDung")
public class DapAn extends BaseStringIdEntity {
    private static final long serialVersionUID = -1040411075326712901L;
    @Id
    @Column(name = "MaDA", nullable = false, length = 10)
    private String maDA = generateMaKhoa();
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaCH")
    private CauHoi maCH;
    @Column(name = "NoiDung", length = 300)
    private String noiDung;

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public CauHoi getMaCH() {
        return maCH;
    }

    public void setMaCH(CauHoi maCH) {
        this.maCH = maCH;
    }

    @Override
    public void setId(String id) {
        this.maDA = id;
    }

    @Override
    public String getId() {
        return maDA;
    }

    public String getMaDA() {
        return maDA;
    }

    public void setMaDA(String maDA) {
        this.maDA = maDA;
    }

    private String generateMaKhoa() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}