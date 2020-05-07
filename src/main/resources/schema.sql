/*CREATE TABLE student(
    id LONG NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birthdate DATE NULL
);*/

DROP TABLE IF EXISTS student;

CREATE TABLE student(
    id int unsigned NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    birthdate DATE NULL,

    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS teacher;
CREATE TABLE teacher(
    id int unsigned NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    subject VARCHAR(20) NOT NULL,

    PRIMARY KEY(id)
);