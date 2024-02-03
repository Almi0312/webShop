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
values (1, 'Худи Nike', 3999.0, 1, 'Топовое худи с вышитой эмблемой найк', 1),
       (2, 'Худи с Барни', 2999.0, 1, 'Очень приятное к телу худи с мишкой Барни. Героем мультиков нашего детства', 2);

ALTER SEQUENCE product_seq RESTART WITH 3;

INSERT INTO product_images (id, title, product_id, is_preview_image, size, bytes, content_type, original_file_name)
VALUES (1, 'file1', 1, true, 1478458, 36334, 'image/jpeg', '278428-frederika.jpg'),
       (2, 'file2', 1, false, 550944,36335 , 'image/jpeg', '1696502273_gas-kvas-com-p-kartinki-lyubie-10.jpg'),
       (3, 'file3', 1, false, 364134,36336 , 'image/jpeg', 'krasivye-kartinki-pandy-na-rabochij-stol-26.jpg'),
       (4, 'file1', 2, true, 1478458, 36334, 'image/jpeg', '278428-frederika.jpg'),
       (5, 'file2', 2, false, 550944,36335 , 'image/jpeg', '1696502273_gas-kvas-com-p-kartinki-lyubie-10.jpg'),
       (6, 'file3', 2, false, 364134,36336 , 'image/jpeg', 'krasivye-kartinki-pandy-na-rabochij-stol-26.jpg');
ALTER SEQUENCE product_images_seq RESTART WITH 7;