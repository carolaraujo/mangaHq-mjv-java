DROP TABLE IF EXISTS TB_NOTICIAS;
-- NOTICIAS --
CREATE TABLE TB_NOTICIAS
(
   id INT AUTO_INCREMENT PRIMARY KEY,
   titulo VARCHAR (50) NOT NULL,
   textoConteudo VARCHAR (500) NOT NULL,
   urlImagem VARCHAR (200) NOT NULL,
   dataPublicacao DATE NOT NULL,
   autor VARCHAR (50) NOT NULL
);
INSERT INTO TB_NOTICIAS
(
   titulo,
   textoConteudo,
   urlImagem,
   dataPublicacao,
   autor
)
VALUES
('Titulo','Texto.','IMG','2020-10-10','Autor');
