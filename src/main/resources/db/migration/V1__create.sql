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
drop sequence if exists image_seq;
create sequence image_seq start with 1 increment by 1;
drop sequence if exists product_images_seq;
create sequence product_images_seq start with 1 increment by 1;
drop sequence if exists product_sizes_seq;
create sequence product_sizes_seq start with 1 increment by 1;
drop sequence if exists news_seq;
create sequence news_seq start with 1 increment by 1;
drop sequence if exists product_comment_seq;
create sequence product_comment_seq start with 1 increment by 1;

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
                               product_id bigint not null
                            );

drop table if exists orders cascade;
create table orders (
                        id bigint primary key,
                        sum numeric(38,2),
                        created timestamp(6),
                        address text,
                        last_changed timestamp(6),
                        user_id bigint,
                        status varchar(255) check (status in ('NEW','APPROVED','CANCELED','PAID','CLOSED','RETURNED'))
                    );

drop table if exists products cascade;
create table products (
                          id bigint primary key,
                          price numeric(38,2),
                          category_id bigint,
                          description varchar(255),
                          title varchar(255),
                          date_of_change timestamp(6),
                          date_of_created timestamp(6),
                          preview_image_id bigint
                            );


drop table if exists users cascade;
create table users (
                       id bigint primary key,
                       address varchar(255),
                       email varchar(255),
                       first_name varchar(255),
                       last_name varchar(255),
                       password varchar(255),
                       phone varchar(255),
                       role varchar(255) check (role in ('ADMIN','CLIENT','MANAGER')),
                       name varchar(255),
                       archive boolean,
                       created timestamp(6)
                        );
drop table if exists products_sizes cascade;
create table products_sizes (
                                product_id bigint not null,
                                size_id bigint not null
                            );

drop table if exists product_images cascade;
create table product_images (
                        id bigint PRIMARY KEY,
                        product_id bigint,
                        title varchar(255),
                        size bigint,
                        content_type varchar(255),
                        is_preview_image boolean,
                        original_file_name varchar(255),
                        bytes oid
                            );

drop table if exists product_sizes cascade;
create table product_sizes (
                                id bigint PRIMARY KEY,
                                ru_size varchar(10),
                                inter_size varchar(10)
);


drop table if exists news cascade;
create table news (
                               id bigint PRIMARY KEY,
                               name varchar(200),
                               description text,
                               date_created timestamp(6)
);

drop table if exists product_comments cascade;
create table product_comments (
                               id bigint PRIMARY KEY,
                               user_id bigint,
                               description text,
                               product_id bigint,
                               date_created timestamp(6)
);


alter table if exists buckets add constraint buckets_user_id_FK foreign key (user_id) references users;
alter table if exists buckets_products add constraint buckets_product_id_FK foreign key (product_id) references products;
alter table if exists buckets_products add constraint product_buckets_id_FK foreign key (bucket_id) references buckets;
alter table if exists products_sizes add constraint product_sizes_id_FK foreign key (size_id) references product_sizes;
alter table if exists products_sizes add constraint size_products_id_FK foreign key (product_id) references products;
alter table if exists order_details add constraint order_details_order_id_FK foreign key (order_id) references orders;
alter table if exists order_details add constraint orders_details_fk_product foreign key (product_id) references products;
alter table if exists orders add constraint order_user_id_FK foreign key (user_id) references users;
alter table if exists products add constraint products_category_id_FK foreign key (category_id) references categories;
alter table if exists product_images add constraint prod_images_prod_id foreign key (product_id) references products;
alter table if exists product_comments add constraint prod_comment_prod_id foreign key (product_id) references products;
alter table if exists product_comments add constraint prod_comment_user_id foreign key (user_id) references users;
