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
INSERT INTO `species` (`id`, `name`, `metaname`) VALUES ('NHAN', 'Nh??n', 'nhan'),
('MIT', 'M??t', 'mit'), 
('BO', 'B??', 'bo'),
('XOAI', 'Xo??i', 'xoai'),
('OI', '???i', 'oi'), 
('CAM', 'Cam', 'cam'),
('BUOI', 'B?????i', 'buoi'), 
('MAM', 'M???n', 'man'), 
('NA', 'Na', 'na'), 
('MANGCUT', 'M??ng c???t', 'mang-cut'),
('CHOMCHOM', 'Ch??m ch??m', 'chom-chom');
INSERT INTO `seedlings` (`id`, `name`, `species`, `farm`, `price`, `metaname`, `viewcount`, `promtionPrice`, `img`, `moreimg`, `datecreate`, `characteristic`) VALUES 
('1000000001', 'nh??n kh??ng h???t h??ng y??n', 'NHAN', '1', '50000', 'nhan-khong-hat-hung-yen', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'cai ni taocung ch???u th??i'), 
('1000000002', 'nh??n mu???n h??ng y??n', 'NHAN', '1', '50000', 'nhan-muon-hung-yen', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'tao ch???u'),
('1000000003', 'nh??n b??', 'NHAN', '1', '50000', 'nhan-bo', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'cai ni taocung ch???u th??i'),
('1000000004', 'nh??n th??i', 'NHAN', '1', '50000', 'nhan-thai', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'cai ni taocung ch???u th??i'),
('1000000005', 'nh??n tim', 'NHAN', '1', '50000', 'nhan-tim', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'cai ni taocung ch???u th??i'),
('1000000006', 'nh??n s???m h??ng y??n', 'NHAN', '1', '50000', 'nhan-som-hung-yen', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'cai ni taocung ch???u th??i'),
('1000000007', 'nh??n Idor', 'NHAN', '1', '50000', 'nhan-idor', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'cai ni taocung ch???u th??i'),
('1000000008', 'nh??n Choai', 'NHAN', '1', '50000', 'nhan-choai', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'cai ni taocung ch???u th??i'),
('1000000009', 'Thanhnh??n ', 'NHAN', '1', '50000', 'thanh-nhan', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'cai ni taocung ch???u th??i'),
('1000000010', 'nh??n x?????ng t??m', 'NHAN', '1', '50000', 'nhan-xuong-tim', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'cai ni taocung ch???u th??i'),
('1000000011', 'nh??n h???ng ph??c', 'NHAN', '1', '50000', 'nhan-hong-phuc', '0', NULL, 'thanhnhan.jpg', NULL, '2021-10-24', 'tao ch???u'),
('1000000012', 'Ch??m ch??m d??nh', 'CHOMCHOM', '1', '50000', 'chom-chom-dinh', '0', NULL, 'chomchomdinh.jpg', NULL, NULL, 'tao khong bi???t g??'),
('1000000013', 'Ch??m ch??m Nh??n', 'CHOMCHOM', '1', '50000', 'chom-chom-nhan', '0', NULL, 'chomchomdinh.jpg', NULL, NULL, 'tao khong bi???t g??'), 
('1000000014', 'Ch??m ch??m Th??i', 'CHOMCHOM', '1', '50000', 'chom-chom-thai', '0', NULL, 'chomchomdinh.jpg', NULL, NULL, 'tao khong bi???t g??'), 
('1000000015', 'Ch??m ch??m tr??c', 'CHOMCHOM', '1', '50000', 'chom-chom-troc', '0', NULL, 'chomchomdinh.jpg', NULL, NULL, 'tao khong bi???t g??'),
('1000000017', 'M??t linh vi??n', 'MIT', '1', '50000', 'mit-linh-vien', '0', NULL, 'mitkhonghat.jfif', NULL, '2021-10-24', 'kh??ng biets g?? h???'),
('1000000018', 'M??t ngh???', 'MIT', '1', '50000', 'mit-nghe', '0', NULL, 'mitkhonghat.jfif', NULL, '2021-10-24', 'kh??ng biets g?? h???'),
('1000000019', 'M??t t??? n???', 'MIT', '1', '50000', 'mit-to-nu', '0', NULL, 'mitkhonghat.jfif', NULL, '2021-10-24', 'kh??ng biets g?? h???'),
('1000000020', 'M??t th??i', 'MIT', '1', '50000', 'mit-thai', '0', NULL, 'mitkhonghat.jfif', NULL, '2021-10-24', 'kh??ng biets g?? h???'),
('1000000021', 'M??t t??? qu??', 'MIT', '1', '50000', 'mit-tu-quy', '0', NULL, 'mitkhonghat.jfif', NULL, '2021-10-24', 'kh??ng biets g?? h???'),
('1000000022', 'M??t ru???t ?????', 'MIT', '1', '50000', 'mit-ruot-do', '0', NULL, 'mitkhonghat.jfif', NULL, '2021-10-24', 'kh??ng biets g?? h???'),
('1000000023', 'Xo??i c??t chu', 'XOAI', '1', '50000', 'xoai-cat-chu', '0', NULL, 'xoaicatchu.jpg', NULL, '2021-10-24', 'tao ??? m??y lu??n'), 
('1000000024', 'xo??i c??t h??a l???c', 'XOAI', '1', '50000', 'xoai-cat-hoa-loc', '0', NULL, 'xoaicatchu.jpg', NULL, '2021-10-24', 'tao kh??ng bi???t g?? h???t'),
('1000000025', 'Xo??i ????i loan', 'XOAI', '1', '50000', 'xoai-dai-loan', '0', NULL, 'xoaicatchu.jpg', NULL, '2021-10-24', 'tao ??? m??y lu??n'),
('1000000026', 'Xo??i h???t l??p', 'XOAI', '1', '50000', 'xoai-hat-lep', '0', NULL, 'xoaicatchu.jpg', NULL, '2021-10-24', 'tao ??? m??y lu??n'),
('1000000027', 'Xo??i keo', 'XOAI', '1', '50000', 'xoai-keo', '0', NULL, 'xoaicatchu.jpg', NULL, '2021-10-24', 'tao ??? m??y lu??n'),
('1000000028', 'Xo??i th??i', 'XOAI', '1', '50000', 'xoai-thai', '0', NULL, 'xoaicatchu.jpg', NULL, '2021-10-24', 'tao ??? m??y lu??n'),
('1000000029', 'Xo??i thanh ca', 'XOAI', '1', '50000', 'xoai-thanh-ca', '0', NULL, 'xoaicatchu.jpg', NULL, '2021-10-24', 'tao ??? m??y lu??n'),
('1000000030', 'Xo??i t?????ng', 'XOAI', '1', '50000', 'xoai-tuong', '0', NULL, 'xoaicatchu.jpg', NULL, '2021-10-24', 'tao ??? m??y lu??n'),
('1000000031', 'Xo??i t??? qu??', 'XOAI', '1', '50000', 'xoai-tu-quy', '0', NULL, 'xoaicatchu.jpg', NULL, '2021-10-24', 'tao ??? m??y lu??n'),
('1000000032', 'xo??i ??c', 'XOAI', '1', '50000', 'xoai-uc', '0', NULL, 'xoaicatchu.jpg', NULL, '2021-10-24', 'tao kh??ng bi???t g?? h???t'),
('1000000035', 'B?? Booth', 'BO', '1', '50000', 'bo-booth', '0', NULL, '034dai.jfif', NULL, '2021-10-24', 'chua c?? d??? li???u'), 
('1000000036', 'B?? Cuba m3', 'BO', '1', '50000', 'bo-cuba-m3', '0', NULL, '034dai.jfif', NULL, '2021-10-24', 'chua c?? d??? li???u'), 
('1000000037', 'B?? hass', 'BO', '1', '50000', 'bo-hass', '0', NULL, '034dai.jfif', NULL, '2021-10-24', 'chua c?? d??? li???u'), 
('1000000038', 'B?? pinkerton', 'BO', '1', '50000', 'bo-pinkerton', '0', NULL, '034dai.jfif', NULL, '2021-10-24', 'chua c?? d??? li???u'), 
('1000000039', 'B?? reed', 'BO', '1', '50000', 'bo-reed', '0', NULL, '034dai.jfif', NULL, '2021-10-24', 'chua c?? d??? li???u'), 
('1000000040', 'B?? s??p m?? ???????ng', 'BO', '1', '50000', 'bo-sap-ma-duong', '0', NULL, '034dai.jfif', NULL, '2021-10-24', 'chua c?? d??? li???u'), 
('1000000041', 'B?? thanh b??ch', 'BO', '1', '50000', 'bo-thanh-bich', '0', NULL, '034dai.jfif', NULL, '2021-10-24', 'chua c?? d??? li???u'), 
('1000000042', 'B?? ta 21', 'BO', '1', '50000', 'bo-ta-21', '0', NULL, '034dai.jfif', NULL, '2021-10-24', 'chua c?? d??? li???u');
