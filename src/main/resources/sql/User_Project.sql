CREATE TABLE user_project
(
    user_id    BIGINT NOT NULL REFERENCES person (id) ON DELETE CASCADE,
    project_id BIGINT NOT NULL REFERENCES project (id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, project_id)
);
