USE epsi;

INSERT INTO seances (seanceId,startDate,name,jeuId,startTime) VALUES ('be961c7e-c44d-41c4-b4a8-8adeb0d0ea91','2019-12-04 21:30:00','Magic Night','9af55fa9-c12f-4546-a6b0-8fa53e2c730e','14:20');
INSERT INTO seances (seanceId,startDate,name,jeuId,startTime) VALUES ('86ab6a47-5274-4411-b467-30adde333e12','2019-11-30 20:00:00','Monopoly','0cdbc326-ef07-4d24-bdcc-964b86e3cd23','15:30');

INSERT INTO jeu (jeuId, nom) VALUES ('9af55fa9-c12f-4546-a6b0-8fa53e2c730e','Magic');
INSERT INTO jeu (jeuId, nom) VALUES ('0cdbc326-ef07-4d24-bdcc-964b86e3cd23','Monopoly');

INSERT INTO adherents (adherentId, nom,jeuId,login,mdp,admin,alreadyConnected) VALUES ('be9dce71-f402-4b59-a899-376b76ab557e','Clark Kent','9af55fa9-c12f-4546-a6b0-8fa53e2c730e','Clark','test',1,1);
INSERT INTO adherents (adherentId, nom,jeuId,login,mdp,admin,alreadyConnected) VALUES ('581f4b0f-3491-4352-9e54-4eb9d54b8ce4','Tony Stark','9af55fa9-c12f-4546-a6b0-8fa53e2c730e','Tony','test',1,1);
INSERT INTO adherents (adherentId, nom,jeuId,login,mdp,admin,alreadyConnected) VALUES ('8db59083-0ae4-4bab-bba0-989ed83cdbeb','Lois Lane','9af55fa9-c12f-4546-a6b0-8fa53e2c730e','Lois','test',0,0);
INSERT INTO adherents (adherentId, nom,jeuId,login,mdp,admin,alreadyConnected) VALUES ('3df8e6ba-c7ab-4d6d-bb8f-57bcf7d8f663','Kate','9af55fa9-c12f-4546-a6b0-8fa53e2c730e','Kate','test',0,0);

INSERT INTO inscriptions (inscriptionId, seanceId, adherentId) VALUES ('4631bfe2-624d-4429-90c3-0dac6f2e7fe0','be961c7e-c44d-41c4-b4a8-8adeb0d0ea91','be9dce71-f402-4b59-a899-376b76ab557e');








