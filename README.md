# SpringBoot_TP_Biblio

Ce projet est une application Java réalisée avec Spring Boot. Il m'a permis de comprendre le fonctionnement de Spring Boot, ainsi que son utilisation dans le développement d'applications web.

## Prérequis

Avant d'utiliser ce projet, assurez-vous d'avoir Java JDK 21 installé sur votre système. Vous pouvez le télécharger depuis [ici](https://www.oracle.com/java/technologies/downloads/#java21).

## Dépendances

Ce projet utilise Gradle pour la gestion des dépendances. Les principales dépendances sont :

- **JPA** : Pour la gestion de la persistance des données.
- **Spring Web** : Pour la création d'applications web avec Spring.
- **Thymeleaf** : Pour la création de pages HTML dynamiques.
- **MySQL** : Pour la gestion de la base de données.

## Utilisation

1. Clonez ce dépôt GitHub sur votre machine locale :

```bash
git clone https://github.com/Emie18/SpringBoot_TP_Biblio.git
```

2. Assurez-vous d'avoir une instance de MySQL installée sur votre système.

3. Importez le script `biblio.sql` dans votre base de données MySQL pour créer la structure de la base de données nécessaire au fonctionnement de l'application.

4. Dans le fichier `src/main/resources/application.properties`, adaptez les paramètres d'authentification de la base de données (username, mot de passe) en fonction de votre configuration.

5. lancer séparement les deux projet. il devrait se trouver sur : http://localhost:8082/ --> client et http://localhost:8080/api_livre/livres -->L'API

## Structure du Projet

- **API_livre/** : Contient l'API utilisée par le client pour interagir avec la base de données.
- **Client_biblio/** : Contient le client de l'application.
- **src/main/resources/application.properties** : Fichier de configuration contenant les paramètres de l'application, notamment ceux liés à la base de données.(API)
