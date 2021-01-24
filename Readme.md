# TP application gestion d'équipes pour l'Université Sorbonne Paris Nord

## Tags des Technologies :

+ __Spring__
+ __Spring Boot__
+ __Spring data JPA__
+ __Spring MVC__
+ __Hibernate__
+ __TomCat__
+ __REST, endPoints, RxJS__
+ __ANgular, Material, NodeJS, NPM, Anhular CLI__

L'objectif de ce TP est de développer une application en `fullstack` qui permet de gérer des équipes de Football.  

Une partie __backend/api__ en __Spring boot__ permettra de gérer les équipes avec une base de données `in memory` `H2` et d'exposer des `endPoints` en REST.  
`Spring data JPA` et `Hibernate` seront utilisés pour la partie accès aux données.    

Une partie __frontend__ permettra de gérer les équipes via le framework __Angular 14__.
__NodeJs__, __TypeScript__, __RxJs__, __Material__... seront utilisés avec Angular

L'application va permettre :
 + D'afficher une liste d'équipes
 + D'afficher le détail d'une équipe
 + D'ajouter une nouvelle équipe en base de données via un formulaire Web
 + De supprimer une équipe existante
 + Et en dernière partie d'afficher et ajouter une liste de joueurs pour une équipe.   

Même si nous apprécions particulièrement les architectures `hexagonal` et le `DDD :  Domain Driven Design`, le choix pour ce TP a été de ne pas aborder ces concepts et s'est porté sur une architecture en couche classique avec une séparation __controller__, __service__ et __repository__.
