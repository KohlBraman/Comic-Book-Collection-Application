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



INSERT INTO comics (title, cover_img, synopsis, volume, issue_number, cover_date, writer_id, artist_id, colorist_id, editor_id, inker_id, letterer_id)
VALUES ('In The Hands of ... Mephisto!', 'https://comicvine.gamespot.com/a/uploads/scale_large/11/117763/2403520-ss16.png', 'Will Silver Surfer succumb to Mephisto''s offer? Mephisto, with a new plan to claim the Surfer''s soul, disguises himself among humans. He tricks the Surfer into returning home, only to find his love, Shalla Bal, missing. The Surfer battles Mephisto but is overpowered. As they create energy surges, SHIELD notices. Mephisto reveals his plan: reuniting the Surfer with Shalla Bal if he pledges loyalty and destroys SHIELD. The Surfer reluctantly agrees.', 'The Silver Surfer', 16, '05/01/1970', 1, 6, NULL, 1, 19, 24),
    ('The Underworld Rises Again', 'https://comicvine.gamespot.com/a/uploads/scale_large/0/4/32659-4571-36430-1-superman-the-man-of.jpg', 'Not even Superman may be able to rescue the orphaned Keith, who''s uncovered the amazing secret of the subterranean denizens of Metropolis''s underworld. Also: Doomsday is coming...a first glimpse at a new character who will have a chilling effect on the life of Superman!', 'Superman: The Man of Steel', 17, '11/01/1992', 2, 7, 11, 15, 20 , 25),
    ('Generation Next, Part 3: Enter Freely And of Your Own Will', 'https://comicvine.gamespot.com/a/uploads/scale_large/0/4/35672-3092-39830-1-uncanny-x-men-the.jpg', 'Paige and fellow mutants, find themselves captive. Clarice uses her powers to reveal the mutants'' abilities are not inhibited. In San Francisco, Emma, Banshee, Jubilee, and Thomas research a SHIELD safe house. Monet uncovers that they are being monitored by the Phalanx. Emma and Banshee infiltrate the safe house, facing off against SHIELD agents. Monet exposes Gregor as a Phalanx spy. The mutants manage to escape their cell, discovering they are on a boat at sea.','The Uncanny X-Men', 317, '10/01/1994', 3, 8, 12, 16, 21, 26),
    ('Arcadia, Part 3: 120 Days of Sod All', 'https://comicvine.gamespot.com/a/uploads/scale_large/6/67663/4404810-07.jpg', 'In the windmill, Orlando eats Dane''s finger. Fanny attacks, and Orlando slashes her. King Mob and Boy witness a modified version of De Sade''s story. In Venice, Percy mourns his daughter. Ragged Robin explores Rennes-le-Chateau, meeting a chess player revealing mysteries. In the chapel, Cyphermen claim to have found John the Baptist''s oracular head.', 'The Invisibles', 7, '03/01/1995', 4, 9, 13, 17, 22, 27),
    ('Home', 'https://comicvine.gamespot.com/a/uploads/scale_large/0/4/46617-3824-55260-1-wonder-woman.jpg', 'Circe offers Diana an impossible choice: Kill an innocent soul, or never see her homeland again! Is this the return of Themyscira?', 'Wonder Woman', 89, '08/01/1994', 5, 10, 14, 18, 23, 27),
    ('Revenge of the Sinister Six, Part Three', 'https://comicvine.gamespot.com/a/uploads/scale_large/5/56044/2423653-spider_man__1990__20d.jpeg', 'Dr. Octopus! Electro! Mysterio! The Vulture! The Hobgoblin! Sandman! The Sinister Six, the deadliest foes Spider-Man has ever fought, return to wreak terrible vengeance upon our favorite wall-crawler — and an unsuspecting world. With Dr. Octopus’ new Adamantium arms and help from another dimension on the Six’s side, Spidey decides to round up his own band of allies: the Hulk, Ghost Rider, the Fantastic Four and more!', 'Spider-Man', 20, '03/20/1992', 28, 28, 29, 30, NULL, 26),
    ('Under the Hood, Part 1: New Business', 'https://comicvine.gamespot.com/a/uploads/scale_large/0/4/67892-796-100890-1-batman.jpg', 'Batman learns that someone unknown has managed a hostile takeover of Kord industries, which is WayneTech''s research and development unit, responsible for a number of the items he uses in his war on crime. Meanwhile, as Black Mask continues to increase his grip on Gotham''s underworld, a new player makes himself known. The Red Hood, who insists that his drug dealer stay away from kids. In response, Black Mask recruits yet another of Gotham''s supercriminals - Mister Freeze.', 'Batman', 635, '02/01/2005', 31, 32, 33, 34, 35, 36),
    ('The Name of the Game, Part One', 'https://comicvine.gamespot.com/a/uploads/scale_large/2/22773/584980-theboys01.jpg', 'Butcher meets CIA Director Rayner, convincing her to lead the anti-supe team. They engage in a liaison. In Glasgow, Hughie''s girlfriend is killed by A-Train. Learning of Hughie''s lack of interest in compensation, Butcher travels to Scotland to recruit him for the team.', 'The Boys', 1, '10/01/2006', 37, 38, 39, 40, NULL, 41),
    ('Cherry, Part One', 'https://comicvine.gamespot.com/a/uploads/scale_large/6/67663/2516748-03.jpg', 'Wee Hughie goes to New York to meet Butcher, who already assumes Hughie is part of The Boys. Hughie meets other members: Female, Frenchman, and Mothers Milk. In The Seven''s headquarters, rookie Starlight faces a disturbing initiation. Meanwhile, Butcher targets Teenage Kix as their first supe mission, while Hughie contemplates joining The Boys.', 'The Boys', 3, '11/04/2006', 37, 38, 39, 40, NULL, 41),
    ('Cherry, Part Two', 'https://comicvine.gamespot.com/a/uploads/scale_large/0/9116/1031434-4.jpg', 'They''re young, they''re beautiful, they''re the number one teen super-team: they''re Teenage Kix, and they''re right in The Boys'' gunsights. Hughie gets his first look at our heroes doing what they do best - and isn''t too keen on some of the things he sees.', 'The Boys', 4, '12/01/2006', 37, 38, 39, 40, NULL, 41),
    ('The Clown at Midnight', 'https://comicvine.gamespot.com/a/uploads/scale_large/0/40/92861-796-106607-1-batman.jpg', 'Eight former Joker henchmen die at a cemetery from toxic flowers. Batman suspects Joker and finds a bloody Joker card. In Arkham, Batman confronts a bandaged Joker allied with a speech therapist, likely Harley Quinn. Harley executes Joker''s plan, killing henchmen. Batman finds her, and in a fight, defeats Joker but is shot by Harley, claiming he ignores her. Joker is seemingly returned to Arkham.', 'Batman', 663, '04/01/2007', 4, 42, 42, 34, 42, 43),
    ('Batman in Bethlehem', 'https://comicvine.gamespot.com/a/uploads/scale_large/5/56044/1973911-batman__1940__666.jpeg', 'Meet Damian Wayne, the Batman of Tomorrow in this special issue set 15 years from now in a nightmarish future Gotham! In a world torn apart by terrorism, plagues, rogue weather and bizarre super-crime, only 24 hours are left before the climactic battle of Armageddon — and only one man who might be able to stop it. But will he? The Son of the Bat meets the Prince of Darkness and the stage is set for the ultimate battle between evil and moral ambiguity.', 'Batman', 666, '07/25/2007', 4, 44, 45, 34, 46, 47),
    ('The Black Issue', 'https://comicvine.gamespot.com/a/uploads/scale_large/0/6060/171220-2127-113467-1-amazing-spider-man.jpg', 'In the wake of the 9/11 terrorist attacks, Spider-Man and other heroes stand in shock feeling sorrow in the aftermath of an event they were powerless to stop.', 'The Amazing Spider-Man', 36, '12/01/2001', 48, 49, 50, 51, 52, 53);

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
