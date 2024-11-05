CREATE TABLE task_status
(
    id     SERIAL PRIMARY KEY,
    status VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO task_status(status)
VALUES ('BACKLOG'),
       ('IN_PROGRESS'),
       ('COMPLETED'),
       ('FAILED');
