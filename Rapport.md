##Rapport YatzyGame

Dans ce rapport, je vais présenter les modifications apportées au code original développer par Émily Bache.

Dans un premier temps, j'ai renommé les tests pour qu'ils soient en adéquats avec les méthodes.

L'utilisation des __assertEquals__ au lieu des __assertTrue__ pour rendre le code plus homogène.

Ensuite, j'ai rajouté les tests qui ont été présenter dans la description du jeu qui est disponible via ce [lien](https://sammancoaching.org/kata_descriptions/yatzy.html).

La partie la plus importante réside dans le code qui se trouve dans la classe __YatzyPatrition__.

En effet, au tout début, j'ai essayé d'améliorer le code en supprimant les variables inutilisables et en reformulant le code d'une manière élégante.

De ce fait, j'ai essayé de rendre les choses plus simples, compréhensives. En comprenant, les règles du jeu, j'ai adapté le code à ma propre conception.

Je me suis rendu compte qu'il y avait des bouts de code répétitif alors j'ai décidé de modéliser tout ça en créant une nouvelle classe  __Dice__.

En utilisant les principes de Java, j'ai implémenté cette dernière classe via une interface.

Sachant que d'un côté, j'ai utilisé les __Stream__ pour faciliter la compréhension du code.

Vu que j'avais déjà programmé en fonctionnel __OCAML__, __HASKELL__ cela m'a semblé assez logique de les utiliser.

D'un autre côté, j'ai rajouté une énumération afin de lier les catégories aux méthodes.

Enfin, j'ai utilisé SonarLint pour nettoyer le code.