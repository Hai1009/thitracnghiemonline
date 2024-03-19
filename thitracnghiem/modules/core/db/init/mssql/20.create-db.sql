-- begin LOP
alter table Lop add constraint FK_LOP_ON_MAKHOA foreign key (MAKHOA) references Khoa(MaKhoa)^
create index IDX_LOP_ON_MAKHOA on Lop (MAKHOA)^
-- end LOP
-- begin THISINH
alter table ThiSinh add constraint FK_THISINH_ON_KHOA foreign key (KHOA) references Khoa(MaKhoa)^
alter table ThiSinh add constraint FK_THISINH_ON_LOP foreign key (LOP) references Lop(MaLop)^
create index IDX_THISINH_ON_KHOA on ThiSinh (KHOA)^
create index IDX_THISINH_ON_LOP on ThiSinh (LOP)^
-- end THISINH
-- begin DAPAN
alter table DapAn add constraint FK_DAPAN_ON_MACH foreign key (MACH) references CauHoi(MaCH)^
create index IDX_DAPAN_ON_MACH on DapAn (MACH)^
-- end DAPAN
-- begin PHIEUTL
alter table PhieuTL add constraint FK_PHIEUTL_ON_MACH foreign key (MACH) references CauHoi(MaCH)^
alter table PhieuTL add constraint FK_PHIEUTL_ON_MADA foreign key (MADA) references DapAn(MaDA)^
alter table PhieuTL add constraint FK_PHIEUTL_ON_MATS foreign key (MATS) references ThiSinh(MaTS)^
create index IDX_PHIEUTL_ON_MACH on PhieuTL (MACH)^
create index IDX_PHIEUTL_ON_MADA on PhieuTL (MADA)^
create index IDX_PHIEUTL_ON_MATS on PhieuTL (MATS)^
-- end PHIEUTL
-- begin DETHI
alter table DeThi add constraint FK_DETHI_ON_MACH foreign key (MACH) references CauHoi(MaCH)^
create index IDX_DETHI_ON_MACH on DeThi (MACH)^
-- end DETHI
-- begin CAUHOI
alter table CauHoi add constraint FK_CAUHOI_ON_MADT foreign key (MADT) references DeThi(MaDT)^
create index IDX_CAUHOI_ON_MADT on CauHoi (MADT)^
-- end CAUHOI
