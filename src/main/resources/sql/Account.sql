CREATE TABLE account
(
    id                BIGSERIAL PRIMARY KEY,
    user_id           BIGSERIAL REFERENCES person (id)   NOT NULL,
    account_status_id INT REFERENCES account_status (id) NOT NULL,
    date_registration DATE                               NOT NULL,
    date_update_info  DATE
);