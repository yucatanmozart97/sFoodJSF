INSERT INTO LOJA(nome, descricao, cnpj) VALUES('Loja teste1', 'Descricao teste 1', '111111111111');
INSERT INTO LOJA(nome, descricao, cnpj) VALUES('Loja teste2', 'Descricao teste 2', '222222222222');

INSERT INTO PRODUTO(nome, descricao) VALUES('Produto 1', 'descricao produto 1');
INSERT INTO PRODUTO(nome, descricao) VALUES('Produto 2', 'descricao produto 2');
INSERT INTO PRODUTO(nome, descricao) VALUES('Produto 3', 'descricao produto 3');
INSERT INTO PRODUTO(nome, descricao) VALUES('Produto 4', 'descricao produto 4');

INSERT INTO LOJA_PRODUTO(loja_fk, produto_fk, preco) VALUES(1, 1, 12.0);
INSERT INTO LOJA_PRODUTO(loja_fk, produto_fk, preco) VALUES(1, 2, 15.0);
INSERT INTO LOJA_PRODUTO(loja_fk, produto_fk, preco) VALUES(2, 3, 18.0);
INSERT INTO LOJA_PRODUTO(loja_fk, produto_fk, preco) VALUES(2, 4, 21.0);

INSERT INTO USUARIO(nome, user_name, email, telefone, senha) VALUES('Usuario 1', 'teste1', 'usuario1', '111111', '$2a$10$jeL1YXQ0cifoYTrvgVgdD.k1Guvr.cVeSZl1k2w00rQdntgIvwizK');
INSERT INTO USUARIO(nome, email, telefone, senha) VALUES('Usuario 2', 'usuario2@g', '222222', 'xpto2');
INSERT INTO USUARIO(nome, email, telefone, senha) VALUES('Usuario 3', 'usuario3@g', '333333', 'xpto3');

INSERT INTO USUARIO_LOJA_PRODUTO(lp_fk, usuario_fk, quantidade) VALUES('1', '1', '2');
INSERT INTO USUARIO_LOJA_PRODUTO(lp_fk, usuario_fk, quantidade) VALUES('2', '1', '3');
INSERT INTO USUARIO_LOJA_PRODUTO(lp_fk, usuario_fk, quantidade) VALUES('3', '2', '4');
INSERT INTO USUARIO_LOJA_PRODUTO(lp_fk, usuario_fk, quantidade) VALUES('4', '3', '1');