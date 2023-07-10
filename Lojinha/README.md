# PROJETO LOJINHA EM JAVA

O objetivo desse projeto foi aplicar os conhecimentos adquiridos em Programação Orientada a Objetos e Banco de Dados Relacionais usando Java e MySQL, com a criação de um CRUD simples.

### Banco de dados MySQL

Foi criado um BD para ter a base do projeto. Esse BD era composto de 1 tabela com 7 colunas:

##### 1 - ID (primary key que era gerado junto com qualquer item adicionado na tabela em uma soma do anterior + 1)
##### 2 - setor
##### 3 - modelo
##### 4 - tamanho 
##### 5 - cor
##### 6 - preco 
##### 7 - estoque

Com a criação da tabela e a definição dos tipos de dados de cada coluna, seguimos com o código Java que interage diretamente com ela.

### Java

O código foi dividido em 2 packages: 
##### 1 - estoque
Nesse package, tem as classes referentes a tudo o que e necessário para o programa rodar e acessar o BD de forma segura: os métodos getters e setters (Categorias.java), a conexão com o Banco de Dados (Conexao.java), a classe Main que é responsável por rodar tudo (Main.java) e a classe Comandos.java que inicialmente foi criada para organizar os comandos CRUD, porém achei melhor deixá-los junto das GUIs (explicadas mais a frente) e mantive essa classe apenas para registro do pensamento.
* o arquivo senha.txt é só para armazenar a senha do BD local fora do código

##### 2 - GUIs
Como o nome diz, nesse package temos as interfaces gráficas que fazem o usuário interagir diretamente com o BD. Todas foram criadas usando o Java Swing (algumas do 0, outras usando layouts). 
Com exceção da classe Tudo.java, todas as outras são representação de uma ação no CRUD:

* CREATE -> cria um novo item na tabela / adiciona um novo produto ao estoque da lojinha
* READ   -> mostra a tabela atualizada 
* UPDATE -> atualiza a coluna "estoque" / simulação de uma venda ou compra, onde a quantidade de produtos no estoque diminui ou aumenta
* DELETE -> deleta um item da tabela

A classe Tudo.java é como uma espécie de guia para o usuário executar a ação desejada 





