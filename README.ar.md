<div align="center">
<img width="400"
src=".github/truffleshuffle_logo_with_name.svg">
</div>

<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->

[![All Contributors](https://img.shields.io/badge/all_contributors-15-orange.svg?style=flat-square)](#contributors-)

<!-- ALL-CONTRIBUTORS-BADGE:END -->

Truffle Shuffle عبارة عن مكتبة لمعرض بطاقة مكون Android UI مع رسوم متحركة ممتعة. يمكن تخصيص المعرض بسهولة وهو يعتمد على البيانات بناءً على عدد العناصر في المصفوفة والمحتوى الموجود داخل تلك الكائنات. يستخدم معرض البطاقات نظام Android ViewGroup المخصص مع سمات عرض مخصصة لتحديد حجم البطاقات الفردية كنسبة مئوية من حجم ViewGroup. يُستخدم معرض البطاقات هذا في تطبيق TurboTax للجوّال في تشكيلة المنتجات. Truffle Shuffle مكتوب بنسبة 100٪ بلغة Kotlin!

<p align="center">
    <img src=".github/TurboTaxCards.gif" width="300" alt="TurboTax cards"/>
    <img src=".github/textcontentvideo.gif" width="300" alt="Text content video"/>
    <img src=".github/textcontentvideowithmargins.gif" width="300" alt="Text content with margins video"/>
    <img src=".github/textcontentvideo3cards.gif" width="300" alt="Text content with 3 cards video"/>
    <img src=".github/textcardswithtitle.gif" width="300" alt="Text content with titles video"/>
    
</p>
</div>

# بداية سريعة

لتشغيل مشروع المثال ، قم باستنساخ الريبو وتشغيل تطبيق Android من خلاله[بيئة تطوير أندرويد](https://developer.android.com/studio/)على المحاكي.
يمكنك اللعب مع المثال من خلال

-   تغيير التخطيط داخل البطاقات في app / src / main / res / layout / card_layout.xml
-   تغيير عدد البطاقات في المصفوفة في getCardDetails () في app / src / main / kotlin / com / intuit / truffle / shuffle / MainActivity.kt
-   تغيير النسب المئوية لمجموعة العرض في app / src / main / res / القيم / card_view_group_percentages.xml

للمساهمة في هذا المشروع ، تأكد من أن الكود الملتزم به يطابق معايير تنسيق هذا المشروع.

لإعادة التنسيق أو التحقق من توافق التعليمات البرمجية الملتزمة ، اتبع أحد الخيارات التالية:

#### استخدم مهام Gradle (موصى به -[مستندات ktlint](https://ktlint.github.io/)):

-   `./gradlew ktlint`
     <p> Use this command to check the formatting rules are covered </p>
-   `/gradlew ktlintFormat`
     <p> Use this command to re-format code that is not compliant with this project's formatting rules. </p> 

#### استخدم محرك ktlint ([مستندات ktlint](https://ktlint.github.io/)):

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
     

# باستخدام Truffle Shuffle

لإضافة هذا إلى تطبيق Android الخاص بك ، أكمل الخطوات التالية:

1.  أضف التبعية إلى ملف build.gradle الخاص بمشروعك ضمن التبعيات:


    dependencies {
        implementation 'com.intuit.truffleshuffle:truffleshuffle:1.0.0'
    }

وتأكد من إضافة jcenter () إلى تطبيق build.gradle

    repositories {
        jcenter()
    }

2.  أضف com.intuit.truffleshuffle.CardViewGroup إلى ملف xml حيث تريد معرض البطاقات ، مثل app / src / main / res / layout / activity_main.xml
    -   أضف النسب المئوية التي تريدها إلى السمات المخصصة لـ CardViewGroup في ملف xml
        -   custom: dashboardCardHeightPercentage ، مخصص: widthPercentage ، مخصص: topSpacingPercentage ، custom: bottomSpacingPercentage
3.  أضف تنسيق xml (card_layout.xml) لمحتويات بطاقاتك المشابهة لـ app / src / main / res / layout / card_layout.xml
4.  قم بإنشاء بطاقة مجلد معرض مع ملفين:
    -   CardContent similar to app/src/main/kotlin/com/intuit/truffle/shuffle/cardGallery/CardContent.kt
        -   هذا هو كائن البيانات الخاص بك لمحتويات البطاقة
    -   CustomizeAdapter مشابه لـ app / src / main / kotlin / com / intuit / truffle / shuffle / cardGallery / CustomizeAdapter.kt
        -   يجب أن يأخذ المنشئ ArrayList<CardContent>ويجب أن يوسع CardContentAdapter<CardContent>
        -   تجاوز وظيفة getViewContent () لتعيين محتوى البيانات في CardContent إلى طرق العرض في card_layout.xml ، على سبيل المثال. ضبط النص في عرض النص
5.  في النشاط حيث ستستخدم مكون واجهة المستخدم هذا:
    -   قم بإنشاء CustomizeAdapter الذي حددته للتو وقم بتمرير قائمة صفيف لمحتويات البطاقة ومعرف المورد داخل البطاقة أي. R.layout.card_layout
    -   استدعاء setupAdapter () على CustomizeAdapter الذي أنشأته للتو باستخدام CardViewGroup باستخدام findViewById ()
6.  الآن عنصر TruffleShuffle UI جاهز للاستخدام!

# التواصل والمساهمة

-   اذا أنت**تحتاج مساعدة**، افتح مشكلة وضع علامة باسم`help wanted`.
-   اذا أنت**وجدت خطأ**، افتح مشكلة وضع علامة باسم`bug`.
-   اذا أنت**طلب ميزة**، افتح مشكلة وضع علامة باسم`feature`.
-   اذا أنت**تريد المساهمة**، يرجى الرجوع إلى وثائق المساهمة وإرسال طلب سحب.
    -   من أجل تقديم طلب سحب ، يرجى تفرع هذا الريبو وإرسال بيان عام من الريبو المتشعب الخاص بك.
    -   احصل على رسالة مفصلة حول ما يصلح / يعزز / يضيف علاقاتك العامة.
    -   يجب أن تحصل كل علاقات عامة على موافقة قبل أن ندمج.

## المساهمون ✨

الشكر يذهب إلى هؤلاء الأشخاص الرائعين ([مفتاح الرموز التعبيرية](https://allcontributors.org/docs/en/emoji-key)):

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

هذا المشروع يتبع[كل المساهمين](https://github.com/all-contributors/all-contributors)تخصيص. مساهمات من أي نوع مرحب بها!
