CREATE DATABASE [mockproject];

USE [mockproject];

CREATE TABLE [Country](
    [CountryId] INT IDENTITY PRIMARY KEY,
    [CountryName] NVARCHAR(20)
);

CREATE TABLE [State](
    [StateId] INT IDENTITY PRIMARY KEY,
    [StateName] NVARCHAR(35)
);

CREATE TABLE [Users](
    [UserId] INT IDENTITY PRIMARY KEY,
    [UserName] NVARCHAR(255) NOT NULL,
    [Password] NVARCHAR(80) NOT NULL,
    [Email] VARCHAR(155) NOT NULL,
    [FirstName] NVARCHAR(155),
    [LastName] NVARCHAR(155),
    [Role] VARCHAR(35),
    [CreateDate] DATETIME NOT NULL,
    [CountryId] INT,
    [StateId] INT,
    FOREIGN KEY ([CountryId]) REFERENCES [Country]([CountryId]) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY ([StateId]) REFERENCES [State]([StateId]) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE [Manufacture](
    [ManufactureId] INT PRIMARY KEY IDENTITY,
    [ManufactureName] NVARCHAR(155) NOT NULL
);

CREATE TABLE [Product](
    [ProductId] VARCHAR(6) PRIMARY KEY,
    [ProductName] NVARCHAR(155),
    [ProductPrice] FLOAT,
    [Description] NVARCHAR(355),
    [Image] VARCHAR(255),
    [Quantity] INT,
    [Condition] VARCHAR(15),
    [DateOfManufacture] DATE,
    [Spec] NVARCHAR(155),
    [Properties] NVARCHAR(255),
    [ManufactureId] INT,
    FOREIGN KEY ([ManufactureId]) REFERENCES [Manufacture]([ManufactureId]) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE [Orders](
    [OrderId] INT IDENTITY PRIMARY KEY,
    [UserId] INT,
    [CartNumber] INT,
    [Country] NVARCHAR(45),
    [OderDate] DATE,
    [Phone] VARCHAR(10),
    [PostalCode] VARCHAR(20),
    [State] VARCHAR(45),
    [City] VARCHAR(45),
    [OrderAddress1] VARCHAR(55),
    [OrderAddress2] VARCHAR(55),
    FOREIGN KEY ([UserId]) REFERENCES [Users]([UserId]) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE [OrderDetail](
    [OrderDetailId] INT IDENTITY PRIMARY KEY,
    [OrderId] INT,
    [ProductId] VARCHAR(6),
    [OrderQuantity] INT,
    [TotalAmount] FLOAT,
    FOREIGN KEY ([OrderId]) REFERENCES [Orders]([OrderId]) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY ([ProductId]) REFERENCES [Product]([ProductId]) ON DELETE CASCADE ON UPDATE CASCADE
);

SELECT * FROM [Users];