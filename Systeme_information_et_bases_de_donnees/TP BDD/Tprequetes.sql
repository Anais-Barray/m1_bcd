rlwrap sqlplus abarray/yaki349@venus/master
start requete.sql
quit

-------------- TP1 ----------------

start TP1.sql
start Tp1MastereTuples.sql
select * from fournisseurs;
select nomc from clients where solde<0;
select nomf, nomp from prix where nomp='brique' or nomp='parpaing';
select nomc, adrsc from clients where nomc like 'j%';
select commandes.nomc, adrsc from clients, commandes where nomp='brique' AND qte between 5 and 10 and clients.nomc=commandes.nomc;
--clients.nomc ou commandes.nomc, important de spécifier sinon ambigüité; clients.nomc=commandes.nomc est une jointure, permet de récup les adrs des clients dans clients pour les clients identiques a ceux de commandes
select nomp, avg(cout) from prix group by nomp;
insert into commandes values(6,'paul','parpaing',8);
insert into commandes values(7,'pierre','ciment',12);
update clients set adrsc='83000 Toulon' where nomc='jean';
update prix set cout=cout*1.15 where nomf='Samaco';
update fournisseurs set adrsf='69005 Lyon' AND nomf='Technal' where nomf='Samaco';9005 Lyon
alter table prix disable constraint nomf_fk;--car cle etrangere sur un attribut de la table fournisseurs que l'on souhaite modifier
update fournisseurs set nomf='Technal', adressef='69005 Lyon' where nomf='Samaco';
update prix set nomf='Technal' where nomf='Samaco';
alter table prix enable constraint nomf_fk;

-------------- TP2 ----------------

start TP2.sql
start Tp2MastereTuples.sql
select nom, fonction, embauche from EMP;
select num, nom, salaire from EMP where salaire<=2000;
select * from EMP where comm is not null order by comm desc;
select nom from EMP where embauche>'01-JAN-91';
select emp.nom, lieu from emp, dept;
select nom from emp group by n_sup;
select e1.nom as sup, e2.nom as emp from emp e1, emp e2 where e2.n_sup=e1.num;-- auto-jointure, e2.n_sup est la table des employés, e1.num devient la table des supérieurs.
select nom from emp where fonction=(select fonction from emp where nom='CODD') and nom<>'CODD';
select nom from emp where salaire>(select max(salaire) from emp where n_dept=30);
select e2.nom as employe from emp e1, emp e2 where e2.n_sup=e1.num and e2.n_dept<>e1.n_dept;
select nom, n_dept from emp where exists(select n_dept from emp where embauche>'01-JAN-98');
select nom, fonction, salaire from emp where salaire=(select max(salaire) from emp);
select n_dept, sum(salaire) as somme_salaire, count(num) as num_salarie, min(salaire) as min_salaire, max(salaire) as max_salaire, avg(salaire) as avg_salaire from emp group by n_dept;
select n_dept from emp group by n_dept having count(num)=(select max(count(num)) from emp group by n_dept); --having = where avec condition
select distinct e1.n_dept from emp e1 where not exists (select e2.n_dept from emp e2 where fonction='ingenieur' and e1.n_dept=e2.n_dept);
OU
select distinct(n_dept) from emp where n_dept not in (select n_dept from emp where fonction='ingenieur'); --distinct : met pas les doublons, n'avoir qu'une fois le n_dept qui apparait.
select n_dept from emp group by n_dept having count(distinct (fonction)) = select count(distinct(fonction) from emp group by n_dept);


-------------- TP3 ----------------

alter table dept add constraint dept_pk primary key (N_DEPT); --ajoute une contrainte. nomtable (dept), type d'ajout (contrainte), nom contrainte (dept_pk), type contrainte (primary key), nom attribut où on add ((N_DEPT)) : défini cet attribut comme pk.
alter table salgrade add constraint salgrade_pk primary key (GRADE);
alter table emp add constraint emp_pk primary key (NUM);
alter table emp add constraint nom_u unique (NOM); --pb : duplicat de Martin, contrainte violée, changer dabord les noms.
update emp set nom='Martin1' where num=16712;
alter table EMP add constraint responsable foreign key (N_SUP) references EMP(NUM);
alter table EMP add constraint dept foreign key (N_DEPT) references DEPT(N_DEPT); -- pb parent key not found. fonctionne pas car n_dept (emp) 100 existe pas dans n_dept (dept), ne pointe vers rien (parent existe pas). Ajouter n_dept 100.
select distinct (n_dept) from emp;
select distinct (n_dept) from dept;
update emp set n_dept=40 where n_dept=100;
alter table EMP add constraint commission check ((FONCTION='commercial' AND COMM is not null) OR (FONCTION!='commercial' and COMM is null));
select table_name, constraint_name, constraint_type from user_constraints;
update emp set comm=200 where nom='BALIN'; --ERROR at line 1:
--ORA-02290: check constraint (ABARRAY.COMMISSION) violated
alter table EMP drop constraint commission;
update emp set comm=200 where nom='BALIN';
1 row updated.
alter table EMP add constraint commission check ((FONCTION='commercial' AND COMM is not null) OR (FONCTION!='commercial' and COMM is null));--ORA-02293: cannot validate (ABARRAY.COMMISSION) - check constraint violated
alter table EMP disable constraint commission;
alter table EMP enable constraint commission;
create table REJETS (ROW_ID ROWID, OWNER VARCHAR2(30), TABLE_NAME VARCHAR2(30), CONSTRAINT VARCHAR2(30));
desc REJETS;
alter table EMP enable constraint commission exceptions into REJETS; --select * from REJETS  :
--AAAcYUAAEAAAJg7AAP	 ABARRAY	  EMP		COMMISSION
select ROWID from EMP;
delete from EMP where ROWID in (select ROW_ID from REJETS where ROW_ID='AAAcYUAAEAAAJg7AAP');
alter table EMP enable constraint commission;
select constraint_name, constraint_type, status, validated from user_constraints where (table_name='EMP');
select constraint_name, column_name from user_cons_columns where (table_name='EMP');
select table_name, num_rows from user_tables; --affiche les noms de tables et nombre de tuples des tables utilisateur.
select table_name, owner from all_tables;
select table_name, owner from dba_tables; --affiche toutes les tables de tous les utilisateurs de la database.
alter table emp drop constraint commission;
alter table emp drop constraint dept;
alter table emp drop constraint responsable;
alter table emp drop constraint nom_u;
alter table emp drop constraint emp_pk;--ordre des drop important car des contraintes dépendent les unes des autres.


-------------- TP4 ----------------

start Tp2MastereTuples.sql
desc EMP;
select nom from EMP;
col nomAttribut a10;
select table_name from all_tables; --affiche nom des tables auquel on a accès.
select table_name from user_tables; --affiche nom des tables que l'on a crée.
select owner from all_tables;
desc all_tables;
desc user_tab_columns; --affiche les attributs des colonnes que l'on peut voir pour chaque table/vue crée par l'util.
select table_name, column_name from user_tab_columns;--affiche tous les noms de colonne des tables créées.
select count(column_name) from user_tab_columns where table_name='EMP';
desc user_constraints;
select constraint_name, constraint_type, table_name, status from user_constraints;
select constraint_name, status from user_constraints where table_name='PRIX';
select constraint_name, status from user_constraints where table_name='PRIX' and constraint_type='P';
set lignesize 200;-- élargi l'affichage des lignes.
select table_name, column_name from user_tab_columns where table_name='&table';--& = appel l'utilisateur, requete paramétrable, affiche "Enter value for table :"
grant select on emp to jdemontigny;
select * from jdemontigny.EMP;
update ksugier.dept set lieu='Managua' where lieu='Rennes';
commit;-- important sinon pas MAJ => valide l'instruction.
grant select on dept to ksugier with grant option; --donne a ksugier le droit de donner des droits sur nos tables
grant select on abarray.DEPT to jdemontigny; --ksugier peut faire cet ordre
revoke select on EMP from jdemontigny;
revoke ALL on dept from ksugier;
desc user_tab_privs_made; --aff attributs des droits attribués par l'utilisateur;
select table_name, grantee, grantor, privilege from user_tab_privs_made;
select privilege, table_name, grantable, grantor from user_tab_privs_recd;--grantable pour voir si on a grant option.
create view Vue as select * from jdemontigny.EMP;





