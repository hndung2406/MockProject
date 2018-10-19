

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
    [Role] VARCHAR(35) DEFAULT 'user',
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
    [Description] NVARCHAR(MAX),
    [Image] VARCHAR(255),
    [Quantity] INT,
    [Condition] VARCHAR(15),
    [DateOfManufacture] DATE,
    [Spec] NVARCHAR(MAX),
    [Properties] NVARCHAR(MAX),
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

INSERT INTO Users (UserName, Password, Email, FirstName, LastName, CreateDate)
VALUES ('conga','hoangday','demo@gmail.com','Nguyen','Hung Son',GETDATE())
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
INSERT INTO Manufacture
VALUES ('Realme')
GO

INSERT INTO Manufacture
VALUES ('Huawei')
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

INSERT INTO Product
VALUES('P1098',
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

INSERT INTO Product
VALUES('P2011',
	  'iPhone X 64GB Gray', 
	  1250, 
	  'The Apple iPhone X is one of the most groundbreaking launches from Apple as far as both technology and design are concerned. Each and every department is richly fed with the most that you could get. And since the new iPhone X loses the home button and the fingerprint scanner on it, the FaceID is what replaces it, big time.',
	  'iphone-x-64gb-1-400x460.png',
	  200,
	  'New',
	  GETDATE(),
	  'The Apple iPhone X, launched alongside the iPhone 8, has a stunning display that eventually turns out to be the stand-out feature with an edge-cutting super Retina, bezel-less 5.8-inch screen. The sharp resolution of 1,125 x 2,436 pixels enhances the crystal-clear ',
	  'The iPhone X is possibly the biggest innovation from Apple since the original iPhone',
	  1)
GO

INSERT INTO Product
VALUES('P2012',
	  'Samsung Galaxy Tab A 10.5', 
	  950, 
	  'The Samsung Galaxy Tab A 10.5 LTE with its vast screen real estate is definitely an appropriate device for your productivity needs. However, the screen is not very flattering to the eyes for long periods. The configuration underneath is also sufficient to deliver a smooth day to day experience for basic tasks and surfing. The cameras are decent. The battery is enormous, which is highly appreciated. Now, the hiccups, for what the tablet offers, we feel for the price that it is a bit too expensive.',
	  'samsung-galaxy-tab-a-105-inch-chitietblue-400x460.png',
	  250,
	  'New',
	  GETDATE(),
	  'The Apple iPhone X, launched alongside the iPhone 8, has a stunning display that eventually turns out to be the stand-out feature with an edge-cutting super Retina, bezel-less 5.8-inch screen. The sharp resolution of 1,125 x 2,436 pixels enhances the crystal-clear ',
	  'The iPhone X is possibly the biggest innovation from Apple since the original iPhone',
	  2)
GO

INSERT INTO Product
VALUES('P2023',
	  'Realme 2 Pro', 
	  650, 
	  'The Realme 2 Pro is a mid-range smartphone that has a lot of impressive features. The device holds one of the strongest configurations which makes it the perfect gadget for gaming, multitasking and multimedia purposes. The cameras are perfect for clicking pictures under any condition. ',
	  'realme-2-4gb-64gb-docquyen-400x400.jpg',
	  20,
	  'New',
	  GETDATE(),
	  'The Realme 2 Pro styles a stunning IPS LCD display of 6.3-inch with a screen resolution of 1,080 x 2,340 pixels with a pixel density of 409ppi which can render decent viewing experience.',
	  'The Realme 2 Pro runs by a powerful Li-ion battery of 3,500mAh capacity that promises a long power backup for the users. It supports 4G VoLTE services. Other connectivity features offered by the device are WiFi 802.11, Mobile Hotspot, Bluetooth, A-GPS, etc.',
	  6)
GO

INSERT INTO Product
VALUES('P2013',
	  'Realme 2 Pro ', 
	  1150, 
	  'The Realme 2 Pro is a mid-range smartphone that has a lot of impressive features. The device holds one of the strongest configurations which makes it the perfect gadget for gaming, multitasking and multimedia purposes. The cameras are perfect for clicking pictures under any condition. ',
	  'realme-2-4gb-64gb-docquyen-400x400.jpg',
	  10,
	  'New',
	  GETDATE(),
	  'The Realme 2 Pro styles a stunning IPS LCD display of 6.3-inch with a screen resolution of 1,080 x 2,340 pixels with a pixel density of 409ppi which can render decent viewing experience.',
	  'The Realme 2 Pro runs by a powerful Li-ion battery of 3,500mAh capacity that promises a long power backup for the users. It supports 4G VoLTE services. Other connectivity features offered by the device are WiFi 802.11, Mobile Hotspot, Bluetooth, A-GPS, etc.',
	  6)
GO

INSERT INTO Product
VALUES('P2014',
	  ' iPhone Xs 256GB', 
	  1750, 
	  'The Apple iPhone XS is one of the finest smartphones ever by the most trusted brand in the world. It has everything one can imagine in a phone, a classy look, extremely superior display with widescreen, fast charging capability as well as wireless charging support which is a great relief indeed. It uses the iPhone latest iOS v11.2 operation system which has a lot of improvements over its predecessor. The body is  both dustproof and water resistance.',
	  'iphone-xs-256gb-white-400x460.png',
	  10,
	  'New',
	  GETDATE(),
	  'The iPhone XS comes up with 5.8-inch OLED display having a screen resolution of 1,125 x 2,436 pixels and a sharp 463-PPI that delivers a clear viewing experience with a great colour reproduction. It is operated by a combination of hexa-core (a 2.49 GHz Vortex .',
	  'For photography and videography, this device can prove out to be one of the best with a dual rear setup of 12MP + 12MP lens and a 7MP front lens with retina flash that can capture bright selfies with impressive effects. The iPhone XS get its power from 2,685mAh Li-ion battery which can suffice the power requirement of the device throughout the day. It can support fast charging feature as well as wireless charging feature that can fill the battery while on the move.',
	  1)
GO

INSERT INTO Product
VALUES('P2015',
	  'Samsung Galaxy S9+ 128GB', 
	  850, 
	  'The Samsung Galaxy S9 128GB is a good smartphone and comes with plenty of attractive features. It has several protective features like water resistance and screen protection, which helps to avoid any damages. It also assures smooth multi-tasking and switching between application.',
	  'samsung-galaxy-s9-plus-128gb-400x460-400x460.png',
	  20,
	  'New',
	  GETDATE(),
	  'The Samsung Galaxy S9 128GB holds a 5.8 inch super AMOLED display that exhibits a screen resolution of 1,440 x 2,960 pixels resulting in a pixel density of 568 PPI. The device comes with three different body colour option - Midnight Black, Coral Blue and Lilac Purple. In addition, the smartphone is capable enough to be water and dust resistance. The display is protected by a Corning Gorilla Glass v5 which is layered over the screen to avoid scratches.',
	  'The Samsung Galaxy S9 128GB boots on Android v8.0 (Oreo) operating system. Under the hood, it is powered by dual quad-core processors, which is a 2.7Ghz M2 Mongoose and a 1.7Ghz Cortex A53. To deliver a good performance, the dual set of processors is paired with a 4GB RAM. For the graphical requirements, a Mali-G72 MP18 is present in the device. This combination is seated on Samsung Exynos 9 Octa 9810 chipset.',
	  2)
GO

INSERT INTO Product
VALUES('P2016',
	  'Huawei Nova 3', 
	  650, 
	  'The Huawei Nova 3i presents all the features of a mid-range smartphone. It has a great set of dual cameras at both the ends. The screen will also feel good while watching videos. However, the need for a bigger battery capacity is felt since the provided power seems short for a day of heavy usage.',
	  'huawei-nova-3-purple-400x460.png',
	  100,
	  'New',
	  GETDATE(),
	  'The Huawei Nova 3i has come with a 6.3inches IPS LCD display with a high resolution of 4,616 x 3,464 Pixels and a pixel density is around 409ppi that defines sharpness in the vision. The mid-range device features a stylish aspect ratio of 19.5:9 that will take the HD+ experience to another level.',
	  'The Huawei Nova 3i derives its power from a 3,340mAh Li-ion battery that can last for almost a day with a single charge. The Hybrid SIM slot device supports 4G VoLTE so you may hardly face connectivity issue. In terms of connectivity with other devices, it features Wi-Fi 802.11, Mobile Hotspot, Bluetooth v4.2. In the location department, it supports features like A-GPS and Glonass. ',
	  7)
GO

INSERT INTO Product
VALUES('P2017',
	  'Huawei Nova 3', 
	  450, 
	  'The Huawei Nova 3i presents all the features of a mid-range smartphone. It has a great set of dual cameras at both the ends. The screen will also feel good while watching videos. However, the need for a bigger battery capacity is felt since the provided power seems short for a day of heavy usage.',
	  'huawei-nova-3-purple-400x460.png',
	  100,
	  'New',
	  GETDATE(),
	  'The Huawei Nova 3i has come with a 6.3inches IPS LCD display with a high resolution of 4,616 x 3,464 Pixels and a pixel density is around 409ppi that defines sharpness in the vision. The mid-range device features a stylish aspect ratio of 19.5:9 that will take the HD+ experience to another level.',
	  'The Huawei Nova 3i derives its power from a 3,340mAh Li-ion battery that can last for almost a day with a single charge. The Hybrid SIM slot device supports 4G VoLTE so you may hardly face connectivity issue. In terms of connectivity with other devices, it features Wi-Fi 802.11, Mobile Hotspot, Bluetooth v4.2. In the location department, it supports features like A-GPS and Glonass. ',
	  7)
GO

INSERT INTO Product
VALUES('P2018',
	  'Huawei Y7 Pro', 
	  850, 
	  'The Huawei Y7 Prime 2018 is a good smartphone which equipped with lots of features. It has one of the best designed body in the price range and is a treat to the eyes. It has quality lenses, which help to give you quality photographs. For storage purpose, the device offers a good storage capacity in which you can store lot of files and documents. To keep maintain the privacy of your phone and the content you keep in it, the Huawei Y7 Prime 2018.',
	  'huawei-y7-pro-2018-400x460.png',
	  150,
	  'New',
	  GETDATE(),
	  'The Huawei Y7 Prime 2018 sports a 5.99 inch IPS LCD display which exhibits a screen resolution of 720 x 1,440 pixels, resulting in a pixel density of 269 PPI. The smartphone comes with three different body colour option - Black, Blue and Gold. For security purpose, the device is aided with a rear-mounted fingerprint sensor. In addition to this, the smartphone has a face unlock system as well. ',
	  'The Huawei Y7 Prime 2018 boots up on Android v8.0 (Oreo) operating system. Under the hood, the device is equipped with a 1.4Ghz Cortex A53 octa-core processor which is coupled with a 3GB RAM. To fulfill the graphical requirement, an Adreno 505 GPU is present in the device. This combination is placed on a Qualcomm Snapdragon 430 MSM8937 chipset.',
	  7)
GO

INSERT INTO Product
VALUES('P2019',
	  'Huawei Y7 Prime 2018', 
	  850, 
	  'The Huawei Y7 Prime 2018 sports a 5.99 inch IPS LCD display which exhibits a screen resolution of 720 x 1,440 pixels, resulting in a pixel density of 269 PPI. The smartphone comes with three different body colour option - Black, Blue and Gold. For security purpose, the device is aided with a rear-mounted fingerprint sensor. In addition to this, the smartphone has a face unlock system as well. ',
	  'huawei-y7-pro-2018-400x460.png',
	  50,
	  'New',
	  GETDATE(),
	  'The Huawei Y7 Prime 2018 boots up on Android v8.0 (Oreo) operating system. Under the hood, the device is equipped with a 1.4Ghz Cortex A53 octa-core processor which is coupled with a 3GB RAM. To fulfill the graphical requirement, an Adreno 505 GPU is present in the device. This combination is placed on a Qualcomm Snapdragon 430 MSM8937 chipset. ',
	  'The Huawei Y7 Prime 2018 is armed with a dual primary camera setup of 13MP and 2MP. The primary lenses are capable of capturing images of 4,128 x 3,096 pixels resolution. For selfie needs, it offers an 8MP lens. When it comes to the connectivity, the smartphone offers 4G with VoLTE, WiFi, Mobile Hotspot, Bluetooth, GPS and a microUSB as well.   ',
	  7)
GO




SELECT * FROM Manufacture



--SELECT VIEWWS--
SELECt * FROM Users
SELECT * FROM Manufacture
SELECT * FROM Product
GO


--STORE PROCEDURE--


IF OBJECT_ID('usp_FetchProductsInCurrentPage', 'P') IS NOT NULL
	DROP PROC usp_FetchProductsInCurrentPage
GO

CREATE PROC usp_FetchProductsInCurrentPage
@fromRowIndex INT,
@maxResultPerPage INT
AS
	BEGIN
		SELECT *
	FROM Product p
	ORDER BY p.ProductId
	OFFSET @fromRowIndex ROWS
	FETCH NEXT @maxResultPerPage ROWS ONLY
	END
GO

IF OBJECT_ID('usp_FetchProductsByCreatedDate', 'P') IS NOT NULL
	DROP PROC usp_FetchProductsByCreatedDate
GO

CREATE PROC usp_FetchProductsByCreatedDate
@createdDate DATE
AS
	BEGIN
		SELECT TOP 8 *
		FROM Product p
		WHERE p.DateOfManufacture > @createdDate
		ORDER BY p.DateOfManufacture 
	END
GO

EXEC usp_FetchProductsByCreatedDate '2018-10-01'


