
-- INSERT INTO tb_user (name, cpf, birth_date, income, children) VALUES ('Marco Antonio', '17816783752', TIMESTAMP WITH TIME ZONE '1998-02-27T10:00:00Z',  3000, 2);
-- INSERT INTO tb_user (name, cpf, birth_date, income, children) VALUES ('Giorgian Arrascaeta', '17316687752', TIMESTAMP WITH TIME ZONE '1998-02-27T10:00:00Z',  109000, 1);
-- INSERT INTO tb_user (name, cpf, birth_date, income, children) VALUES ('Blake Antonio', '17816783752', TIMESTAMP WITH TIME ZONE '1998-02-27T10:00:00Z',  33000, 1);
-- INSERT INTO tb_user (name, cpf, birth_date, income, children) VALUES ('Andreas Pereira', '17816783752', TIMESTAMP WITH TIME ZONE '1998-02-27T10:00:00Z',  3213000, 3);
-- INSERT INTO tb_user (name, cpf, birth_date, income, children) VALUES ('Kevin De Bruyne', '17816783752', TIMESTAMP WITH TIME ZONE '1998-02-27T10:00:00Z',  1113000, 5);
-- INSERT INTO tb_user (name, cpf, birth_date, income, children) VALUES ('Antonio', '17816783752', TIMESTAMP WITH TIME ZONE '1998-02-27T10:00:00Z',  5000, 2);
-- INSERT INTO tb_user (name, cpf, birth_date, income, children) VALUES ('Marco', '17816783752', TIMESTAMP WITH TIME ZONE '1998-02-27T10:00:00Z',  3000, 0);
-- INSERT INTO tb_user (name, cpf, birth_date, income, children) VALUES ('Karol Calis', '17816783752', TIMESTAMP WITH TIME ZONE '1998-02-27T10:00:00Z',  8000, 0);
-- INSERT INTO tb_user (name, cpf, birth_date, income, children) VALUES ('Sentinel ', '17816783752', TIMESTAMP WITH TIME ZONE '1998-02-27T10:00:00Z',  13000, 1);
-- INSERT INTO tb_user (name, cpf, birth_date, income, children) VALUES ('Sasuke', '17816783752', TIMESTAMP WITH TIME ZONE '1998-02-27T10:00:00Z',  123000, 1);

-- INSERT INTO tb_user (name, cpf, birth_date, income, password) VALUES ('Sasuke', '17816783752', TIMESTAMP WITH TIME ZONE '1998-02-27T10:00:00Z', 123000, "mordekai07");

INSERT INTO tb_user (name, cpf, email, password, birth_date, income) VALUES ('Marco Antonio', '17816783752', 'marcoantnovo@gmail.com', '$2a$12$KsMFLUvs5IgW26NApQNg6eJJm7oCASG1ew7q34hBBdl0wWiAfTdMe', TIMESTAMP WITH TIME ZONE '1998-02-27T10:00:00Z', 4000.00);

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
-- INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
-- INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
-- INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);