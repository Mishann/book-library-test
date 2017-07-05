drop database if exists book_library; 
create database book_library;
use book_library;

CREATE TABLE book (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `author` VARCHAR(200) NOT NULL,
    `name` VARCHAR(200) NOT NULL
);

insert into book(`author`,`name`)
values('George Orwell', '"1984"');

insert into book(`author`,`name`)
values('Charles Dickens', '"Great Expectations "');

insert into book(`author`,`name`)
values('Charles Dickens', '"Great Expectations"');

insert into book(`author`,`name`)
values('Jonathan Swift', '"Gullivers Travels"');

insert into book(`author`,`name`)
values('Charles Dickens', '"David Copperfield"');

insert into book(`author`,`name`)
values('Miguel de Cervantes', '"Don Quixote"');





