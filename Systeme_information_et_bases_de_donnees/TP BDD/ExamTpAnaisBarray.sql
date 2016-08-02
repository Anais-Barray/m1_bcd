drop table soigne;
drop table pensionnaire;
drop table gardien;
drop table espece;



create table gardien
(numMatricule varchar(5), nom varchar(15), prenom varchar(15), genre varchar(1), constraint numM_pk primary key(numMatricule));

create table espece
(nom varchar(20), classe varchar(12), continent varchar(15), constraint nom_pk primary key(nom));

create table pensionnaire
(codeP varchar(5), surnom varchar(15), sexe varchar(1), date_naissance date, date_arrivee date, nom_espece varchar(20), constraint codeP_pk primary key(codeP), constraint nomE_fk foreign key(nom_espece) references espece(nom));

create table soigne
(codeP varchar(5), numG varchar(5), date_debut date, date_fin date, constraint soigne_pk primary key(codeP,numG,date_debut), constraint codeP_fk foreign key(codeP) references pensionnaire(codeP), constraint numM_fk foreign key(numG) references gardien(numMatricule));

--note : check (date_arrivee>=date_naissance) ne fonctionne pas.

1 : select surnom, sexe from pensionnaire where nom_espece='Perroquet vaza';
2 : select surnom, nom_espece as Espece from espece, pensionnaire where continent=('Afrique') AND pensionnaire.nom_espece = espece.nom;
3 : select count(codeP) as nb_Animaux_Pensionnaires from pensionnaire;
4 : select nom_espece, count(codeP) as nb_Animaux_Par_Espece from pensionnaire group by nom_espece;
5 : select nom_espece as nb_Animaux_Plus_Representes, count(codeP) as nb_espece from pensionnaire group by nom_espece having count(codeP)=(select max(count(codeP)) from pensionnaire group by nom_espece);
6 : select surnom, nom_espece, sexe, date_naissance, continent from pensionnaire, espece where pensionnaire.nom_espece=espece.nom AND classe='Oiseau';
7 : select distinct surnom, nom_espece from pensionnaire, soigne where pensionnaire.codeP not in (select codeP from soigne);
8 : select distinct codeP from soigne s1 where not exists (select * from gardien g where not exists (select * from soigne s2 where s1.codeP=s2.codeP AND s2.numG=g.numMatricule));


