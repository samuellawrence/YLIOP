insert into personnel
values(10001,'Ranga', '03024339202','Father', '01423382983', 'E1234567');
    
insert into personnel
values(10002, 'Ravi', '0102039202', 'Sister', '01829382981','A1234568');

--
--insert into rfidlogs
--values('A1234568', 'IN', '');
--
--insert into rfidlogs
--values('E1234567', 'OUT', '');


insert into role
values(1,'Admin');

insert into user
values(2, 'TRUE', '$2a$10$WI/9Yt8BgWe3R2CUbRWrUug58UOpmVT6p1kPpvbuvSXBQ02SDVpq.', 'admin');

insert into user_roles
values(2,1);