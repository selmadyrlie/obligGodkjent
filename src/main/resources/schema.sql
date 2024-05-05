CREATE TABLE Billett (
                         ID        INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
                         fornavn   VARCHAR(255) NOT NULL,
                         etternavn VARCHAR(255) NOT NULL,
                         tlf       VARCHAR(10) NOT NULL,
                         epost     VARCHAR(255) NOT NULL
);