BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO persons (first_name, last_name)
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
    ('Clem', 'Robins'),
    ('Erik', 'Larsen'),
    ('Gregory', 'Wright'),
    ('Tom', 'DeFalco'),
    ('Judd', 'Winick'),
    ('Doug', 'Mahnke'),
    ('Alex', 'Sinclair'),
    ('Dan', 'DiDio'),
    ('Tom', 'Nguyen'),
    ('Pat', 'Brosseau'),
    ('Garth', 'Ennis'),
    ('Darick', 'Robertson'),
    ('Tony', 'Aviña'),
    ('Kristy', 'Quinn'),
    ('Greg', 'Thompson'),
    ('John', 'Van Fleet'),
    ('Todd', 'Klein'),
    ('Andy', 'Kubert'),
    ('Guy', 'Major'),
    ('Jesse', 'Delperdang'),
    ('Jared', 'Fletcher'),
    ('J. Michael', 'Straczynski'),
    ('John', 'Romita Jr.'),
    ('Dan', 'Kemp'),
    ('Axel', 'Alonso'),
    ('Scott', 'Hanna'),
    ('Richard', 'Starkings');



INSERT INTO comics (title, cover_img, volume, issue_number, cover_date, writer_id, artist_id, colorist_id, editor_id, inker_id, letterer_id)
VALUES ('In The Hands of ... Mephisto!', 'https://comicvine.gamespot.com/a/uploads/scale_large/11/117763/2403520-ss16.png', 'The Silver Surfer', 16, '05/01/1970', 1, 6, NULL, 1, 19, 24),
    ('The Underworld Rises Again', 'https://comicvine.gamespot.com/a/uploads/scale_large/0/4/32659-4571-36430-1-superman-the-man-of.jpg', 'Superman: The Man of Steel', 17, '11/01/1992', 2, 7, 11, 15, 20 , 25),
    ('Generation Next, Part 3: Enter Freely And of Your Own Will', 'https://comicvine.gamespot.com/a/uploads/scale_large/0/4/35672-3092-39830-1-uncanny-x-men-the.jpg', 'The Uncanny X-Men', 317, '10/01/1994', 3, 8, 12, 16, 21, 26),
    ('Arcadia, Part 3: 120 Days of Sod All', 'https://comicvine.gamespot.com/a/uploads/scale_large/6/67663/4404810-07.jpg', 'The Invisibles', 7, '03/01/1995', 4, 9, 13, 17, 22, 27),
    ('Home', 'https://comicvine.gamespot.com/a/uploads/scale_large/0/4/46617-3824-55260-1-wonder-woman.jpg', 'Wonder Woman', 89, '08/01/1994', 5, 10, 14, 18, 23, 27),
    ('Revenge of the Sinister Six, Part Three', 'https://comicvine.gamespot.com/a/uploads/scale_large/5/56044/2423653-spider_man__1990__20d.jpeg', 'Spider-Man', 20, '03/20/1992', 28, 28, 29, 30, NULL, 26),
    ('Under the Hood, Part 1: New Business', 'https://comicvine.gamespot.com/a/uploads/scale_large/0/4/67892-796-100890-1-batman.jpg', 'Batman', 635, '02/01/2005', 31, 32, 33, 34, 35, 36),
    ('The Name of the Game, Part One', 'https://comicvine.gamespot.com/a/uploads/scale_large/2/22773/584980-theboys01.jpg', 'The Boys', 1, '10/01/2006', 37, 38, 39, 40, NULL, 41),
    ('Cherry, Part One', 'https://comicvine.gamespot.com/a/uploads/scale_large/6/67663/2516748-03.jpg', 'The Boys', 3, '11/04/2006', 37, 38, 39, 40, NULL, 41),
    ('Cherry, Part Two', 'https://comicvine.gamespot.com/a/uploads/scale_large/0/9116/1031434-4.jpg', 'The Boys', 4, '12/01/2006', 37, 38, 39, 40, NULL, 41),
    ('The Clown at Midnight', 'https://comicvine.gamespot.com/a/uploads/scale_large/0/40/92861-796-106607-1-batman.jpg', 'Batman', 663, '04/01/2007', 4, 42, 42, 34, 42, 43),
    ('Batman in Bethlehem', 'https://comicvine.gamespot.com/a/uploads/scale_large/5/56044/1973911-batman__1940__666.jpeg', 'Batman', 666, '07/25/2007', 4, 44, 45, 34, 46, 47),
    ('The Black Issue', 'https://comicvine.gamespot.com/a/uploads/scale_large/0/6060/171220-2127-113467-1-amazing-spider-man.jpg', 'The Amazing Spider-Man', 36, '12/01/2001', 48, 49, 50, 51, 52, 53);

INSERT INTO user_collections (collection_name, user_id)
VALUES ('Marvel Collection', 1),
    ('DC Collection', 2);

INSERT INTO comic_user_collection (comic_id, user_collection_id)
VALUES (1, 1),
    (2, 2),
    (3, 1),
    (4, 2),
    (5, 2);





COMMIT TRANSACTION;
