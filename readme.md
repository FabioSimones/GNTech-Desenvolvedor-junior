# 📋 Avaliação Técnica

## 🎯 Objetivo
Avaliar competências em:
- Extração de dados via API  
- Armazenamento em banco de dados  
- Configuração de acesso remoto  
- Uso de Docker para conteinerização  

Também será avaliada a capacidade de integrar essas etapas, seguir boas práticas de programação e organizar o versionamento do código com Git.

---

## 🛠️ Instruções

### 1. Extração de Dados via API
- Utilize uma API pública para realizar uma requisição **GET**.  
- API: [ViaCEP](https://viacep.com.br).  
- Extraia dados de interesse (ex.: dados climáticos de uma cidade).  
- Utilize parâmetros dinâmicos na URL e autenticação via chave de API.  

### 2. Armazenamento em Banco de Dados
- Utilize **MySQL** ou **PostgreSQL**.  
- Uma tabela é suficiente para demonstrar a habilidade.  

### 3. Acesso Remoto
- Crie uma API simples (**RESTful**) para consultar os dados armazenados.  
- Documente a utilização com **Swagger** ou **Postman**.  

### 4. Conteinerização com Docker *(Opcional)*
- Crie um ambiente Docker que contenha a API e o banco de dados.  
- Permita execução em qualquer máquina.  

### 5. Controle de Versão (Git)
- Suba todo o código-fonte e arquivos de configuração do Docker no GitHub.  
- Organize o repositório de forma clara.  
- Inclua este **README.md** com instruções de configuração e execução.  

---

## 📦 Entregáveis
- Repositório no GitHub contendo:  
  - Código-fonte completo em **Python** (preferencialmente), **Node.js** ou outra linguagem de sua escolha.  
  - Arquivos de configuração do Docker.  
  - Documentação clara no README.  

---

## ✅ Critérios de Avaliação
- Qualidade e clareza do código.  
- Organização do repositório Git e documentação.  
- Estrutura correta das tabelas no banco de dados.  
- Uso adequado do Docker para ambiente reprodutível e funcional.  

---

# 🚀 Resolução Adotada

## 🔧 Tecnologias Utilizadas
- **Spring Boot 17**  
- **PostgreSQL** em container Docker  
- **Lombok** para otimização de código (getters, setters, construtores, etc.)  
- **OpenFeign** para consumo de API externa
- **Postman** para realizar testes

- **Configurações iniciais**:
<img width="1529" height="896" alt="image" src="https://github.com/user-attachments/assets/ecc7fd9b-2120-44cd-ba17-12645a4db8b9" />


---

## ⚙️ Configuração do Projeto
1. Criação da API com **Spring Initializr**.  
2. Criação do arquivo **docker-compose.yml** para subir o banco PostgreSQL:

<img width="475" height="388" alt="image" src="https://github.com/user-attachments/assets/da519d10-ea6f-4fb3-94f4-137dc4ccb351" />


```bash
docker compose up -d
```
<img width="1005" height="388" alt="image" src="https://github.com/user-attachments/assets/f3593066-4332-4f41-a20b-ea531865880f" />


## ⚠️ É necessário ter o Docker Desktop instalado.

---
## 🗄️ Estrutura do Projeto

- **Entidade**: Endereco
- **DTO**: para transferência de dados
- **Repository**: responsável pela persistência no banco
- **Service**:
  - Consome API externa via OpenFeign
  - Salva dados no banco
  - Implementa método de pesquisa por CEP
  - Inclui exceções personalizadas para mensagens mais claras
- **Controller**:
  - Endpoints RESTful com métodos POST e GET
  - Testes de funcionamento e tratamento de erros

---
## 🌐 Endpoints Disponíveis
- Salvar endereço via CEP
```bash
POST http://localhost:8080/enderecos/{cep}
```
Exemplo:
```bash
POST http://localhost:8080/enderecos/88161384
```
<img width="924" height="571" alt="image" src="https://github.com/user-attachments/assets/3a461153-1e4f-4bc3-a6c6-2859d9d712bc" />
<img width="918" height="517" alt="image" src="https://github.com/user-attachments/assets/7d26a368-7f12-430a-a039-11d8fc237197" />
<img width="930" height="622" alt="image" src="https://github.com/user-attachments/assets/f577a457-5441-4dbb-82e1-08ea673f62c9" />


- Consultar endereços salvos no banco
```bash
GET http://localhost:8080/enderecos
```

<img width="926" height="622" alt="image" src="https://github.com/user-attachments/assets/d5791081-c174-4df2-90a4-a53dc29d4ac8" />


---
## 📌 Observações
- O projeto foi desenvolvido para ser simples, funcional e de fácil reprodução.
- O uso do Docker garante que qualquer pessoa possa testar sem precisar instalar o PostgreSQL localmente.
