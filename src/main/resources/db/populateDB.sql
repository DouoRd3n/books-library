
DELETE from person_favorite_books;
DELETE FROM books;


INSERT INTO person(login, password, role) VALUES ('login1', 'password1', 0);
INSERT INTO person(login, password, role) VALUES ('login2', 'password2', 1);
INSERT INTO person(login, password, role) VALUES ('login3', 'password3', 2);


insert into books(author, title) VALUES ('author1', 'title1');
insert into books(author, title) VALUES ('author2', 'title2');
insert into books(author, title) VALUES ('author3', 'title3');

insert into person_favorite_books(person_id, favorite_books_id) VALUES (1,1);
insert into person_favorite_books(person_id, favorite_books_id) VALUES (1,2);
insert into person_favorite_books(person_id, favorite_books_id) VALUES (1,3);