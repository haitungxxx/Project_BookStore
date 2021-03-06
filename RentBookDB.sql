USE [master]
GO
/****** Object:  Database [BookStoreDB]    Script Date: 7/14/2020 1:59:09 PM ******/
CREATE DATABASE [BookStoreDB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'HotelDB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\HotelDB.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'HotelDB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\HotelDB_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [BookStoreDB] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BookStoreDB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BookStoreDB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BookStoreDB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BookStoreDB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BookStoreDB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BookStoreDB] SET ARITHABORT OFF 
GO
ALTER DATABASE [BookStoreDB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BookStoreDB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BookStoreDB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BookStoreDB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BookStoreDB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BookStoreDB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BookStoreDB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BookStoreDB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BookStoreDB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BookStoreDB] SET  DISABLE_BROKER 
GO
ALTER DATABASE [BookStoreDB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BookStoreDB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BookStoreDB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BookStoreDB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BookStoreDB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BookStoreDB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BookStoreDB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BookStoreDB] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [BookStoreDB] SET  MULTI_USER 
GO
ALTER DATABASE [BookStoreDB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BookStoreDB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BookStoreDB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BookStoreDB] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [BookStoreDB] SET DELAYED_DURABILITY = DISABLED 
GO
USE [BookStoreDB]
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 7/14/2020 1:59:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[orderID] [char](50) NOT NULL,
	[bookID] [char](50) NOT NULL,
	[quantity] [int] NULL,
 CONSTRAINT [PK_OrderDetail] PRIMARY KEY CLUSTERED 
(
	[orderID] ASC,
	[bookID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblBook]    Script Date: 7/14/2020 1:59:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblBook](
	[bookID] [char](50) NOT NULL,
	[title] [nvarchar](50) NULL,
	[quantity] [int] NULL,
	[price] [float] NULL,
	[isActive] [bit] NULL,
 CONSTRAINT [PK_tblRoom] PRIMARY KEY CLUSTERED 
(
	[bookID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblOrder]    Script Date: 7/14/2020 1:59:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblOrder](
	[orderID] [char](50) NOT NULL,
	[userID] [char](50) NULL,
	[total] [float] NULL,
	[getDate] [datetime] NULL,
	[returnDate] [datetime] NULL,
 CONSTRAINT [PK_tblOrder] PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 7/14/2020 1:59:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblUser](
	[userID] [char](50) NOT NULL,
	[password] [nvarchar](50) NULL,
	[fullName] [nvarchar](50) NULL,
	[roleID] [nvarchar](50) NULL,
	[isActive] [bit] NULL,
 CONSTRAINT [PK_tblUser] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[OrderDetail] ([orderID], [bookID], [quantity]) VALUES (N'user0                                             ', N'C#                                                ', 1)
INSERT [dbo].[OrderDetail] ([orderID], [bookID], [quantity]) VALUES (N'user0                                             ', N'C++                                               ', 1)
INSERT [dbo].[OrderDetail] ([orderID], [bookID], [quantity]) VALUES (N'user1                                             ', N'C#                                                ', 1)
INSERT [dbo].[OrderDetail] ([orderID], [bookID], [quantity]) VALUES (N'user1                                             ', N'sachmoi                                           ', 1)
INSERT [dbo].[tblBook] ([bookID], [title], [quantity], [price], [isActive]) VALUES (N'C                                                 ', N'C nangcao', 40, 30000, 1)
INSERT [dbo].[tblBook] ([bookID], [title], [quantity], [price], [isActive]) VALUES (N'C#                                                ', N'C# nang cao', 60, 50000, 1)
INSERT [dbo].[tblBook] ([bookID], [title], [quantity], [price], [isActive]) VALUES (N'C++                                               ', N'C++ nang cao', 50, 30000, 1)
INSERT [dbo].[tblBook] ([bookID], [title], [quantity], [price], [isActive]) VALUES (N'Error                                             ', N'Error Book', 30, 70000, 0)
INSERT [dbo].[tblBook] ([bookID], [title], [quantity], [price], [isActive]) VALUES (N'Java                                              ', N'Java co ban', 50, 10000, 1)
INSERT [dbo].[tblBook] ([bookID], [title], [quantity], [price], [isActive]) VALUES (N'OutOfStock                                        ', N'Out of stock', 0, 10000, 1)
INSERT [dbo].[tblBook] ([bookID], [title], [quantity], [price], [isActive]) VALUES (N'sachmoi                                           ', N'newnew', 20, 23900, 1)
INSERT [dbo].[tblBook] ([bookID], [title], [quantity], [price], [isActive]) VALUES (N'sachmoi2                                          ', N'newnew', 20, 20000, 1)
INSERT [dbo].[tblBook] ([bookID], [title], [quantity], [price], [isActive]) VALUES (N'youtube                                           ', N'youtube', 20, 20000, 1)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [getDate], [returnDate]) VALUES (N'user0                                             ', N'user                                              ', 80000, CAST(N'2020-07-14 00:00:00.000' AS DateTime), CAST(N'2020-07-28 00:00:00.000' AS DateTime))
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [getDate], [returnDate]) VALUES (N'user1                                             ', N'user                                              ', 73900, CAST(N'2020-07-14 00:00:00.000' AS DateTime), CAST(N'2020-07-28 00:00:00.000' AS DateTime))
INSERT [dbo].[tblUser] ([userID], [password], [fullName], [roleID], [isActive]) VALUES (N'a1                                                ', N'2', N'xinchao', N'user', 0)
INSERT [dbo].[tblUser] ([userID], [password], [fullName], [roleID], [isActive]) VALUES (N'a10                                               ', N'2', N'zxczc', N'user', 0)
INSERT [dbo].[tblUser] ([userID], [password], [fullName], [roleID], [isActive]) VALUES (N'a2                                                ', N'2', N'asda', N'user', 0)
INSERT [dbo].[tblUser] ([userID], [password], [fullName], [roleID], [isActive]) VALUES (N'a3                                                ', N'2', N'asd', N'user', 1)
INSERT [dbo].[tblUser] ([userID], [password], [fullName], [roleID], [isActive]) VALUES (N'a4                                                ', N'2', N'adsad', N'user', 1)
INSERT [dbo].[tblUser] ([userID], [password], [fullName], [roleID], [isActive]) VALUES (N'a5                                                ', N'2', N'adasda', N'user', 1)
INSERT [dbo].[tblUser] ([userID], [password], [fullName], [roleID], [isActive]) VALUES (N'a6                                                ', N'2', N'asdasdasd', N'user', 1)
INSERT [dbo].[tblUser] ([userID], [password], [fullName], [roleID], [isActive]) VALUES (N'a7                                                ', N'2', N'adasd', N'user', 1)
INSERT [dbo].[tblUser] ([userID], [password], [fullName], [roleID], [isActive]) VALUES (N'a8                                                ', N'2', N'adasds', N'user', 1)
INSERT [dbo].[tblUser] ([userID], [password], [fullName], [roleID], [isActive]) VALUES (N'a9                                                ', N'2', N'zxczxc', N'user', 1)
INSERT [dbo].[tblUser] ([userID], [password], [fullName], [roleID], [isActive]) VALUES (N'admin                                             ', N'1', N'SuperAdmin', N'admin', 1)
INSERT [dbo].[tblUser] ([userID], [password], [fullName], [roleID], [isActive]) VALUES (N'admin1                                            ', N'1', N'Admin1', N'admin', 1)
INSERT [dbo].[tblUser] ([userID], [password], [fullName], [roleID], [isActive]) VALUES (N'admin2                                            ', N'1', N'Admin2', N'admin', 1)
INSERT [dbo].[tblUser] ([userID], [password], [fullName], [roleID], [isActive]) VALUES (N'admin3                                            ', N'1', N'Admin3', N'admin', 1)
INSERT [dbo].[tblUser] ([userID], [password], [fullName], [roleID], [isActive]) VALUES (N'banuser                                           ', N'2', N'ohNo', N'user', 0)
INSERT [dbo].[tblUser] ([userID], [password], [fullName], [roleID], [isActive]) VALUES (N'user                                              ', N'2', N'qweqe', N'user', 1)
INSERT [dbo].[tblUser] ([userID], [password], [fullName], [roleID], [isActive]) VALUES (N'user1                                             ', N'2', N'qweqe', N'user', 1)
INSERT [dbo].[tblUser] ([userID], [password], [fullName], [roleID], [isActive]) VALUES (N'user2                                             ', N'2', N'qweqweq', N'user', 1)
INSERT [dbo].[tblUser] ([userID], [password], [fullName], [roleID], [isActive]) VALUES (N'user3                                             ', N'2', N'qweqewqe', N'user', 1)
INSERT [dbo].[tblUser] ([userID], [password], [fullName], [roleID], [isActive]) VALUES (N'user4                                             ', N'2', N'qweqwe', N'user', 1)
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_tblBook] FOREIGN KEY([bookID])
REFERENCES [dbo].[tblBook] ([bookID])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_tblBook]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_tblOrder] FOREIGN KEY([orderID])
REFERENCES [dbo].[tblOrder] ([orderID])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_tblOrder]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_tblRoom] FOREIGN KEY([bookID])
REFERENCES [dbo].[tblBook] ([bookID])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_tblRoom]
GO
ALTER TABLE [dbo].[tblOrder]  WITH CHECK ADD  CONSTRAINT [FK_tblOrder_tblUser] FOREIGN KEY([userID])
REFERENCES [dbo].[tblUser] ([userID])
GO
ALTER TABLE [dbo].[tblOrder] CHECK CONSTRAINT [FK_tblOrder_tblUser]
GO
USE [master]
GO
ALTER DATABASE [BookStoreDB] SET  READ_WRITE 
GO
