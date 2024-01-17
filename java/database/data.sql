BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO person (first_name, last_name)
VALUES ('Stan', 'Lee'),
    ('Louise Jones', 'Simonson'),
    ('Scott', 'Lobdell'),
    ('Grant', 'Morrison'),
    ('Christopher', 'Priest'),
    ('John', 'Buscema'),
    ('Jon', 'Bogdanove'),
    ('Joe', 'Madureira'),
    ('Jill', 'Thompson'),
    ('John', 'Ross'),
    ('Glenn', 'Whitmore'),
    ('Steve', 'Buccellato'),
    ('Daniel', 'Vozzo'),
    ('Trish', 'Mulvihill'),
    ('Mike', 'Carlin'),
    ('Ben', 'Raab'),
    ('Stuart', 'Moore'),
    ('Paul', 'Kupperberg'),
    ('Chic', 'Stone'),
    ('Bob', 'McLeod'),
    ('Dan', 'Green'),
    ('Dennis', 'Cramer'),
    ('Romeo', 'Tanghal'),
    ('Sam', 'Rosen'),
    ('Bill', 'Oakley'),
    ('Chris', 'Eliopoulos'),
    ('Clem', 'Robins');

INSERT INTO comics (title, cover_img, volume, issue_number, cover_date, writer_id, artist_id, colorist_id, editor_id, inker_id, letterer_id)
VALUES ('In The Hands of ... Mephisto!', 'https://comicvine.gamespot.com/a/uploads/scale_large/11/117763/2403520-ss16.png', 'The Silver Surfer', 16, '05/01/1970', 1, 6, NULL, 1, 19, 24),
    ('The Underworld Rises Again', 'https://comicvine.gamespot.com/a/uploads/scale_large/0/4/32659-4571-36430-1-superman-the-man-of.jpg', 'Superman: The Man of Steel', 17, '11/01/1992', 2, 7, 11, 15, 20 , 25),
    ('Generation Next, Part 3: Enter Freely And of Your Own Will', 'https://comicvine.gamespot.com/a/uploads/scale_large/0/4/35672-3092-39830-1-uncanny-x-men-the.jpg', 'The Uncanny X-Men', 317, '10/01/1994', 3, 8, 12, 16, 21, 26),
    ('Arcadia, Part 3: 120 Days of Sod All', 'https://comicvine.gamespot.com/a/uploads/scale_large/6/67663/4404810-07.jpg', 'The Invisibles', 7, '03/01/1995', 4, 9, 13, 17, 22, 27),
    ('Home', 'https://comicvine.gamespot.com/a/uploads/scale_large/0/4/46617-3824-55260-1-wonder-woman.jpg', 'Wonder Woman', 89, '08/01/1994', 5, 10, 14, 18, 23, 27);




COMMIT TRANSACTION;
