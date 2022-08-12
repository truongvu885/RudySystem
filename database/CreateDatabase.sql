create database rudysystem;
use rudysystem;

create table video(
                      id bigint primary key auto_increment,
                      name varchar(30) not null unique ,
                      issueDate date,
                      author varchar(30),
                      length int,
                      category varchar(30),
                      quality varchar(10),
                      price float
);

create table bookOnTape(
                           id bigint primary key auto_increment,
                           name varchar(30) not null unique ,
                           issueDate date,
                           author varchar(30),
                           length int,
                           category varchar(30),
                           price float
);

create table Furniture(
                          id bigint primary key auto_increment,
                          name varchar(30) not null unique ,
                          issueDate date,
                          author varchar(30),
                          mass float,
                          material varchar(20),
                          price float
);

create table rentVideo(
    id bigint auto_increment primary key ,
    rentDate timestamp,
    expireDate timestamp,
    totalDate int,
    totalMoney float,
    videoId bigint ,
    foreign key (videoId) references video(id)
);

create table rentBookTape(
                          id bigint primary key auto_increment,
                          rentDate timestamp,
                          expireDate timestamp,
                          totalItem int,
                          totalMoney float,
                          bookTapeId bigint ,
                          foreign key (bookTapeId) references bookontape(id)
);
create table rentFurniture(
                            id bigint primary key auto_increment,
                            rentDate timestamp,
                            expireDate timestamp,
                            totalItem int,
                            totalMoney float,
                            furnitureId bigint ,
                            foreign key (furnitureId) references furniture(id)
  );

drop database rudysystem;