package com.company.thitracnghiem.entity;

import com.haulmont.cuba.core.entity.BaseStringIdEntity;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DdlGeneration;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.*;
import java.util.Date;

@DdlGeneration(value = DdlGeneration.DbScriptGenerationMode.CREATE_ONLY)
@Table(name = "PhieuTL")
@Entity(name = "thitracnghiem_PhieuTL")
public class PhieuTL extends BaseStringIdEntity {
    private static final long serialVersionUID = 2005285719503173463L;
    @Id
    @Column(name = "MaPTL", nullable = false, length = 10)
    private String maPTL = generatemaPTL();
    private String generatemaPTL() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
    @Column(name = "DapAnDaChon", length = 50)
    private String dapAnDaChon;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaCH")
    private CauHoi maCH;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaDA")
    private DapAn maDA;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaDT")
    private DeThi maDT;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NgayThi")
    private Date ngayThi;

    public Date getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(Date ngayThi) {
        this.ngayThi = ngayThi;
    }

    public DeThi getMaDT() {
        return maDT;
    }

    public void setMaDT(DeThi maDT) {
        this.maDT = maDT;
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

    public String getDapAnDaChon() {
        return dapAnDaChon;
    }

    public void setDapAnDaChon(String dapAnDaChon) {
        this.dapAnDaChon = dapAnDaChon;
    }

    @Override
    public void setId(String id) {
        this.maPTL = id;
    }

    @Override
    public String getId() {
        return maPTL;
    }

    public String getMaPTL() {
        return maPTL;
    }

    public void setMaPTL(String maPTL) {
        this.maPTL = maPTL;
    }
}