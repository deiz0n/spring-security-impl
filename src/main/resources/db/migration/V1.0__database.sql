CREATE TABLE tb_user(
    id varchar(255) primary key not null,
    name varchar(255) not null unique,
    role varchar(255) not null
);

CREATE TABLE tb_product(
   id varchar(255) primary key not null,
   name varchar(255) not null unique,
   price decimal not null
);
