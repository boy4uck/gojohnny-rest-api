CREATE TABLE if not exists photo(
  id BIGINT NOT NULL,
  url VARCHAR(255) NOT NULL ,
  creation_time TIMESTAMP NOT NULL,
  user_id BIGINT NOT NULL,

  CONSTRAINT photo_pk PRIMARY KEY (id),
  CONSTRAINT photo_users_fk FOREIGN KEY (user_id) references users
);