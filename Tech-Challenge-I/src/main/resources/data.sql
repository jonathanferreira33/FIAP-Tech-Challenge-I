INSERT INTO UserEntity (firstName, lastName, email, admin, tipoUsuario, doc) VALUES
('Jon', 'Snow', 'jon.snow@got.com', true, 1, '12345678901'),
('Daenerys', 'Targaryen', 'daenerys.targaryen@got.com', true, 2, '23456789012'),
('Tyrion', 'Lannister', 'tyrion.lannister@got.com', false, 1, '34567890123'),
('Arya', 'Stark', 'arya.stark@got.com', false, 1, '45678901234'),
('Sansa', 'Stark', 'sansa.stark@got.com', false, 1, '56789012345'),
('Bran', 'Stark', 'bran.stark@got.com', false, 1, '67890123456'),
('Cersei', 'Lannister', 'cersei.lannister@got.com', true, 2, '78901234567'),
('Jaime', 'Lannister', 'jaime.lannister@got.com', false, 1, '89012345678'),
('Jorah', 'Mormont', 'jorah.mormont@got.com', false, 1, '90123456789'),
('Samwell', 'Tarly', 'samwell.tarly@got.com', false, 1, '01234567890');


INSERT INTO Product (productName, price, shortDescription, categoryCode) VALUES
('Batata Frita', 12.50, 'Batata frita crocante', 1),                                -- Categoria: Snack
('Hambúrguer', 25.00, 'Hambúrguer com carne e queijo', 1),                          -- Categoria: Snack
('Cachorro-Quente', 18.00, 'Cachorro-quente com molho especial', 1),                -- Categoria: Snack
('Chips de Batata Doce', 12.00, 'Chips de batata doce assada', 1),                  -- Categoria: Snack
('Sanduíche Vegano', 20.00, 'Sanduíche com vegetais frescos e homus', 1),           -- Categoria: Snack
('Falafel', 18.00, 'Bolinho de grão-de-bico frito', 1),                             -- Categoria: Snack
('Pizza', 40.00, 'Pizza de mussarela', 2),                                          -- Categoria: Follow-up
('Salada Caesar', 22.00, 'Salada com molho Caesar', 2),                             -- Categoria: Follow-up
('Sanduíche de Queijo Branco', 20.00, 'Sanduíche de Queijo Branco ao Pesto', 2),    -- Categoria: Follow-up
('Lasanha de Berinjela', 32.00, 'Lasanha feita com berinjela e queijo', 2),         -- Categoria: Follow-up
('Refrigerante', 5.00, 'Refrigerante de cola', 3),                                  -- Categoria: Drink
('Suco de Laranja', 7.00, 'Suco natural de laranja', 3),                            -- Categoria: Drink
('Água Mineral', 3.00, 'Água mineral sem gás', 3),                                  -- Categoria: Drink
('Suco Verde', 8.00, 'Suco detox com couve e limão', 3),                            -- Categoria: Drink
('Smoothie de Morango', 10.00, 'Smoothie refrescante de morango', 3),               -- Categoria: Drink
('Chá Gelado', 6.00, 'Chá gelado de ervas e limão', 3),                             -- Categoria: Drink
('Pudim', 10.00, 'Pudim de leite condensado', 4),                                   -- Categoria: Dessert
('Torta de Limão', 15.00, 'Torta de limão com merengue', 4),                        -- Categoria: Dessert
('Sorvete de Coco', 12.00, 'Sorvete de coco sem lactose', 4),                       -- Categoria: Dessert
('Mousse de Maracujá', 14.00, 'Mousse de maracujá leve e refrescante', 4);          -- Categoria: Dessert