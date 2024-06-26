DROP SEQUENCE GS_ESTADO_SEQ;

DROP TABLE GS_ESTADO CASCADE CONSTRAINTS;

DROP SEQUENCE GS_CIDADE_SEQ;

DROP TABLE GS_CIDADE CASCADE CONSTRAINTS;

DROP SEQUENCE GS_EMPRESA_SEQ;

DROP TABLE GS_EMPRESA CASCADE CONSTRAINTS;

DROP SEQUENCE GS_ENDERECO_SEQ;

DROP TABLE GS_ENDERECO CASCADE CONSTRAINTS;

DROP SEQUENCE GS_VEICULO_SEQ;

DROP TABLE GS_VEICULO CASCADE CONSTRAINTS;

DROP SEQUENCE GS_VISTORIA_SEQ;

DROP TABLE GS_VISTORIA CASCADE CONSTRAINTS;

DROP SEQUENCE GS_INSPETOR_SEQ;

DROP TABLE GS_INSPETOR CASCADE CONSTRAINTS;

DROP SEQUENCE GS_INSPETOR_VISTORIA_SEQ;

DROP TABLE GS_INSPETOR_VISTORIA CASCADE CONSTRAINTS;

CREATE SEQUENCE GS_ESTADO_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE GS_CIDADE_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE GS_EMPRESA_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE GS_ENDERECO_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE GS_VEICULO_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE GS_VISTORIA_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE GS_INSPETOR_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE GS_INSPETOR_VISTORIA_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE GS_ESTADO (
    ID NUMBER DEFAULT GS_ESTADO_SEQ.NEXTVAL PRIMARY KEY,
    NOME VARCHAR2(50) NOT NULL,
    SIGLA VARCHAR2(2) NOT NULL
);

CREATE TABLE GS_CIDADE (
    ID NUMBER DEFAULT GS_CIDADE_SEQ.NEXTVAL PRIMARY KEY,
    NOME VARCHAR2(50) NOT NULL,
    ESTADO_ID NUMBER NOT NULL,
    FOREIGN KEY (ESTADO_ID) REFERENCES GS_ESTADO(ID)
);

CREATE TABLE GS_EMPRESA (
    ID NUMBER DEFAULT GS_EMPRESA_SEQ.NEXTVAL PRIMARY KEY,
    CNPJ VARCHAR2(14) NOT NULL,
    NOME VARCHAR2(50) NOT NULL,
    TELEFONE VARCHAR2(11) NOT NULL,
    EMAIL VARCHAR2(50) NOT NULL
);

CREATE TABLE GS_ENDERECO (
    ID NUMBER DEFAULT GS_ENDERECO_SEQ.NEXTVAL PRIMARY KEY,
    RUA VARCHAR2(100) NOT NULL,
    NUMERO VARCHAR2(10) NOT NULL,
    CEP VARCHAR2(11) NOT NULL,
    CIDADE_ID NUMBER NOT NULL,
    EMPRESA_ID NUMBER NOT NULL,
    FOREIGN KEY (CIDADE_ID) REFERENCES GS_CIDADE(ID),
    FOREIGN KEY (EMPRESA_ID) REFERENCES GS_EMPRESA(ID)
);

CREATE TABLE GS_VEICULO (
    TIE NUMBER DEFAULT GS_VEICULO_SEQ.NEXTVAL PRIMARY KEY,
    NOME VARCHAR2(30) NOT NULL,
    TIPO VARCHAR2(50) NOT NULL,
    TIPO_MOTOR VARCHAR2(50) NOT NULL,
    SONAR VARCHAR2(50) NOT NULL,
    EMPRESA_ID NUMBER NOT NULL,
    LINK_IMAGEM VARCHAR2(100) NOT NULL,
    FOREIGN KEY (EMPRESA_ID) REFERENCES GS_EMPRESA(ID)
);

CREATE TABLE GS_VISTORIA (
    ID NUMBER DEFAULT GS_VISTORIA_SEQ.NEXTVAL PRIMARY KEY,
    DATA DATE NOT NULL,
    NIVEL_RUIDO NUMBER NOT NULL,
    RESULTADO VARCHAR2(30) NOT NULL,
    OBSERVACOES VARCHAR2(100) NOT NULL,
    VEICULO_ID NUMBER NOT NULL,
    FOREIGN KEY (VEICULO_ID) REFERENCES GS_VEICULO(TIE)
);

CREATE TABLE GS_INSPETOR (
    ID NUMBER DEFAULT GS_INSPETOR_SEQ.NEXTVAL PRIMARY KEY,
    NOME VARCHAR2(50) NOT NULL,
    RG VARCHAR2(11) NOT NULL,
    ESPECIALIZACAO VARCHAR2(50),
    TELEFONE VARCHAR2(11) NOT NULL
);

CREATE TABLE GS_INSPETOR_VISTORIA (
    ID NUMBER DEFAULT GS_INSPETOR_VISTORIA_SEQ.NEXTVAL PRIMARY KEY,
    INSPETOR_ID NUMBER NOT NULL,
    VISTORIA_ID NUMBER NOT NULL,
    FOREIGN KEY (INSPETOR_ID) REFERENCES GS_INSPETOR(ID),
    FOREIGN KEY (VISTORIA_ID) REFERENCES GS_VISTORIA(ID)
);

INSERT INTO GS_ESTADO (
    NOME,
    SIGLA
) VALUES (
    'São Paulo',
    'SP'
);

INSERT INTO GS_ESTADO (
    NOME,
    SIGLA
) VALUES (
    'Rio de Janeiro',
    'RJ'
);

INSERT INTO GS_ESTADO (
    NOME,
    SIGLA
) VALUES (
    'Minas Gerais',
    'MG'
);

INSERT INTO GS_CIDADE (
    NOME,
    ESTADO_ID
) VALUES (
    'São Paulo',
    1
);

INSERT INTO GS_CIDADE (
    NOME,
    ESTADO_ID
) VALUES (
    'Rio de Janeiro',
    2
);

INSERT INTO GS_CIDADE (
    NOME,
    ESTADO_ID
) VALUES (
    'Belo Horizonte',
    3
);

INSERT INTO GS_EMPRESA (
    CNPJ,
    NOME,
    TELEFONE,
    EMAIL
) VALUES (
    '12345678000100',
    'Empresa A',
    '11987654321',
    'contato@empresaA.com'
);

INSERT INTO GS_EMPRESA (
    CNPJ,
    NOME,
    TELEFONE,
    EMAIL
) VALUES (
    '23456789000111',
    'Empresa B',
    '21987654321',
    'contato@empresaB.com'
);

INSERT INTO GS_EMPRESA (
    CNPJ,
    NOME,
    TELEFONE,
    EMAIL
) VALUES (
    '34567890000122',
    'Empresa C',
    '31987654321',
    'contato@empresaC.com'
);

INSERT INTO GS_ENDERECO (
    RUA,
    NUMERO,
    CEP,
    CIDADE_ID,
    EMPRESA_ID
) VALUES (
    'Rua A',
    '100',
    '01001001',
    1,
    1
);

INSERT INTO GS_ENDERECO (
    RUA,
    NUMERO,
    CEP,
    CIDADE_ID,
    EMPRESA_ID
) VALUES (
    'Rua B',
    '200',
    '02002002',
    2,
    2
);

INSERT INTO GS_ENDERECO (
    RUA,
    NUMERO,
    CEP,
    CIDADE_ID,
    EMPRESA_ID
) VALUES (
    'Rua C',
    '300',
    '03003003',
    3,
    3
);

INSERT INTO GS_VEICULO (
    NOME,
    TIPO,
    TIPO_MOTOR,
    SONAR,
    EMPRESA_ID,
    LINK_IMAGEM
) VALUES (
    'Veículo A',
    'Tipo 1',
    'Motor 1',
    'Sonar 1',
    1,
    'http://imagemA.com'
);

INSERT INTO GS_VEICULO (
    NOME,
    TIPO,
    TIPO_MOTOR,
    SONAR,
    EMPRESA_ID,
    LINK_IMAGEM
) VALUES (
    'Veículo B',
    'Tipo 2',
    'Motor 2',
    'Sonar 2',
    2,
    'http://imagemB.com'
);

INSERT INTO GS_VEICULO (
    NOME,
    TIPO,
    TIPO_MOTOR,
    SONAR,
    EMPRESA_ID,
    LINK_IMAGEM
) VALUES (
    'Veículo C',
    'Tipo 3',
    'Motor 3',
    'Sonar 3',
    3,
    'http://imagemC.com'
);

INSERT INTO GS_VISTORIA (
    DATA,
    NIVEL_RUIDO,
    RESULTADO,
    OBSERVACOES,
    VEICULO_ID
) VALUES (
    TO_DATE('2023-05-01', 'YYYY-MM-DD'),
    50,
    'Aprovado',
    'Nenhuma',
    1
);

INSERT INTO GS_VISTORIA (
    DATA,
    NIVEL_RUIDO,
    RESULTADO,
    OBSERVACOES,
    VEICULO_ID
) VALUES (
    TO_DATE('2023-05-02', 'YYYY-MM-DD'),
    60,
    'Reprovado',
    'Ruído alto',
    2
);

INSERT INTO GS_VISTORIA (
    DATA,
    NIVEL_RUIDO,
    RESULTADO,
    OBSERVACOES,
    VEICULO_ID
) VALUES (
    TO_DATE('2023-05-03', 'YYYY-MM-DD'),
    55,
    'Aprovado',
    'Ruído aceitável',
    3
);

INSERT INTO GS_INSPETOR (
    RG,
    NOME,
    ESPECIALIZACAO,
    TELEFONE
) VALUES (
    '123456789',
    'Ana Rosa',
    'Especialista A',
    '11987654321'
);

INSERT INTO GS_INSPETOR (
    RG,
    NOME,
    ESPECIALIZACAO,
    TELEFONE
) VALUES (
    '987654321',
    'João Silva',
    'Especialista B',
    '21987654321'
);

INSERT INTO GS_INSPETOR (
    RG,
    NOME,
    ESPECIALIZACAO,
    TELEFONE
) VALUES (
    '456123789',
    'Maria Santos',
    'Especialista C',
    '31987654321'
);

INSERT INTO GS_INSPETOR_VISTORIA (
    INSPETOR_ID,
    VISTORIA_ID
) VALUES (
    1,
    1
);

INSERT INTO GS_INSPETOR_VISTORIA (
    INSPETOR_ID,
    VISTORIA_ID
) VALUES (
    2,
    2
);

INSERT INTO GS_INSPETOR_VISTORIA (
    INSPETOR_ID,
    VISTORIA_ID
) VALUES (
    3,
    3
);