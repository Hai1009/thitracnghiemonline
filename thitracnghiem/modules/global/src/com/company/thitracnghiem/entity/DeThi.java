package com.company.thitracnghiem.entity;

import com.haulmont.cuba.core.entity.BaseStringIdEntity;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DdlGeneration;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.*;

@DdlGeneration(value = DdlGeneration.DbScriptGenerationMode.CREATE_ONLY)
@Table(name = "DeThi")
@Entity(name = "thitracnghiem_DeThi")
public class DeThi extends BaseStringIdEntity {
    private static final long serialVersionUID = 7301466720708892465L;
    @Id
    @Column(name = "MaDT", nullable = false, length = 10)
    private String maDT = generatemaDT();
    private String generatemaDT() {
        return RandomStringUtils.randomAlphanumeric(10);
    };
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaCH")
    private CauHoi maCH;
    @Column(name = "SoLuong")
    private Integer soLuong;

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public CauHoi getMaCH() {
        return maCH;
    }

    public void setMaCH(CauHoi maCH) {
        this.maCH = maCH;
    }

    @Override
    public void setId(String id) {
        this.maDT = id;
    }

    @Override
    public String getId() {
        return maDT;
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }
}