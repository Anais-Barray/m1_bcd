-- rlwrap sqlplus abarray/yaki349@venus/master

drop table prix;
drop table fournisseurs;
drop table commandes;
drop table clients;

--important ordre des drop

create table fournisseurs
(nomf varchar(20) constraint nomf_pk primary key, adrsf varchar(50));

create table prix
(nomf varchar(20), nomp varchar(20), cout number(6) check (cout>0), constraint prix_pk primary key(nomf,nomp), constraint nomf_fk foreign key(nomf) references fournisseurs(nomf));

create table clients
(nomc varchar(20) constraint clients_pk primary key, adrsc varchar(50), solde integer);

create table commandes
(ncom integer constraint ncom_pk primary key, nomc varchar(20) references clients(nomc), nomp varchar(20), qte integer check (qte>0));




-- 2eme version

create table fournisseurs
(nomf varchar(20) primary key, adrsf varchar(50));

create table prix
(nomf varchar(20), nomp varchar(20), cout number(6) check (cout>0), constraint prix_pk primary key(nomf,nomp), constraint nomf_fk foreign key(nomf) references fournisseurs(nomf));
--fk car ref une pk d'ailleurs.

create table clients
(nomc varchar(20) primary key, adrsc varchar(50), solde integer);

create table commandes
(ncom integer primary key, nomc varchar(20) references clients(nomc), nomp varchar(20), qte integer check (qte>0));


