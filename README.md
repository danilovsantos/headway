# headway
Projeto criado para avaliação técnica profissional.

PROBLEMA:

Consumir um arquivo contendo movimentação de vendas do primeiro trimestre de algumas filiais de uma empresa hipotética e exibir:

- Filial que mais vendeu no período;
- Filial que teve o maior crescimento;
- Filial que teve a maior queda nas vendas;
- Mês em que a empresa mais vendeu.

SOLUÇÃO:

-Criação de interface web para upload de arquivo csv e exibição dos resultados.

ARQUITETURA:

JAVA 8
SPRING MVC
JSP
MAVEN

INSTALAÇÃO E EXECUÇÃO:

- Faça git clone do projeto.
- Dentro da IDE selecione o menu File > Import > Existing Maven Projects.
- Selecione a pasta do projeto e o arquivo pom.xml.
- Clique no projeto dentro da IDE e selecione a opção Maven > Update Project.
- Execute o comando mvn install no diretório onde o arquivo pom.xml se encontra.
- Execute o método main da classe "br.com.headway.exame.test.TesteUploadMovimentacao" informando os parâmetros de pesquisa.
- Ou faça deploy do arquivo "workspace/headway/target/headway.war" em seu servidor de aplicação.
- Acesse a url "http://localhost:8080/headway/uploadFile".
