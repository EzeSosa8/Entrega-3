-- Active: 1699997124528@@127.0.0.1@3306@phpmyadmin
CREATE DATABASE registro_mant;

USE registro_mant;

CREATE TABLE edificio (
  id_edificio INT(4) NOT NULL PRIMARY KEY,
  direccion VARCHAR(50) NOT NULL,
  localidad VARCHAR(50) NOT NULL,
);

CREATE TABLE contratista (
  id_contratista INT(8) NOT NULL PRIMARY KEY,
  razonSocial VARCHAR(20) NOT NULL,
  email VARCHAR(50) NOT NULL,
  telefono INTEGER(20) NOT NULL,
);

CREATE TABLE equipamiento (
  id_equipamiento INT(10) NOT NULL PRIMARY KEY,
  marca VARCHAR(20) NOT NULL,
  modelo VARCHAR(20) NOT NULL,
  capacidad DOUBLE NOT NULL,
  FOREIGN KEY (id_edificio) REFERENCES edificio(id_edificio),
);

CREATE TABLE ordenServicio (
  id INT(15) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  descripcion VARCHAR(500) NOT NULL,
  plazo INTEGER(4) NOT NULL,
  fechaInicio DATE NOT NULL,
  fechaFin DATE NOT NULL,
  FOREIGN KEY (id_edificio) REFERENCES edificio(id_edificio),
  FOREIGN KEY (id_contratista) REFERENCES contratista(id_contratista),
  FOREIGN KEY (id_equipamiento) REFERENCES equipamiento(id_equipamiento),
);

INSERT INTO edificio VALUES (1000, 'Casa Central, Bme Mitre 441', 'caba');
INSERT INTO edificio VALUES (3008, 'Flores, Av. Rivadavia 11897', 'caba');

INSERT INTO contratista VALUES (1, 'Climacentral', 'info@climacentral.com', 46252436);
INSERT INTO contratista VALUES (2, 'Mejores', 'info@mejores.com', 48904785);

INSERT INTO equipamiento VALUES (1, 'Daikin', 'Split', 3000, 1000);
INSERT INTO equipamiento VALUES (2, 'Carrier', 'Split', 6000, 1000);
INSERT INTO equipamiento VALUES (3, 'Carrier', 'Split', 4500, 3008);

INSERT INTO ordenServicio VALUES ('Reparar compresor', 10, 2024-01-01, 2024-01-11, 1000, 1, 1);
INSERT INTO ordenServicio VALUES ('Completar carga de gas', 5, 2024-01-01, 2024-01-06, 3008, 2, 3);

SELECT * FROM ordenServicio
WHERE fechaFin BETWEEN '2024-01-05' AND '2024-01-15';

DELETE FROM edificio;
DELETE FROM contratista;
DELETE FROM equipamiento;
DELETE FROM ordenServicio;