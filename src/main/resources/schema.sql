/*CREATE TABLE student(
    id LONG NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birthdate DATE NULL
);*/

DROP TABLE student;

CREATE TABLE IF NOT EXISTS student(
    id int unsigned NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    birthdate DATE NULL,

    PRIMARY KEY(id)
);