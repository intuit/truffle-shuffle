<div align="center">
<img width="400"
src=".github/truffleshuffle_logo_with_name.svg">
</div>

<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->

[![All Contributors](https://img.shields.io/badge/all_contributors-15-orange.svg?style=flat-square)](#contributors-)

<!-- ALL-CONTRIBUTORS-BADGE:END -->

ट्रफल शफल एक मजेदार एनीमेशन के साथ एक एंड्रॉइड यूआई घटक कार्ड गैलरी लाइब्रेरी है। गैलरी आसानी से अनुकूलन योग्य है और एक सरणी में वस्तुओं की संख्या और उन वस्तुओं के अंदर की सामग्री के आधार पर डेटा संचालित होती है। व्यूग्रुप के आकार के प्रतिशत के रूप में अलग-अलग कार्ड के आकार को निर्दिष्ट करने के लिए कार्ड गैलरी कस्टम दृश्य विशेषताओं के साथ कस्टम-निर्मित एंड्रॉइड व्यूग्रुप का उपयोग करती है। इस कार्ड गैलरी का उपयोग उत्पाद लाइनअप में TurboTax के मोबाइल ऐप पर किया जाता है। Truffle Shuffle को कोटलिन में 100% लिखा गया है!

<p align="center">
    <img src=".github/TurboTaxCards.gif" width="300" alt="TurboTax cards"/>
    <img src=".github/textcontentvideo.gif" width="300" alt="Text content video"/>
    <img src=".github/textcontentvideowithmargins.gif" width="300" alt="Text content with margins video"/>
    <img src=".github/textcontentvideo3cards.gif" width="300" alt="Text content with 3 cards video"/>
    <img src=".github/textcardswithtitle.gif" width="300" alt="Text content with titles video"/>
    
</p>
</div>

# जल्दी शुरू

उदाहरण परियोजना को चलाने के लिए, रेपो को क्लोन करें और Android एप्लिकेशन को चलाएं[एंड्रॉइड स्टूडियो](https://developer.android.com/studio/)एक एमुलेटर पर।
आप द्वारा उदाहरण के साथ खेल सकते हैं

-   ऐप/src/main/res/layout/card_layout.xml में कार्ड के अंदर लेआउट बदलना
-   ऐप/src/main/kotlin/com/intuit/truffle/shuffle/MainActivity.kt में getCardDetails() में सरणी में कार्ड की संख्या बदलना
-   ऐप/src/main/res/values/card_view_group_percentages.xml में व्यू ग्रुप का प्रतिशत बदलना

इस परियोजना में योगदान करने के लिए, सुनिश्चित करें कि प्रतिबद्ध कोड इस परियोजना के प्रारूपण मानकों से मेल खाता है।

प्रतिबद्ध कोड को दोबारा प्रारूपित करने या जांचने के लिए, निम्न विकल्पों में से एक का पालन करें:

#### ग्रेडल कार्यों का उपयोग करें (अनुशंसित -[केटीलिंट डॉक्स](https://ktlint.github.io/)):

-   `./gradlew ktlint`
     <p> Use this command to check the formatting rules are covered </p>
-   `/gradlew ktlintFormat`
     <p> Use this command to re-format code that is not compliant with this project's formatting rules. </p> 

#### ktlint इंजन का प्रयोग करें ([केटीलिंट डॉक्स](https://ktlint.github.io/)):

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
     

# ट्रफल शफल का उपयोग करना

इसे अपने Android एप्लिकेशन में जोड़ने के लिए, निम्न चरणों को पूरा करें:

1.  निर्भरता के तहत अपने प्रोजेक्ट की build.gradle फ़ाइल में निर्भरता जोड़ें:


    dependencies {
        implementation 'com.intuit.truffleshuffle:truffleshuffle:1.0.0'
    }

और सुनिश्चित करें कि आपके ऐप बिल्ड.ग्रेडल में jcenter() जोड़ा गया है

    repositories {
        jcenter()
    }

2.  com.intuit.truffleshuffle.CardViewGroup को उस xml फ़ाइल में जोड़ें जहाँ आप कार्ड गैलरी चाहते हैं, जैसे app/src/main/res/layout/activity_main.xml
    -   xml फ़ाइल में CardViewGroup की कस्टम विशेषताओं में इच्छित प्रतिशत जोड़ें
        -   कस्टम:डैशबोर्डकार्डहाइटप्रतिशत, कस्टम:चौड़ाईप्रतिशत, कस्टम:टॉपस्पेसिंगप्रतिशत, कस्टम:बॉटमस्पेसिंगप्रतिशत
3.  ऐप/src/main/res/layout/card_layout.xml के समान अपने कार्ड की सामग्री के लिए एक xml लेआउट (card_layout.xml) जोड़ें
4.  2 फाइलों के साथ एक फोल्डर कार्डगैलरी बनाएं:
    -   ऐप/src/main/kotlin/com/intuit/truffle/shuffle/cardGallery/CardContent.kt के समान कार्ड सामग्री
        -   कार्ड की सामग्री के लिए यह आपका डेटा ऑब्जेक्ट है
    -   ऐप/src/main/kotlin/com/intuit/truffle/shuffle/cardGallery/CustomizeAdapter.kt के समान अनुकूलक अनुकूलित करें
        -   कंस्ट्रक्टर को एक ArrayList लेना चाहिए<CardContent>और CardContentAdapter का विस्तार करना चाहिए<CardContent>
        -   cardContent में डेटा सामग्री को अपने card_layout.xml में दृश्यों पर सेट करने के लिए getViewContent() फ़ंक्शन को ओवरराइड करें, यानी। टेक्स्ट को टेक्स्ट व्यू में सेट करना
5.  उस गतिविधि में जहाँ आप इस UI घटक का उपयोग करेंगे:
    -   एक CustomizeAdapter को इंस्टेंट करें जिसे आपने अभी-अभी परिभाषित किया है और CardContents की एक ArrayList और कार्ड के अंदर की संसाधन आईडी में पास करें। आर.लेआउट.कार्ड\_लेआउट
    -   FindViewById () का उपयोग करके अभी-अभी CardViewGroup के साथ बनाए गए CustomizeAdapter पर setupAdapter () को कॉल करें।
6.  अब TruffleShuffle UI घटक उपयोग के लिए तैयार है!

# संचार और योगदान

-   अगर तुम**मदद की ज़रूरत है**, कोई समस्या खोलें और इस रूप में टैग करें`help wanted`.
-   अगर तुम**एक बग मिला**, कोई समस्या खोलें और इस रूप में टैग करें`bug`.
-   अगर तुम**एक सुविधा अनुरोध है**, कोई समस्या खोलें और इस रूप में टैग करें`feature`.
-   अगर तुम**योगदान देना चाहते हैं**, कृपया योगदान दस्तावेज़ देखें और एक पुल अनुरोध सबमिट करें।
    -   एक पुल अनुरोध जमा करने के लिए, कृपया इस रेपो को फोर्क करें और अपने फोर्क्ड रेपो से एक पीआर जमा करें।
    -   आपका पीआर क्या ठीक करता/बढ़ाता/जोड़ता है, इसके बारे में एक विस्तृत संदेश दें।
    -   विलय करने से पहले प्रत्येक पीआर को मंजूरी लेनी होगी।

## योगदानकर्ता ✨

धन्यवाद इन अद्भुत लोगों को जाता है ([इमोजी कुंजी](https://allcontributors.org/docs/en/emoji-key)):

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

यह परियोजना निम्नलिखित है[सभी योगदानकर्ता](https://github.com/all-contributors/all-contributors)विशिष्टता। किसी भी तरह के योगदान का स्वागत है!
