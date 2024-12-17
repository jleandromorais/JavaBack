CREATE TABLE registro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nomeCompleto VARCHAR(255),
    dataNascimento DATE,
    nacionalidade VARCHAR(100),
    naturalidade VARCHAR(100),
    estadoCivil VARCHAR(50),
    nomePai VARCHAR(255),
    nomeMae VARCHAR(255),
    email VARCHAR(255),
    cpf VARCHAR(14),
    tipoConta VARCHAR(50),
    agencia VARCHAR(50),
    cartoes JSON,  -- Usando JSON para armazenar os tipos de cartões
    rua VARCHAR(255),
    numero VARCHAR(10),
    complemento VARCHAR(255),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    estado VARCHAR(100),
    cep VARCHAR(10)
);
