-- create database if not exists smartphone_store;
use smartphone_store;
--
-- -- create data
-- create table users (
--     id int primary key auto_increment,
--     full_name varchar(100) not null,
--     email varchar(100) not null unique,
--     password varchar(255) not null,
--     phone varchar(15) not null,
--     address text,
--     role enum('Admin', 'Customer') not null default 'Customer',
--     is_active boolean default true,
--     index idx_email (email),
--     index idx_role (role)
-- );
--
-- create table categories (
--     id int primary key auto_increment,
--     name varchar(100) not null unique,
--     description text,
--     index idx_name (name)
-- );
--
-- create table products (
--     id int primary key auto_increment,
--     name varchar(200) not null,
--     brand varchar(100) not null,
--     capacity varchar(20),
--     color varchar(50),
--     price decimal(12,2) not null check (price >= 0),
--     stock int not null default 0 check (stock >= 0),
--     description text,
--     category_id int,
--     foreign key (category_id) references categories(id) on delete set null,
--     index idx_name (name),
--     index idx_brand (brand),
--     index idx_price (price),
--     index idx_category (category_id)
-- );
--
-- create table orders (
--     id int primary key auto_increment,
--     user_id int not null,
--     order_date timestamp default current_timestamp,
--     total_amount decimal(12,2) not null check (total_amount >= 0),
--     status enum('Pending', 'Shipping', 'Delivered', 'Cancelled') not null default 'Pending',
--     shipping_address text not null,
--     shipping_phone varchar(15) not null,
--     coupon_code varchar(50),
--     discount_amount decimal(12,2) default 0,
--     foreign key (user_id) references users(id) on delete restrict,
--     index idx_user (user_id),
--     index idx_status (status),
--     index idx_date (order_date)
-- );
--
-- create table order_details (
--     id int primary key auto_increment,
--     order_id int not null,
--     product_id int not null,
--     quantity int not null check (quantity > 0),
--     price decimal(12,2) not null check (price >= 0),
--     foreign key (order_id) references orders(id) on delete cascade,
--     foreign key (product_id) references products(id) on delete restrict,
--     index idx_order (order_id),
--     index idx_product (product_id)
-- );
--
-- create table coupons (
--     id int primary key auto_increment,
--     code varchar(50) not null unique,
--     discount_percent int not null check (discount_percent between 1 and 100),
--     valid_from date not null,
--     valid_to date not null,
--     max_usage int default 1,
--     used_count int default 0,
--     min_order_amount decimal(12,2) default 0,
--     is_active boolean default true,
--     index idx_code (code),
--     index idx_valid (valid_from, valid_to)
-- );
--
create table coupon_products (
    id int primary key auto_increment,
    coupon_id int not null,
    product_id int not null,
    foreign key (coupon_id) references coupons(id) on delete cascade,
    foreign key (product_id) references products(id) on delete cascade,
    unique key unique_coupon_product (coupon_id, product_id)
);

create table coupon_brands (
    id int primary key auto_increment,
    coupon_id int not null,
    brand varchar(100) not null,
    foreign key (coupon_id) references coupons(id) on delete cascade,
    unique key unique_coupon_brand (coupon_id, brand)
);

-- create table flash_sales (
--     id int primary key auto_increment,
--     product_id int not null,
--     flash_price decimal(12,2) not null check (flash_price >= 0),
--     flash_quantity int not null check (flash_quantity >= 0),
--     start_time datetime not null,
--     end_time datetime not null,
--     foreign key (product_id) references products(id) on delete cascade,
--     index idx_product (product_id),
--     index idx_time (start_time, end_time)
-- );
--
-- -- insert data
-- insert into categories (name, description)
-- values
--    ('IPhone', 'Dòng điện thoại Apple iPhone'),
--    ('Samsung', 'Điện thoại Samsung Galaxy'),
--    ('Xiaomi', 'Điện thoại Xiaomi'),
--    ('OPPO', 'Điện thoại OPPO'),
--    ('Vivo', 'Điện thoại Vivo');
--
-- -- users (password: 123456 đã hash BCrypt - bạn nên thay bằng hash thật trong code)
# admin@gmail.com
# insert into users (full_name, email, password, phone, address, role)
# values
#     ('Admin System', 'admin@smartphone.com', '$2a$10$N9qo8uLOickgx2ZMRZoMy.Mr/FMh2uY6XjMqGZqZgYzXxXxXxXxX', '0987654321', 'Hanoi, Vietnam', 'Admin'),
#     ('Nguyen Van A', 'a.nguyen@email.com', '$2a$10$N9qo8uLOickgx2ZMRZoMy.Mr/FMh2uY6XjMqGZqZgYzXxXxXxX', '0901234567', '123 Le Loi, Q1, HCM', 'Customer'),
#     ('Tran Thi B', 'b.tran@email.com', '$2a$10$N9qo8uLOickgx2ZMRZoMy.Mr/FMh2uY6XjMqGZqZgYzXxXxXxX', '0909876543', '456 Nguyen Hue, Q1, HCM', 'Customer');
--
# insert into users (full_name, email, password, phone, address, role)
# values
#     ('Admin System', 'admin@gmail.com', '$2a$10$QXih24MRIa35Eo7NaYQrkOpe7q1ZFRK560/wymhWNjqHN5/9EE8LC', '0987654321', 'Hanoi, Vietnam', 'Admin');
-- insert into products (name, brand, capacity, color, price, stock, description, category_id)
-- values
--     ('iPhone 15 Pro Max', 'Apple', '256GB', 'Titan Xám', 29990000.00, 15, 'Chip A17 Pro, màn hình 6.7 inch Super Retina XDR', 1),
--     ('iPhone 15 Pro', 'Apple', '128GB', 'Titan Trắng', 25990000.00, 20, 'Chip A17 Pro, màn hình 6.1 inch', 1),
--     ('Samsung Galaxy S24 Ultra', 'Samsung', '512GB', 'Titan Đen', 28490000.00, 10, 'S Pen tích hợp, camera 200MP', 2),
--     ('Samsung Galaxy S24 Plus', 'Samsung', '256GB', 'Xanh', 22990000.00, 12, 'Màn hình 6.7 inch Dynamic AMOLED', 2),
--     ('Xiaomi 14T Pro', 'Xiaomi', '512GB', 'Xanh', 14990000.00, 25, 'Camera Leica 50MP, pin 5000mAh', 3),
--     ('Xiaomi Redmi Note 13', 'Xiaomi', '256GB', 'Đen', 6990000.00, 30, 'Màn hình AMOLED 120Hz', 3);
--
-- insert into coupons (code, discount_percent, valid_from, valid_to, max_usage, min_order_amount, is_active)
-- values
-- ('Welcome10', 10, curdate(), date_add(curdate(), interval 30 day), 100, 500000.00, true),
-- ('Sale20', 20, curdate(), date_add(curdate(), interval 7 day), 50, 1000000.00, true),
-- ('Flash50', 50, curdate(), date_add(curdate(), interval 1 day), 10, 2000000.00, true);
--
-- insert into flash_sales (product_id, flash_price, flash_quantity, start_time, end_time) values
-- (1, 25990000.00, 5, now(), date_add(now(), interval 24 hour)),
-- (3, 24990000.00, 3, now(), date_add(now(), interval 24 hour));
--
-- insert into orders (user_id, total_amount, status, shipping_address, shipping_phone) values
--     (2, 29990000.00, 'Delivered', '123 Le Loi, Q1, HCM', '0901234567'),
--     (2, 28490000.00, 'Shipping', '123 Le Loi, Q1, HCM', '0901234567'),
--     (3, 6990000.00, 'Pending', '456 Nguyen Hue, Q1, HCM', '0909876543');
--
-- insert into order_details (order_id, product_id, quantity, price)
-- values
--     (1, 1, 1, 29990000.00),
--     (2, 3, 1, 28490000.00),
--     (3, 6, 1, 6990000.00);
alter table categories add column is_deleted boolean default false;
alter table categories add index idx_is_deleted (is_deleted);

alter table products add column is_deleted boolean default false;
alter table products add index idx_is_deleted (is_deleted);

alter table coupons add column applicable_type varchar(20) default 'ALL';

-- Thêm sản phẩm cho category iPhone
insert into products (name, brand, capacity, color, price, stock, description, category_id)
values
    ('iPhone 15', 'Apple', '128GB', 'Hồng', 18990000.00, 20, 'Chip A16, màn hình 6.1 inch', 1),
    ('iPhone 15 Plus', 'Apple', '128GB', 'Xanh', 21990000.00, 18, 'Chip A16, màn hình 6.7 inch', 1),
    ('iPhone 14 Pro Max', 'Apple', '256GB', 'Tím', 24990000.00, 10, 'Chip A16, camera 48MP', 1),
    ('iPhone 14 Pro', 'Apple', '128GB', 'Vàng', 20990000.00, 12, 'Chip A16, màn hình 6.1 inch', 1),
    ('iPhone 14', 'Apple', '128GB', 'Đỏ', 15990000.00, 25, 'Chip A15, camera kép', 1),
    ('iPhone 13 Pro Max', 'Apple', '256GB', 'Xanh', 19990000.00, 8, 'Chip A15, pin trâu', 1),
    ('iPhone 13', 'Apple', '128GB', 'Trắng', 12990000.00, 15, 'Chip A15, màn hình 6.1 inch', 1),
    ('iPhone SE 2022', 'Apple', '64GB', 'Đen', 9990000.00, 30, 'Chip A15, Touch ID', 1);

-- Thêm sản phẩm cho category Samsung
insert into products (name, brand, capacity, color, price, stock, description, category_id)
values
    ('Samsung Galaxy S23 Ultra', 'Samsung', '256GB', 'Tím', 22990000.00, 12, 'S Pen tích hợp, camera 200MP', 2),
    ('Samsung Galaxy S23 Plus', 'Samsung', '256GB', 'Xanh', 18990000.00, 15, 'Màn hình 6.6 inch', 2),
    ('Samsung Galaxy S23', 'Samsung', '128GB', 'Xám', 15990000.00, 20, 'Màn hình 6.1 inch', 2),
    ('Samsung Galaxy Z Fold5', 'Samsung', '512GB', 'Đen', 34990000.00, 5, 'Màn hình gập 7.6 inch', 2),
    ('Samsung Galaxy Z Flip5', 'Samsung', '256GB', 'Xanh', 22990000.00, 8, 'Màn hình gập 3.4 inch', 2),
    ('Samsung Galaxy A54', 'Samsung', '128GB', 'Tím', 8990000.00, 25, 'Màn hình 6.4 inch, pin 5000mAh', 2),
    ('Samsung Galaxy A34', 'Samsung', '128GB', 'Xanh', 6990000.00, 30, 'Màn hình 6.6 inch, pin 5000mAh', 2),
    ('Samsung Galaxy M54', 'Samsung', '128GB', 'Đen', 7990000.00, 20, 'Pin 6000mAh, camera 108MP', 2);

-- Thêm sản phẩm cho category Xiaomi
insert into products (name, brand, capacity, color, price, stock, description, category_id)
values
    ('Xiaomi 13T Pro', 'Xiaomi', '256GB', 'Xanh', 12990000.00, 15, 'Camera Leica 50MP, chip Dimensity', 3),
    ('Xiaomi 13T', 'Xiaomi', '256GB', 'Đen', 10990000.00, 18, 'Camera Leica 50MP', 3),
    ('Xiaomi 12T Pro', 'Xiaomi', '256GB', 'Xám', 11990000.00, 10, 'Camera 200MP, sạc 120W', 3),
    ('Xiaomi Redmi Note 12', 'Xiaomi', '128GB', 'Xanh', 4990000.00, 35, 'Màn hình AMOLED, pin 5000mAh', 3),
    ('Xiaomi Redmi Note 11', 'Xiaomi', '128GB', 'Xám', 3990000.00, 40, 'Màn hình 6.43 inch', 3),
    ('Xiaomi Pad 6', 'Xiaomi', '128GB', 'Xám', 8990000.00, 12, 'Máy tính bảng 11 inch', 3),
    ('Xiaomi 14', 'Xiaomi', '256GB', 'Trắng', 15990000.00, 8, 'Chip Snapdragon 8 Gen 3', 3);

-- Thêm sản phẩm cho category OPPO
insert into products (name, brand, capacity, color, price, stock, description, category_id)
values
    ('OPPO Find X6 Pro', 'OPPO', '256GB', 'Đen', 19990000.00, 10, 'Camera Hasselblad', 4),
    ('OPPO Find N3', 'OPPO', '512GB', 'Vàng', 29990000.00, 5, 'Màn hình gập 7.8 inch', 4),
    ('OPPO Reno10 Pro', 'OPPO', '256GB', 'Xanh', 11990000.00, 15, 'Camera tele 32MP', 4),
    ('OPPO Reno10', 'OPPO', '128GB', 'Hồng', 8990000.00, 20, 'Màn hình AMOLED 120Hz', 4),
    ('OPPO A78', 'OPPO', '128GB', 'Xanh', 5990000.00, 25, 'Pin 5000mAh, sạc 67W', 4),
    ('OPPO A58', 'OPPO', '128GB', 'Đen', 4990000.00, 30, 'Màn hình 6.56 inch', 4);

-- Thêm sản phẩm cho category Vivo
insert into products (name, brand, capacity, color, price, stock, description, category_id)
values
    ('Vivo X100 Pro', 'Vivo', '256GB', 'Đen', 18990000.00, 8, 'Camera ZEISS 50MP', 5),
    ('Vivo X100', 'Vivo', '256GB', 'Xanh', 15990000.00, 10, 'Camera ZEISS', 5),
    ('Vivo V30 Pro', 'Vivo', '256GB', 'Hồng', 12990000.00, 12, 'Camera selfie 50MP', 5),
    ('Vivo V30', 'Vivo', '128GB', 'Xanh', 9990000.00, 15, 'Màn hình 6.78 inch', 5),
    ('Vivo Y100', 'Vivo', '128GB', 'Vàng', 6990000.00, 20, 'Pin 5000mAh', 5),
    ('Vivo Y36', 'Vivo', '128GB', 'Đen', 5490000.00, 25, 'Màn hình 6.64 inch', 5);

# -- Xem tất cả đơn hàng
# SELECT id, user_id, total_amount, status, order_date
# FROM orders
# WHERE status = 'Delivered'
# ORDER BY order_date DESC;
#
# -- Xem đơn hàng theo tháng
# SELECT id, user_id, total_amount, status, order_date
# FROM orders
# WHERE status = 'Delivered'
#   AND MONTH(order_date) = 4
#   AND YEAR(order_date) = 2026;

# INSERT INTO orders (user_id, total_amount, status, shipping_address, shipping_phone, order_date)
# VALUES
#     (2, 29990000.00, 'Delivered', '123 Le Loi, Q1, HCM', '0901234567', '2026-04-01 10:30:00'),
#     (2, 28490000.00, 'Delivered', '123 Le Loi, Q1, HCM', '0901234567', '2026-04-05 14:20:00'),
#     (3, 6990000.00, 'Delivered', '456 Nguyen Hue, Q1, HCM', '0909876543', '2026-04-10 09:15:00'),
#     (2, 18990000.00, 'Delivered', '123 Le Loi, Q1, HCM', '0901234567', '2026-04-15 16:45:00'),
#     (3, 15990000.00, 'Delivered', '456 Nguyen Hue, Q1, HCM', '0909876543', '2026-04-20 11:00:00');
#
# -- Thêm chi tiết đơn hàng
# INSERT INTO order_details (order_id, product_id, quantity, price)
# VALUES
#     (4, 1, 1, 29990000.00),
#     (5, 3, 1, 28490000.00),
#     (6, 6, 1, 6990000.00),
#     (7, 2, 1, 18990000.00),
#     (8, 5, 1, 15990000.00);