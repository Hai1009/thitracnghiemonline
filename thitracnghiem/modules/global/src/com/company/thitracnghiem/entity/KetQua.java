package com.company.thitracnghiem.entity;

import com.haulmont.cuba.core.entity.BaseStringIdEntity;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DdlGeneration;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.*;
import java.util.Date;

@DdlGeneration(value = DdlGeneration.DbScriptGenerationMode.CREATE_ONLY)
@Table(name = "KetQua")
@Entity(name = "thitracnghiem_KetQua")
public class KetQua extends BaseStringIdEntity {
    private static final long serialVersionUID = -5865649328861881051L;
    @Id
    @Column(name = "MaKQ", nullable = false, length = 10)
    private String maKQ = generatemaKQ();
    private String generatemaKQ() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
    @Column(name = "Diem")
    private Integer diem;

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

    public Integer getDiem() {
        return diem;
    }

    public void setDiem(Integer diem) {
        this.diem = diem;
    }

    @Override
    public void setId(String id) {
        this.maKQ = id;
    }

    @Override
    public String getId() {
        return maKQ;
    }

    public String getMaKQ() {
        return maKQ;
    }

    public void setMaKQ(String maKQ) {
        this.maKQ = maKQ;
    }
}