CREATE TABLE "user"
(
    id            BIGSERIAL PRIMARY KEY,
    first_name    VARCHAR(255) DEFAULT 'USER',
    last_name     VARCHAR(255),
    phone         VARCHAR(255),
    email         VARCHAR(255) UNIQUE           NOT NULL,
    password      VARCHAR(255)                  NOT NULL,
    date_of_birth DATE,
    role          INT REFERENCES person_role (id) NOT NULL
)