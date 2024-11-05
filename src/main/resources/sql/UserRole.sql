CREATE TABLE user_role
(
    id   SERIAL PRIMARY KEY,
    role VARCHAR(255) UNIQUE NOT NULL
);

INSERT INTO person_role(role)
VALUES ('STUDY'),
       ('PERSONAL'),
       ('WORKER');