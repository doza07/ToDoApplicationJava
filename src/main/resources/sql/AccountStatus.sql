CREATE TABLE account_status
(
    id     SERIAL PRIMARY KEY,
    status VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO account_status(status)
VALUES ('USER'),
       ('VIP'),
       ('ADMIN')
