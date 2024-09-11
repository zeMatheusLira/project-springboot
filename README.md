# Project Spring Boot

## Descrição

Este é um projeto desenvolvido utilizando o framework Spring Boot. O objetivo principal é criar uma API RESTful robusta e escalável, aplicando boas práticas de desenvolvimento backend e utilizando Java como linguagem principal.

## Funcionalidades

- **CRUD completo**: Implementação das operações de criação, leitura, atualização e exclusão.
- **Integração com banco de dados em memória usando JPA/Hibernate**: O projeto utiliza JPA com a implementação Hibernate para mapeamento objeto-relacional (ORM). A persistência de dados é feita em memória, sem a necessidade de um banco de dados externo. Isso é ideal para fins de desenvolvimento e testes rápidos.
- - **Injeção de Dependências com `@Autowired`**: Uso do `@Autowired` do Spring para gerenciar a injeção de dependências entre componentes, facilitando a modularidade e o desacoplamento do código.
- **Tratamento de exceções**: Customização de mensagens de erro com um sistema de exceções global.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação principal.
- **Spring Boot 3.x**: Framework para criação de aplicações Java.
- **Maven**: Gerenciamento de dependências e build.
- **JPA / Hibernate**: Mapeamento objeto-relacional (ORM).
- **Banco de dados**: Hibernate em memória.

## Modelo de domínio



## Instância de domínio



## Camadas lógicas 



## Instalação e Execução

### Pré-requisitos

- **Java 17** ou superior instalado.
- **Maven** instalado.
- Banco de dados configurado (-Apenas necessário se não quiser o hibernate em memória-) (PostgreSQL, MySQL, etc.).

### Passos para rodar o projeto:

1. Clone o repositório:
    ```bash
    git clone https://github.com/zeMatheusLira/project-springboot.git
    ```
2. Navegue até a pasta do projeto:
    ```bash
    cd project-springboot
    ```
3. Configure o arquivo `application.properties` com as informações do seu banco de dados (mesmo com o hibernate em memória tem que configurar ele).

5. Execute o projeto utilizando o Maven:
    ```bash
    mvn spring-boot:run
    ```

## Estrutura do Projeto

- **/src/main/java**: Contém a lógica da aplicação, incluindo os controladores, serviços e repositórios.
- **/src/main/resources**: Contém arquivos de configuração, como o `application.properties` e outros recursos.
- **/src/test/java**: Testes automatizados.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.

## Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo [LICENSE](./LICENSE) para mais detalhes.

