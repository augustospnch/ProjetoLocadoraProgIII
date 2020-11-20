CREATE DATABASE locadora;
USE locadora;

CREATE TABLE filme (
    idFilme int NOT NULL auto_increment primary key,
    titulo varchar(50),
    tempo int,
    sinopse varchar(500),
    categoria varchar(20),
	imagem3d tinyint,
    audio tinyint
);

CREATE TABLE cliente (
	idCliente int NOT NULL auto_increment primary key,
    nome varchar(50),
    email varchar(30),
    telefone varchar(11),
    endereço varchar(60),
    cpf int
);