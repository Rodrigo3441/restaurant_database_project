-- DADOS PARA TESTE DO SISTEMA
-- CLIENTES
INSERT INTO CLIENTE (
    pk_cli_cpf,
    cli_primeiro_nome,
    cli_nome_meio,
    cli_ultimo_nome,
    cli_telefone,
    cli_email,
    cli_senha
) VALUES
('12345678901', 'Carlos', 'Eduardo', 'Silva', '11987654321', 'carlos.silva@email.com', '123'),
('23456789012', 'Mariana', 'Aparecida', 'Souza', '11991234567', 'mariana.souza@email.com', '123'),
('34567890123', 'João', 'Pedro', 'Oliveira', '11999887766', 'joao.oliveira@email.com', '123'),
('45678901234', 'Fernanda', 'Cristina', 'Costa', '11995554433', 'fernanda.costa@email.com', '123'),
('56789012345', 'Lucas', 'Henrique', 'Pereira', '11993332211', 'lucas.pereira@email.com', '123'),
('67890123456', 'Ana', 'Beatriz', 'Almeida', '11997778899', 'ana.almeida@email.com', '123'),
('78901234567', 'Ricardo', 'Augusto', 'Lima', '11996665544', 'ricardo.lima@email.com', '123'),
('89012345678', 'Juliana', 'Mendes', 'Rocha', '11994443322', 'juliana.rocha@email.com', '123'),
('90123456789', 'Thiago', 'Vinicius', 'Martins', '11992221100', 'thiago.martins@email.com', '123'),
('01234567890', 'Patricia', 'Helena', 'Ferreira', '11990001122', 'patricia.ferreira@email.com', '123');

-- ENTREGADORES
INSERT INTO ENTREGADOR (
    pk_etg_cpf,
    etg_primeiro_nome,
    etg_nome_meio,
    etg_ultimo_nome,
    etg_telefone,
    etg_veiculo,
    etg_disponibilidade
) VALUES
('11122233344', 'Carlos', 'Henrique', 'Souza', '11987654321', 'ABC1234', 0),
('22233344455', 'Marcos', 'Vinicius', 'Oliveira', '11991234567', 'DEF5678', 0),
('33344455566', 'Juliano', 'Cesar', 'Lima', '11999887766', 'GHI9012', 0),
('44455566677', 'Roberto', 'Almeida', 'Pereira', '11995554433', 'JKL3456', 0),
('55566677788', 'Fernando', 'Augusto', 'Costa', '11993332211', 'MNO7890', 0),
('66677788899', 'Thiago', 'Rafael', 'Martins', '11997778899', 'PQR1122', 0),
('77788899900', 'Lucas', 'Eduardo', 'Rocha', '11996665544', 'STU3344', 0),
('88899900011', 'André', 'Felipe', 'Gomes', '11994443322', 'VWX5566', 0),
('99900011122', 'Ricardo', 'Silveira', 'Barbosa', '11992221100', 'YZA7788', 0),
('00011122233', 'Mateus', 'Leonardo', 'Ferreira', '11990001122', 'BCD9900', 0);

-- CATEGORIA RESTAURANTE
INSERT INTO CATEGORIA_RESTAURANTE (
    pk_res_id_catg,
    ctr_nome,
    ctr_descricao
) VALUES
(1, 'Pizzaria', 'Restaurantes especializados em pizzas e massas italianas.'),
(2, 'Hamburgueria', 'Estabelecimentos focados em hambúrgueres artesanais e lanches.'),
(3, 'Japonesa', 'Restaurantes de culinária japonesa com sushi, sashimi e temakis.'),
(4, 'Churrascaria', 'Especializados em carnes grelhadas e rodízios.'),
(5, 'Vegetariana', 'Restaurantes com foco em pratos vegetarianos e saudáveis.'),
(6, 'Brasileira', 'Comida típica brasileira e pratos regionais.'),
(7, 'Árabe', 'Culinária árabe com esfihas, quibes e pratos tradicionais.'),
(8, 'Mexicana', 'Especializados em tacos, burritos, nachos e pratos mexicanos.'),
(9, 'Cafeteria', 'Cafés, salgados, doces e bebidas especiais.'),
(10, 'Doceria', 'Estabelecimentos especializados em sobremesas e doces.');

-- CATEGORIA PRODUTO
INSERT INTO CATEGORIA_PRODUTO (
    pk_prd_id_catg,
    ctp_nome,
    ctp_descricao
) VALUES
(1, 'Pizza', 'Produtos relacionados a pizzas salgadas e doces.'),
(2, 'Hambúrguer', 'Hambúrgueres artesanais, combos e lanches especiais.'),
(3, 'Bebida', 'Refrigerantes, sucos, águas e bebidas em geral.'),
(4, 'Sobremesa', 'Doces, bolos, sorvetes e sobremesas variadas.'),
(5, 'Sushi', 'Produtos da culinária japonesa como sushi e sashimi.'),
(6, 'Porção', 'Porções para compartilhar como batata frita e petiscos.'),
(7, 'Massa', 'Massas italianas como lasanha, macarrão e nhoque.'),
(8, 'Salada', 'Saladas frescas e pratos saudáveis.'),
(9, 'Café', 'Cafés, cappuccinos e bebidas quentes.'),
(10, 'Combo', 'Combinações promocionais de produtos.');

-- RESTAURANTES
INSERT INTO RESTAURANTE (
    pk_res_cnpj,
    res_nome,
    res_telefone,
    fk_res_id_catg,
    res_senha
) VALUES
('12345678000101', 'Sabor Paulista', '11987654321', NULL, '123'),
('23456789000112', 'Pizza Suprema', '11991234567', NULL, '123'),
('34567890000123', 'Burger House', '11999887766', NULL, '123'),
('45678901000134', 'Temaki Express', '11995554433', NULL, '123'),
('56789012000145', 'Churrasco Grill', '11993332211', NULL, '123'),
('67890123000156', 'Cantina Bella Massa', '11997778899', NULL, '123'),
('78901234000167', 'Doce Encanto', '11996665544', NULL, '123'),
('89012345000178', 'Café Central', '11994443322', NULL, '123'),
('90123456000189', 'Mexican Hot', '11992221100', NULL, '123'),
('01234567000190', 'Green Salad Fit', '11990001122', NULL, '123');

-- PRODUTOS
INSERT INTO PRODUTO (
    pk_prd_codigo,
    prd_nome,
    prd_descricao,
    fk_prd_id_catg
) VALUES
(1, 'Pizza Calabresa', 'Pizza tradicional com calabresa, cebola e queijo.', NULL),
(2, 'Hambúrguer Artesanal', 'Hambúrguer artesanal com cheddar e bacon.', NULL),
(3, 'Refrigerante Cola 2L', 'Bebida gaseificada sabor cola.', NULL),
(4, 'Temaki Salmão', 'Temaki recheado com salmão fresco e cream cheese.', NULL),
(5, 'Batata Frita Grande', 'Porção grande de batatas fritas crocantes.', NULL),
(6, 'Lasanha Bolonhesa', 'Lasanha recheada com molho bolonhesa e queijo.', NULL),
(7, 'Salada Caesar', 'Salada com alface, croutons e molho caesar.', NULL),
(8, 'Milk Shake Chocolate', 'Milk shake cremoso sabor chocolate.', NULL),
(9, 'Café Expresso', 'Café expresso tradicional servido quente.', NULL),
(10, 'Combo Família', 'Combo promocional com lanche, bebida e sobremesa.', NULL);



SELECT * FROM CLIENTE;
SELECT * FROM ENDERECO_CLIENTE;
SELECT * FROM RESTAURANTE;
SELECT * FROM ENDERECO_RESTAURANTE;
SELECT * FROM PRODUTO;
SELECT * FROM PRODUTO_RESTAURANTE;
SELECT * FROM PEDIDO;
SELECT * FROM ITEM_PEDIDO;
SELECT * FROM ENTREGADOR;
SELECT * FROM CATEGORIA_PRODUTO;
SELECT * FROM CATEGORIA_RESTAURANTE;



