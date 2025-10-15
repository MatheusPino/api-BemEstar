README.md - Projeto Bem Estar
# 🧘‍♂️ Projeto - Bem Estar

O projeto **Bem Estar** é uma aplicação voltada para promover práticas sustentáveis e bem-estar social por meio de tecnologia.  
A ideia é disponibilizar ferramentas e recursos que ajudam a monitorar e otimizar fatores que impactam a qualidade de vida e sustentabilidade em diferentes contextos.

---

## 📦 Como executar localmente com Docker

Siga os passos para executar a aplicação **Bem Estar** localmente utilizando o Docker:

1. **Certifique-se de que o Docker está instalado:**
   ```bash
   docker --version
   ```

2. **Baixe a imagem da aplicação:**
   ```bash
   docker pull matheuspino/bem-estar-production
   ```

3. **Execute o container:**
   ```bash
   docker run -d -p 8080:8080 matheuspino/bem-estar-production
   ```

4. **Acesse a aplicação:**
   - A aplicação estará disponível em:  
     👉 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 🚀 Pipeline CI/CD

### Ferramentas Utilizadas
- **GitHub Actions:** Automatiza o pipeline para integração (CI) e deploy contínuo (CD).  
- **Docker Hub:** Repositório para imagens containerizadas da aplicação.  
- **Staging e Produção:** Ambientes separados para validação e disponibilização final da aplicação.

### Etapas do Pipeline
1. **Integração Contínua (CI):**
   - A cada `commit` ou `pull request`, o pipeline executa:
     - Build da aplicação com **Maven**.
     - Testes automatizados com **JUnit/Mockito**.
   - Resultado exibido diretamente no **GitHub Actions**.

2. **Containerização:**
   - Uma imagem Docker otimizada é gerada e publicada no **Docker Hub**, pronta para ser utilizada em qualquer ambiente.

3. **Deploy Contínuo (CD):**
   - **Staging:** Deploy automático a cada push na branch `main`.  
   - **Produção:** Deploy manual através do `workflow_dispatch`.

---

## 🐳 Containerização

A aplicação é containerizada para garantir portabilidade e consistência entre ambientes.

### Dockerfile
```dockerfile
# Etapa 1: Build da aplicação
FROM maven:3.9.0-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Configuração do runtime
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/bem-estar.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```
---

### Ambiente de Staging
- URL: `staging.bemestar.com`  

### Ambiente de Produção
- URL: `producao.bemestar.com`  

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 21  
- **Frameworks:** Spring Boot, Jakarta EE, Swagger (OpenAPI)  
- **Testes:** JUnit, Mockito  
- **Containerização:** Docker  
- **CI/CD:** GitHub Actions, Docker Hub  
- **Banco de Dados:** MongoDB

---

## ✨ Autores

**Integrantes do Projeto:**
-Matheus Pino Apolinário
-Aléxia Emanuelle Reis de Sá
-Thiago Vieira de Souza
-Rodrigo Ramos Rebouças

---

## 📚 Licença

Este projeto é de uso educacional e demonstra práticas de CI/CD com Docker e GitHub Actions.
