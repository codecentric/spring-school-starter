DROP TABLE IF EXISTS Users;

CREATE TABLE Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL
);

INSERT INTO Users (first_name, last_name, email) VALUES ('Harry', 'Potter', 'harry@hogwarts.de');
INSERT INTO Users (first_name, last_name, email) VALUES ('Hermine', 'Granger', 'hermine@hogwarts.de');
INSERT INTO Users (first_name, last_name, email) VALUES ('Ron', 'Weasly', 'ron@hogwarts.de');

