
CREATE TABLE [dbo].[cartes](
	[id] [int]  NOT NULL,
	[libelle] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[categories]    Script Date: 29/02/2024 11:52:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[categories](
	[id] [int]  NOT NULL,
	[libelle] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[commandes]    Script Date: 29/02/2024 11:52:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[commandes](
	[id] [int]  NOT NULL,
	[id_table] [int] NULL,
	[heure] [datetime2](6) NULL,
	[statut] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[commandes_produits]    Script Date: 29/02/2024 11:52:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[commandes_produits](
	[id_commande] [int] NOT NULL,
	[id_produit] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[horaires]    Script Date: 29/02/2024 11:52:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[horaires](
	[heure_fermeture] [time](7) NULL,
	[heure_ouverture] [time](7) NULL,
	[id] [int]  NOT NULL,
	[jour] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[horaires_restaurants]    Script Date: 29/02/2024 11:52:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[horaires_restaurants](
	[id_horaire] [int] NOT NULL,
	[id_restaurant] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[messages]    Script Date: 29/02/2024 11:52:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[messages](
	[id] [int]  NOT NULL,
	[id_restaurant] [int] NULL,
	[id_utilisateur] [int] NULL,
	[contenu] [varchar](255) NULL,
	[sujet] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[produits]    Script Date: 29/02/2024 11:52:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[produits](
	[id] [int]  NOT NULL,
	[id_categorie] [int] NULL,
	[prix] [real] NOT NULL,
	[description] [varchar](255) NULL,
	[nom] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[produits_cartes]    Script Date: 29/02/2024 11:52:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[produits_cartes](
	[id_carte] [int] NOT NULL,
	[id_produit] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[reservations]    Script Date: 29/02/2024 11:52:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[reservations](
	[date_res] [date] NULL,
	[heure] [time](7) NULL,
	[id] [int]  NOT NULL,
	[id_restaurant] [int] NULL,
	[id_table] [int] NULL,
	[id_utilisateur] [int] NULL,
	[nb_personnes] [int] NOT NULL,
	[commentaire] [varchar](255) NULL,
	[statut] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[restaurants]    Script Date: 29/02/2024 11:52:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[restaurants](
	[id] [int]  NOT NULL,
	[id_carte] [int] NULL,
	[adresse] [varchar](255) NULL,
	[cpo] [varchar](255) NULL,
	[nom] [varchar](255) NULL,
	[ville] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tableres]    Script Date: 29/02/2024 11:52:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tableres](
	[id] [int]  NOT NULL,
	[id_restaurant] [int] NULL,
	[nombre_places] [int] NOT NULL,
	[numero_table] [int] NOT NULL,
	[statut] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[utilisateurs]    Script Date: 29/02/2024 11:52:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[utilisateurs](
	[id] [int]  NOT NULL,
	[is_admin] [bit] NULL,
	[email] [varchar](255) NULL,
	[mot_de_passe] [varchar](255) NULL,
	[nom] [varchar](255) NULL,
	[prenom] [varchar](255) NULL,
	[telephone] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Index [UK_i8mhg2r5fxqoo4xljqj1pnggx]    Script Date: 29/02/2024 11:52:31 ******/
CREATE UNIQUE NONCLUSTERED INDEX [UK_i8mhg2r5fxqoo4xljqj1pnggx] ON [dbo].[commandes]
(
	[id_table] ASC
)
WHERE ([id_table] IS NOT NULL)
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[commandes]  WITH CHECK ADD  CONSTRAINT [FKmkpkp1ytuukrpsi5lc7rka55a] FOREIGN KEY([id_table])
REFERENCES [dbo].[tableres] ([id])
GO
ALTER TABLE [dbo].[commandes] CHECK CONSTRAINT [FKmkpkp1ytuukrpsi5lc7rka55a]
GO
ALTER TABLE [dbo].[commandes_produits]  WITH CHECK ADD  CONSTRAINT [FK3ql8gc2sygtlx7dj9vtj6ak36] FOREIGN KEY([id_produit])
REFERENCES [dbo].[produits] ([id])
GO
ALTER TABLE [dbo].[commandes_produits] CHECK CONSTRAINT [FK3ql8gc2sygtlx7dj9vtj6ak36]
GO
ALTER TABLE [dbo].[commandes_produits]  WITH CHECK ADD  CONSTRAINT [FK83dnwqrng5tdmc1wtxubushlr] FOREIGN KEY([id_commande])
REFERENCES [dbo].[commandes] ([id])
GO
ALTER TABLE [dbo].[commandes_produits] CHECK CONSTRAINT [FK83dnwqrng5tdmc1wtxubushlr]
GO
ALTER TABLE [dbo].[horaires_restaurants]  WITH CHECK ADD  CONSTRAINT [FKdu4y2cu2rkj0tv7nh2r23m51n] FOREIGN KEY([id_horaire])
REFERENCES [dbo].[horaires] ([id])
GO
ALTER TABLE [dbo].[horaires_restaurants] CHECK CONSTRAINT [FKdu4y2cu2rkj0tv7nh2r23m51n]
GO
ALTER TABLE [dbo].[horaires_restaurants]  WITH CHECK ADD  CONSTRAINT [FKqfqbyy0byg8dkwevcw75hcypr] FOREIGN KEY([id_restaurant])
REFERENCES [dbo].[restaurants] ([id])
GO
ALTER TABLE [dbo].[horaires_restaurants] CHECK CONSTRAINT [FKqfqbyy0byg8dkwevcw75hcypr]
GO
ALTER TABLE [dbo].[messages]  WITH CHECK ADD  CONSTRAINT [FK6h8fh0iarfk8rgn2rupovex85] FOREIGN KEY([id_restaurant])
REFERENCES [dbo].[restaurants] ([id])
GO
ALTER TABLE [dbo].[messages] CHECK CONSTRAINT [FK6h8fh0iarfk8rgn2rupovex85]
GO
ALTER TABLE [dbo].[messages]  WITH CHECK ADD  CONSTRAINT [FKjua4nts9ny5wfy6b6bg8pv1dl] FOREIGN KEY([id_utilisateur])
REFERENCES [dbo].[utilisateurs] ([id])
GO
ALTER TABLE [dbo].[messages] CHECK CONSTRAINT [FKjua4nts9ny5wfy6b6bg8pv1dl]
GO
ALTER TABLE [dbo].[produits]  WITH CHECK ADD  CONSTRAINT [FKoxko2iw93mgoixwrkniqq11k6] FOREIGN KEY([id_categorie])
REFERENCES [dbo].[categories] ([id])
GO
ALTER TABLE [dbo].[produits] CHECK CONSTRAINT [FKoxko2iw93mgoixwrkniqq11k6]
GO
ALTER TABLE [dbo].[produits_cartes]  WITH CHECK ADD  CONSTRAINT [FKkjeykeglgdl6cmnsa4glivk70] FOREIGN KEY([id_carte])
REFERENCES [dbo].[cartes] ([id])
GO
ALTER TABLE [dbo].[produits_cartes] CHECK CONSTRAINT [FKkjeykeglgdl6cmnsa4glivk70]
GO
ALTER TABLE [dbo].[produits_cartes]  WITH CHECK ADD  CONSTRAINT [FKp7qwgxg210070l06eihfwg3ji] FOREIGN KEY([id_produit])
REFERENCES [dbo].[produits] ([id])
GO
ALTER TABLE [dbo].[produits_cartes] CHECK CONSTRAINT [FKp7qwgxg210070l06eihfwg3ji]
GO
ALTER TABLE [dbo].[reservations]  WITH CHECK ADD  CONSTRAINT [FKb1gh00q44dhw24wajyfrwmlnt] FOREIGN KEY([id_utilisateur])
REFERENCES [dbo].[utilisateurs] ([id])
GO
ALTER TABLE [dbo].[reservations] CHECK CONSTRAINT [FKb1gh00q44dhw24wajyfrwmlnt]
GO
ALTER TABLE [dbo].[reservations]  WITH CHECK ADD  CONSTRAINT [FKg71q6151pwkabpm2s0cl1n07o] FOREIGN KEY([id_table])
REFERENCES [dbo].[tableres] ([id])
GO
ALTER TABLE [dbo].[reservations] CHECK CONSTRAINT [FKg71q6151pwkabpm2s0cl1n07o]
GO
ALTER TABLE [dbo].[reservations]  WITH CHECK ADD  CONSTRAINT [FKl9l6hgfk3sa87r0w4abh9dns8] FOREIGN KEY([id_restaurant])
REFERENCES [dbo].[restaurants] ([id])
GO
ALTER TABLE [dbo].[reservations] CHECK CONSTRAINT [FKl9l6hgfk3sa87r0w4abh9dns8]
GO
ALTER TABLE [dbo].[restaurants]  WITH CHECK ADD  CONSTRAINT [FKk9qa5r3rt2kswq2ywb5jerbkj] FOREIGN KEY([id_carte])
REFERENCES [dbo].[cartes] ([id])
GO
ALTER TABLE [dbo].[restaurants] CHECK CONSTRAINT [FKk9qa5r3rt2kswq2ywb5jerbkj]
GO
ALTER TABLE [dbo].[tableres]  WITH CHECK ADD  CONSTRAINT [FKfqh1o7nt6q5fw80u90hvd2okh] FOREIGN KEY([id_restaurant])
REFERENCES [dbo].[restaurants] ([id])
GO
ALTER TABLE [dbo].[tableres] CHECK CONSTRAINT [FKfqh1o7nt6q5fw80u90hvd2okh]
GO
USE [master]
GO
ALTER DATABASE [GESTION_RESTAURANT_SPRING] SET  READ_WRITE 
GO
