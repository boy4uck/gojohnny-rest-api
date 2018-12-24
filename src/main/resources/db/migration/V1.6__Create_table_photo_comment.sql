CREATE TABLE photo_comment (
  id            BIGINT,
  text          VARCHAR(255) NOT NULL,
  creation_time TIMESTAMP    DEFAULT now(),
  photo_id      BIGINT       NOT NULL,
  user_id       BIGINT       NOT NULL,
  CONSTRAINT photo_comment_pk PRIMARY KEY (id),
  CONSTRAINT photo_comment_user_fk FOREIGN KEY (user_id) REFERENCES users,
  CONSTRAINT photo_comment_photo_fk FOREIGN KEY (photo_id) REFERENCES photo
);