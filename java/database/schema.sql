BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, persons, comics, user_comic, user_collections, comic_user_collection CASCADE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,

	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE persons (
	person_id SERIAL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,

	CONSTRAINT PK_person PRIMARY KEY (person_id)
);
CREATE TABLE comics (
	comic_id SERIAL,
	title varchar(200) NOT NULL,
	cover_img varchar(200),
	volume varchar(50) NOT NULL,
	issue_number int NOT NULL,
	cover_date DATE NOT NULL,
	writer_id int NULL,
	artist_id int NULL,
	colorist_id int NULL,
	editor_id int NULL,
	inker_id int NULL,
	letterer_id int NULL,


	CONSTRAINT PK_comics PRIMARY KEY (comic_id),
	CONSTRAINT FK_comics_writer FOREIGN KEY (writer_id) REFERENCES person(person_id),
	CONSTRAINT FK_comics_artist FOREIGN KEY (artist_id) REFERENCES person(person_id),
	CONSTRAINT FK_comics_colorist FOREIGN KEY (colorist_id) REFERENCES person(person_id),
	CONSTRAINT FK_comics_editor FOREIGN KEY (editor_id) REFERENCES person(person_id),
	CONSTRAINT FK_comics_inker FOREIGN KEY (inker_id) REFERENCES person(person_id),
	CONSTRAINT FK_comics_letterer FOREIGN KEY (letterer_id) REFERENCES person(person_id)
);
CREATE TABLE user_comic (
	user_id int NOT NULL,
	comic_id int NOT NULL,

	CONSTRAINT PK_user_comic PRIMARY KEY (user_id, comic_id)
);
CREATE TABLE user_collections (
	user_collection_id SERIAL,
	collection_name varchar(100),
	user_id int NOT NULL,

	CONSTRAINT PK_user_collections PRIMARY KEY (user_collection_id),
	CONSTRAINT FK_user_collections FOREIGN KEY (user_id) REFERENCES users(user_id)
);
CREATE TABLE comic_user_collection (
--    collection_id
	comic_id int NOT NULL,
	user_collection_id int NOT NULL,

	CONSTRAINT PK_comic_user_collection PRIMARY KEY (comic_id, user_collection_id)
);

COMMIT TRANSACTION;