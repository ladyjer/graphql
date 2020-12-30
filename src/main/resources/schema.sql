DROP TABLE IF EXISTS useless;

CREATE TABLE useless
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    message VARCHAR(250) DEFAULT NULL
);

CREATE TABLE person
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(250) DEFAULT NULL
);

CREATE TABLE love
(
    id_useless INT,
    id_person  INT
);

ALTER TABLE love
    ADD FOREIGN KEY (id_person)
        REFERENCES person(id);
ALTER TABLE love
    ADD FOREIGN KEY (id_useless)
        REFERENCES useless(id);
