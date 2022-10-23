SET search_path TO medical;

INSERT INTO medical_card (id, client_status, med_status, registry_dt, comment) VALUES (1, 'I', null , '2022-10-22', 'Patient1');
INSERT INTO medical_card (id, client_status, med_status, registry_dt, comment) VALUES (2, 'H', null , '2022-10-21', 'Patient2');
INSERT INTO medical_card (id, client_status, med_status, registry_dt, comment) VALUES (3, 'H', null , '2022-10-20', 'Patient3');
INSERT INTO medical_card (id, client_status, med_status, registry_dt, comment) VALUES (4, 'I',  'H' , '2022-10-19', 'Patient4');
INSERT INTO medical_card (id, client_status, med_status, registry_dt, comment) VALUES (5, 'H', null , '2022-10-18', 'Patient5');

INSERT INTO contact (id, phone_number, email, profile_link) VALUES (1, '8-999-999-99-99', 'email1@gmail.com', 'contact1.com');
INSERT INTO contact (id, phone_number, email, profile_link) VALUES (2, '8-999-999-99-99', 'email2@mail.ru', 'contact2.ru');
INSERT INTO contact (id, phone_number, email, profile_link) VALUES (3, '8-999-999-99-99', 'email3@gmail.com', 'contact3.com');
INSERT INTO contact (id, phone_number, email, profile_link) VALUES (4, '8-999-999-99-99', 'email4@gmail.com', 'contact4.com');
INSERT INTO contact (id, phone_number, email, profile_link) VALUES (5, '8-999-999-99-99', 'email5@mail.ru', 'contact5.ru');

insert into illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) values (1, 1, 6, 'M', '2022-05-22', '2022-10-20');
insert into illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) values (2, 2, 7, 'F', '2022-05-11', '2022-09-13');
insert into illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) values (3, 3, 8, 'M', '2022-05-12', '2022-07-11');
insert into illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) values (4, 4, 9, 'F', '2022-05-14', '2022-06-23');
insert into illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) values (5, 4, 10,'M', '2022-05-19', '2022-11-04');

INSERT INTO person_data (id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id) VALUES (1, 'lastName1', 'firstName1', '1980-03-27', 42, 'M', 1, 1, null);
INSERT INTO person_data (id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id) VALUES (2, 'lastName2', 'firstName2', '1999-05-10', 23, 'F', 2, 2, 1);
INSERT INTO person_data (id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id) VALUES (3, 'lastName4', 'firstName3', '1968-03-10', 54, 'M', 3, 3, null);
INSERT INTO person_data (id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id) VALUES (4, 'lastName3', 'firstName4', '1992-03-10', 30, 'F', 4, 4, 3);
INSERT INTO person_data (id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id) VALUES (5, 'lastName5', 'firstName5', '2002-03-10', 20, 'M', 5, 5, 3);

INSERT INTO address (id, contact_id, country_id, city, index, street, building, flat) VALUES (1, 1, 1, 'Moscow', 111111, 'Tverskaya', '1', '1');
INSERT INTO address (id, contact_id, country_id, city, index, street, building, flat) VALUES (2, 2, 2, 'Moscow', 111111, 'Tverskaya', '2', '2');
INSERT INTO address (id, contact_id, country_id, city, index, street, building, flat) VALUES (3, 3, 3, 'Moscow', 111111, 'Tverskaya', '3', '3');
INSERT INTO address (id, contact_id, country_id, city, index, street, building, flat) VALUES (4, 4, 4, 'Moscow', 111111, 'Tverskaya', '4', '4');
INSERT INTO address (id, contact_id, country_id, city, index, street, building, flat) VALUES (5, 5, 5, 'Moscow', 111111, 'Tverskaya', '5', '5');
INSERT INTO address (id, contact_id, country_id, city, index, street, building, flat) VALUES (6, 5, 5, 'Moscow', 111111, 'Tverskaya', '5', '5');