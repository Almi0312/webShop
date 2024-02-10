INSERT INTO users (id, archive, email, name, first_name, last_name, password, role)
VALUES (1, false,'admin@mail.ru', 'admin', 'Admin','Adminov','$2a$10$VeVo/MVfPG8caBnspvbleu.UDY04qPDrqCXQkLEGyf9JjyMlNetDO','ADMIN'),
       (2, false,'manager@mail.ru', 'manager', 'Юля','Шайхуллина', '$2a$10$VeVo/MVfPG8caBnspvbleu.UDY04qPDrqCXQkLEGyf9JjyMlNetDO','MANAGER'),
       (3, false,'manager@mail.ru', 'manager','Артур','Шайхуллин','$2a$10$VeVo/MVfPG8caBnspvbleu.UDY04qPDrqCXQkLEGyf9JjyMlNetDO','CLIENT');

ALTER SEQUENCE user_seq RESTART WITH 4;

INSERT INTO categories (id, name)
values (1, 'Худи'),
       (2, 'Свитшоты'),
       (3, 'Футболки'),
       (4, 'Шопперы'),
       (5, 'Лонгсливы');
ALTER SEQUENCE categories_seq RESTART WITH 6;


INSERT INTO products (id, title, price, category_id, description, preview_image_id)
values (1, 'Футболка "Джерри"', 1600.00, 3, 'Топовое худи с вышитой эмблемой найк', 1),
       (2, 'Лонгслив "Печеньки"', 3600, 5, 'Приятный к телу лонгслив. 100% хлопок. 100% вышивки и никаких рисунков', 2),
       (3, 'Худи "Лапшичка"', 2999.0, 1, 'd', 5),
       (4, 'Футболка "На ручки"', 1800, 3, 'd', 6);
ALTER SEQUENCE product_seq RESTART WITH 5;


INSERT INTO product_images (id, product_id, title,size, content_type, is_preview_image, original_file_name, bytes)
VALUES  (1,1,'file1',512616,'image/jpeg',true,'джерри найк2.jpg',42680),
        (2,2,'file1',396955,'image/jpeg',true,'печенька3.jpg',42681),
        (3,2,'file2',422391,'image/jpeg',false,'печенька2.jpg',42682),
        (4,2,'file3',429646,'image/jpeg',false,'печенька1.jpg',42683),
        (5,3,'file1',223668,'image/jpeg',true,'Любовь.jpg',42684),
        (6,4,'file1',931606,'image/jpeg',true,'на ручки2.jpg',42685);

ALTER SEQUENCE product_images_seq RESTART WITH 7;


INSERT INTO product_sizes(id, ru_size, inter_size)
VALUES (1, '42', 'S'),
       (2, '44-46', 'M'),
       (3, '48-50', 'L'),
       (4, '52', 'XL'),
       (5, '54-56', 'XXL'),
       (6, '56', '3XL');
ALTER SEQUENCE product_sizes_seq RESTART WITH 7;

INSERT INTO products_sizes(product_id, size_id)
VALUES (1,1),(1,2),(1,3),(1,4),(1,5),
       (2,1), (2,2),(2,3),(2,4),(2,5),
       (3,1),(3,2),(3,3),(3,4),(3,5),
       (4,1),(4,2),(4,3),(4,4),(4,5);
ALTER SEQUENCE product_sizes_seq RESTART WITH 21;



