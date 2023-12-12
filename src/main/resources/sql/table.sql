#회원 테이블
create table member (
    id varchar(50) not null,
    password varchar(100) not null,
    nickname varchar(30),
    name varchar(20),
    phone varchar(20),
    address varchar(50),
    create_date timestamp default current_timestamp not null,
    update_date timestamp,
    primary key(id)
);

#상품 테이블
create table item (
    id int auto_increment not null,
    member_id varchar(50) not null,
    category_id varchar(30),
    title varchar(50),
    price int,
    content varchar(1000),
    img varchar(200),
    sale_yn char(1),
    view_cnt int,
    create_date timestamp,
    update_date timestamp,
    primary key(id)
);

#채팅 테이블
create table chatroom (
    room_id int auto_increment not null,
    member_id varchar(50) not null,
    create_date timestamp default current_timestamp not null,
    primary key(room_id)
);

#파일 테이블
create table file (
    file_id int auto_increment not null,
    item_id int not null,
    original_name varchar(100),
    save_name varchar(600) not null,
    size int,
    represent_yn char(1),
    create_date timestamp not null,
    primary key(file_id)
);

#카테고리 테이블
create table category (
    category_id int auto_increment not null,
    name varchar(100) not null,
    primary key(category_id)
);

#상품 좋아요 테이블
create table heart (
    id int auto_increment not null,
    member_id varchar(100) not null,
    item_id int not null,
    primary key(id)
);