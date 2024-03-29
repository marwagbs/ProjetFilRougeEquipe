DELETE FROM messages;
DELETE FROM horaires_restaurants;
DELETE FROM reservations;
DELETE FROM commandes_produits;
DELETE FROM commandes;
DELETE FROM produits_cartes;
DELETE FROM produits;
DELETE FROM tableres;
DELETE FROM utilisateurs;
DELETE FROM categories;
DELETE FROM restaurants;
DELETE FROM cartes;
DELETE FROM horaires;

-- Insertion des catégories
INSERT INTO Categories (id, libelle) VALUES
(1, 'Entrée'),
(2, 'Plats'),
(3, 'Boisson'),
(4, 'Dessert');

-- Insertion des produits
INSERT INTO Produits (id, nom, description, prix, id_categorie) VALUES
(1, 'Salade César', 'Salade romaine, poulet grillé, parmesan, croutons', 10.99, 1),
(2, 'Poulet rôti', 'Poulet rôti avec légumes de saison', 15.99, 2),
(3, 'Coca-Cola', 'Boisson gazeuse', 2.50, 4),
(4, 'Tiramisu', 'Dessert italien au café', 7.99, 3),
(5, 'Soupe à l oignon', 'Soupe à l oignon avec fromage gratiné', 8.50, 1),
(6, 'Steak frites', 'Steak saignant avec frites croustillantes', 18.50, 2),
(7, 'Eau minérale', 'Eau plate de source', 1.99, 4),
(8, 'Salade de fruits', 'Assortiment de fruits frais', 9.99, 3),
(9, 'Pâtes Carbonara', 'Pâtes avec sauce à la crème, lardons et parmesan', 12.50, 2),
(10, 'Thé vert', 'Thé vert japonais', 3.99, 4);

-- Insertion des utilisateurs
INSERT INTO Utilisateurs (id, nom, prenom, email, mot_de_passe, telephone, role, temps_expiration, token) VALUES
(1, 'Dupont', 'Jean', 'jean.dupont@mail.com', 'motdepasse1', '1234567890', 'employe', NULL, NULL),
(2, 'Martin', 'Sophie', 'sophie.martin@mail.com', 'motdepasse2', '2345678901', 'employe', NULL, NULL),
(3, 'Lefevre', 'Pierre', 'pierre.lefevre@mail.com', 'motdepasse3', '3456789012', 'employe', NULL, NULL),
(4, 'Dubois', 'Marie', 'marie.dubois@mail.com', 'motdepasse4', '4567890123', 'employe', NULL, NULL),
(5, 'Bertrand', 'Thomas', 'thomas.bertrand@mail.com', 'motdepasse5', '5678901234', 'employe', NULL, NULL),
(6, 'Leroux', 'Laura', 'laura.leroux@mail.com', 'motdepasse6', '6789012345', 'employe', NULL, NULL),
(7, 'Girard', 'Alexandre', 'alexandre.girard@mail.com', 'motdepasse7', '7890123456', 'employe', NULL, NULL),
(8, 'Moreau', 'Céline', 'celine.moreau@mail.com', 'motdepasse8', '8901234567', 'employe', NULL, NULL),
(9, 'Fournier', 'Luc', 'luc.fournier@mail.com', 'motdepasse9', '9012345678', 'employe', NULL, NULL),
(10, 'Roux', 'Emilie', 'emilie.roux@mail.com', 'motdepasse10', '0123456789', 'employe', NULL, NULL);

-- Insertion des cartes
INSERT INTO Cartes (id, libelle) VALUES
(1, 'Carte Printemps'),
(2, 'Carte Été'),
(3, 'Carte Automne'),
(4, 'Carte Hiver'),
(5, 'Carte Spéciale'),
(6, 'Carte Végétarienne'),
(7, 'Carte Enfant'),
(8, 'Carte Classique'),
(9, 'Carte Exotique'),
(10, 'Carte Gourmande');

INSERT INTO Produits_Cartes(id_produit, id_carte)
SELECT P.id, C.id
FROM Produits P, Cartes C;

-- Insertion des restaurants
INSERT INTO Restaurants (id, nom, adresse, cpo, ville, id_carte) VALUES
(1, 'Le Petit Bistro', '12 Rue de la Gastronomie', '44000', 'NANTES', 1),
(2, 'La Brasserie du Coin', '24 Avenue Gourmet', '75001', 'PARIS', 2),
(3, 'Chez Marcel', '8 Rue de Délices', '69002', 'LYON', 3),
(4, 'Le Bon Appétit', '15 Quai Savoureux', '33000', 'BORDEAUX', 4);

-- Insertion des tables de réservation
INSERT INTO TableRes (id, nombre_places, numero_table, statut, id_restaurant) VALUES
(1, 4, 1, 'absent', 1),
(2, 2, 1, 'present', 1),
(3, 6, 1, 'absent', 2),
(4, 5, 1, 'absent', 3),
(5, 3, 2, 'present', 2),
(6, 4, 2, 'absent', 4),
(7, 2, 2, 'absent', 3),
(8, 6, 2, 'absent', 4),
(9, 3, 3, 'present', 1),
(10, 5, 3, 'absent', 1),
(11, 4, 4, 'absent', 4),
(12, 2, 4, 'present', 2),
(13, 6, 3, 'absent', 3),
(14, 5, 3, 'absent', 4),
(15, 3, 5, 'present', 1),
(16, 4, 5, 'absent', 2),
(17, 2, 4, 'absent', 3),
(18, 6, 4, 'absent', 4),
(19, 3, 6, 'present', 1),
(20, 5, 6, 'absent', 2);

-- Insertion des réservations
INSERT INTO Reservations (id, date_res, heure, nb_personne, id_utilisateur, id_restaurant, statut, commentaire, id_table) VALUES
(1, '2024-02-01', '19:30:00', 4, 1, 1, 'acceptée', 'Réservation pour un anniversaire', 2),
(2, '2024-02-02', '20:00:00', 2, 2, 2, 'refusée', NULL, 3),
(3, '2024-02-03', '18:45:00', 3, 3, 3, 'refusée', 'Réservation pour un groupe trop important', 4),
(4, '2024-02-04', '19:00:00', 5, 4, 4, 'acceptée', NULL, 6),
(5, '2024-02-05', '21:00:00', 2, 5, 1, 'acceptée', NULL, 10),
(6, '2024-02-06', '19:15:00', 3, 6, 2, 'refusée', NULL, 5),
(7, '2024-02-07', '20:30:00', 4, 7, 3, 'acceptée', NULL, 7),
(8, '2024-02-08', '18:00:00', 2, 8, 4, 'refusée', NULL, 11),
(9, '2024-02-09', '19:45:00', 5, 9, 1, 'acceptée', NULL, 9),
(10, '2024-02-10', '20:15:00', 3, 10, 2, 'acceptée', NULL, 12);

-- Insertion des messages
INSERT INTO Messages (id, id_utilisateur, id_restaurant, contenu, sujet) VALUES
(1, 2, 1, 'Bonjour, nous avons des allergies alimentaires spécifiques.', 'Allergies alimentaires'),
(2, 4, 2, 'Pouvez-vous nous réserver une table pour deux ce soir ?', 'Réservation pour ce soir'),
(3, 6, 3, 'Y a-t-il des plats végétariens disponibles ?', 'Options végétariennes'),
(4, 8, 4, 'Pouvez-vous personnaliser un plat pour moi ?', 'Personnalisation du plat'),
(5, 10, 1, 'Nous avons un grand groupe, avez-vous une salle privée ?', 'Groupe important');

-- Insertion des commandes
INSERT INTO Commandes (id, statut, id_table, heure) VALUES
(1, 'Prête', 2, NULL),
(2, 'Servie', 5, NULL),
(3, 'Réglée', 9, NULL),
(4, 'Réglée', 12, NULL),
(5, 'Servie', 15, NULL),
(6, 'Réglée', 19, NULL);

 --Insertion des commandes produits
INSERT INTO Commandes_Produits (id_commande, id_produit) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6);

-- Insertion des horaires
INSERT INTO Horaires (id, jour, heure_ouverture, heure_fermeture)
VALUES
    (1, 'Lundi', '12:00:00', '14:00:00'), (7, 'Lundi', '19:00:00', '22:00:00'),
    (2, 'Mardi', '11:30:00', '14:00:00'), (8, 'Mardi', '19:00:00', '22:00:00'),
    (3, 'Mercredi', '12:00:00', '14:00:00'), (9, 'Mercredi', '19:00:00', '22:00:00'),
    (4, 'Jeudi', '12:00:00', '14:00:00'), (10, 'Jeudi', '19:00:00', '22:30:00'),
    (5, 'Vendredi', '11:00:00', '14:30:00'), (11, 'Vendredi', '18:30:00', '23:00:00'),
	(6, 'Samedi', '10:30:00', '15:30:00'), (12, 'Samedi', '19:00:00', '23:00:00');
	
-- Insérer les données dans Horaires_restaurants pour chaque restaurant et chaque horaire
INSERT INTO Horaires_restaurants (id_restaurant, id_horaire)
VALUES (1,1),
	   (1,2),
	   (1,3),
	   (1,4),
	   (1,5),
	   (1,6),
	   (1,7),
	   (1,8),
	   (1,10),
	   (2,1),
	   (2,2),
	   (2,5),
	   (2,6),
	   (2,7),
	   (2,8),
	   (2,9),
	   (2,10),
	   (3,1),
	   (3,2),
	   (3,3),
	   (3,4),
	   (3,7),
	   (3,8),
	   (3,9),
	   (3,10),
	   (3,11),
	   (3,12),
	   (4,1),
	   (4,2),
	   (4,3),
	   (4,4),
	   (4,5),
	   (4,6),
	   (4,7),
	   (4,10),
	   (4,11),
	   (4,8);