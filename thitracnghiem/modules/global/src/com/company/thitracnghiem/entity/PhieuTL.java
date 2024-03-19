package com.company.thitracnghiem.entity;

import com.haulmont.cuba.core.entity.BaseStringIdEntity;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DdlGeneration;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.*;

@DdlGeneration(value = DdlGeneration.DbScriptGenerationMode.CREATE_ONLY)
@Table(name = "PhieuTL")
@Entity(name = "thitracnghiem_PhieuTL")
public class PhieuTL extends BaseStringIdEntity {
    private static final long serialVersionUID = -3248267936066040836L;
    @Id
    @Column(name = "PhieuTLID", nullable = false, length = 10)
    private String phieuTLID = generatePhieuTLID();
    private String generatePhieuTLID() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaCH")
    private CauHoi maCH;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaDA")
    private DapAn maDA;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaTS")
    private ThiSinh maTS;

    public ThiSinh getMaTS() {
        return maTS;
    }

    public void setMaTS(ThiSinh maTS) {
        this.maTS = maTS;
    }

    public DapAn getMaDA() {
        return maDA;
    }

    public void setMaDA(DapAn maDA) {
        this.maDA = maDA;
    }

    public CauHoi getMaCH() {
        return maCH;
    }

    public void setMaCH(CauHoi maCH) {
        this.maCH = maCH;
    }

    @Override
    public void setId(String id) {
        this.phieuTLID = id;
    }

    @Override
    public String getId() {
        return phieuTLID;
    }

    public String getPhieuTLID() {
        return phieuTLID;
    }

    public void setPhieuTLID(String phieuTLID) {
        this.phieuTLID = phieuTLID;
    }
}