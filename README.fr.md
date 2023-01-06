<div align="center">
<img width="400"
src=".github/truffleshuffle_logo_with_name.svg">
</div>

<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->

[![All Contributors](https://img.shields.io/badge/all_contributors-15-orange.svg?style=flat-square)](#contributors-)

<!-- ALL-CONTRIBUTORS-BADGE:END -->

Truffle Shuffle est une bibliothèque de galeries de cartes de composants d'interface utilisateur Android avec une animation amusante. La galerie est facilement personnalisable et est pilotée par les données en fonction du nombre d'objets dans un tableau et du contenu à l'intérieur de ces objets. La galerie de cartes utilise un ViewGroup Android personnalisé avec des attributs de vue personnalisés pour spécifier la taille des cartes individuelles en pourcentage de la taille du ViewGroup. Cette galerie de cartes est utilisée sur l'application mobile d'ImpôtRapide dans la gamme de produits. Truffle Shuffle est écrit à 100% en Kotlin !

<p align="center">
    <img src=".github/TurboTaxCards.gif" width="300" alt="TurboTax cards"/>
    <img src=".github/textcontentvideo.gif" width="300" alt="Text content video"/>
    <img src=".github/textcontentvideowithmargins.gif" width="300" alt="Text content with margins video"/>
    <img src=".github/textcontentvideo3cards.gif" width="300" alt="Text content with 3 cards video"/>
    <img src=".github/textcardswithtitle.gif" width="300" alt="Text content with titles video"/>
    
</p>
</div>

# Démarrage rapide

Pour exécuter l'exemple de projet, clonez le référentiel et exécutez l'application Android via[Studio Android](https://developer.android.com/studio/)sur un émulateur.
Vous pouvez jouer avec l'exemple en

-   Modification de la disposition à l'intérieur des cartes dans app/src/main/res/layout/card_layout.xml
-   Modification du nombre de cartes dans le tableau dans getCardDetails() dans app/src/main/kotlin/com/intuit/truffle/shuffle/MainActivity.kt
-   Modification des pourcentages du groupe de vues dans app/src/main/res/values/card_view_group_percentages.xml

Pour contribuer à ce projet, assurez-vous que le code validé correspond aux normes de formatage de ce projet.

Pour reformater ou vérifier que le code validé est conforme, suivez l'une des options suivantes :

#### Utiliser les tâches Gradle (recommandé -[docs ktlint](https://ktlint.github.io/)):

-   `./gradlew ktlint`
     <p> Use this command to check the formatting rules are covered </p>
-   `/gradlew ktlintFormat`
     <p> Use this command to re-format code that is not compliant with this project's formatting rules. </p> 

#### Utiliser le moteur ktlint ([docs ktlint](https://ktlint.github.io/)):

-   `ktlint`
     <p> Use this command to check the formatting rules are covered </p>
-   `ktlint "src/**/*.kt" "!src/**/*Test.kt"`
     <p> Check only certain locations (prepend ! to negate the pattern) </p>     
-   `ktlint -F`
     <p> Use this command to re-format code that is not compliant with this project's formatting rules.
     (if some errors cannot be fixed automatically they will be printed to stderr) </p> 
-   `ktlint -F "src/**/*.kt"`
     <p> Use this command to re-format certain locations (prepend ! to negate the pattern)  . 
     (if some errors cannot be fixed automatically they will be printed to stderr) </p>    
-   `ktlint --install-git-pre-commit-hook`
     <p> Install git hook to automatically check files for style violations on commit. </p>       
     

# Utilisation de Truffle Shuffle

Pour l'ajouter à votre propre application Android, procédez comme suit :

1.  Ajoutez la dépendance au fichier build.gradle de votre projet sous les dépendances :


    dependencies {
        implementation 'com.intuit.truffleshuffle:truffleshuffle:1.0.0'
    }

Et assurez-vous que jcenter() est ajouté à votre application build.gradle

    repositories {
        jcenter()
    }

2.  Ajoutez le com.intuit.truffleshuffle.CardViewGroup au fichier xml où vous voulez la galerie de cartes, comme dans app/src/main/res/layout/activity_main.xml
    -   ajoutez les pourcentages que vous souhaitez aux attributs personnalisés du CardViewGroup dans le fichier xml
        -   personnalisé:tableau de bordCardHeightPercentage, personnalisé:widthPercentage, personnalisé:topSpacingPercentage, personnalisé:bottomSpacingPercentage
3.  Ajoutez une mise en page xml (card_layout.xml) pour le contenu de vos cartes similaire à app/src/main/res/layout/card_layout.xml
4.  Créez un dossier cardGallery avec 2 fichiers :
    -   CardContent similaire à app/src/main/kotlin/com/intuit/truffle/shuffle/cardGallery/CardContent.kt
        -   Ceci est votre objet de données pour le contenu de la carte
    -   CustomizeAdapter similaire à app/src/main/kotlin/com/intuit/truffle/shuffle/cardGallery/CustomizeAdapter.kt
        -   Le constructeur doit prendre une ArrayList<CardContent>et devrait étendre CardContentAdapter<CardContent>
        -   Remplacez la fonction getViewContent() pour définir le contenu des données dans cardContent sur les vues de votre card_layout.xml, c'est-à-dire. définir le texte dans un textView
5.  Dans l'activité où vous utiliserez ce composant d'interface utilisateur :
    -   Instanciez un CustomizeAdapter que vous venez de définir et transmettez un arrayList de CardContents et l'ID de ressource à l'intérieur de la carte, c'est-à-dire. R.layout.card_layout
    -   Appelez setupAdapter() sur le CustomizeAdapter que vous venez de créer avec CardViewGroup en utilisant findViewById()
6.  Le composant d'interface utilisateur TruffleShuffle est maintenant prêt à être utilisé !

# Communication et contribution

-   Si vous**Besoin d'aide**, ouvrez un problème et marquez comme`help wanted`.
-   Si vous**trouvé un bogue**, ouvrez un problème et marquez comme`bug`.
-   Si vous**avoir une demande de fonctionnalité**, ouvrez un problème et marquez comme`feature`.
-   Si vous**envie de contribuer**, veuillez vous référer à la documentation de contribution et soumettre une demande d'extraction.
    -   Afin de soumettre une pull request, veuillez bifurquer ce référentiel et soumettre un PR à partir de votre référentiel bifurqué.
    -   Ayez un message détaillé sur ce que votre PR corrige/améliore/ajoute.
    -   Chaque PR doit obtenir une approbation avant de fusionner.

## Contributeurs ✨

Merci à ces gens formidables ([clé emoji](https://allcontributors.org/docs/en/emoji-key)):

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->

<!-- prettier-ignore-start -->

<!-- markdownlint-disable -->

<table>
  <tr>
    <td align="center"><a href="http://www.katielevy.com"><img src="https://avatars0.githubusercontent.com/u/8975181?v=4?s=100" width="100px;" alt=""/><br /><sub><b>Katie Levy</b></sub></a><br /><a href="https://github.com/intuit/truffle-shuffle/commits?author=katielevy1" title="Code">💻</a></td>
    <td align="center"><a href="https://github.com/roxiomontes"><img src="https://avatars3.githubusercontent.com/u/14279937?v=4?s=100" width="100px;" alt=""/><br /><sub><b>Rocio Montes</b></sub></a><br /><a href="https://github.com/intuit/truffle-shuffle/commits?author=roxiomontes" title="Documentation">📖</a></td>
    <td align="center"><a href="https://github.com/monicamiyasato"><img src="https://avatars0.githubusercontent.com/u/56657880?v=4?s=100" width="100px;" alt=""/><br /><sub><b>monicamiyasato</b></sub></a><br /><a href="https://github.com/intuit/truffle-shuffle/commits?author=monicamiyasato" title="Documentation">📖</a></td>
    <td align="center"><a href="https://www.linkedin.com/in/napoleon-salazar-15744154/"><img src="https://avatars0.githubusercontent.com/u/16261373?v=4?s=100" width="100px;" alt=""/><br /><sub><b>cfsnsalazar</b></sub></a><br /><a href="https://github.com/intuit/truffle-shuffle/commits?author=cfsnsalazar" title="Code">💻</a></td>
    <td align="center"><a href="https://github.com/MathiasX1"><img src="https://avatars0.githubusercontent.com/u/13027082?v=4?s=100" width="100px;" alt=""/><br /><sub><b>MathiasX1</b></sub></a><br /><a href="https://github.com/intuit/truffle-shuffle/commits?author=MathiasX1" title="Code">💻</a></td>
    <td align="center"><a href="https://github.com/abaer123"><img src="https://avatars0.githubusercontent.com/u/22059145?v=4?s=100" width="100px;" alt=""/><br /><sub><b>Anthony Baer</b></sub></a><br /><a href="https://github.com/intuit/truffle-shuffle/commits?author=abaer123" title="Documentation">📖</a></td>
    <td align="center"><a href="https://github.com/adilanchian"><img src="https://avatars0.githubusercontent.com/u/13204620?v=4?s=100" width="100px;" alt=""/><br /><sub><b>Alec Dilanchian</b></sub></a><br /><a href="https://github.com/intuit/truffle-shuffle/commits?author=adilanchian" title="Code">💻</a></td>
  </tr>
  <tr>
    <td align="center"><a href="https://github.com/hwangange"><img src="https://avatars1.githubusercontent.com/u/12180288?v=4?s=100" width="100px;" alt=""/><br /><sub><b>Angela Hwang</b></sub></a><br /><a href="https://github.com/intuit/truffle-shuffle/commits?author=hwangange" title="Code">💻</a></td>
    <td align="center"><a href="https://github.com/henry398"><img src="https://avatars0.githubusercontent.com/u/28519908?v=4?s=100" width="100px;" alt=""/><br /><sub><b>henry398</b></sub></a><br /><a href="https://github.com/intuit/truffle-shuffle/commits?author=henry398" title="Code">💻</a></td>
    <td align="center"><a href="https://linktr.ee/Sanchi_Rastogi"><img src="https://avatars.githubusercontent.com/u/46872971?v=4?s=100" width="100px;" alt=""/><br /><sub><b>Sanchi Rastogi</b></sub></a><br /><a href="https://github.com/intuit/truffle-shuffle/commits?author=sanchi0204" title="Code">💻</a></td>
    <td align="center"><a href="https://github.com/adrishyantee"><img src="https://avatars.githubusercontent.com/u/73780844?v=4?s=100" width="100px;" alt=""/><br /><sub><b>Adrishyantee Maiti</b></sub></a><br /><a href="https://github.com/intuit/truffle-shuffle/commits?author=adrishyantee" title="Code">💻</a></td>
    <td align="center"><a href="https://kerinpithawala.netlify.app/"><img src="https://avatars.githubusercontent.com/u/46436993?v=4?s=100" width="100px;" alt=""/><br /><sub><b>Kerin Pithawala</b></sub></a><br /><a href="https://github.com/intuit/truffle-shuffle/commits?author=KerinPithawala" title="Documentation">📖</a></td>
    <td align="center"><a href="http://ritaokonkwo6@gmail.com"><img src="https://avatars.githubusercontent.com/u/35587632?v=4?s=100" width="100px;" alt=""/><br /><sub><b>Okonkwo Rita</b></sub></a><br /><a href="https://github.com/intuit/truffle-shuffle/commits?author=Rita-Okonkwo" title="Code">💻</a></td>
    <td align="center"><a href="https://github.com/amypritc"><img src="https://avatars.githubusercontent.com/u/20962408?v=4?s=100" width="100px;" alt=""/><br /><sub><b>Amy Rathore</b></sub></a><br /><a href="https://github.com/intuit/truffle-shuffle/commits?author=amypritc" title="Code">💻</a></td>
  </tr>
  <tr>
    <td align="center"><a href="https://github.com/Anusha05"><img src="https://avatars.githubusercontent.com/u/6751651?v=4?s=100" width="100px;" alt=""/><br /><sub><b>Anusha Bandekar</b></sub></a><br /><a href="https://github.com/intuit/truffle-shuffle/commits?author=Anusha05" title="Code">💻</a></td>
  </tr>
</table>

<!-- markdownlint-restore -->

<!-- prettier-ignore-end -->

<!-- ALL-CONTRIBUTORS-LIST:END -->

Ce projet fait suite à[tous les contributeurs](https://github.com/all-contributors/all-contributors)spécification. Les contributions de toute nature sont les bienvenues !
