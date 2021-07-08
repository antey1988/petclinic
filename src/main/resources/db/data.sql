INSERT INTO specialties VALUES (1, 'radiology');
INSERT INTO specialties VALUES (2, 'surgery');
INSERT INTO specialties VALUES (3, 'dentistry');

INSERT INTO vets VALUES (1, 'Ivan', 'Ivanov');
INSERT INTO vets VALUES (2, 'Igor', 'Sidorov');
INSERT INTO vets VALUES (3, 'Igor', 'Kosov');
INSERT INTO vets VALUES (4, 'Evgenia', 'Sergeeva');
INSERT INTO vets VALUES (5, 'Olga', 'Petrova');
INSERT INTO vets VALUES (6, 'Irina', 'Bondarenko');

INSERT INTO vets_specialties (vet_id, specialty_id) VALUES (1, 1);
INSERT INTO vets_specialties (vet_id, specialty_id) VALUES (2, 1);
INSERT INTO vets_specialties (vet_id, specialty_id) VALUES (3, 2);
INSERT INTO vets_specialties (vet_id, specialty_id) VALUES (3, 3);
INSERT INTO vets_specialties (vet_id, specialty_id) VALUES (4, 2);
INSERT INTO vets_specialties (vet_id, specialty_id) VALUES (5, 1);
INSERT INTO vets_specialties (vet_id, specialty_id) VALUES (5, 2);
INSERT INTO vets_specialties (vet_id, specialty_id) VALUES (6, 3);


INSERT INTO addresses VALUES (1, 'Rostov-on-Don', 'str. Eremenko', 4);
INSERT INTO addresses VALUES (2, 'Rostov-on-Don', 'str. Zorge', 40);
INSERT INTO addresses VALUES (3, 'Rostov-on-Don', 'avi. Marshala Zhukova', 95);
INSERT INTO addresses VALUES (4, 'Moscow', 'str. Zorge', 15);
INSERT INTO addresses VALUES (5, 'Krasnodar', 'avi. Marshala Zhukova', 3);
INSERT INTO addresses VALUES (6, 'Sochi', 'str. Eremenko', 27);

INSERT INTO owners VALUES (1, 'Ivan', 'Ivanov', '89281234567');
INSERT INTO owners VALUES (2, 'Ivan', 'Petrov', '89281234568');
INSERT INTO owners VALUES (3, 'Ivan', 'Sidorov', '89281234569');
INSERT INTO owners VALUES (4, 'Sergey', 'Kot', '89281234487');
INSERT INTO owners VALUES (5, 'Anton', 'Petrov', '89081234567');
INSERT INTO owners VALUES (6, 'Egor', 'Bondarev', '89274321567');
INSERT INTO owners VALUES (7, 'Elena', 'Petuhova', '89281234997');
INSERT INTO owners VALUES (8, 'Anna', 'Kozlova', '89281287267');
INSERT INTO owners VALUES (9, 'Yuliya', 'Petina', '89281239876');

INSERT INTO owners_addresses (owner_id, address_id) VALUES (1, 1);
INSERT INTO owners_addresses (owner_id, address_id) VALUES (2, 1);
INSERT INTO owners_addresses (owner_id, address_id) VALUES (3, 2);
INSERT INTO owners_addresses (owner_id, address_id) VALUES (4, 3);
INSERT INTO owners_addresses (owner_id, address_id) VALUES (5, 4);
INSERT INTO owners_addresses (owner_id, address_id) VALUES (6, 5);
INSERT INTO owners_addresses (owner_id, address_id) VALUES (7, 3);
INSERT INTO owners_addresses (owner_id, address_id) VALUES (8, 2);
INSERT INTO owners_addresses (owner_id, address_id) VALUES (9, 6);

INSERT INTO types VALUES (1, 'cat');
INSERT INTO types VALUES (2, 'dog');
INSERT INTO types VALUES (3, 'lizard');
INSERT INTO types VALUES (4, 'snake');
INSERT INTO types VALUES (5, 'bird');
INSERT INTO types VALUES (6, 'hamster');


INSERT INTO pets VALUES (1, 'Leo', '2010-09-07', 1, 1);
INSERT INTO pets VALUES (2, 'Basil', '2012-08-06', 6, 2);
INSERT INTO pets VALUES (3, 'Rosy', '2011-04-17', 2, 3);
INSERT INTO pets VALUES (4, 'Jewel', '2010-03-07', 2, 3);
INSERT INTO pets VALUES (5, 'Iggy', '2010-11-30', 3, 4);
INSERT INTO pets VALUES (6, 'George', '2010-01-20', 4, 5);
INSERT INTO pets VALUES (7, 'Samantha', '2012-09-04', 1, 6);
INSERT INTO pets VALUES (8, 'Max', '2012-09-04', 1, 6);
INSERT INTO pets VALUES (9, 'Lucky', '2011-08-06', 5, 7);
INSERT INTO pets VALUES (10, 'Mulligan', '2007-02-24', 2, 8);
INSERT INTO pets VALUES (11, 'Freddy', '2010-03-09', 5, 9);
INSERT INTO pets VALUES (12, 'Lucky', '2010-06-24', 2, 9);
INSERT INTO pets VALUES (13, 'Sly', '2012-06-08', 1, 8);

INSERT INTO visits VALUES (1, 7, '2013-01-01', 'rabies shot');
INSERT INTO visits VALUES (2, 8, '2013-01-02', 'rabies shot');
INSERT INTO visits VALUES (3, 8, '2013-01-03', 'neutered');
INSERT INTO visits VALUES (4, 7, '2013-01-04', 'spayed');
