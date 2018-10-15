

USE master
GO

DECLARE @DatabaseName nvarchar(50)
SET @DatabaseName = N'MockProject_GroupOne'

DECLARE @SQL varchar(max)

SELECT @SQL = COALESCE(@SQL,'') + 'Kill ' + Convert(varchar, SPId) + ';'
FROM MASTER..SysProcesses
WHERE DBId = DB_ID(@DatabaseName) AND SPId <> @@SPId

EXEC(@SQL)

IF EXISTS (SELECT 1 FROM sys.databases WHERE name = @DatabaseName)
	BEGIN 
		DROP DATABASE MockProject_GroupOne
	END
GO

CREATE DATABASE MockProject_GroupOne
GO

USE MockProject_GroupOne
GO



IF EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = '[Country]')				
	BEGIN
		DROP TABLE [Country]
	END
GO


CREATE TABLE [Country](
    [CountryId] INT IDENTITY PRIMARY KEY,
    [CountryName] NVARCHAR(20) UNIQUE
);
GO


IF EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = '[State]')				
	BEGIN
		DROP TABLE [State]
	END
GO

CREATE TABLE [State](
    [StateId] INT IDENTITY PRIMARY KEY,
    [StateName] NVARCHAR(35) UNIQUE
);
GO

IF EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = '[Users]')				
	BEGIN
		DROP TABLE [Users]
	END
GO

CREATE TABLE [Users](
    [UserId] INT IDENTITY PRIMARY KEY,
    [UserName] NVARCHAR(255) NOT NULL UNIQUE,
    [Password] NVARCHAR(80) NOT NULL,
    [Email] VARCHAR(155) NOT NULL UNIQUE,
    [FirstName] NVARCHAR(155),
    [LastName] NVARCHAR(155),
    [Role] VARCHAR(35),
    [CreateDate] DATETIME NOT NULL,
);
GO

IF EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = '[Manufacture]')				
	BEGIN
		DROP TABLE [Manufacture]
	END
GO
CREATE TABLE [Manufacture](
    [ManufactureId] INT PRIMARY KEY IDENTITY,
    [ManufactureName] NVARCHAR(155) NOT NULL UNIQUE
);


IF EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = '[Product]')				
	BEGIN
		DROP TABLE [Product]
	END
GO

CREATE TABLE [Product](
    [ProductId] VARCHAR(6) PRIMARY KEY,
    [ProductName] NVARCHAR(155),
    [ProductPrice] FLOAT,
    [Description] NVARCHAR(355),
    [Image] VARCHAR(255),
    [Quantity] INT,
    [Condition] VARCHAR(15),
    [DateOfManufacture] DATE,
    [Spec] NVARCHAR(255),
    [Properties] NVARCHAR(255),
    [ManufactureId] INT,
    FOREIGN KEY ([ManufactureId]) REFERENCES [Manufacture]([ManufactureId]) ON DELETE CASCADE ON UPDATE CASCADE
);
GO

IF EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = '[Orders]')				
	BEGIN
		DROP TABLE [Orders]
	END
GO


CREATE TABLE [Orders](
    [OrderId] INT IDENTITY PRIMARY KEY,
    [UserId] INT NULL,
    [CardNumber] BIGINT,
    [CountryId] INT,
    [OrderDate] DATE,
    [Phone] VARCHAR(10),
    [PostalCode] VARCHAR(20),
    [StateId] INT,
    [City] VARCHAR(45),
    [OrderAddress1] VARCHAR(55),
    [OrderAddress2] VARCHAR(55),
    FOREIGN KEY ([CountryId]) REFERENCES [Country]([CountryId]) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY ([StateId]) REFERENCES [State]([StateId]) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY ([UserId]) REFERENCES [Users]([UserId]) ON DELETE CASCADE ON UPDATE CASCADE
);

GO

IF EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = '[OrderDetail]')				
	BEGIN
		DROP TABLE [OrderDetail]
	END
GO

CREATE TABLE [OrderDetail](
    [OrderDetailId] INT IDENTITY PRIMARY KEY,
    [OrderId] INT,
    [ProductId] VARCHAR(6),
    [OrderQuantity] INT,
    [TotalAmount] FLOAT,
    FOREIGN KEY ([OrderId]) REFERENCES [Orders]([OrderId]) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY ([ProductId]) REFERENCES [Product]([ProductId]) ON DELETE CASCADE ON UPDATE CASCADE
);
GO


--INSERT RECORDS

--Country--
INSERT INTO Country 
VALUES ('Vietnam')
GO
INSERT INTO Country 
VALUES ('USA')
GO

--State--
INSERT INTO State 
VALUES ('IL')
GO
INSERT INTO State 
VALUES ('MA')
GO

--User

INSERT INTO Users (UserName, Password, Email, FirstName, LastName, Role, CreateDate)
VALUES ('hoanglatoi','Hoangday@7589','group01@domain.com','Nguyen','Dinh Hoang', 'admin', GETDATE())
GO
INSERT INTO Users (UserName, Password, Email, FirstName, LastName, Role, CreateDate)
VALUES ('dunglatoi','Dung@123','group02@domain.com','Hoang','Ngoc Dung', 'admin', GETDATE())
GO
INSERT INTO Users (UserName, Password, Email, FirstName, LastName, Role, CreateDate)
VALUES ('linhlatoi','Linh@123','group03@domain.com','Nguyen','Thanh Linh', 'admin', GETDATE())
GO



INSERT INTO Manufacture
VALUES ('Apple')
GO
INSERT INTO Manufacture
VALUES ('Samsung')
GO
INSERT INTO Manufacture
VALUES ('Oppo')
GO
INSERT INTO Manufacture
VALUES ('Nokia')
GO
INSERT INTO Manufacture
VALUES ('BPhone')
GO

INSERT INTO Product
VALUES('P1011',
	  'Oppo F9', 
	  350, 
	  'The Oppo F9 is yet another feature-packed release with well thought out specifications. From the large FHD screen that delivers great visuals, to the cameras delivering aesthetic photos.',
	  'oppo-f9-red-2-400x460.png',
	  100,
	  'New',
	  '2018-1-10',
	  'The Oppo F9 features a sizable 6.3-inch FHD display with 1,080 x 2,280 pixels screen resolution, put together with a 400 PPI pixel density and an impressive 19:9',
	  'The OPPO F9 comes with a tiny notched-display and a Gorilla Glass 6 protection on top',
	  3)
GO

INSERT INTO Product
VALUES('P1012',
	  'Samsung Galaxy J8', 
	  450, 
	  'The Samsung Galaxy J8 2018 is a good smartphone that is packed with quality features. Its excellent configuration can deliver powerful performance and is capable of handling multiple tasks with ease.',
	  'samsung-galaxy-j8-400x460.png',
	  200,
	  'New',
	  '2018-2-10',
	  'The Samsung Galaxy J8 2018 flaunts a 6-inch Super AMOLED display with a pixel density of 274 PPI and a screen resolution of 720 x 1480 pixels.',
	  'The Galaxy J8 comes with the narrow-bezel Infinity Display design and an impressive build. The smartphone manages to offer excellent battery life',
	  2)
GO

INSERT INTO Product
VALUES('P1014',
	  'Samsung Galaxy Note 9', 
	  450, 
	  'The Samsung Galaxy Note 9 does not only impress with its design but also with its powerful performance. The strong configuration outputs a great performance while playing gaming and doing multitasking.',
	  'samsung-galaxy-note-9-black-400x460-400x460.png',
	  300,
	  'New',
	  '2018-10-10',
	  'The Samsung Galaxy Note 9 features a 6.4-inch Super AMOLED  display which features a screen resolution of 1,440 x 2,960 pixels (514ppi). Driving the phone, a combination of 2.7GHz quad-core M3 Mongoose and 1.7GHz quad-core Cortex A55 processors are ',
	  'The Samsung Galaxy Note 9 does not only impress with its design but also with its powerful performance',
	  2)
GO

INSERT INTO Product
VALUES('P1013',
	  'iPhone 7 Plus 32GB', 
	  550, 
	  'The Apple iPhone 7 is nothing short of extraordinary. It comes with a mammoth battery backup, smart configuration, and an unrivaled camera. It is also water and splash resistant. So if you do not mind spending your bucks and want uncompromising performance, then go for this beauty.',
	  'apple-iphone-7-plus-1-400x460-400x460.png',
	  500,
	  'New',
	  '2018-4-10',
	  'The Apple iPhone 7 Plus comes with a 5.5-inch FHD (1,080 x 1,920 pixels) IPS LCD display capable of producing 401 pixels per inch',
	  'The Apple iPhone 7 is nothing short of extraordinary. It comes with a mammoth battery backup, smart config.',
	  1)
GO

INSERT INTO Product
VALUES('P1016',
	  'iPhone 6s Plus 32GB', 
	  550, 
	  'The Apple iPhone 6S Plus 32GB with quality elements, is another addition model in the Apple 6s Plus series. Like earlier versions, it also features almost the same built up.',
	  'iphone-6s-plus-32gb-400x450-400x450.png',
	  200,
	  'New',
	  '2018-3-10',
	  'The Apple iPhone 7 Plus comes with a 5.5-inch FHD (1,080 x 1,920 pixels) IPS LCD display capable of producing 401 pixels per inch',
	  'The Apple iPhone 6S Plus 32GB has a 5.5-inch IPS LCD Full HD (1,080 x 1,920 pixels) display and weighs 192 grams. It boots on iOS v9 operating system, features a fingerprint scanner.',
	  1)
GO

INSERT INTO Product
VALUES('P1088',
	  'OPPO A3s', 
	  550, 
	  'The Oppo A3s has all the good features that makes it an all-round budget smartphone. The long battery life and overall configuration will give a positive reviews in terms of smooth performance',
	  'oppo-a3s-red-400x460.png',
	  300,
	  'New',
	  '2018-10-10',
	  'he Oppo A3s comes with a thin bezel provided at both side. It has a 6.2inch IPS LCD display having a resolution of 720 x 1,520 pixels and a pixel density of 271ppi.',
	  'The Oppo A3s has all the good features that makes it an all-round budget smartphone. The long battery life and overall configuration will give a positive reviews in terms of smooth performance.',
	  3)
GO




--SELECT VIEWWS--
SELECt * FROM Users
SELECT * FROM Manufacture
SELECT * FROM Product

SELECT *
FROM Product p
ORDER BY p.ProductId
OFFSET 0 ROWS
FETCH NEXT 3 ROWS ONLY

CREATE PROC usp_fetchProductByPageNumber