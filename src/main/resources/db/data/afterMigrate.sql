DROP TABLE IF EXISTS tb_user;
DROP TABLE IF EXISTS tb_product;

INSERT INTO  tb_user(id, name, role) VALUES
            (gen_random_uuid(), 'Dudu', 'ADMIN'),
            (gen_random_uuid(), 'Eduardo', 'EMPLOYEE'),
            (gen_random_uuid(), 'Amada', 'TRAINEE');

INSERT INTO tb_product(id, name, price) VALUES
            (gen_random_uuid(), 'Product 1', 17.3),
            (gen_random_uuid(), 'Product 2', 28.2),
            (gen_random_uuid(), 'Product 3', 38,2);