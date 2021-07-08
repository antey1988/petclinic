DROP TABLE vets_specialties IF EXISTS;
DROP TABLE vets IF EXISTS;
DROP TABLE specialties IF EXISTS;
DROP TABLE visits IF EXISTS;
DROP TABLE pets IF EXISTS;
DROP TABLE types IF EXISTS;
DROP TABLE owners IF EXISTS;

CREATE TABLE specialties (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(100)
);
CREATE INDEX specialties_name ON specialties (name);

CREATE TABLE addresses (
   id INTEGER IDENTITY,
   city VARCHAR(100),
   street VARCHAR(100),
   house INTEGER,
   PRIMARY KEY (id)
);

CREATE TABLE vets (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(100),
  second_name  VARCHAR(100)
);
CREATE INDEX vets_first_name ON vets (first_name);
CREATE INDEX vets_second_name ON vets (second_name);

CREATE TABLE vets_specialties (
  vet_id       INTEGER NOT NULL,
  specialty_id INTEGER NOT NULL,
  PRIMARY KEY(vet_id, specialty_id)
);
ALTER TABLE vets_specialties ADD CONSTRAINT fk_vets_specialties_vets FOREIGN KEY (vet_id) REFERENCES vets (id);
ALTER TABLE vets_specialties ADD CONSTRAINT fk_vets_specialties_specialties FOREIGN KEY (specialty_id) REFERENCES specialties (id);

CREATE TABLE owners (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(100),
  second_name  VARCHAR(100),
  telephone  VARCHAR(20)
);
CREATE INDEX owners_first_name ON owners (first_name);
CREATE INDEX owners_second_name ON owners (second_name);

CREATE TABLE owners_addresses (
  owner_id  INTEGER NOT NULL,
  address_id INTEGER NOT NULL,
  PRIMARY KEY(owner_id, address_id)
);
ALTER TABLE owners_addresses ADD CONSTRAINT fk_owners_addresses_owners FOREIGN KEY (owner_id) REFERENCES owners (id);
ALTER TABLE owners_addresses ADD CONSTRAINT fk_owners_addresses_addresses FOREIGN KEY (address_id) REFERENCES addresses (id);


CREATE TABLE types (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(100)
);
CREATE INDEX types_name ON types (name);

CREATE TABLE pets (
  id         INTEGER IDENTITY PRIMARY KEY,
  name       VARCHAR(100),
  birth_date DATE,
  type_id    INTEGER NOT NULL,
  owner_id   INTEGER NOT NULL
);
ALTER TABLE pets ADD CONSTRAINT fk_pets_owners FOREIGN KEY (owner_id) REFERENCES owners (id);
ALTER TABLE pets ADD CONSTRAINT fk_pets_types FOREIGN KEY (type_id) REFERENCES types (id);
CREATE INDEX pets_name ON pets (name);

CREATE TABLE visits (
  id          INTEGER IDENTITY PRIMARY KEY,
  pet_id      INTEGER NOT NULL,
  visit_date  DATE,
  description VARCHAR(255)
);
ALTER TABLE visits ADD CONSTRAINT fk_visits_pets FOREIGN KEY (pet_id) REFERENCES pets (id);
CREATE INDEX visits_pet_id ON visits (pet_id);
