insert into rf_id_log
(id, rf_id_card_no, status, last_modified)
values(1,'A1234568', 'IN', CURRENT_DATE());

insert into rf_id_log
(id, rf_id_card_no, status, last_modified)
values(2, 'E1234567', 'OUT', CURRENT_DATE());

insert into personnel
(id, name, phone_number, emergency_contact, emergency_contact_number, rf_log_id)
values(10001,'Ranga', '03024339202','Father', '01423382983', 1);
    
insert into personnel
(id, name, phone_number, emergency_contact, emergency_contact_number, rf_log_id)
values(10002, 'Ravi', '0102039202', 'Sister', '01829382981',2);

insert into role
values(1,'Admin');

insert into user
values(2, 'TRUE', '$2a$10$WI/9Yt8BgWe3R2CUbRWrUug58UOpmVT6p1kPpvbuvSXBQ02SDVpq.', 'admin');

insert into user_roles
values(2,1);