# ProjetBoVoyage

Ce document expose les règles de codage pour le projet.

Le projet utilise les technologies suivantes:
  - SpringMVC
  - SpringIoC
  - SpringSecurity
  - Hibernate
  - JUnit
  

Tous les éléments du code (classes, attributs, méthodes, etc) doivent être commentés de telle façon à être compréhensibles par 
les autres développeurs.

Pour les class:
  - nom: le nom des classes doit être complet et respecter les règles de camelcase
  - Les noms des interfaces des classes doivent être écrits de la façon suivante: IClassService, IClassDao, etc
  - Les noms des implémentations des interfaces doivent être écrits de la façon suivante: ClassServiceImpl, ClassDaoImpl, etc
  - Les noms des controleurs doivent être écrits de la façon suivante: ClassController
  
Pour les attributs des classes:
  - doivent être écrit en minuscule et respecter les règles de camelcase
  - doivent contenir plus de 2 lettres
  - doivent être compréhensibles par une personne externe au projet
  
Pour les méthodes:
  - Les noms des méthodes des classes doivent être écrits de la façon suivante: public <?> nomModeleService(), public <?> nomModeleDao()
  - Les paramètres des méthodes sont raccourcis à un minimum de lettres (e.g. Produit p, Categorie c). Des lettres sont rajoutées 
  pour lever les ambiguités (e.g. Client cl, Conseiller con)
  
Pour les entités:
  - Toutes les entités créées dans la DB doivent être écrits en minuscules, être égal au nom de la Class, au pluriel
  
Pour la Vue:
  - Les ressources des pages JSP (css, js, templates, images) sont contenues dans le dossier webapp/resources
  - L'entrée unique de l'application est un fichier index.jsp, situé dans le dossier webapp.
  - Les pages JSP de la vue sont situées dans le dossier webapp/WEB-INF/pages
  
Toutes les méthodes de DAO doivent être testées avec JUnit.

Toutes les lignes de codes doivent être correctement indentées.

Extension d'URL dans les controlleurs : "classTypeMethode" exemple : "avionAfficheAjouter" ou "voyageSoumettreModifier"
Pour les noms d'attributs : "2premières lettre de la classe + Méthodes conjugué à l'infirmatif du plus que subjonctif" Exemple :"avAjout" pour avion ajouter
