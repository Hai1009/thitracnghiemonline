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
