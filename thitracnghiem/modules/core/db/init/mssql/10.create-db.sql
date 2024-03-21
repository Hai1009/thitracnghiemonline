-- begin LOP
create table Lop (
    MaLop varchar(10),
    --
    MaKhoa varchar(10) not null,
    TenLop varchar(50),
    --
    primary key (MALOP)
)^
-- end LOP
-- begin KHOA
create table Khoa (
    MaKhoa varchar(10),
    --
    TenKhoa varchar(50),
    --
    primary key (MAKHOA)
)^
-- end KHOA
-- begin THISINH
create table ThiSinh (
    MaTS varchar(10),
    --
    DN varchar(40),
    HinhAnh uniqueidentifier,
    Khoa varchar(10) not null,
    Lop varchar(10) not null,
    Mess varchar(200),
    MK varchar(50),
    NgaySinh datetime2,
    Quyen tinyint,
    Ten varchar(40),
    TrangThai tinyint,
    --
    primary key (MATS)
)^
-- end THISINH
-- begin CAUHOI
create table CauHoi (
    MaCH varchar(10),
    --
    MaDT varchar(10),
    NoiDung varchar(300),
    --
    primary key (MACH)
)^
-- end CAUHOI
-- begin DAPAN
create table DapAn (
    MaDA varchar(10),
    --
    MaCH varchar(10) not null,
    NoiDung varchar(300),
    --
    primary key (MADA)
)^
-- end DAPAN
-- begin PHIEUTL
create table PhieuTL (
    PhieuTLID varchar(10),
    --
    MaCH varchar(10) not null,
    MaDA varchar(10) not null,
    MaTS varchar(10) not null,
    --
    primary key (PHIEUTLID)
)^
-- end PHIEUTL
-- begin DETHI
create table DeThi (
    MaDT varchar(10),
    --
    MaCH varchar(10) not null,
    SoLuong integer,
    --
    primary key (MADT)
)^
-- end DETHI
-- begin KETQUA
create table KetQua (
    MaKQ varchar(10),
    --
    Diem integer,
    MaDT varchar(10) not null,
    MaTS varchar(10) not null,
    NgayThi datetime2,
    --
    primary key (MAKQ)
)^
-- end KETQUA
