
insert into espece values ('Pic vert' , 'Oiseau' , 'faune locale');
insert into espece values ('Rouge-gorge' , 'Oiseau' , 'faune locale');
insert into espece values ('Genette' , 'Mammifere' , 'faune locale');
insert into espece values ('Emeu' , 'Oiseau' , 'Oceanie');
insert into espece values ('Ibis rouge' , 'Oiseau' , 'Amerique du Sud');
insert into espece values ('Perroquet vaza' , 'Oiseau' , 'Afrique');
insert into espece values ('Takin du Tibet' , 'Mammifere' , 'Eurasie');
insert into espece values ('Wallaby de Bennett' , 'Mammifere' , 'Afrique');
insert into espece values ('Gazelle de Mhorr' , 'Mammifere' , 'Eurasie');
insert into espece values ('Girafe de Rothschild' , 'Mammifere' , 'Afrique');
insert into espece values ('Lion Atlas', 'Mammifere',  'Afrique');

insert into pensionnaire values ('OPV1' , 'Pikki' , 'M', '1-dec-2013', '1-dec-2013', 'Pic vert') ;
insert into pensionnaire values ('ORG1' , 'Roro' , 'M', '12-aug-2013', '12-aug-2013', 'Rouge-gorge') ;
insert into pensionnaire values ('ORG2' , 'Roro_Junior', 'M', '12-aug-2014', '12-aug-2014', 'Rouge-gorge') ;
insert into pensionnaire values ('GM1' , 'Felicite' , 'F', '23-mar-2010', '23-mar-2010', 'Genette') ;
insert into pensionnaire values ('GM2' , 'Parfait' , 'M', '21-may-2010', '21-may-2010', 'Genette') ;
insert into pensionnaire values ('OE1' , 'Emilie' , 'F', '2-jan-2008', '23-apr-2010', 'Emeu') ;
insert into pensionnaire values ('OE2' , 'Kamelie' , 'F', '2-jan-2009', '23-apr-2010', 'Emeu') ;
insert into pensionnaire values ('OE3' , 'Amelie' , 'F', '2-jan-2009', '23-apr-2010', 'Emeu') ;
insert into pensionnaire values ('OE4' , 'Kalin' , 'M', '22-dec-2009', '23-apr-2010', 'Emeu') ;
insert into pensionnaire values ('OI1' , 'Iodus' , 'M', '3-mar-2008', '3-mar-2008', 'Ibis rouge') ;
insert into pensionnaire values ('PV1' , 'Coco' , 'M', '3-apr-2007', '3-jun-2009', 'Perroquet vaza') ;
insert into pensionnaire values ('PV2' , 'Cocotte' , 'F', '3-may-2007', '3-jun-2009', 'Perroquet vaza') ;
insert into pensionnaire values ('TT1' , 'Takinet' , 'M', '3-feb-2002', '7-jun-2007', 'Takin du Tibet') ;
insert into pensionnaire values ('TT2' , 'Takinette' , 'F', '3-may-2001', '7-jul-2007', 'Takin du Tibet') ;
insert into pensionnaire values ('MW1' , 'Wallace' , 'M', '5-jun-2003', '5-jun-2003', 'Wallaby de Bennett') ;
insert into pensionnaire values ('MW2' , 'Warren' , 'M', '25-mar-2004', '5-jun-2004', 'Wallaby de Bennett') ;
insert into pensionnaire values ('MG1' , 'Gazzi' , 'F', '5-jul-2014', '5-jul-2014', 'Gazelle de Mhorr') ;
insert into pensionnaire values ('MG2' , 'Gazzou' , 'F', '8-aug-2008', '9-nov-2010', 'Girafe de Rothschild') ;
insert into pensionnaire values ('MG3' , 'Girafon' , 'M', '5-apr-2000', '4-nov-2008', 'Girafe de Rothschild') ;
insert into pensionnaire values ('MG4' , 'Girafa' , 'F', '25-mar-2000', '4-nov-2008', 'Girafe de Rothschild') ;
insert into pensionnaire values ('MG5' , 'Girafine' , 'F', '25-mar-2007', '4-nov-2008', 'Girafe de Rothschild') ;
insert into pensionnaire values ('MG6' , 'Girafon_Junior' , 'F', '24-jun-2009', '24-jun-2009', 'Girafe de Rothschild') ;


insert into gardien values ('AC1','Colinet','Antoine','H');
insert into gardien values ('DM1','Dupont','Marie','F');
insert into gardien values ('LL1','Linne','Lise','F');
insert into gardien values ('SO1','Saporta','Olivier','H');

insert into soigne values('OE1','AC1','23-apr-2010',null);
insert into soigne values('OE2','AC1','23-apr-2010',null);
insert into soigne values('OE3','AC1','23-apr-2010',null);
insert into soigne values('OE4','AC1','23-apr-2010',null);
insert into soigne values('OI1','AC1','3-mar-2008','4-mar-2011');
insert into soigne values('OI1','DM1','5-mar-2011','24-jun-2012');
insert into soigne values('OI1','LL1','25-jun-2012','24-jun-2013');
insert into soigne values('OI1','SO1','25-jun-2013',null);
insert into soigne values('PV1','SO1','3-jun-2009',null);
insert into soigne values('PV2','SO1','3-jun-2009',null);
insert into soigne values('TT1','SO1','7-jun-2007','6-jul-2007');
insert into soigne values('TT2','LL1','7-jul-2007',null);
insert into soigne values('TT1','LL1','7-jul-2007',null);
insert into soigne values('MW1','LL1','5-jun-2003',null);
insert into soigne values('MW2','LL1','5-jun-2004',null);
insert into soigne values('MG1','DM1','5-jul-2004',null);
insert into soigne values('MG2','DM1','10-nov-2010',null);
insert into soigne values('MG3','DM1','4-nov-2008',null);
insert into soigne values('MG4','DM1','4-nov-2008',null);
insert into soigne values('MG5','DM1','4-nov-2008',null);
insert into soigne values('MG6','DM1','24-jun-2009',null);

commit;

