# 🦷 Dentinho Feliz - API Backend

## 📌 Integrantes do Grupo
- **Luiz Alecsander Viana** (RM553034)
- **Guilherme Augusto de Oliveira** (RM554176)
- **Lucas Martinez Lopes** (RM553816)

## 📖 Descrição do Projeto
O **Dentinho Feliz** é um aplicativo educacional voltado para conscientização sobre higiene bucal infantil. A API backend foi desenvolvida em **Spring Boot** e implantada na **nuvem Azure** utilizando **Azure Container Instances** e **Azure SQL Database**.

## 🎯 Tecnologias Utilizadas
- **Backend**: Java Spring Boot
- **Banco de Dados**: Azure SQL Database
- **Infraestrutura**: Azure Container Instances (ACI), Azure Container Registry (ACR)
- **Gerenciamento de dependências**: Maven
- **Controle de versão**: Git/GitHub

## 🛠️ Arquitetura da Solução
![arquiteturaprojeto.jpeg](src%2Fmain%2Fresources%2Farquiteturaprojeto.jpeg)

## 🚀 Como Rodar o Projeto

### 1️⃣ **Pré-requisitos**
Antes de iniciar, você precisará ter instalado em sua máquina:
- [Java 17+](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)
- [Azure CLI](https://learn.microsoft.com/pt-br/cli/azure/install-azure-cli)
- [Git](https://git-scm.com/)

### 2️⃣ **Clonando o Repositório**
```sh
 git clone https://github.com/luizalec7/dentinhofelizapp.git
 cd dentinhofelizapp
```

### 3️⃣ **Configuração do Banco de Dados**
Antes de rodar a aplicação, verifique o arquivo `application.properties` com a configuração do **Azure SQL Database**:

```properties
spring.datasource.url=jdbc:sqlserver://dentinhofeliz-db.database.windows.net:1433;database=dentinhofelizdb;encrypt=true;trustServerCertificate=false;loginTimeout=30;
spring.datasource.username=adminluiz@dentinhofeliz-db
spring.datasource.password=Elmatador2020@
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver

spring.jpa.database-platform=org.hibernate.dialect.SQLServerDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4️⃣ **Compilar e Rodar Localmente**
Para rodar a aplicação localmente, use:
```sh
mvn clean package
java -jar target/dentinhofelizapp-0.0.1-SNAPSHOT.war
```

A API estará disponível em: `http://localhost:8080`

### 5️⃣ **Rodar o Container Docker**
Caso queira rodar via **Docker**, execute:
```sh
docker build -t dentinhofelizapp .
docker run -p 8080:8080 dentinhofelizapp
```

### 6️⃣ **Deploy na Azure Cloud**
Após configurar seu container registry e armazenar a imagem, use:
```sh
az container create --resource-group dentinhofeliz-rg \
  --name dentinhofeliz-container \
  --image dentinhofelizacr.azurecr.io/dentinhofelizapp:v2 \
  --dns-name-label dentinhofelizapp \
  --ports 8080 \
  --registry-login-server dentinhofelizacr.azurecr.io \
  --registry-username dentinhofelizacr \
  --registry-password "SUA_SENHA" \
  --os-type Linux \
  --cpu 1 \
  --memory 1.5
```
A API estará disponível em: `http://dentinhofelizapp.brazilsouth.azurecontainer.io:8080`

---

## 🧪 Exemplos de Testes
Após iniciar a aplicação, você pode testar os endpoints usando o **Postman** ou o **cURL**.

### ✅ **Testar API no Navegador**
Acesse `http://dentinhofelizapp.brazilsouth.azurecontainer.io:8080/health` para verificar o status da API.

### ✅ **Testar Cadastro de Usuário**
```sh
curl -X POST "http://dentinhofelizapp.brazilsouth.azurecontainer.io:8080/salvarCadastro" \
     -H "Content-Type: application/json" \
     -d '{"nome": "João", "idade": 10, "email": "joao@email.com"}'
```

### ✅ **Listar Todos os Usuários**
```sh
curl -X GET "http://dentinhofelizapp.brazilsouth.azurecontainer.io:8080/usuarios"
```

---

## 📽️ Vídeos do Projeto
📌 **Demonstração do Projeto:** https://www.youtube.com/watch?v=CVogzgAbt4o

## 🔗 Links
- 🔗 **Repositório GitHub:** [Dentinho Feliz - API](https://github.com/luizalec7/dentinhofelizapp.git)
- 🔗 **Azure Container Instance:** [http://dentinhofelizapp.brazilsouth.azurecontainer.io:8080](http://dentinhofelizapp.brazilsouth.azurecontainer.io:8080)

---

## 📌 Conclusão
O projeto **Dentinho Feliz** foi desenvolvido para auxiliar crianças a manterem uma boa higiene bucal, utilizando gamificação e um sistema de aprendizado interativo. A API backend foi estruturada seguindo boas práticas de desenvolvimento e implantada na **nuvem Azure** para garantir escalabilidade e confiabilidade.
