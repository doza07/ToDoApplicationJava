CREATE TABLE task
(
    id          BIGSERIAL PRIMARY KEY,
    project_id  BIGINT REFERENCES project (id) NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    start_date   DATE         NOT NULL,
    update_date  DATE,
    end_date     DATE,
    tasks_tatus  INT REFERENCES task_status (id) NOT NULL
);

