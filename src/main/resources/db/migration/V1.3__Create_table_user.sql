CREATE TABLE IF NOT EXISTS "user" (
  id              BIGINT NOT NULL,
  first_name      VARCHAR(255) NOT NULL,
  last_name       VARCHAR(255) NOT NULL,
  email           VARCHAR(255) NOT NULL,
  password        VARCHAR(255) NOT NULL,
  creation_time   DATE         NOT NULL,

  CONSTRAINT user_PK PRIMARY KEY (id),
  CONSTRAINT user_email_AK UNIQUE (email)
);