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
