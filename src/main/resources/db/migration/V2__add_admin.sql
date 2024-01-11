INSERT INTO users (id, archive, email, name, password, role)
VALUES (1, false,'admin@mail.ru', 'admin','$2a$10$VeVo/MVfPG8caBnspvbleu.UDY04qPDrqCXQkLEGyf9JjyMlNetDO','ADMIN'),
       (2, false,'manager@mail.ru', 'manager','$2a$10$VeVo/MVfPG8caBnspvbleu.UDY04qPDrqCXQkLEGyf9JjyMlNetDO','MANAGER'),
       (3, false,'client@mail.ru', 'client','$2a$10$VeVo/MVfPG8caBnspvbleu.UDY04qPDrqCXQkLEGyf9JjyMlNetDO','CLIENT');

ALTER SEQUENCE user_seq RESTART WITH 4;