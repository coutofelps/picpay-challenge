# Desafio Técnico do PicPay - Aplicação Spring Boot

Este projeto foi desenvolvido como parte do desafio técnico proposto pelo PicPay. O objetivo do desafio era desenvolver uma aplicação Spring Boot que resolvesse os requisitos especificados no [repositório do GitHub do PicPay](https://github.com/PicPay/picpay-desafio-backend).

## Descrição do Projeto

A aplicação desenvolvida é uma solução para o problema proposto pelo PicPay. Ela consiste em um sistema de pagamentos, onde é possível realizar transações entre diferentes usuários. A aplicação oferece endpoints para criar novas transações, listar transações existentes e buscar o saldo de um usuário.

## Tecnologias Utilizadas

- **Spring Boot**: Utilizado como framework principal para o desenvolvimento da aplicação.
- **JUnit**: Utilizado para escrever e executar testes unitários.
- **Mockito**: Utilizado para criação de mocks e stubs em testes unitários.

## Estrutura do Projeto

A estrutura do projeto segue os padrões convencionais do Spring Boot:

- `src/main/java`: Contém o código fonte da aplicação.
- `src/test/java`: Contém os testes unitários.
- `src/main/resources`: Contém arquivos de configuração da aplicação.

## Executando a Aplicação

Para executar a aplicação, é necessário ter o Java e o Maven instalados. Após clonar o repositório, execute o seguinte comando na raiz do projeto:

```bash
mvn spring-boot:run
```

Isso iniciará a aplicação na porta padrão 8080.

## Executando os Testes

Para executar os testes unitários, utilize o seguinte comando:

```bash
mvn test
```

## Endpoints Disponíveis

A aplicação oferece os seguintes endpoints:

- `POST /transaction`: Cria uma nova transação.
- `GET /transaction`: Retorna todas as transações existentes.
- `GET /balance/{userId}`: Retorna o saldo do usuário com o ID especificado.

## Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para enviar pull requests ou abrir issues para discutir novas funcionalidades, melhorias ou correções de bugs.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

---

## Dependências do Projeto

Este projeto utiliza as seguintes dependências:

- **Spring Boot Starter Data JPA**: Fornece suporte ao Spring Boot para integração com JPA (Java Persistence API).
- **Spring Boot Starter Web**: Oferece suporte ao desenvolvimento de aplicativos da web usando o Spring MVC e o Tomcat incorporado.
- **Spring Boot DevTools**: Fornece ferramentas de desenvolvimento adicionais para aumentar a produtividade, como reinicialização automática do servidor.
- **H2 Database**: Um banco de dados em memória frequentemente usado para desenvolvimento e testes.
- **Project Lombok**: Uma biblioteca que automatiza a geração de código repetitivo, como getters, setters e construtores.
- **Spring Boot Starter Test**: Fornece suporte para escrever e executar testes automatizados na aplicação.

Essas dependências são essenciais para o desenvolvimento e execução da aplicação Spring Boot, fornecendo recursos para acesso a dados, desenvolvimento da interface web, ferramentas de desenvolvimento, banco de dados em memória e teste.
