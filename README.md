# Desafio técnico

## 🔌 Esta aplicação utilizou-se das seguintes tecnologias

* [Flyway Migration](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#howto.data-initialization.migration-tool.flyway)

* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web)

* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#data.sql.jpa-and-spring-data)

  
  

##  🔥 Como usar?

 Pra você usar esse projeto você irá precisar seguir alguns passos:
 
#### 💾 MySQL
* Você vai precisar apenas ter um servidor **MySQL** instalado na sua máquina rodando na porta padrão **3306**
* Usuário **root** e senha também **root**
* E você irá precisar criar um banco de dados chamado **tech-challenge**
* Você pode fazer isso mais facilmente utilizando Docker e irá apenas precisar rodar este comando
* `docker pull mysql`
* `docker run --name some-mysql -e -p 3306:3306 MYSQL_ROOT_PASSWORD=root -d mysql:latest
`

#### 🔒 CPF Validator
* Você também irá precisar realizar o **git clone** e rodar o projeto que realiza a **[verificação de CPF's](https://github.com/ghisiluizgustavo/tc-cpf)** através deste repositório
* Este projeto não tem nenhuma dependência externa como um banco de dados, então apenas baixando e rodando você já será capaz de usar dele
