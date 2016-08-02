------------------------------FOURNISSEURS-------------------------------------

insert into fournisseurs values ('Abounayan', '92190 Meudon');
insert into fournisseurs values ('Cima','75010 Paris');
insert into fournisseurs values ('Preblocs','92230 Genevilliers');
insert into fournisseurs values ('Samaco','75116 Paris');

-----------------------------PRIX----------------------------------------------

insert into prix values ('Abounayan', 'sable',300);
insert into prix values ('Abounayan', 'brique',1500);
insert into prix values ('Abounayan', 'parpaing',1150);
insert into prix values ('Preblocs','tuile',1150);
insert into prix values ('Preblocs','parpaing',1200);
insert into prix values ('Samaco','parpaing',1150);
insert into prix values ('Samaco','ciment',125);
insert into prix values ('Samaco','brique',1200);

------------------------------CLIENTS--------------------------------------------
insert into clients values ('jean','75006 Paris',-12000);
insert into clients values ('paul','75003 Paris',0);
insert into clients values ('vincent','94200 Ivry',3000);
insert into clients values ('pierre','92400 Courbevoie',7000);

-----------------------------COMMANDES-------------------------------------------
insert into commandes values (1,'jean','brique',5);
insert into commandes values (2,'jean','ciment',1);
insert into commandes values (3,'paul','brique',3);
insert into commandes values (4,'paul','parpaing',9);
insert into commandes values (5,'vincent','parpaing',7);

