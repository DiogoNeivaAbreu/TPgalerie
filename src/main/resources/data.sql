-- Initialisation des tables
INSERT INTO Galerie(id, nom, adresse) VALUES (1, 'Saatchi', 'King\''s Road, Londres');

INSERT INTO Exposition(id, debut, intitule, duree, ORGANISATEUR_ID) VALUES (1, TO_DATE('01/01/2021', 'DD/MM/YYYY'), 'expo1', 2, 1);
INSERT INTO Exposition(id, debut, intitule, duree, ORGANISATEUR_ID) VALUES (2, TO_DATE('03/01/2021', 'DD/MM/YYYY'), 'expo2', 1, 1);
INSERT INTO Exposition(id, debut, intitule, duree, ORGANISATEUR_ID) VALUES (3, TO_DATE('05/01/2021', 'DD/MM/YYYY'), 'expo3', 10, 1);
INSERT INTO Exposition(id, debut, intitule, duree, ORGANISATEUR_ID) VALUES (4, TO_DATE('15/01/2021', 'DD/MM/YYYY'), 'expo4', 3, 1);

INSERT INTO Personne(DTYPE, id, nom, adresse) VALUES ('Personne', 1, 'Jean', 'Castres');

INSERT INTO Personne(DTYPE, id, nom, adresse) VALUES ('Artiste', 2, 'Pierre', 'Castres');

INSERT INTO Tableau(id, titre, support, largeur, hauteur, AUTEUR_ID) VALUES (1, 'titre1', 'toile', 40, 60, 1);

INSERT INTO Transaction(id, vendu_Le, prix_Vente, CLIENT_ID, LIEU_DE_VENTE_ID, OEUVRE_ID) VALUES (1, TO_DATE('15/01/2021', 'DD/MM/YYYY'), 100, 1, 1, 1);