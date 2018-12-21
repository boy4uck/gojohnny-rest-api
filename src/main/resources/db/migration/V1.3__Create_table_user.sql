CREATE TABLE IF NOT EXISTS users (
  id              BIGINT NOT NULL,
  first_name      VARCHAR(255) NOT NULL,
  last_name       VARCHAR(255) NOT NULL,
  email           VARCHAR(255) NOT NULL,
  password        VARCHAR(255) NOT NULL,
  creation_time   DATE         NOT NULL,

  CONSTRAINT users_PK PRIMARY KEY (id),
  CONSTRAINT users_email_AK UNIQUE (email)
);