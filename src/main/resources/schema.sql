DROP TABLE IF EXISTS TB_NOTICIAS;
-- NOTICIAS --
CREATE TABLE TB_NOTICIAS
(
   id INT AUTO_INCREMENT PRIMARY KEY,
   titulo VARCHAR (100) NOT NULL,
   textoConteudo VARCHAR (800) NOT NULL,
   urlImagem VARCHAR (500) NOT NULL,
   dataPublicacao DATE NOT NULL,
   autor VARCHAR (50) NOT NULL,
   acessos BIGINT NOT NULL
);
INSERT INTO TB_NOTICIAS
(
   titulo,
   textoConteudo,
   urlImagem,
   dataPublicacao,
   autor,
   acessos
)
VALUES
('Confira as quatro novas HQs da Viúva-Negra pela Panini',
'Para os fãs do universo Marvel que estão ansiosos pela chegada do filme sobre a grande espiã russa Natasha Romanoff, a Editora Panini lança quatro HQs da Viúva-Negra que prometem aquecer os motores de quem quer acompanhar a incrível personagem. Com histórias bem diferentes umas das outras, as publicações permitem que os leitores conheçam mais a fundo a trajetória de Romanoff no universo dos quadrinhos. Lançadas no fim do mês de setembro, as novidades estarão disponíveis em todo o país.',
'https://estacaogeek.com.br/wp-content/uploads/2016/05/viuva-negra-trama-mais-delicada-768x427.jpg',
'2020-10-6',' Fernanda Mendes', '150'),
('Panini lança linha Marvel Teens com foco em público adolescente',
'A Editora Panini anuncia o lançamento de Marvel Teens, linha voltada ao público adolescente com histórias focadas na nova geração de heróis, que promete deixar os fãs ainda mais apaixonados pelo Universo Marvel. Com os planos de lançar, ainda em 2020, quatro títulos com histórias incríveis, a primeira publicação protagonizada por Miles Morales, personagem do melhor filme de animação do Oscar de 2018, chegará aos pontos de venda da Editora em todo o país no próximo dia 9 de setembro.',
'https://estacaogeek.com.br/wp-content/uploads/2020/09/destaque-milesmorales-696x392.jpg',
'2020-10-8', 'Anna Nascimento', '96'),
('Batman Day é comemorado pela Panini com eventos digitais e descontos em HQs',
'No próximo dia 19 de setembro, é comemorado o Batman Day 2020 em todo o mundo. Para que no Brasil a data possa ser celebrada por todos os fãs do Homem-Morcego em grande estilo, a editora Panini preparou algumas surpresas, como lives, HQ especial, sessão de autógrafos e promoções que acontecem durante o mês de setembro.',
'https://estacaogeek.com.br/wp-content/uploads/2020/09/174438-672x420.jpg',
'2020-10-10', 'Anna Nascimento', '320'),
('Haikyu!! | Mangá chega ao fim neste mês no Japão',
'O mangá, de Haruichi Furudate, começou a ser publicado em fevereiro de 2012 na revista Weekly Shōnen Jump. Agora, 43 volumes depois, e mais popular do que nunca, o derradeiro final está próximo.',
'https://estacaogeek.com.br/wp-content/uploads/2020/07/ef4e129c7c85bcd6868e019714063b64-768x432.jpg',
'2020-10-11', 'Sérgio Henrique de Araújo', '42'),
('Novo Mangá de Death Note chega ao Brasil pela Editora JBC',
'A Editora JBC traz para o Brasil o one-shot inédito de Death Note, recém lançado no Japão. A história fechada em 88 páginas é assinada pela Takeshi Obata e Tsugumi Ohba, os mesmos autores do mangá original, e será publicada em formato e-book ainda em fevereiro nas principais plataformas digitais (Amazon Kindle, Google Play Books, Kobo Rakuten e iBooks).',
'https://estacaogeek.com.br/wp-content/uploads/2020/02/deathnote-one-hot-jbc.jpg',
'2020-10-15', 'Sérgio Henrique de Araújo', '419'),
('O Regresso de Jaspion: graphic novel disponível também em versão digital',
'Mês passado, a Editora JBC iniciou a pré-venda da graphic novel O Regresso de Jaspion, que conta com roteiro de Fábio Yabu e arte de Michel Borges. Em alguns dias começa o envio da revista para os leitores, e além da versão física a editora acaba de disponibilizar também a versão digital.',
'http://images.universohq.com/2020/09/RegressoJaspion01_des01-1024x350.jpg',
'2020-10-20', 'Samir Naliato', '299'),
('Apagão, HQ de Raphael Fernandes, ganha continuação e vira card game',
'Em 2014, a editora Draco publicou o especial Apagão Extra - Ligação Direta, e no ano seguinte este universo foi expandido com a a edição Apagão - Cidade sem lei/luz, criação do roteirista Raphael Fernandes que contou ainda com desenhos do artista Camaleão. A ideia veio com um blecaute real que aconteceu em São Paulo, em 10 de novembro de 2009. Naquela noite, Raphael descobriria, ao sair de um show, o horror de ver a cidade sem pessoas na rua e em uma escuridão total.',
'http://images.universohq.com/2020/10/ApagaoFrutoProibido_des01-1024x350.jpg',
'2020-10-20','Samir Naliato', '211'),
('Faleceu o quadrinhista Alex Varenne',
'Faleceu, no último dia 20 de outubro, aos 81 anos, o quadrinhista Alex Varenne. Varenne nasceu no dia 29 de agosto de 1939 em Saint-Germain-au-Mont-dor, na França. Ele foi cartunista, pintor, quadrinhista e professor de artes plásticas. Teve seus primeiros trabalhos de ficção cientifica publicados na revista francesa Charlie Mensuel, e de erotismo na Écho des Savanes, no final da década de 1970. Nessa época os roteiros eram de seu irmão, Daniel.',
'http://images.universohq.com/2020/10/alex_1170_400-1024x350.jpg',
'2020-10-21', 'Marcelo Naranjo', '415');






