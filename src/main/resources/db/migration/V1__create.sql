drop sequence if exists bucket_seq;
create sequence bucket_seq start with 1 increment by 1;
drop sequence if exists categories_seq;
create sequence categories_seq start with 1 increment by 1;
drop sequence if exists order_details_seq;
create sequence order_details_seq start with 1 increment by 1;
drop sequence if exists orders_seq;
create sequence orders_seq start with 1 increment by 1;
drop sequence if exists product_seq;
create sequence product_seq start with 1 increment by 1;
drop sequence if exists user_seq;
create sequence user_seq start with 1 increment by 1;

drop table if exists buckets cascade;
create table buckets (
                         id bigint primary key,
                         user_id bigint unique
);

drop table if exists buckets_products cascade;
create table buckets_products (
                                  bucket_id bigint not null,
                                  product_id bigint not null
);

drop table if exists categories cascade;
create table categories (
                            id bigint primary key,
                            name varchar(255)
);

drop table if exists order_details cascade;
create table order_details (
                               id bigint  primary key,
                               amount bigint not null,
                               price numeric(38,2),
                               order_id bigint not null,
                               product_id bigint not null,
                               comment varchar(255)
);

drop table if exists orders cascade;
create table orders (
                        id bigint primary key,
                        sum numeric(38,2),
                        created timestamp(6),
                        last_changed timestamp(6),
                        user_id bigint,
                        address varchar(255),
                        status varchar(255) check (status in ('NEW','APPROVED','CANCELED','PAID','CLOSED','RETURNED'))
);

drop table if exists products cascade;
create table products (
                          id bigint primary key,
                          price numeric(38,2),
                          category_id bigint,
                          description varchar(255),
                          title varchar(255),
                          image bytea
);


drop table if exists users cascade;
create table users (
                       id bigint primary key,
                       archive boolean not null,
                       address varchar(255),
                       email varchar(255),
                       name varchar(255),
                       password varchar(255),
                       phone varchar(255),
                       role varchar(255) check (role in ('ADMIN','CLIENT','MANAGER','GUEST')),
                       username varchar(255),
                       created timestamp(6)
);

alter table if exists buckets add constraint buckets_user_id_FK foreign key (user_id) references users;
alter table if exists buckets_products add constraint buckets_product_id_FK foreign key (product_id) references products;
alter table if exists buckets_products add constraint product_buckets_id_FK foreign key (bucket_id) references buckets;
alter table if exists order_details add constraint order_details_order_id_FK foreign key (order_id) references orders;
alter table if exists order_details add constraint orders_details_fk_product foreign key (product_id) references products;
alter table if exists orders add constraint order_user_id_FK foreign key (user_id) references users;
alter table if exists products add constraint products_category_id_FK foreign key (category_id) references categories;
