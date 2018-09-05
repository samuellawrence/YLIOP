insert into rf_id_log
(id, rf_id_card_no, status, last_modified)
values(1,'A000001', 'IN', CURRENT_DATE());

insert into rf_id_log
(id, rf_id_card_no, status, last_modified)
values(2, 'A000002', 'OUT', CURRENT_DATE());

insert into rf_id_log
(id, rf_id_card_no, status, last_modified)
values(3,'A000003', 'IN', CURRENT_DATE());

insert into rf_id_log
(id, rf_id_card_no, status, last_modified)
values(4, 'A000004', 'OUT', CURRENT_DATE());


insert into rf_id_log
(id, rf_id_card_no, status, last_modified)
values(5,'A000005', 'IN', CURRENT_DATE());

insert into rf_id_log
(id, rf_id_card_no, status, last_modified)
values(6, 'A000006', 'OUT', CURRENT_DATE());


insert into rf_id_log
(id, rf_id_card_no, status, last_modified)
values(7,'A000007', 'IN', CURRENT_DATE());

insert into rf_id_log
(id, rf_id_card_no, status, last_modified)
values(8, 'A000008', 'OUT', CURRENT_DATE());


insert into rf_id_log
(id, rf_id_card_no, status, last_modified)
values(9,'A000009', 'IN', CURRENT_DATE());

insert into rf_id_log
(id, rf_id_card_no, status, last_modified)
values(10, 'A00010', 'OUT', CURRENT_DATE());

insert into personnel
(id, name, phone_number, emergency_contact, emergency_contact_number, rf_log_id)
values(10001,'Jeremy', '0902433920','Father', '0302433920', 1);
    
insert into personnel
(id, name, phone_number, emergency_contact, emergency_contact_number, rf_log_id)
values(10002, 'Emily', '0802433921', 'Sister', '0302433920',2);

insert into personnel
(id, name, phone_number, emergency_contact, emergency_contact_number, rf_log_id)
values(10003,'Yeh Yun', '0702433922','Father', '0302433920', 3);
    
insert into personnel
(id, name, phone_number, emergency_contact, emergency_contact_number, rf_log_id)
values(10004, 'Denzil', '0602433923', 'Sister', '0302433920',4);


insert into personnel
(id, name, phone_number, emergency_contact, emergency_contact_number, rf_log_id)
values(10005,'Karl', '0502433924','Father', '0302433920', 5);
    
insert into personnel
(id, name, phone_number, emergency_contact, emergency_contact_number, rf_log_id)
values(10006, 'Tze Weng', '0402433925', 'Sister', '0302433920',6);


insert into personnel
(id, name, phone_number, emergency_contact, emergency_contact_number, rf_log_id)
values(10007,'Alvin', '0302433926','Father', '0302433920', 7);
    
insert into personnel
(id, name, phone_number, emergency_contact, emergency_contact_number, rf_log_id)
values(10008, 'Jeff', '0202433927', 'Sister', '0302433920',8);

insert into personnel
(id, name, phone_number, emergency_contact, emergency_contact_number, rf_log_id)
values(10009,'Toe', '0102433928','Father', '0302433920', 9);
    
insert into personnel
(id, name, phone_number, emergency_contact, emergency_contact_number, rf_log_id)
values(10010, 'Cedric', '0302433929', 'Sister', '0302433920',10);



insert into role
values(1,'Admin');

insert into user
values(2, 'TRUE', '$2a$10$WI/9Yt8BgWe3R2CUbRWrUug58UOpmVT6p1kPpvbuvSXBQ02SDVpq.', 'admin');

insert into user_roles
values(2,1);