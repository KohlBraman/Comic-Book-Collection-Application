BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, comics, user_comic, comic_collections, user_collections, writers, artists CASCADE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,

	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE comics (
	comic_id SERIAL,
	title varchar(50) NOT NULL,
	cover_img varchar(200),
	issue_number int NOT NULL,
	number_pages int NOT NULL,
	date_published DATE NOT NULL,
	writer1_id int NOT NULL,
	writer2_id int,
	writer3_id int,
	artist1_id int NOT NULL,
	artist2_id int,
	artist3_id int,

	CONSTRAINT PK_comics PRIMARY KEY (comic_id),
	CONSTRAINT FK_writers FOREIGN KEY (writer1_id) REFERENCES writers(writer_id),
	CONSTRAINT FK_writers FOREIGN KEY (writer2_id) REFERENCES writers(writer_id),
	CONSTRAINT FK_writers FOREIGN KEY (writer3_id) REFERENCES writers(writer_id),
	CONSTRAINT FK_artists FOREIGN KEY (artist1_id) REFERENCES artists(artist_id),
	CONSTRAINT FK_artists FOREIGN KEY (artist2_id) REFERENCES artists(artist_id),
	CONSTRAINT FK_artists FOREIGN KEY (artist3_id) REFERENCES artists(artist_id),
);
CREATE TABLE user_comic (
	user_id int NOT NULL,
	comic_id int NOT NULL

	CONSTRAINT PK_user_comic PRIMARY KEY (user_id),
	CONSTRAINT PK_user_comic PRIMARY KEY (comic_id)

);
CREATE TABLE user_collections (
	user_collection_id SERIAL,
	collection_name varchar(100),
	user_id int NOT NULL

	CONSTRAINT PK_user_collections PRIMARY KEY (user_collection_id),
	CONSTRAINT FK_user_collections FOREIGN KEY (user_id) REFERENCES users(user_id)
);
CREATE TABLE comic_collections (
	comic_id int NOT NULL,
	user_collection_id int NOT NULL

	CONSTRAINT PK_comic_collections PRIMARY KEY (comic_id),
	CONSTRAINT PK_comic_collections PRIMARY KEY (user_collection_id)
);
CREATE TABLE writers (
	writer_id SERIAL,
	first_name varchar(30) NOT NULL,
	last_name varchar(30) NOT NULL

	CONSTRAINT PK_writers PRIMARY KEY (writer_id)
);
CREATE TABLE artists (
	artist_id SERIAL,
	first_name varchar(30) NOT NULL,
	last_name varchar(30) NOT NULL

	CONSTRAINT PK_artists PRIMARY KEY (artist_id)
);

COMMIT TRANSACTION;
