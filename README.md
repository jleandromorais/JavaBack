# 🚀 Projeto Banco Digital 🚀

Este projeto é um sistema de **banco digital** completo, com diversas funcionalidades essenciais para o gerenciamento de contas e transações financeiras. O sistema foi desenvolvido utilizando **Java 21** (ou Spring Boot 2.7.x, se aplicável) e outras dependências importantes para integração com o banco de dados.

## 🔑 Funcionalidades

- **Verificação de Login:** O sistema permite verificar se o login do usuário já existe, validando as credenciais fornecidas. 🔒
- **Tabela de Registro:** Um registro completo das ações do usuário, incluindo logins, transferências e outras interações com a plataforma. 📝
- **Fluxo de Dinheiro:** Gerenciamento de saldo dos usuários, permitindo que as transações (depositar, sacar e transferir) sejam feitas de forma eficiente. 💸
- **Página de Transferências:** Uma página específica para realizar transferências entre contas, com funcionalidades de verificação de saldo e validação de dados. 🔄
- **Criação de Cartão Aleatório:** Criação de cartões virtuais com números aleatórios, simulando um cartão bancário real. 💳
- **Outras Funções:** O sistema também inclui funcionalidades adicionais para gerenciamento de contas, histórico de transações, entre outras. 🔧

## 🛠️ Tecnologias e Dependências

- **Java 21:** A versão mais recente do Java foi utilizada para garantir desempenho e recursos avançados de programação. ☕
- **Spring Boot 2.7.x:** Utilizado para facilitar a criação do back-end com segurança e robustez. 🖥️
- **Flyway:** Ferramenta de migração de banco de dados utilizada para gerenciar e versionar as alterações no banco de dados de maneira eficiente. 🗃️
- **Banco de Dados:** O sistema utiliza banco de dados relacional para armazenar informações do usuário, saldo, transações e registros. 🏦

## 📦 Como Rodar o Projeto

1. Clone este repositório em sua máquina local:
   ```bash
   git clone https://github.com/seuusuario/banco-digital.git
2. Navegue até o diretório do projeto:
   cd banco-digital
3.Compile o projeto:

bash
./mvnw clean install
4.Inicie o servidor
./mvnw spring-boot:run
