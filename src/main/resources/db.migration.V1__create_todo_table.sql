CREATE TABLE todo_item (
                           id VARCHAR(36) PRIMARY KEY,
                           title VARCHAR(100) NOT NULL,
                           description VARCHAR(200),
                           due_date DATETIME,
                           priority INT NOT NULL,
                           completed TINYINT(1) NOT NULL,
                           created_date DATETIME NOT NULL,
                           completed_date DATETIME
);