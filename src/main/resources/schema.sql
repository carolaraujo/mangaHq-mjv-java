/**
* O DROP DEVE OCORRER NA SEGUINTE ORDEM POR CONTA DE DEPENDENCIA ENTRE AS TABELAS.
* TOTAL DE 8 NOTICIAS, 6 MANGAS/HQS E 8 USUARIOS CADASTRADOS.
* A TABELA DE USUÁRIOS FICARÁ RESPONSAVEL PELOS MANGÁS/HQ QUE O MESMO POSSUI, 
	DEPOIS DEVE-SE REALIZAR O JOIN E LIMPAR A SELEÇÃO.
*/
DROP TABLE IF EXISTS TB_USUARIO_MANGASHQS;
DROP TABLE IF EXISTS TB_USUARIO;
DROP TABLE IF EXISTS TB_MANGAS_HQS;
DROP TABLE IF EXISTS TB_NOTICIAS;
-- NOTICIAS --
CREATE TABLE TB_NOTICIAS
(
   id_noticia INT AUTO_INCREMENT PRIMARY KEY,
   titulo VARCHAR (100) NOT NULL,
   textoConteudo VARCHAR (800) NOT NULL,
   urlImagem VARCHAR (500) NOT NULL,
   dataPublicacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   autor VARCHAR (50) NOT NULL,
   categoria VARCHAR(30) NOT NULL
);

--MANGAS_HQS--
CREATE TABLE TB_MANGAS_HQS
(
   id_mangahq INT AUTO_INCREMENT PRIMARY KEY,
   titulo VARCHAR (100) NOT NULL,
   autor VARCHAR (100) NOT NULL,
   urlCapa VARCHAR (800) NOT NULL,
   dataAdicao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   categoria VARCHAR (50) NOT NULL,
   volumes BIGINT NOT NULL,
   resumo VARCHAR(900) NOT NULL
);

--USUARIO--
CREATE TABLE TB_USUARIO(
	id_usuario INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(80) NOT NULL,
	login VARCHAR(20) NOT NULL,
	tipoUsuario VARCHAR(10) NOT NULL,
	dataCriacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


--USUARIO/MANGAHQ--
CREATE TABLE TB_USUARIO_MANGASHQS(
	fk_id_usuario INT NOT NULL,
	fk_id_mangahq INT NOT NULL,
	dataAdicao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (fk_id_usuario) REFERENCES TB_USUARIO(id_usuario),
	FOREIGN KEY (fk_id_mangahq) REFERENCES TB_MANGAS_HQS(id_mangahq)
);
-----------------------------------------------------------------------------------------------------------	
--INSERT TB_NOTICIAS--
INSERT INTO TB_NOTICIAS
(
   titulo,
   textoConteudo,
   urlImagem,
   autor,
   categoria
)
VALUES
('Confira as quatro novas HQs da Viúva-Negra pela Panini',
'Para os fãs do universo Marvel que estão ansiosos pela chegada do filme sobre a grande espiã russa Natasha Romanoff, a Editora Panini lança quatro HQs da Viúva-Negra que prometem aquecer os motores de quem quer acompanhar a incrível personagem. Com histórias bem diferentes umas das outras, as publicações permitem que os leitores conheçam mais a fundo a trajetória de Romanoff no universo dos quadrinhos. Lançadas no fim do mês de setembro, as novidades estarão disponíveis em todo o país.',
'https://estacaogeek.com.br/wp-content/uploads/2016/05/viuva-negra-trama-mais-delicada-768x427.jpg',
'Fernanda Mendes', 'HQ'),
('Panini lança linha Marvel Teens com foco em público adolescente',
'A Editora Panini anuncia o lançamento de Marvel Teens, linha voltada ao público adolescente com histórias focadas na nova geração de heróis, que promete deixar os fãs ainda mais apaixonados pelo Universo Marvel. Com os planos de lançar, ainda em 2020, quatro títulos com histórias incríveis, a primeira publicação protagonizada por Miles Morales, personagem do melhor filme de animação do Oscar de 2018, chegará aos pontos de venda da Editora em todo o país no próximo dia 9 de setembro.',
'https://estacaogeek.com.br/wp-content/uploads/2020/09/destaque-milesmorales-696x392.jpg',
'Anna Nascimento', 'HQ'),
('Batman Day é comemorado pela Panini com eventos digitais e descontos em HQs',
'No próximo dia 19 de setembro, é comemorado o Batman Day 2020 em todo o mundo. Para que no Brasil a data possa ser celebrada por todos os fãs do Homem-Morcego em grande estilo, a editora Panini preparou algumas surpresas, como lives, HQ especial, sessão de autógrafos e promoções que acontecem durante o mês de setembro.',
'https://estacaogeek.com.br/wp-content/uploads/2020/09/174438-672x420.jpg',
'Anna Nascimento', 'HQ'),
('Haikyu!! | Mangá chega ao fim neste mês no Japão',
'O mangá, de Haruichi Furudate, começou a ser publicado em fevereiro de 2012 na revista Weekly Shōnen Jump. Agora, 43 volumes depois, e mais popular do que nunca, o derradeiro final está próximo.',
'https://estacaogeek.com.br/wp-content/uploads/2020/07/ef4e129c7c85bcd6868e019714063b64-768x432.jpg',
'Sérgio Henrique de Araújo', 'MANGA'),
('Novo Mangá de Death Note chega ao Brasil pela Editora JBC',
'A Editora JBC traz para o Brasil o one-shot inédito de Death Note, recém lançado no Japão. A história fechada em 88 páginas é assinada pela Takeshi Obata e Tsugumi Ohba, os mesmos autores do mangá original, e será publicada em formato e-book ainda em fevereiro nas principais plataformas digitais (Amazon Kindle, Google Play Books, Kobo Rakuten e iBooks).',
'https://estacaogeek.com.br/wp-content/uploads/2020/02/deathnote-one-hot-jbc.jpg',
'Sérgio Henrique de Araújo', 'MANGA'),
('O Regresso de Jaspion: graphic novel disponível também em versão digital',
'Mês passado, a Editora JBC iniciou a pré-venda da graphic novel O Regresso de Jaspion, que conta com roteiro de Fábio Yabu e arte de Michel Borges. Em alguns dias começa o envio da revista para os leitores, e além da versão física a editora acaba de disponibilizar também a versão digital.',
'http://images.universohq.com/2020/09/RegressoJaspion01_des01-1024x350.jpg',
'Samir Naliato', 'MANGA'),
('Apagão, HQ de Raphael Fernandes, ganha continuação e vira card game',
'Em 2014, a editora Draco publicou o especial Apagão Extra - Ligação Direta, e no ano seguinte este universo foi expandido com a a edição Apagão - Cidade sem lei/luz, criação do roteirista Raphael Fernandes que contou ainda com desenhos do artista Camaleão. A ideia veio com um blecaute real que aconteceu em São Paulo, em 10 de novembro de 2009. Naquela noite, Raphael descobriria, ao sair de um show, o horror de ver a cidade sem pessoas na rua e em uma escuridão total.',
'http://images.universohq.com/2020/10/ApagaoFrutoProibido_des01-1024x350.jpg',
'Samir Naliato', 'HQ'),
('Faleceu o quadrinhista Alex Varenne',
'Faleceu, no último dia 20 de outubro, aos 81 anos, o quadrinhista Alex Varenne. Varenne nasceu no dia 29 de agosto de 1939 em Saint-Germain-au-Mont-dor, na França. Ele foi cartunista, pintor, quadrinhista e professor de artes plásticas. Teve seus primeiros trabalhos de ficção cientifica publicados na revista francesa Charlie Mensuel, e de erotismo na Écho des Savanes, no final da década de 1970. Nessa época os roteiros eram de seu irmão, Daniel.',
'http://images.universohq.com/2020/10/alex_1170_400-1024x350.jpg',
'Marcelo Naranjo', 'HQ');

--INSERT TB_MANGAS_HQS--
INSERT INTO TB_MANGAS_HQS
(
	titulo,
	autor,
 	urlCapa,
 	categoria,
 	volumes,
 	resumo
)
VALUES
('Demon Slayer - Kimetsu No Yaiba', 'Koyoharu Gotouge', 
'https://upload.wikimedia.org/wikipedia/pt/thumb/4/45/Kimetsu_no_Yaiba_%28capa_do_volume_1%29.png/210px-Kimetsu_no_Yaiba_%28capa_do_volume_1%29.png',
'MANGA', 18, 
'Ambientada no Japão durante o Período Taishō (1912-1926), a história gira ao entorno de Tanjirō Kamado, um garoto bondoso e inteligente que vive junto com sua mãe e seus irmãos, ganhando dinheiro vendendo carvão, assim como seu falecido pai.'),
('Berserk', 'Kentaro Miura', 
'https://upload.wikimedia.org/wikipedia/pt/thumb/4/45/Berserk_vol01.jpg/200px-Berserk_vol01.jpg',
'MANGA', 40, 
'Guts é um guerreiro errante e antigo Comandante da Tropa de Assalto da renomada unidade mercenária conhecida como o "Bando do Falcão" (鷹の団 Taka no Dan?). Ele, agora, caça criaturas demoníacas chamadas Apóstolos, humanos que fizeram um pacto com um grupo de arquidemônios conhecidos como "A Mão de Deus" que exige o sacrifício de qualquer coisa ou pessoa que for mais achegado a eles em troca de um poder sobrenatural incrível.'),
('Gantz', 'Hiroya Oku',
'https://m.media-amazon.com/images/I/81PTql2cU1L._AC_UY218_.jpg',
'MANGA', 37, 
'Kei Kurono é um jovem, inseguro e pervertido. Nunca se importou com nada e com ninguém. Um dia após voltar da escola encontra no metrô um antigo conhecido seu, que não vê desde quando era uma criança, Masaru Katou. De início o ignora mas este observa um mendigo bêbado caindo nos trilhos.'),
('Batman - A queda do morcego', 'Alan Grant', 
'https://images-na.ssl-images-amazon.com/images/I/51+NxT3h5zL._SX334_BO1,204,203,200_.jpg',
'HQ', 3,
'Publicada ao longo dos anos de 1993 e 1994 nos Estados Unidos, a saga foi dividida em 3 partes: A Queda (KnightFall); A Cruzada/A Busca (Knightquest); e O Fim (KnightsEnd). Abarcou todos os bat-títulos da época como Detectives Comics, Batman, Batman: Shadow of the Bat, Robin, Catwoman, Batman Annual, Batman: Legends of the Dark Knight e outras séries como Showcase e Justice League Task Force.'),
('Sandman', 'Neil Gaiman', 
'https://images-na.ssl-images-amazon.com/images/I/41BL4glqIFL._SX325_BO1,204,203,200_.jpg',
'HQ', 75,
'A história é vista do ponto de vista de Sonho, um dentre os sete perpétuos, a representação antropomórfica do sonho, inicialmente preso por um grupo de humanos que almejava prender sua irmã mais velha Morte para que se tornassem imortais, mas falham e capturam sonho.');

--INSERT TB_USUARIO--
INSERT INTO TB_USUARIO (
	nome,
	login,
	tipoUsuario
) VALUES 
('João', 'jonjon', 'NORMAL'),
('Maria', 'mari22', 'NORMAL'),
('Jose', 'joseali', 'ADMIN'),
('Rafaela', 'rafa2000', 'ADMIN'),
('Jorge', 'jorge', 'NORMAL'),
('Manuel', 'manuca', 'NORMAL'),
('Renato', 'qwe', 'ADMIN'),
('Flora', 'asd', 'NORMAL');

--INSERT TB_USUARIO_MANGASHQS --
INSERT INTO TB_USUARIO_MANGASHQS (fk_id_usuario, fk_id_mangahq)
VALUES 
(1, 1),
(1, 2),
(2, 3),
(2, 5),
(3, 1),
(3, 3),
(4, 1),
(4, 2),
(4, 3),
(4, 4),
(4, 5),
(7, 2),
(7, 1),
(7, 5),
(8, 2),
(8, 3);


