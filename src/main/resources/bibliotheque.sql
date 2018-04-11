-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 11 avr. 2018 à 12:25
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bibliotheque`
--

-- --------------------------------------------------------

--
-- Structure de la table `emprunt`
--

DROP TABLE IF EXISTS `emprunt`;
CREATE TABLE IF NOT EXISTS `emprunt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `livre_id` int(11) NOT NULL,
  `usager` varchar(100) NOT NULL,
  `date_emprunt` date NOT NULL,
  `date_retour` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `livre_id` (`livre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `emprunt`
--

INSERT INTO `emprunt` (`id`, `livre_id`, `usager`, `date_emprunt`, `date_retour`) VALUES
(1, 10, 'Aymeric', '2018-04-08', NULL),
(2, 4, 'Imène', '2018-04-09', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

DROP TABLE IF EXISTS `livre`;
CREATE TABLE IF NOT EXISTS `livre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(100) NOT NULL,
  `annee` int(4) NOT NULL,
  `auteur` varchar(100) NOT NULL,
  `editeur` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`id`, `titre`, `annee`, `auteur`, `editeur`) VALUES
(1, 'Le Vieil Homme et la Mer', 1952, 'Ernest Hemingway', 'Charles Scribner\'s Sons'),
(2, 'Gargantua', 1532, 'François Rabelais', 'Inconnu'),
(3, 'Pantagruel', 1534, 'François Rabelais', 'Inconnu'),
(4, 'Moby Dick', 1851, 'Herman Melville', 'Richard Bentley'),
(5, 'Dragon Ball vol.1', 1984, 'Akira Toriyama', 'Glénat'),
(6, 'Rendez-vous avec Rama', 1973, 'Arthur C. Clarke', 'Gollancz'),
(7, 'Illiade', -850, 'Homère', 'Inconnu'),
(8, 'Odyssée', -850, 'Homère', 'Inconnu'),
(9, 'Fleur de nave vinaigrette', 1962, 'Frédéric Dard', 'Fleuve Noir'),
(10, 'Les clefs du pouvoir sont dans la boîte à gants', 1981, 'Frédéric Dard', 'Fleuve Noir');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD CONSTRAINT `emprunt_ibfk_1` FOREIGN KEY (`livre_id`) REFERENCES `livre` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
