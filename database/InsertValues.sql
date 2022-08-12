use rudysystem;
select * from video;
select * from bookontape;
select * from furniture;

insert into video( name, issuedate, author, length, category, quality, price)
values ('java spring','2021-08-10','Truong',60,'abczyz','1080',5);

insert into bookontape(name, issuedate, author, length, category, price)
values ('English','2021-08-10','Truong',60,'abczyz',4);

insert into furniture(name, issuedate, author, mass,material, price)
values ('book','2021-08-10','Truong',2.3,'wood',2);

 insert into rentvideo(rentdate, expiredate, totaldate, totalmoney, videoid)  values('2022-08-12 15:49:32.872','2022-08-17 15:49:32.872',5,250.0,3);
