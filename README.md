# API Rest Fórum Alura | Spring Boot | ONE

## Descrição

Esta é uma API REST desenvolvida com Spring Boot para o programa Oracle Next Education. Ela fornece endpoints para gerenciar tópicos do fórum (/topicos), realizar login (/login) e cadastrar usuários (/cadastrar). A autenticação é feita utilizando JWT (JSON Web Token) com um tempo de validade de 2 horas.

## Endpoints

### 1. Criar Tópicos

- **Endpoint**: `/topicos`
- **Descrição**: Permite criar novos tópicos de dúvidas no fórum.
- **Método HTTP**: POST
- **Corpo da Requisição**: JSON com os dados do tópico a ser criado.

### 2. Login

- **Endpoint**: `/login`
- **Descrição**: Permite que os usuários façam login na plataforma.
- **Método HTTP**: POST
- **Parâmetros da Requisição**: Nome de usuário e senha.
- **Resposta**: Retorna um token JWT válido por 2 horas.

### 3. Cadastrar Usuários

- **Endpoint**: `/cadastrar`
- **Descrição**: Permite o cadastro de novos usuários na plataforma.
- **Método HTTP**: POST
- **Corpo da Requisição**: JSON com os dados do usuário a ser cadastrado.

## Autenticação e Autorização

A API utiliza JSON Web Token (JWT) para autenticação. Após o login bem-sucedido, um token JWT é gerado e deve ser incluído no cabeçalho das requisições subsequentes para endpoints protegidos. Este token tem validade de 2 horas.

## Documentação da API

A documentação da API pode ser acessada através do endpoint `/swagger-ui/index.html`. Lá você encontrará detalhes sobre todos os endpoints, seus parâmetros, respostas e exemplos de uso.

## Executando o Projeto

Para executar o projeto localmente, siga os passos abaixo:

1. Certifique-se de ter o Java JDK e o Maven instalados em sua máquina.
2. Clone este repositório.
3. Navegue até o diretório do projeto.
4. Execute o comando `mvn spring-boot:run`.
5. A API estará disponível em `http://localhost:8080`.

## Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue caso encontre algum problema ou para propor melhorias.
Eu sou João Arthur Britto, o desenvolvedor por trás da API Rest Forum-Alura. Com uma paixão por programação, criei esta aplicação como forma de aprendizado da linguagem Java e seu framework Spring Boot e conclusão de uma das etapas da formação de Back-end com Java proposta pelo programa ONE - Oracle Next Education.

Se você tiver alguma dúvida, sugestão ou comentário, sinta-se à vontade para entrar em contato comigo. Você pode me encontrar em <b>joaoabritto.dev@gmail.com</b>, ou visitar meu perfil no [GitHub](https://github.com/j0aoarthur) e [LinkedIn](https://www.linkedin.com/in/joao-arthur-britto).

## 🎖️ Badge recebida pela conclusão do projeto

<p align="center">
     <img width="500" alt="Badge recebida pela Alura e a Oracle pela conclusão do projeto" src="https://github.com/j0aoarthur/Forum-Alura-ONE/assets/121466923/3b545150-b5ed-4ce4-aeb8-e6dcaffdfb13">
</p>
