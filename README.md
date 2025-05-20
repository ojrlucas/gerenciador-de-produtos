# 🛒 Gerenciador de Produtos (Java + JDBC + MySQL)

Este é um projeto de console feito em Java com persistência de dados em MySQL utilizando JDBC. A aplicação permite **gerenciar produtos** com funcionalidades de CRUD: adicionar, consultar, atualizar e remover produtos, além de resetar toda a lista do banco de dados.

## 🔧 Tecnologias Utilizadas

- **Java 17+**
- **JDBC (Java Database Connectivity)**
- **MySQL**
- **Paradigma Orientado a Objetos (POO)**

## 📦 Funcionalidades

- Adicionar um ou mais produtos
- Listar todos os produtos cadastrados
- Alterar dados de um produto existente
- Remover produto por ID
- Resetar todos os produtos do banco
- Verificação de existência de produto por ID
- Tratamento de exceções e validações simples

## 📁 Estrutura de Diretórios

```
projeto-cadastro-produtos/
│
├── src/
│   ├── aplicacao/
│   │   └── Aplicacao.java
│   │
│   ├── daos/
│   │   └── DaoProduto.java
│   │
│   ├── entidades/
│   │   └── Produto.java
│   │
│   ├── interfaces/
│   │   └── ICrud.java
│   │
│   └── util/
│       └── Conexao.java
│
├── banco/
│   └── script_ddl.sql
│
└── README.md
```
