create database seedlingshop;,
USE seedlingshop;
CREATE TABLE roles(
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(255)
) ENGINE=INNODB;
CREATE TABLE accounts(
	username VARCHAR(50) primary key ,
	password VARCHAR(32),
	status INT
);
CREATE TABLE infomations(
    id VARCHAR(10) PRIMARY KEY NOT NULL,
    fistname TEXT,
    lastname TEXT,
    address TEXT,
    phone VARCHAR(10),
    email VARCHAR(255),
    username VARCHAR(50),
    FOREIGN KEY (username) REFERENCES accounts(username)
);
CREATE TABLE roleUsers(
    id INT PRIMARY KEY AUTO_INCREMENT,
    role VARCHAR(10),
    username VARCHAR(50),
    FOREIGN KEY(role) REFERENCES roles(id),
    FOREIGN KEY(username) REFERENCES accounts(username)
);
CREATE TABLE carts(
    id INT PRIMARY KEY AUTO_INCREMENT,
    user VARCHAR(10)

);
CREATE TABLE farms(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    phone VARCHAR(10),
    logo VARCHAR(255),
    iddistrict int,
    address VARCHAR(255),
    user VARCHAR(10),
    metaname VARCHAR(155),
    FOREIGN KEY(user) REFERENCES infomations(id)
);
CREATE TABLE species(
    id CHAR(10) PRIMARY KEY,
    name TEXT,
    metaname TEXT
);
CREATE TABLE seedlings(
    id VARCHAR(10) PRIMARY KEY,
    name TEXT,
    species CHAR(10),
    farm INT,
    price FLOAT,
    metaname TEXT,
    viewcount INT,
    promtionPrice FLOAT,
    img TEXT,
    moreimg TEXT,
    datecreate DATE,
    care TEXT,
    characteristic TEXT,
    FOREIGN KEY(species) REFERENCES species(id),
    FOREIGN KEY(farm) REFERENCES farms(id)
);
CREATE TABLE detailCarts(
    id INT PRIMARY KEY AUTO_INCREMENT,
    cart INT,
    seedling VARCHAR(10),
    count INT, 
    status INT,
    FOREIGN KEY (seedling) REFERENCES seedlings(id),
        FOREIGN KEY(cart) REFERENCES carts(id)
);
CREATE TABLE rates(
    id INT  PRIMARY KEY AUTO_INCREMENT,
    seedling VARCHAR(10),
    rate FLOAT,
    data DATE,
    content TEXT,
    FOREIGN KEY(seedling) REFERENCES seedlings(id)
) ;
CREATE TABLE feedbacks(
    id INT  PRIMARY KEY AUTO_INCREMENT,
    farm INT,
    image TEXT,
    content TEXT,
    moreimg TEXT,
    FOREIGN KEY(farm) REFERENCES farms(id)
) ;
CREATE TABLE comments(
    id INT  PRIMARY KEY AUTO_INCREMENT,
    seedling VARCHAR(10),
    iduser VARCHAR(10),
    content TEXT,
    FOREIGN KEY(seedling) REFERENCES seedlings(id)
) ;
CREATE TABLE Orders(
    id INT  PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    phone VARCHAR(10),
    address VARCHAR(250),
    date DATE,
    status INT,
    note varchar(255)
) ;

CREATE TABLE detailOrders(
    id INT PRIMARY KEY AUTO_INCREMENT,
    orderid INT,
    seedling VARCHAR(10),
    count INT,
    totalprice FLOAT,
    FOREIGN KEY(orderid) REFERENCES Orders(id),
    FOREIGN KEY(seedling) REFERENCES seedlings(id)
) ;
INSERT INTO `accounts`(`username`, `password`, `status`) VALUES 
('admin','21232f297a57a5a743894a0e4a801fc3',1),
('tvdan','21232f297a57a5a743894a0e4a801fc3',1),
('nhang','21232f297a57a5a743894a0e4a801fc3',1),
('lngoan','21232f297a57a5a743894a0e4a801fc3',1),
('ttinh','21232f297a57a5a743894a0e4a801fc3',1);
INSERT INTO `infomations` (`id`, `fistname`, `lastname`, `address`, `phone`, `email`, `username`) VALUES 
('100000001', 'Thai', 'Dan', 'nam thien- duong thuy- le thuy- quang binh', '0863219876', 'tvdan@gmail.com', 'tvdan'),
('100000002', 'le', 'Thanh tinh', 'thanh chuong - nghe an', '0932683251', 'lkhuyen@gmail.com', 'ttinh');
INSERT INTO `farms` (`id`, `name`, `phone`, `address`, `user`, `metaname`) VALUES 
(NULL, 'Trung tam cay giong Tuan Tran', '0987326271', 'hung thuy-le thuy-quang binh', '100000001', 'trung-tam-cay-giong-tuan-tran'),
(NULL, 'Trung tam cay giong Nam Nhung', '0932973562', 'mai thuy-le thuy-quang binh', '100000002', 'trung-tam-cay-giong-Nam-Nhung');
INSERT INTO `species` (`id`, `name`, `metaname`) VALUES ('NHAN', 'Nhãn', 'nhan'),
('MIT', 'Mít', 'mit'), 
('BO', 'Bơ', 'bo'),
('XOAI', 'Xoài', 'xoai'),
('OI', 'Ổi', 'oi'), 
('CAM', 'Cam', 'cam'),
('BUOI', 'Bưởi', 'buoi'), 
('MAM', 'Mận', 'man'), 
('NA', 'Na', 'na'), 
('MANGCUT', 'Măng cụt', 'mang-cut'),
('CHOMCHOM', 'Chôm chôm', 'chom-chom');
INSERT INTO `seedlings` (`id`, `name`, `species`, `farm`, `price`, `metaname`, `viewcount`, `promtionPrice`, `img`, `moreimg`, `datecreate`, `characteristic`) VALUES 
('1000000001', 'nhãn không hạt hưng yên', 'NHAN', '1', '50000', 'nhan-khong-hat-hung-yen', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'cai ni taocung chịu thôi'), 
('1000000002', 'nhãn muộn hưng yên', 'NHAN', '1', '50000', 'nhan-muon-hung-yen', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'tao chịu'),
('1000000003', 'nhãn bò', 'NHAN', '1', '50000', 'nhan-bo', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'cai ni taocung chịu thôi'),
('1000000004', 'nhãn thái', 'NHAN', '1', '50000', 'nhan-thai', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'cai ni taocung chịu thôi'),
('1000000005', 'nhãn tim', 'NHAN', '1', '50000', 'nhan-tim', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'cai ni taocung chịu thôi'),
('1000000006', 'nhãn sớm hưng yên', 'NHAN', '1', '50000', 'nhan-som-hung-yen', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'cai ni taocung chịu thôi'),
('1000000007', 'nhãn Idor', 'NHAN', '1', '50000', 'nhan-idor', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'cai ni taocung chịu thôi'),
('1000000008', 'nhãn Choai', 'NHAN', '1', '50000', 'nhan-choai', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'cai ni taocung chịu thôi'),
('1000000009', 'Thanhnhãn ', 'NHAN', '1', '50000', 'thanh-nhan', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'cai ni taocung chịu thôi'),
('1000000010', 'nhãn xường tím', 'NHAN', '1', '50000', 'nhan-xuong-tim', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'cai ni taocung chịu thôi'),
('1000000011', 'nhãn hồng phúc', 'NHAN', '1', '50000', 'nhan-hong-phuc', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'tao chịu'),
('1000000012', 'Chôm chôm dính', 'CHOMCHOM', '1', '50000', 'chom-chom-dinh', '0', NULL, 'chomchomdinh.jpg', NULL, NULL, 'tao khong biết gì'),
('1000000013', 'Chôm chôm Nhãn', 'CHOMCHOM', '1', '50000', 'chom-chom-nhan', '0', NULL, 'chomchomdinh.jpg', NULL, NULL, 'tao khong biết gì'), 
('1000000014', 'Chôm chôm Thái', 'CHOMCHOM', '1', '50000', 'chom-chom-thai', '0', NULL, 'chomchomdinh.jpg', NULL, NULL, 'tao khong biết gì'), 
('1000000015', 'Chôm chôm tróc', 'CHOMCHOM', '1', '50000', 'chom-chom-troc', '0', NULL, 'chomchomdinh.jpg', NULL, NULL, 'tao khong biết gì'),
('1000000017', 'Mít linh viên', 'MIT', '1', '50000', 'mit-linh-vien', '0', NULL, 'mitkhonghat.jfif', NULL, '2021-10-24', 'không biets gì hế'),
('1000000018', 'Mít nghệ', 'MIT', '1', '50000', 'mit-nghe', '0', NULL, 'mitkhonghat.jfif', NULL, '2021-10-24', 'không biets gì hế'),
('1000000019', 'Mít tố nữ', 'MIT', '1', '50000', 'mit-to-nu', '0', NULL, 'mitkhonghat.jfif', NULL, '2021-10-24', 'không biets gì hế'),
('1000000020', 'Mít thái', 'MIT', '1', '50000', 'mit-thai', '0', NULL, 'mitkhonghat.jfif', NULL, '2021-10-24', 'không biets gì hế'),
('1000000021', 'Mít tứ quý', 'MIT', '1', '50000', 'mit-tu-quy', '0', NULL, 'mitkhonghat.jfif', NULL, '2021-10-24', 'không biets gì hế'),
('1000000022', 'Mít ruột đỏ', 'MIT', '1', '50000', 'mit-ruot-do', '0', NULL, 'mitkhonghat.jfif', NULL, '2021-10-24', 'không biets gì hế'),
('1000000023', 'Xoài cát chu', 'XOAI', '1', '50000', 'xoai-cat-chu', '0', NULL, 'xoaicatchu.jpg', NULL, '2021-10-24', 'tao ạ mày luôn'), 
('1000000024', 'xoài cát hòa lộc', 'XOAI', '1', '50000', 'xoai-cat-hoa-loc', '0', NULL, 'xoaicatchu.jpg', NULL, '2021-10-24', 'tao không biết gì hết'),
('1000000025', 'Xoài đài loan', 'XOAI', '1', '50000', 'xoai-dai-loan', '0', NULL, 'xoaicatchu.jpg', NULL, '2021-10-24', 'tao ạ mày luôn'),
('1000000026', 'Xoài hạt lép', 'XOAI', '1', '50000', 'xoai-hat-lep', '0', NULL, 'xoaicatchu.jpg', NULL, '2021-10-24', 'tao ạ mày luôn'),
('1000000027', 'Xoài keo', 'XOAI', '1', '50000', 'xoai-keo', '0', NULL, 'xoaicatchu.jpg', NULL, '2021-10-24', 'tao ạ mày luôn'),
('1000000028', 'Xoài thái', 'XOAI', '1', '50000', 'xoai-thai', '0', NULL, 'xoaicatchu.jpg', NULL, '2021-10-24', 'tao ạ mày luôn'),
('1000000029', 'Xoài thanh ca', 'XOAI', '1', '50000', 'xoai-thanh-ca', '0', NULL, 'xoaicatchu.jpg', NULL, '2021-10-24', 'tao ạ mày luôn'),
('1000000030', 'Xoài tượng', 'XOAI', '1', '50000', 'xoai-tuong', '0', NULL, 'xoaicatchu.jpg', NULL, '2021-10-24', 'tao ạ mày luôn'),
('1000000031', 'Xoài tứ quý', 'XOAI', '1', '50000', 'xoai-tu-quy', '0', NULL, 'xoaicatchu.jpg', NULL, '2021-10-24', 'tao ạ mày luôn'),
('1000000032', 'xoài úc', 'XOAI', '1', '50000', 'xoai-uc', '0', NULL, 'xoaicatchu.jpg', NULL, '2021-10-24', 'tao không biết gì hết'),
('1000000035', 'Bơ Booth', 'BO', '1', '50000', 'bo-booth', '0', NULL, '034dai.jfif', NULL, '2021-10-24', 'chua có dữ liệu'), 
('1000000036', 'Bơ Cuba m3', 'BO', '1', '50000', 'bo-cuba-m3', '0', NULL, '034dai.jfif', NULL, '2021-10-24', 'chua có dữ liệu'), 
('1000000037', 'Bơ hass', 'BO', '1', '50000', 'bo-hass', '0', NULL, '034dai.jfif', NULL, '2021-10-24', 'chua có dữ liệu'), 
('1000000038', 'Bơ pinkerton', 'BO', '1', '50000', 'bo-pinkerton', '0', NULL, '034dai.jfif', NULL, '2021-10-24', 'chua có dữ liệu'), 
('1000000039', 'Bơ reed', 'BO', '1', '50000', 'bo-reed', '0', NULL, '034dai.jfif', NULL, '2021-10-24', 'chua có dữ liệu'), 
('1000000040', 'Bơ sáp mã đường', 'BO', '1', '50000', 'bo-sap-ma-duong', '0', NULL, '034dai.jfif', NULL, '2021-10-24', 'chua có dữ liệu'), 
('1000000041', 'Bơ thanh bích', 'BO', '1', '50000', 'bo-thanh-bich', '0', NULL, '034dai.jfif', NULL, '2021-10-24', 'chua có dữ liệu'), 
('1000000042', 'Bơ ta 21', 'BO', '1', '50000', 'bo-ta-21', '0', NULL, '034dai.jfif', NULL, '2021-10-24', 'chua có dữ liệu');
