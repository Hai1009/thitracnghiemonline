package com.company.thitracnghiem.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseStringIdEntity;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DdlGeneration;
import com.haulmont.cuba.core.global.UuidProvider;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@DdlGeneration(value = DdlGeneration.DbScriptGenerationMode.CREATE_ONLY)
@Table(name = "ThiSinh")
@Entity(name = "thitracnghiem_ThiSinh")
@NamePattern("%s|ten")
public class ThiSinh extends BaseStringIdEntity {
    private static final long serialVersionUID = 4352749528651436797L;
    @Id
    @Column(name = "MaTS", nullable = false, length = 10)
    private String maTS= generateMaKhoa();
    @Column(name = "DN", length = 40)
    private String dn;
    @Column(name = "HinhAnh")
    private UUID hinhAnh;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Khoa")
    private com.company.thitracnghiem.entity.Khoa khoa;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Lop")
    private com.company.thitracnghiem.entity.Lop lop;
    @Column(name = "Mess", length = 200)
    private String mess;
    @Column(name = "MK", length = 50)
    private String mk;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NgaySinh")
    private Date ngaySinh;
    @Column(name = "Quyen")
    private Boolean quyen;
    @Column(name = "Ten", length = 40)
    private String ten;
    @Column(name = "TrangThai")
    private Boolean trangThai;

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Boolean getQuyen() {
        return quyen;
    }

    public void setQuyen(Boolean quyen) {
        this.quyen = quyen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public com.company.thitracnghiem.entity.Lop getLop() {
        return lop;
    }

    public void setLop(com.company.thitracnghiem.entity.Lop lop) {
        this.lop = lop;
    }

    public com.company.thitracnghiem.entity.Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(com.company.thitracnghiem.entity.Khoa khoa) {
        this.khoa = khoa;
    }

    public UUID getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(UUID hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    @Override
    public void setId(String id) {
        this.maTS = id;
    }

    @Override
    public String getId() {
        return maTS;
    }

    public String getMaTS() {
        return maTS;
    }

    public void setMaTS(String maTS) {
        this.maTS = maTS;
    }
    private String generateMaKhoa() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}