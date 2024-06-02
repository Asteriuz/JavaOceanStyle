# Sprint 01 - EconoMed

-   *Java Advanced*

## Integrantes do Grupo

-   Augusto Barcelos Barros – RM: 98078 - Turma: 2TDSS
-   Izabelly De Oliveira Menezes - RM: 551423
-   Lucas Pinheiro de Melo – RM: 97707 - Turma: 2TDSS
-   Marcos Henrique Garrido da Silva - RM: 99578
-   Mel Maia Rodrigues – RM: 98266

## Detalhes

Esse projeto tem como objetivo, mostrar em detalhes, parte da nossa solução para a Global Solution 2024, Economia Azul.

Utilizamos um sistema de Banco de Dados relacional, para armazenar e manipular os dados necessários para o desenvolvimento do projeto.

A pasta database, contém arquivos referentes ao nosso banco de dados, que é responsável por mostrar um pouco mais sobre como ele é estruturado, possuindo nossos modelos lógicos e relacionais.

A pasta requests, contém arquivos referentes às requisições de nossos endpoints, podendo ser utilizado em algum programa como o Postman ou Insomnia para que seja possivel a vizualização e teste de nossas requisições.

## ⚠ Sobre o projeto

O objetivo desta solução é identificar e monitorar veículos aquáticos que ultrapassam os limites de ruído durante a navegação, já que o barulho emitido pelos barcos prejudica significativamente a vida marinha. Para alcançar essa meta, propomos a implementação de uma vistoria obrigatória para todos os barcos, com o propósito de verificar suas condições acústicas.

Durante a vistoria, será medido o nível de ruído emitido pelo barco. Se o barco emitir um ruído igual ou superior a 100 dB, será reprovado na vistoria. Os proprietários dos barcos reprovados deverão realizar melhorias no motor ou substituí-lo, conforme necessário, para reduzir o impacto negativo sobre a vida marinha.

Esta medida visa mitigar a poluição sonora nos oceanos, protegendo a biodiversidade marinha e promovendo a sustentabilidade dos ecossistemas aquáticos.

Temos também, ideias que vão muito além de código, para poder analisar e entender melhor o som que cada navio emite e o quanto isso afeta os animais marinhos, colocando hidrofones e boias e analisando o som emitido nos oceanos, e assim, poder identificar o navio barulhento, e agir de forma mais eficaz.

## Instruções para uso

### 1. Clone o repositório do projeto ou baixe os arquivos do zip:

bash
git clone https://github.com/Asteriuz/JavaOceanStyle


### 2. Inicialize o projeto Maven na sua IDE:

#### No diretório do projeto, onde esta o arquivo pom.xml

bash
mvn clean install


### 3. Execute o projeto

bash
mvn spring-boot:run


### 4. Teste usando seu API tester de preferência (Postman/Insomnia):

Copie nosso arquivo mais recente .json dentro da pasta requests, e importe em seu API tester, para que assim, veja as requisições possíveis.

## Requisitos

-   *Java*

## Dependências

-   *spring-boot-starter-web*
    -   Fornece recursos essenciais para desenvolver aplicativos da web no Spring Boot, como configuração do servidor incorporado e suporte a RESTful.
-   *spring-boot-devtools*
    -   Facilita o desenvolvimento ao oferecer ferramentas como reinicialização automática do aplicativo e configurações específicas de desenvolvimento.
-   *ojdbc11 & ojdbc8*
    -   Drivers JDBC para Oracle Database, permitindo a conexão e interação de aplicativos Java com o Oracle Database nas versões 11g e 12c, respectivamente.
-   *lombok*
    -   Reduz a verbosidade do código Java automatizando a geração de métodos padrão, como getters, setters e construtores, através de anotações.
-   *spring-boot-starter-test*
    -   Oferece suporte para testes em aplicativos Spring Boot, incluindo bibliotecas como JUnit e Mockito, simplificando a escrita e execução de testes.
-   *spring-boot-starter-data-jpa*
    -   Simplifica o acesso e manipulação de dados em bancos de dados através do Spring Data JPA, configurando automaticamente a camada de persistência para trabalhar com JPA em aplicativos Spring Boot.

# Funcionalidade

O sistema possui diversas funcionalidades CRUD para nossas entidades:

## 1. Veiculo

O Veiculo é nossa entidade "principal", pois é ele que iremos utilizar para as análises. Em nosso veiculo, podemos fazer o CRUD completo pois é nele que manipulamos seus dados.

-   *Create*
-   *List all*
-   *Search by id*
-   *Update*
-   *Delete*

## 2. Empresa

A empresa é a base de todos nossos navios e barcos, armazenando os dados da responsável pelos veiculos. Aqui, temos todos os dados da Empresa, por isso, temos o CRUD completo.

-   *Create*
-   *List all*
-   *Search by id*
-   *Update*
-   *Delete*

## 3. Vistoria

A Vistoria é uma entidade responsável por armazenar os dados de resultados da vistoria de um certo veiculo, para conseguir ver os resultados, data, etc. Como a Vistoria possui os dados base, então nela, temos o CRUD completo.

-   *Create*
-   *List all*
-   *Search by id*
-   *Update*
-   *Delete*

## 4. Inspetor

No Inspetor, armazenamos os dados de todas os inspetores que podem fazer a vistoria nos veiculos. Nela, temos o CRUD completo, pois podemos fazer toda manipulação dele independentemente da vistoria.

-   *Create*
-   *List all*
-   *Search by id*
-   *Update*
-   *Delete*

## 5. Estado Empresa

No Endereço Empresa, temos todos os dados de endereço da empresa. Aqui, possuímos o CRUD completo.

-   *Create*
-   *List all*
-   *Search by id*
-   *Update*
-   *Delete*

## 6. Cidade Empresa

Na Cidade Empresa, temos todos os dados da cidade de uma empresa. Aqui, possuímos o CRUD completo.

-   *Create*
-   *List all*
-   *Search by id*
-   *Update*
-   *Delete*

## 7. Endereço Empresa

No Endereço Empresa, temos todos os dados de endereço. Aqui, possuímos o CRUD completo.

-   *Create*
-   *List all*
-   *Search by id*
-   *Update*
-   *Delete*

# Estrutura

O sistema está organizado seguindo a arquitetura MVC:

-   *controller*: Classes que lidam com solicitações HTTP, invocando a lógica de negócios apropriada e retornando respostas HTTP.
-   *dto*: Classes que transferem dados entre diferentes partes do sistema, frequentemente refletindo a estrutura dos dados das solicitações e respostas HTTP.
-   *handler*: Classes que lidam com exceções específicas ou globais no aplicativo.
-   *model*: Classes que representam os objetos de negócios do aplicativo.
-   *repository*: Classes ou interfaces que definem operações de acesso a dados para interagir com o banco de dados.