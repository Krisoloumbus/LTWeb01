-- Tạo database
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'lt_web')
BEGIN
    CREATE DATABASE lt_web;
END
GO

USE lt_web;
GO

-- =========================
-- 1. USERS
-- =========================
IF OBJECT_ID('users', 'U') IS NOT NULL DROP TABLE users;
GO

CREATE TABLE users (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(100) NOT NULL,
    password NVARCHAR(255) NOT NULL,
    isSeller BIT DEFAULT 0,
    isAdmin BIT DEFAULT 0
);
GO

-- Insert user
SET IDENTITY_INSERT users ON;

INSERT INTO users (id, name, password, isSeller, isAdmin) VALUES
(2, N'admin', N'123', 0, 1);

SET IDENTITY_INSERT users OFF;
GO


-- =========================
-- 2. CATEGORY
-- =========================
IF OBJECT_ID('category', 'U') IS NOT NULL DROP TABLE category;
GO

CREATE TABLE category (
    cate_id INT IDENTITY(1,1) PRIMARY KEY,
    cate_name NVARCHAR(255) NOT NULL,
    icons NVARCHAR(255) NULL
);
GO

INSERT INTO category (cate_name, icons) VALUES
(N'áo', N'assets/images/categories/1772457153194.jpeg'),
(N'quần', N'assets/images/categories/1772457359191.jpeg');
GO


-- =========================
-- 3. PRODUCTS
-- =========================
IF OBJECT_ID('products', 'U') IS NOT NULL DROP TABLE products;
GO

CREATE TABLE products (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(255) NOT NULL,
    description NVARCHAR(MAX),
    price FLOAT NOT NULL,
    img NVARCHAR(500),
    category_id INT,
    seller_id BIGINT,
    amount INT DEFAULT 0,
    stock INT DEFAULT 0,

    FOREIGN KEY (category_id) REFERENCES category(cate_id),
    FOREIGN KEY (seller_id) REFERENCES users(id)
);
GO

-- Insert sample product
INSERT INTO products (name, description, price, img, category_id, seller_id, amount, stock) VALUES
(N'Áo thun basic', N'Áo thun cotton', 120000, N'assets/images/products/aothun.jpg', 1, 2, 10, 100),
(N'Quần jean', N'Quần jean nam', 350000, N'assets/images/products/jean.jpg', 2, 2, 5, 50);
GO