DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `user_id`  INT PRIMARY KEY,
    `password` VARCHAR(255) NOT NULL,
    `name`     VARCHAR(255) NOT NULL,
    `email`    VARCHAR(255) NOT NULL,
    `avatar`   VARCHAR(255)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`
(
    `course_id`   INT PRIMARY KEY AUTO_INCREMENT,
    `course_code` VARCHAR(255) NOT NULL,
    `semester`    VARCHAR(255) NOT NULL,
    `instructor`  VARCHAR(255) NOT NULL,
    `course_name` VARCHAR(255) NOT NULL,
    `description` VARCHAR(255)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `course_event`;
CREATE TABLE `course_event`
(
    `event_id`   INT PRIMARY KEY AUTO_INCREMENT,
    `course_id`  INT          NOT NULL,
    `semester`   VARCHAR(255) NOT NULL,
    `instructor` VARCHAR(255) NOT NULL,
    `event_name` VARCHAR(255) NOT NULL,
    `start_time` DATETIME     NOT NULL,
    `end_time`   DATETIME     NOT NULL,
    FOREIGN KEY (course_id) REFERENCES course (course_id)
);

DROP TABLE IF EXISTS `course_announcement`;
CREATE TABLE `course_announcement`
(
    `announcement_id` INT PRIMARY KEY AUTO_INCREMENT,
    `course_id`       INT          NOT NULL,
    `subject`         VARCHAR(255) NOT NULL,
    `content`         VARCHAR(255),
    `created_at`      TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    FOREIGN KEY (course_id) REFERENCES course (course_id)
);

DROP TABLE IF EXISTS `thread`;
CREATE TABLE thread
(
    `thread_id`    INT PRIMARY KEY AUTO_INCREMENT,
    `user_id`      INT          NOT NULL,
    `category`     VARCHAR(255) NOT NULL,
    `thread_title` VARCHAR(255) NOT NULL,
    `thread_body`  TEXT         NOT NULL,
    `created_at`   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    FOREIGN KEY (user_id) REFERENCES user (user_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`
(
    `post_id`    INT PRIMARY KEY AUTO_INCREMENT,
    `user_id`    INT       NOT NULL,
    `thread_id`  INT       NOT NULL,
    `reply_to`   INT,
    `post_body`  TEXT      NOT NULL,
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    FOREIGN KEY (user_id) REFERENCES user (user_id),
    FOREIGN KEY (thread_id) REFERENCES thread (thread_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;





