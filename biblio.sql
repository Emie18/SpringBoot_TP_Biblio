-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 03 juin 2024 à 11:53
-- Version du serveur : 8.2.0
-- Version de PHP : 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `biblio`
--

-- --------------------------------------------------------

--
-- Structure de la table `emprunteurs`
--

DROP TABLE IF EXISTS `emprunteurs`;
CREATE TABLE IF NOT EXISTS `emprunteurs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `numero` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `emprunteurs`
--

INSERT INTO `emprunteurs` (`id`, `nom`, `numero`) VALUES
(1, 'Erich Gamma', 'GOF400'),
(2, 'Richard Helm', 'GOF4012'),
(3, 'Sven', '27042002');

-- --------------------------------------------------------

--
-- Structure de la table `livres`
--

DROP TABLE IF EXISTS `livres`;
CREATE TABLE IF NOT EXISTS `livres` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titre` varchar(100) NOT NULL,
  `auteur` varchar(100) NOT NULL,
  `edition` varchar(100) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `livres`
--

INSERT INTO `livres` (`id`, `titre`, `auteur`, `edition`, `description`) VALUES
(1, 'Le Maître du Haut Château', 'Philip K. Dick', '	G. P. Putnam\'s Sons', '\"Le Maître du Haut Château\" de Philip K. Dick est une œuvre de science-fiction alternative, où l\'histoire se déroule dans une réalité où les forces de l\'Axe ont gagné la Seconde Guerre mondiale. Les États-Unis sont partagés entre le contrôle japonais et nazi, créant un monde de tensions politiques, de résistance clandestine, et d\'interrogations existentielles. Au cœur de cette société, des personnages divers naviguent entre réalité et illusion, chacun cherchant sa propre vérité, guidés par un mystérieux livre intitulé \"La Sauterelle ne se Repose Jamais\", qui décrit un monde où les Alliés ont gagné.'),
(2, 'Les androïdes rêvent-ils de moutons électriques ?', 'Philip K. Dickmissipi', 'Doubleday', '\"Les Androïdes Rêvent-ils de Moutons Électriques?\" de Philip K. Dick est une œuvre visionnaire de science-fiction. Dans un futur post-apocalyptique, Rick Deckard, un chasseur de primes, traque des androïdes presque indiscernables des humains. Sur fond de crise écologique où posséder un animal est un symbole de statut, Deckard se débat avec des questions morales et existentielles, notamment la nature de l\'humanité et la conscience. Le roman interroge la frontière entre l\'homme et la machine dans un monde dystopique où la réalité est souvent floue.'),
(3, 'Emilie', 'Papa', 'Maman', '1+1 = 3');

-- --------------------------------------------------------

--
-- Structure de la table `livres_emprunteurs`
--

DROP TABLE IF EXISTS `livres_emprunteurs`;
CREATE TABLE IF NOT EXISTS `livres_emprunteurs` (
  `livre` int NOT NULL,
  `emprunteur` int NOT NULL,
  `debut` datetime NOT NULL,
  KEY `livre` (`livre`),
  KEY `emprunteur` (`emprunteur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `livres_emprunteurs`
--

INSERT INTO `livres_emprunteurs` (`livre`, `emprunteur`, `debut`) VALUES
(1, 1, '2024-01-19 15:30:00'),
(1, 2, '2023-10-19 15:30:00'),
(2, 2, '2024-01-19 15:30:00');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `livres_emprunteurs`
--
ALTER TABLE `livres_emprunteurs`
  ADD CONSTRAINT `livres_emprunteurs_ibfk_1` FOREIGN KEY (`livre`) REFERENCES `livres` (`id`),
  ADD CONSTRAINT `livres_emprunteurs_ibfk_2` FOREIGN KEY (`emprunteur`) REFERENCES `emprunteurs` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
