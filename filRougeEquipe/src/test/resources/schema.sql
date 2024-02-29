drop table if exists messages;
drop table if exists horaires_restaurants;
drop table if exists reservations;
drop table if exists commandes_produits;
drop table if exists commandes;
drop table if exists produits_cartes;
drop table if exists produits;
drop table if exists tableres;
drop table if exists utilisateurs;
drop table if exists categories;
drop table if exists restaurants;
drop table if exists cartes;
drop table if exists horaires;

CREATE TABLE categories(

	id				INT				PRIMARY KEY ,
	libelle			VARCHAR(20)			NOT NULL

);

CREATE TABLE utilisateurs(
	id			  INT	PRIMARY KEY ,
	nom		VARCHAR(50) NOT NULL,
	prenom	VARCHAR(50) NOT NULL,
	email VARCHAR (50) NOT NULL,
	mot_de_passe VARCHAR (255) NOT NULL	,
	telephone	VARCHAR (50) NOT NULL,
	role VARCHAR (50)
);

CREATE TABLE produits(
	id				INT				PRIMARY KEY ,
	nom VARCHAR (50) NOT NULL,
	description  varchar(250) NOT NULL,
	prix NUMERIC (5,2) NOT NULL,
	id_categorie int NOT NULL,
	

);
CREATE TABLE cartes(
	id				INT				PRIMARY KEY ,
	libelle			VARCHAR(40)			NOT NULL
);

CREATE TABLE produits_cartes(

	id_produit   INT,
	id_carte   INT
	
);

CREATE TABLE restaurants(
	id			  INT	PRIMARY KEY ,
	nom		VARCHAR(50) NOT NULL,
	adresse VARCHAR(60) NOT NULL,
    cpo CHAR(5) NOT NULL CHECK (cpo BETWEEN 01000 AND 95999),
    ville VARCHAR(40) NOT NULL DEFAULT 'NANTES',
	id_carte INT  NULL

);

CREATE TABLE reservations(
	id			  INT	PRIMARY KEY ,
	date_res DATE NOT NULL,
	heure time NOT NULL,
	nb_personne int NOT NULL CHECK (nb_personne>=1),
	id_utilisateur int NOT NULL,
	id_restaurant INT NOT NULL,
	statut VARCHAR (50) NULL,
	commentaire VARCHAR (250) NULL

);

CREATE TABLE messages(
	id			  INT	PRIMARY KEY ,
	id_utilisateur int NOT NULL,
	id_restaurant int NOT NULL,
	contenu VARCHAR(250) NOT NULL,
	sujet  VARCHAR(100) NOT NULL
);

CREATE TABLE tableres(
	id			  INT	PRIMARY KEY ,
	nombre_places INT NOT NULL,
	numero_table   INT NOT NULL, 
	statut  VARCHAR (50) NULL ,
	id_reservation INT NULL,
	id_restaurant INT NOT NULL

);

CREATE TABLE commandes(
	id			  INT	PRIMARY KEY ,
	statut			VARCHAR(20)	Null,
	heure	datetime,
	id_table INT NOT NULL


);

CREATE TABLE commandes_produits(
	id_commande INT NOT NULL,
	id_produit INT NOT NULL
	
);
CREATE TABLE horaires(
		id			  INT	PRIMARY KEY ,
		jour  VARCHAR(15) NOT NULL,
		heure_ouverture VARCHAR(15) NOT NULL,
		heure_fermeture VARCHAR(15) NOT NULL
);

CREATE TABLE horaires_restaurants (
	id_restaurant INT NOT NULL,
	id_horaire    INT NOT NULL

);

ALTER TABLE produits 
	with CHECK ADD
		FOREIGN KEY (id_categorie) REFERENCES categories(id)
		ON DELETE NO ACTION;


ALTER TABLE produits_cartes 
	with CHECK ADD
		FOREIGN KEY (id_produit) REFERENCES produits(id),
		FOREIGN KEY (id_carte) REFERENCES cartes(id);
		

ALTER TABLE commandes
	with CHECK ADD
		FOREIGN KEY (id_table) REFERENCES tableres(id)
		ON DELETE CASCADE;

ALTER TABLE commandes_produits 
	with CHECK ADD
		FOREIGN KEY (id_produit) REFERENCES Produits(id),
		FOREIGN KEY (id_commande) REFERENCES commandes(id);
		

ALTER TABLE tableres 
	with CHECK ADD
		FOREIGN KEY (id_reservation) REFERENCES reservations(id)
		ON DELETE NO ACTION,
		FOREIGN KEY (id_restaurant) REFERENCES restaurants(id)
		ON DELETE CASCADE;
	


ALTER TABLE restaurants 
	with CHECK ADD
		FOREIGN KEY (id_carte) REFERENCES cartes(id)
		ON DELETE NO ACTION;



ALTER TABLE reservations 
	with CHECK ADD
		FOREIGN KEY (id_restaurant) REFERENCES restaurants(id)
		ON DELETE CASCADE,
		FOREIGN KEY (id_utilisateur) REFERENCES Utilisateurs(id)
		ON DELETE CASCADE;
	
ALTER TABLE messages 
	with CHECK ADD
		FOREIGN KEY (id_utilisateur) REFERENCES Utilisateurs(id),
		FOREIGN KEY (id_restaurant) REFERENCES restaurants(id)
		ON DELETE NO ACTION;

ALTER TABLE horaires_restaurants
	with CHECK ADD
		FOREIGN KEY (id_horaire) REFERENCES horaires(id),
		FOREIGN KEY (id_restaurant) REFERENCES restaurants(id);