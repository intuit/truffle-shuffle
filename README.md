<div align="center">
<img width="400"
src=".github/truffleshuffle_logo_with_name.svg">
</div>

<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->
[![All Contributors](https://img.shields.io/badge/all_contributors-3-orange.svg?style=flat-square)](#contributors-)
<!-- ALL-CONTRIBUTORS-BADGE:END -->

    
Truffle Shuffle is an Android UI component card gallery library with a fun animation. The gallery is easily customizable and is data driven based on the number of objects in an array and the content inside of those objects. The card gallery uses a custom-made Android ViewGroup with custom view attributes to specify the size of the individual cards as a percentage of the ViewGroup's size. This card gallery is used on TurboTax's mobile app in the product lineup. Truffle Shuffle is written 100% in Kotlin!



<p align="center">
    <img src=".github/TurboTaxCards.gif" width="300" alt="TurboTax cards"/>
    <img src=".github/textcontentvideo.gif" width="300" alt="Text content video"/>
    <img src=".github/textcontentvideowithmargins.gif" width="300" alt="Text content with margins video"/>
    <img src=".github/textcontentvideo3cards.gif" width="300" alt="Text content with 3 cards video"/>
    <img src=".github/textcardswithtitle.gif" width="300" alt="Text content with titles video"/>
    
</p>
</div>

# Quick Start

To run the example project, clone the repo and run the Android application through [Android Studio](https://developer.android.com/studio/) on an Emulator.
You can play with the example by
- Changing the layout inside of the cards in app/src/main/res/layout/card_layout.xml
- Changing the number of cards in the array in getCardDetails() in app/src/main/kotlin/com/intuit/truffle/shuffle/MainActivity.kt
- Changing the percentages of the view group in app/src/main/res/values/card_view_group_percentages.xml

To contribute to this project, make sure that the code committed matches this project's formatting standards.

To reformat or check that committed code is compliant, follow one of the following options:

#### Use Gradle tasks (recommended - [ktlint docs](https://ktlint.github.io/)):

 - `./gradlew ktlint` 
    <p> Use this command to check the formatting rules are covered </p>
 - `/gradlew ktlintFormat` 
    <p> Use this command to re-format code that is not compliant with this project's formatting rules. </p> 

#### Use ktlint engine ([ktlint docs](https://ktlint.github.io/)):

 - `ktlint`
    <p> Use this command to check the formatting rules are covered </p>
 - `ktlint "src/**/*.kt" "!src/**/*Test.kt"`
    <p> Check only certain locations (prepend ! to negate the pattern) </p>     
 - `ktlint -F`
    <p> Use this command to re-format code that is not compliant with this project's formatting rules.
    (if some errors cannot be fixed automatically they will be printed to stderr) </p> 
 - `ktlint -F "src/**/*.kt"`
    <p> Use this command to re-format certain locations (prepend ! to negate the pattern)  . 
    (if some errors cannot be fixed automatically they will be printed to stderr) </p>    
 - `ktlint --install-git-pre-commit-hook`
    <p> Install git hook to automatically check files for style violations on commit. </p>       
    
# Using Truffle Shuffle

To add this to your own Android application, complete the following steps:

1. Add the dependency to your project's build.gradle file under dependencies:
```
dependencies {
    implementation 'com.intuit.truffleshuffle:truffleshuffle:1.0.0'
}
```
And make sure jcenter() is added to your app build.gradle
```
repositories {
    jcenter()
}
```

2. Add the com.intuit.truffleshuffle.CardViewGroup to the xml file where you want the card gallery, like in app/src/main/res/layout/activity_main.xml
    - add the percentages you want to the custom attributes of the CardViewGroup in the xml file
        - custom:dashboardCardHeightPercentage, custom:widthPercentage, custom:topSpacingPercentage, custom:bottomSpacingPercentage
3. Add an xml layout (card_layout.xml) for the contents of your cards similar to app/src/main/res/layout/card_layout.xml
4. Create a folder cardGallery with 2 files:
    - CardContent similar to app/src/main/kotlin/com/intuit/truffle/shuffle/cardGallery/CardContent.kt
        - This is your data object for the card contents
    - CustomizeAdapter similar to app/src/main/kotlin/com/intuit/truffle/shuffle/cardGallery/CustomizeAdapter.kt
        - The constructor should take an ArrayList<CardContent> and should extend CardContentAdapter<CardContent>
        - Override the getViewContent() function to set the data content in the cardContent to the views in your card_layout.xml, ie. setting the text in a textView
5. In the Activity where you'll be using this UI component:
    - Instantiate a CustomizeAdapter you just defined and pass in an arrayList of CardContents and the resource id of inside the card ie. R.layout.card_layout
    - Call setupAdapter() on the CustomizeAdapter you just created with the CardViewGroup using findViewById()
6. Now the TruffleShuffle UI component is ready to use!

# Communication and Contribution

- If you **need help**, open an issue and tag as `help wanted`.
- If you **found a bug**, open an issue and tag as `bug`.
- If you **have a feature request**, open an issue and tag as `feature`.
- If you **want to contribute**, please refer to the Contributing documentation and submit a pull request.
  - In order to submit a pull request, please fork this repo and submit a PR from your forked repo.
  - Have a detailed message as to what your PR fixes/enhances/adds.
  - Each PR must get an approval before we will merge.

## Contributors ✨

Thanks goes to these wonderful people ([emoji key](https://allcontributors.org/docs/en/emoji-key)):

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tr>
    <td align="center"><a href="http://www.katielevy.com"><img src="https://avatars0.githubusercontent.com/u/8975181?v=4" width="100px;" alt=""/><br /><sub><b>Katie Levy</b></sub></a><br /><a href="https://github.com/intuit/truffle-shuffle/commits?author=katielevy1" title="Code">💻</a></td>
    <td align="center"><a href="https://github.com/roxiomontes"><img src="https://avatars3.githubusercontent.com/u/14279937?v=4" width="100px;" alt=""/><br /><sub><b>Rocio Montes</b></sub></a><br /><a href="https://github.com/intuit/truffle-shuffle/commits?author=roxiomontes" title="Documentation">📖</a></td>
    <td align="center"><a href="https://www.linkedin.com/in/napoleon-salazar-15744154/"><img src="https://avatars0.githubusercontent.com/u/16261373?v=4" width="100px;" alt=""/><br /><sub><b>cfsnsalazar</b></sub></a><br /><a href="https://github.com/intuit/truffle-shuffle/commits?author=cfsnsalazar" title="Code">💻</a></td>
    <td align="center"><a href="https://github.com/monicamiyasato"><img src="https://avatars0.githubusercontent.com/u/56657880?v=4" width="100px;" alt=""/><br /><sub><b>monicamiyasato</b></sub></a><br /><a href="https://github.com/intuit/truffle-shuffle/commits?author=monicamiyasato" title="Documentation">📖</a></td>
    <td align="center"><a href="https://github.com/MathiasX1"><img src="https://avatars0.githubusercontent.com/u/13027082?v=4" width="100px;" alt=""/><br /><sub><b>MathiasX1</b></sub></a><br /><a href="https://github.com/intuit/truffle-shuffle/commits?author=MathiasX1" title="Code">💻</a></td>
  </tr>
</table>

<!-- markdownlint-enable -->
<!-- prettier-ignore-end -->
<!-- ALL-CONTRIBUTORS-LIST:END -->

This project follows the [all-contributors](https://github.com/all-contributors/all-contributors) specification. Contributions of any kind welcome!
