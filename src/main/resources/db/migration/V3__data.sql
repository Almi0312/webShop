INSERT INTO categories (id, name)
values (1, 'Худи'),
       (2, 'Свитшоты'),
       (3, 'Футболки'),
       (4, 'Шопперы'),
       (5, 'Лонгсливы');
ALTER SEQUENCE categories_seq RESTART WITH 6;

INSERT INTO products (id, title, price, description, category_id)
values (1, 'Худи Nike', 3999.0, 'Топовое худи с вышитой эмблемой найк', 1),
       (2, 'Худи с Барни', 3999.0, 'Очень приятное к телу худи с мишкой Барни. Героем мультиков нашего детства', 1),
       (3, 'Футболка оверсайз', 2499.0, 'Оверсайз футболка', 3),
       (4, 'Футболка оверсайз Nike', 2499.0, 'Оверсайз футболка', 3),
       (5, 'худи с принтом', 3999.0, 'Худи', 1);
ALTER SEQUENCE product_seq RESTART WITH 6;
