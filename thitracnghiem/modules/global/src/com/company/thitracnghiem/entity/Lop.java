package com.company.thitracnghiem.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseStringIdEntity;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DdlGeneration;
import com.haulmont.cuba.core.global.UuidProvider;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.*;

@DdlGeneration(value = DdlGeneration.DbScriptGenerationMode.CREATE_ONLY)
@Table(name = "Lop")
@Entity(name = "thitracnghiem_Lop")
@NamePattern("%s|tenLop")
public class Lop extends BaseStringIdEntity {
    private static final long serialVersionUID = 3410318639069980890L;
    @Id
    @Column(name = "MaLop", nullable = false, length = 10)
    private String maLop= generateMaKhoa();
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaKhoa")
    private Khoa maKhoa;
    @Column(name = "TenLop", length = 50)
    private String tenLop;

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public Khoa getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(Khoa maKhoa) {
        this.maKhoa = maKhoa;
    }

    @Override
    public void setId(String id) {
        this.maLop = id;
    }

    @Override
    public String getId() {
        return maLop;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    private String generateMaKhoa() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}