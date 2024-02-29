DROP TABLE IF EXISTS Messages,Produits_Cartes, Commandes_Produits ,Produits , Categories,Commandes , TablesRes,Reservations ,Utilisateurs, Horaires_restaurants, Horaires ,Restaurants  ,cartes   ;

CREATE TABLE Categories(

	id				INT				PRIMARY KEY ,
	libelle			VARCHAR(20)			NOT NULL

);

CREATE TABLE Utilisateurs(
	id			  INT	PRIMARY KEY ,
	nom		VARCHAR(50) NOT NULL,
	prenom	VARCHAR(50) NOT NULL,
	email VARCHAR (50) NOT NULL,
	mot_de_passe VARCHAR (255) NOT NULL	,
	telephone	VARCHAR (50) NOT NULL,
	role VARCHAR (50)
);

CREATE TABLE Produits(
	id				INT				PRIMARY KEY ,
	nom VARCHAR (50) NOT NULL,
	description  varchar(250) NOT NULL,
	prix NUMERIC (5,2) NOT NULL,
	id_categorie int NOT NULL,
	

);
CREATE TABLE Cartes(
	id				INT				PRIMARY KEY ,
	libelle			VARCHAR(40)			NOT NULL
);

CREATE TABLE Produits_Cartes(
	id				INT				PRIMARY KEY ,
	id_produit   INT,
	id_carte   INT
	
);

CREATE TABLE Restaurants(
	id			  INT	PRIMARY KEY ,
	nom		VARCHAR(50) NOT NULL,
	adresse VARCHAR(60) NOT NULL,
    cpo CHAR(5) NOT NULL CHECK (cpo BETWEEN 01000 AND 95999),
    ville VARCHAR(40) NOT NULL DEFAULT 'NANTES',
	id_carte INT  NULL

);

CREATE TABLE Reservations(
	id			  INT	PRIMARY KEY ,
	date_res DATE NOT NULL,
	heure time NOT NULL,
	nb_personne int NOT NULL CHECK (nb_personne>=1),
	id_utilisateur int NOT NULL,
	id_restaurant INT NOT NULL,
	id_table INT NOT NULL,
	statut VARCHAR (50) NULL CHECK (statut in ('accept�e', 'refus�e', null)),
	commentaire VARCHAR (250) NULL

);

CREATE TABLE Messages(
	id			  INT	PRIMARY KEY ,
	id_utilisateur int NOT NULL,
	id_restaurant int NOT NULL,
	contenu VARCHAR(250) NOT NULL,
	sujet  VARCHAR(100) NOT NULL
);

CREATE TABLE Tablesres(
	id			  INT	PRIMARY KEY ,
	nombre_places INT NOT NULL,
	numero_table   INT NOT NULL, 
	statut  VARCHAR (50) NULL DEFAULT 'absent' CHECK (statut in ('absent', 'present')),
	id_restaurant INT NOT NULL

);

CREATE TABLE Commandes(
	id			  INT	PRIMARY KEY ,
	libelle			VARCHAR(20)	Null,
	id_table INT NOT NULL


);

CREATE TABLE Commandes_Produits(
	id				INT				PRIMARY KEY ,
	id_commande INT NOT NULL,
	id_produit INT NOT NULL
	
);
CREATE TABLE Horaires(
		id			  INT	PRIMARY KEY IDENTITY,
		jour  VARCHAR(15) NOT NULL,
		heure_ouverture VARCHAR(15) NOT NULL,
		heure_fermeture VARCHAR(15) NOT NULL
);

CREATE TABLE Horaires_restaurants (
	id				INT				PRIMARY KEY IDENTITY,
	id_restaurant INT NOT NULL,
	id_horaire    INT NOT NULL

);

ALTER TABLE Produits 
	with CHECK ADD
		FOREIGN KEY (id_categorie) REFERENCES categories(id)
		ON DELETE NO ACTION;


ALTER TABLE Produits_Cartes 
	with CHECK ADD
		FOREIGN KEY (id_produit) REFERENCES produits(id),
		FOREIGN KEY (id_carte) REFERENCES cartes(id);
		

ALTER TABLE Commandes
	with CHECK ADD
	
		FOREIGN KEY (id_table) REFERENCES TablesRes(id)
		ON DELETE CASCADE;

ALTER TABLE Commandes_Produits 
	with CHECK ADD
		FOREIGN KEY (id_produit) REFERENCES Produits(id),
		FOREIGN KEY (id_commande) REFERENCES commandes(id);
		

ALTER TABLE Tablesres 
	with CHECK ADD
		FOREIGN KEY (id_restaurant) REFERENCES restaurants(id)
		ON DELETE CASCADE;
	


ALTER TABLE Restaurants 
	with CHECK ADD
		FOREIGN KEY (id_carte) REFERENCES Cartes(id)
		ON DELETE NO ACTION;



ALTER TABLE Reservations 
	with CHECK ADD
		FOREIGN KEY (id_table) REFERENCES Tablesres(id)
		ON DELETE NO ACTION,
		FOREIGN KEY (id_restaurant) REFERENCES restaurants(id)
		ON DELETE CASCADE,
		FOREIGN KEY (id_utilisateur) REFERENCES Utilisateurs(id)
		ON DELETE CASCADE;
	
ALTER TABLE Messages 
	with CHECK ADD
		FOREIGN KEY (id_utilisateur) REFERENCES Utilisateurs(id),
		FOREIGN KEY (id_restaurant) REFERENCES restaurants(id)
		ON DELETE NO ACTION;

ALTER TABLE Horaires_restaurants
	with CHECK ADD
		FOREIGN KEY (id_horaire) REFERENCES horaires(id),
		FOREIGN KEY (id_restaurant) REFERENCES restaurants(id);