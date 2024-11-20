#
-- 数据库初始化
-- 创建库
create database if not exists hf_db;

-- 切换库
use hf_db;

-- 用户表
create table if not exists user(
    id bigint auto_increment comment 'id' primary key,
    userAccount varchar(256) not null comment '账号',
    userPassword varchar(512) not null comment '密码',
    userName varchar(256) comment '用户昵称',
    userAvatar varchar(1024) comment '用户头像',
#     userProfile varchar(512) null comment '用户简介',
    userRole tinyint default 0 not null comment '用户角色：user--0/admin--1/ban--禁用',
    createTime datetime default CURRENT_TIMESTAMP not null comment '创建时间'
#     updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
) comment '用户表';

insert into user(userAccount, userPassword, userName, userAvatar) value ("admin", "admin", "admin", null);
insert into user(userAccount, userPassword, userName, userAvatar) value ("admin1", "admin1", "admin1", null);

-- 心脏病数据
CREATE TABLE if not exists heartdata(
    `id` bigint auto_increment comment 'id' primary key,
    `name` varchar(256) not null comment '用户名',
    photo varchar(256) not null comment '电话号',
    heartDisease varchar(10) not null comment '是否有心脏病',
    BMI varchar(10) not null comment '体脂值',
    smoking varchar(10) not null comment '是否吸烟',
    drinking varchar(10) not null comment '是否饮酒',
    stroke varchar(10) not null comment '是否中风',
    physicalHealth float not null comment '物理健康天数/月',
    mentalHealth float not null comment '心理健康天数/月',
    diffWalking varchar(10) not null comment '是否能行走',
    sex ENUM('male', 'female') not null comment '性别',
    ageCategory VARCHAR(20) not null comment '年龄段',
    race VARCHAR(20) not null comment '种族',
    diabetic VARCHAR(10) not null comment '是否有糖尿病',
    physicalActivity VARCHAR(10) not null comment '是否运动过去一月内',
    genHealth VARCHAR(10) not null comment '是否运动过去一月内',
    sleepTime INT not null comment '每天的睡觉时间',
    asthma VARCHAR(10) not null comment '是否哮喘',
    kidneyDisease VARCHAR(10) not null comment '是否有肾病',
    skinCancer VARCHAR(10) not null comment '是否有皮肤癌',
    createTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null,
    `groupId` int default 0 not null comment '信息所属组，默认属于超级用户',
    isDelete enum('1', '0') default '0' not null comment '1delete;0notdelete'
) comment '心脏病数据';


INSERT INTO heartdata (`name`, `photo`, `heartDisease`, `BMI`, `smoking`, `drinking`, `stroke`, `physicalHealth`, `mentalHealth`, `diffWalking`, `sex`, `ageCategory`, `race`, `diabetic`, `physicalActivity`, `genHealth`, `sleepTime`, `asthma`, `kidneyDisease`, `skinCancer`, `createTime`, `groupId`, `isDelete`) VALUES
                                                                                                                                                                                                                                                                                                                           ('John Doe', '1234567890', 'no', '24.5', 'yes', 'no', 'no', 10.5, 15.0, 'yes', 'male', '31-45', 'Caucasian', 'no', 'yes', 'yes', 7, 'no', 'no', 'no', NOW(), 0, '0'),
                                                                                                                                                                                                                                                                                                                           ('Jane Smith', '9876543210', 'yes', '22.0', 'no', 'yes', 'no', 12.0, 16.5, 'no', 'female', '46-60', 'Asian', 'yes', 'no', 'no', 8, 'yes', 'no', 'no', NOW(), 0, '0'),
                                                                                                                                                                                                                                                                                                                           ('Alice Johnson', '1234987654', 'no', '29.0', 'yes', 'yes', 'no', 8.0, 13.5, 'no', 'female', '18-30', 'Hispanic', 'no', 'yes', 'yes', 6, 'no', 'no', 'no', NOW(), 0, '0'),
                                                                                                                                                                                                                                                                                                                           ('Bob Williams', '4561237890', 'yes', '28.5', 'no', 'no', 'yes', 9.0, 14.0, 'yes', 'male', '31-45', 'African', 'yes', 'no', 'no', 7, 'yes', 'no', 'no', NOW(), 0, '0'),
                                                                                                                                                                                                                                                                                                                           ('Charlie Brown', '6543219870', 'no', '21.5', 'no', 'yes', 'no', 11.0, 15.0, 'no', 'male', '46-60', 'Caucasian', 'no', 'yes', 'yes', 8, 'no', 'no', 'yes', NOW(), 0, '0'),
                                                                                                                                                                                                                                                                                                                           ('Diana Clark', '7890123456', 'yes', '25.0', 'yes', 'no', 'no', 10.0, 13.0, 'yes', 'female', '31-45', 'Asian', 'yes', 'no', 'yes', 9, 'no', 'yes', 'no', NOW(), 0, '0'),
                                                                                                                                                                                                                                                                                                                           ('Edward Scott', '3216549870', 'no', '27.5', 'no', 'yes', 'no', 13.0, 12.0, 'no', 'male', '18-30', 'Caucasian', 'no', 'yes', 'no', 8, 'yes', 'no', 'yes', NOW(), 0, '0'),
                                                                                                                                                                                                                                                                                                                           ('Fiona Turner', '1239876540', 'yes', '26.0', 'yes', 'yes', 'yes', 10.5, 14.5, 'yes', 'female', '46-60', 'Hispanic', 'yes', 'no', 'no', 7, 'yes', 'yes', 'no', NOW(), 0, '0'),
                                                                                                                                                                                                                                                                                                                           ('George Harris', '5678901234', 'no', '23.5', 'no', 'no', 'no', 9.5, 16.0, 'no', 'male', '31-45', 'African', 'no', 'yes', 'yes', 7, 'no', 'no', 'no', NOW(), 0, '0'),
                                                                                                                                                                                                                                                                                                                           ('Hannah King', '7896541230', 'no', '30.0', 'yes', 'yes', 'yes', 12.0, 13.0, 'yes', 'female', '31-45', 'Caucasian', 'no', 'no', 'no', 6, 'no', 'no', 'yes', NOW(), 0, '0'),
                                                                                                                                                                                                                                                                                                                           ('Ivy Lee', '6549873210', 'yes', '22.0', 'no', 'no', 'no', 11.5, 12.5, 'no', 'female', '60+', 'Asian', 'yes', 'yes', 'no', 8, 'yes', 'no', 'no', NOW(), 0, '0'),
                                                                                                                                                                                                                                                                                                                           ('Jack Walker', '3219876540', 'no', '20.5', 'no', 'yes', 'no', 10.0, 14.0, 'no', 'male', '46-60', 'Hispanic', 'no', 'yes', 'no', 9, 'no', 'no', 'no', NOW(), 0, '0'),
                                                                                                                                                                                                                                                                                                                           ('Kathy Adams', '2345678901', 'yes', '31.0', 'yes', 'no', 'no', 13.5, 14.5, 'yes', 'female', '18-30', 'African', 'yes', 'no', 'yes', 8, 'no', 'no', 'no', NOW(), 0, '0'),
                                                                                                                                                                                                                                                                                                                           ('Leo Carter', '5671238901', 'no', '27.0', 'yes', 'yes', 'no', 12.0, 16.0, 'no', 'male', '31-45', 'Caucasian', 'no', 'yes', 'no', 7, 'yes', 'no', 'no', NOW(), 0, '0'),
                                                                                                                                                                                                                                                                                                                           ('Zoe Martin', '1112223334', 'yes', '26.5', 'no', 'yes', 'no', 9.5, 13.5, 'yes', 'female', '31-45', 'Hispanic', 'no', 'yes', 'yes', 7, 'no', 'no', 'no', NOW(), 0, '0');


-- 查询健康与不健康人数
SELECT
    SUM(CASE WHEN heartdisease = 'no' THEN 1 ELSE 0 END) AS total_no,
    SUM(CASE WHEN heartdisease = 'yes' THEN 1 ELSE 0 END) AS total_yes
FROM heartdata;
-- 查询最新20条
SELECT * FROM heartdata ORDER BY createTime,id DESC LIMIT 20;