## 🦷 Projeto Dentinho Feliz - DevOps Cloud Deploy (Sprint 4)

Este projeto é um módulo do sistema **Dentinho Feliz**, um aplicativo educativo infantil voltado à higiene bucal. Nesta Sprint, foi realizada a publicação de um backend Java (Spring Boot) na nuvem com um banco de dados **MySQL Flexible Server (Azure)**, totalmente integrado com **Azure DevOps** usando **CI/CD Pipeline**.

### 👥 Integrantes:
- Luiz Alecsander Viana (RM553034)
- Guilherme Augusto de Oliveira (RM554176)
- Lucas Martinez Lopes (RM553816)

### 🔧 Tecnologias Utilizadas
- Java 17 + Spring Boot
- Azure CLI
- MySQL Flexible Server (Azure Database)
- Azure DevOps Pipelines (CI/CD)
- GitHub

## 🔁 Desenho da Pipeline CI/CD

### 📦 Etapas da CI (Integração Contínua):
1. **Build do Projeto**
    - Usa Maven (`mvn clean install`)
2. **Testes Automatizados**
    - Executa testes unitários (Junit)
3. **Gerar Artefato**
    - Empacota o `.jar` no diretório `target/`

### 🚀 Etapas da CD (Entrega Contínua):
1. **Deploy no Azure App Service**
    - Publica o `.jar` usando Service Principal
2. **Configuração de Banco de Dados**
    - Conecta ao MySQL Flexible Server no Azure

### 🔧 Ferramentas:
- Azure DevOps Pipelines (YAML)
- Azure App Service Linux (Java SE)
- GitHub como SCM
