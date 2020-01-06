USE epsi;

INSERT INTO seances (seanceId,startDateTime) VALUES ('be961c7e-c44d-41c4-b4a8-8adeb0d0ea91','2019-12-04 21:30:00');
INSERT INTO seances (seanceId,startDateTime) VALUES ('86ab6a47-5274-4411-b467-30adde333e12','2019-11-30 20:00:00');

INSERT INTO jeu (jeuId, nom) VALUE ('9af55fa9-c12f-4546-a6b0-8fa53e2c730e','Magic');

INSERT INTO adherents (adherentId, nom) VALUES ('be9dce71-f402-4b59-a899-376b76ab557e','Clark Kent');
INSERT INTO adherents (adherentId, nom) VALUES ('581f4b0f-3491-4352-9e54-4eb9d54b8ce4','Tony Stark');
INSERT INTO adherents (adherentId, nom) VALUES ('8db59083-0ae4-4bab-bba0-989ed83cdbeb','Lois Lane');
INSERT INTO adherents (adherentId, nom,jeuId,login,mdp) VALUES ('3df8e6ba-c7ab-4d6d-bb8f-57bcf7d8f663','Kate Kane','9af55fa9-c12f-4546-a6b0-8fa53e2c730e','Maxence','test');

INSERT INTO inscriptions (inscriptionId, seanceId, adherentId) VALUES ('4631bfe2-624d-4429-90c3-0dac6f2e7fe0','be961c7e-c44d-41c4-b4a8-8adeb0d0ea91','581f4b0f-3491-4352-9e54-4eb9d54b8ce4');
INSERT INTO inscriptions (inscriptionId, seanceId, adherentId) VALUES ('da5009dd-280e-4264-a578-42f5dbc0ddc7','be961c7e-c44d-41c4-b4a8-8adeb0d0ea91','8db59083-0ae4-4bab-bba0-989ed83cdbeb');
INSERT INTO inscriptions (inscriptionId, seanceId, adherentId) VALUES ('a69d535f-9dfe-4c96-b00e-c75f4b2fe39d','be961c7e-c44d-41c4-b4a8-8adeb0d0ea91','3df8e6ba-c7ab-4d6d-bb8f-57bcf7d8f663');
INSERT INTO inscriptions (inscriptionId, seanceId, adherentId) VALUES ('330a2cc4-6550-4321-8a01-7095c52cc69d','86ab6a47-5274-4411-b467-30adde333e12','be9dce71-f402-4b59-a899-376b76ab557e');
INSERT INTO inscriptions (inscriptionId, seanceId, adherentId) VALUES ('a1f59fdd-4592-4305-82ac-0b538aa544eb','86ab6a47-5274-4411-b467-30adde333e12','8db59083-0ae4-4bab-bba0-989ed83cdbeb');








