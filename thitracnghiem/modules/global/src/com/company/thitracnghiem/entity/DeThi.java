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
@Table(name = "DeThi")
@Entity(name = "thitracnghiem_DeThi")
@NamePattern("%s|maDT")
public class DeThi extends BaseStringIdEntity {
    private static final long serialVersionUID = 7413979743642832864L;
    @Id
    @Column(name = "MaDT", nullable = false, length = 10)
    private String maDT = generatemaDT();
    private String generatemaDT() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
    @Column(name = "SoLuong")
    private Integer soLuong;

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
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