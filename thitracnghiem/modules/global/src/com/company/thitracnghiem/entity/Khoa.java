package com.company.thitracnghiem.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseStringIdEntity;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DdlGeneration;
import com.haulmont.cuba.core.global.UuidProvider;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@DdlGeneration(value = DdlGeneration.DbScriptGenerationMode.CREATE_ONLY)
@Table(name = "Khoa")
@Entity(name = "thitracnghiem_Khoa")
@NamePattern("%s|tenKhoa")
public class Khoa extends BaseStringIdEntity {
    private static final long serialVersionUID = -1272955764411444485L;
    @Id
    @Column(name = "MaKhoa", nullable = false, length = 10)
    private String maKhoa = generateMaKhoa();
    @Column(name = "TenKhoa", length = 50)
    private String tenKhoa;

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    @Override
    public void setId(String id) {
        this.maKhoa = id;
    }

    @Override
    public String getId() {
        return maKhoa;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }
    private String generateMaKhoa() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}