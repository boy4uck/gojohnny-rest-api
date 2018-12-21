CREATE TABLE photo_comments (
  id            BIGINT,
  text          VARCHAR(255) NOT NULL,
  creation_time TIMESTAMP    NOT NULL,
  photo_id      BIGINT       NOT NULL,
  user_id       BIGINT       NOT NULL,
  CONSTRAINT photo_comment_photo_FK FOREIGN KEY (photo_id) REFERENCES photos,
  CONSTRAINT photo_comment_user_FK FOREIGN KEY (user_id) REFERENCES "users",
  CONSTRAINT photo_comment_PK PRIMARY KEY (id)
);