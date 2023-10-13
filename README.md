### Task Application
Este é um aplicativo de lista de tarefas (task list) desenvolvido em Java com Spring Boot. Permite aos usuários criar e gerenciar suas tarefas de forma eficiente.

#### Funcionalidades
* Cadastro de Usuários: Os usuários podem se cadastrar fornecendo um nome de usuário único, nome e senha. As senhas são armazenadas de forma segura usando criptografia BCrypt.

* Autenticação de Usuários: As solicitações para recursos protegidos por autenticação são validadas usando o método Basic Auth. O usuário e a senha são verificados no banco de dados antes de conceder o acesso.

* Gerenciamento de Tarefas: Os usuários autenticados podem criar novas tarefas fornecendo um título, descrição, data de início, data de término e prioridade. As datas são validadas para garantir que estejam no futuro e que a data de término seja posterior à data de início. Os usuários podem também listar todas as suas tarefas e atualizá-las conforme necessário.

#### Estrutura do Projeto
* TodolistApplication.java: Arquivo principal de inicialização do Spring Boot.
* Utils.java: Contém métodos utilitários, incluindo um método para copiar propriedades não nulas de objetos.
* UserModel.java: Define a estrutura do modelo de dados do usuário, incluindo ID, nome de usuário, senha e data de criação.
* UserController.java: Controlador para operações relacionadas aos usuários, como registro e autenticação.
* IUserRepository.java: Interface do repositório para operações de banco de dados relacionadas aos usuários.
* TaskModel.java: Define a estrutura do modelo de dados da tarefa, incluindo ID, descrição, título, datas de início e término, prioridade e ID do usuário.
* TaskController.java: Controlador para operações relacionadas às tarefas, incluindo criação, listagem e atualização.
* ITaskRepository.java: Interface do repositório para operações de banco de dados relacionadas às tarefas.
* FilterTaskAuth.java: Implementa um filtro de autenticação para proteger as rotas relacionadas às tarefas.
* Dockerfile: Arquivo para criar uma imagem Docker do aplicativo, facilitando a implantação.

### Como Executar
* Pré-requisitos:

> Java JDK 
> Maven 
> Banco de dados (verifique as configurações no arquivo application.properties)
> Docker

* Clone o Repositório:
```
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio
```
* Configure o Banco de Dados:

> Abra o arquivo application.properties e configure as propriedades do banco de dados, se necessário.

* Execute o Aplicativo:
```
mvn spring-boot:run
```

* Executar oa aplicação via Docker
```
docker build -t todolist-app .
docker run -p 8081:8081 todolist-app
```

O aplicativo estará disponível em http://localhost:8081.

> http://localhost:8081

#### Teste as Funcionalidades:

Use ferramentas como Postman ou cURL para fazer solicitações para as rotas do aplicativo (por exemplo, criar usuários, autenticar, criar tarefas, listar tarefas, etc.).

#### Contribuição
Sinta-se à vontade para contribuir com melhorias, correções de bugs ou novas funcionalidades. Abra uma issue para discutir grandes mudanças antes de enviar um pull request.