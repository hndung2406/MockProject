

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
    [Role] VARCHAR(35)  DEFAULT 'user',
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
    [Spec] NVARCHAR(155),
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
VALUES ('','','','','', '','')
INSERT INTO Users (UserName, Password, Email, FirstName, LastName, Role, CreateDate)
VALUES ('hoanglatoi','Hoangday@7589','group01@domain.com','Nguyen','Dinh Hoang', 'admin', GETDATE())
GO
INSERT INTO Users (UserName, Password, Email, FirstName, LastName, Role, CreateDate)
VALUES ('dunglatoi','Dung@123','group02@domain.com','Hoang','Ngoc Dung', 'admin', GETDATE())
GO
INSERT INTO Users (UserName, Password, Email, FirstName, LastName, Role, CreateDate)
VALUES ('linhlatoi','Linh@123','group03@domain.com','Nguyen','Thanh Linh', 'admin', GETDATE())
GO

