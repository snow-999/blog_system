CREATE TABLE posts (
    post_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    is_edited BOOLEAN NOT NULL,
    content TEXT,
    title VARCHAR(255),
    date DATETIME
);