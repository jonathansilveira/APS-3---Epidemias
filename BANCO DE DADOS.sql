#CRIAÇÃO DO BANCO DE DADOS
create database EPIDEMIA;

#UTILIZAÇÃO DO BANCO DE DADOS
use EPIDEMIA;

#CRIAÇÃO DO BANCO DE DADOS DOENÇA
create table DOENCA (
    idDoenca int (2) not null primary key default 1,
	nomeDoenca varchar (25),
    sintomaDoenca tinytext,
    causaDoenca tinytext,
    prevencaoDoenca tinytext,
    tratamentoDoenca tinytext,
    diagnosticoDoenca tinytext,
    anoDoenca date
)ENGINE=InnoDB; #Para seguir o padrão e adicionar os dados nas tabelas que tem FK

#CRIAÇÃO DO BANCO DE DADOS CIDADE
create table CIDADE (
idCidade	int	(2) not null auto_increment primary key,
id_Doenca int (2) default 1 ,
nomeCidade	varchar	(25),
numHabitantes	int	(6),
numInfectados int (6),
numMortes int (6),
numVacinados int (6),
dataAtualizacao date,
percentualInfectados numeric(5,2),
quantAmostra int (6),


foreign key (id_Doenca) references DOENCA(idDoenca)
)ENGINE=InnoDB;



