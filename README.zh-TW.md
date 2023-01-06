<div align="center">
<img width="400"
src=".github/truffleshuffle_logo_with_name.svg">
</div>

<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->

[![All Contributors](https://img.shields.io/badge/all_contributors-15-orange.svg?style=flat-square)](#contributors-)

<!-- ALL-CONTRIBUTORS-BADGE:END -->

Truffle Shuffle 是一個 Android UI 組件卡庫庫，帶有有趣的動畫。圖庫很容易定制，並且是基於數組中對象的數量和這些對象內的內容的數據驅動的。卡片庫使用帶有自定義視圖屬性的定制 Android ViewGroup 來指定各個卡片的大小占 ViewGroup 大小的百分比。此卡片庫用於 TurboTax 的產品系列中的移動應用程序。 Truffle Shuffle 100% 用 Kotlin 編寫！

<p align="center">
    <img src=".github/TurboTaxCards.gif" width="300" alt="TurboTax cards"/>
    <img src=".github/textcontentvideo.gif" width="300" alt="Text content video"/>
    <img src=".github/textcontentvideowithmargins.gif" width="300" alt="Text content with margins video"/>
    <img src=".github/textcontentvideo3cards.gif" width="300" alt="Text content with 3 cards video"/>
    <img src=".github/textcardswithtitle.gif" width="300" alt="Text content with titles video"/>
    
</p>
</div>

# 快速開始

要運行示例項目，請克隆存儲庫並運行 Android 應用程序[安卓工作室](https://developer.android.com/studio/)在模擬器上。
你可以玩這個例子

-   更改 app/src/main/res/layout/card_layout.xml 中卡片的佈局
-   在 app/src/main/kotlin/com/intuit/truffle/shuffle/MainActivity.kt 的 getCardDetails() 中更改數組中的卡片數量
-   在 app/src/main/res/values/card_view_group_percentages.xml 中更改視圖組的百分比

要為該項目做出貢獻，請確保提交的代碼符合該項目的格式標準。

要重新格式化或檢查提交的代碼是否合規，請遵循以下選項之一：

#### 使用 Gradle 任務（推薦 -[ktlint 文檔](https://ktlint.github.io/)):

-   `./gradlew ktlint`
     <p> Use this command to check the formatting rules are covered </p>
-   `/gradlew ktlintFormat`
     <p> Use this command to re-format code that is not compliant with this project's formatting rules. </p> 

#### 使用 ktlint 引擎 ([ktlint 文檔](https://ktlint.github.io/)):

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
     

# 使用松露隨機播放

要將其添加到您自己的 Android 應用程序，請完成以下步驟：

1.  將依賴項添加到項目的 build.gradle 文件的 dependencies 下：


    dependencies {
        implementation 'com.intuit.truffleshuffle:truffleshuffle:1.0.0'
    }

並確保將 jcenter() 添加到您的應用程序 build.gradle

    repositories {
        jcenter()
    }

2.  將 com.intuit.truffleshuffle.CardViewGroup 添加到您想要卡片庫的 xml 文件中，例如 app/src/main/res/layout/activity_main.xml
    -   將你想要的百分比添加到 xml 文件中 CardViewGroup 的自定義屬性
        -   自定義：dashboardCardHeightPercentage，自定義：widthPercentage，自定義：topSpacingPercentage，自定義：bottomSpacingPercentage
3.  為卡片內容添加一個 xml 佈局 (card_layout.xml)，類似於 app/src/main/res/layout/card_layout.xml
4.  Create a folder cardGallery with 2 files:
    -   CardContent 類似於 app/src/main/kotlin/com/intuit/truffle/shuffle/cardGallery/CardContent.kt
        -   這是卡片內容的數據對象
    -   CustomizeAdapter 類似於 app/src/main/kotlin/com/intuit/truffle/shuffle/cardGallery/CustomizeAdapter.kt
        -   構造函數應該採用 ArrayList<CardContent>並且應該擴展 CardContentAdapter<CardContent>
        -   覆蓋 getViewContent() 函數以將 cardContent 中的數據內容設置為 card_layout.xml 中的視圖，即。在 textView 中設置文本
5.  在您將使用此 UI 組件的 Activity 中：
    -   實例化您剛剛定義的 CustomizeAdapter 並傳入 CardContents 的數組列表和卡內的資源 ID，即。 R.layout.card_layout
    -   使用 findViewById() 在您剛剛使用 CardViewGroup 創建的 CustomizeAdapter 上調用 setupAdapter()
6.  現在 TruffleShuffle UI 組件可以使用了！

# 交流與貢獻

-   如果你**需要幫忙**, 打開一個問題並標記為`help wanted`.
-   如果你**發現一個錯誤**, 打開一個問題並標記為`bug`.
-   如果你**有一個功能請求**, 打開一個問題並標記為`feature`.
-   如果你**想貢獻**，請參考貢獻文檔並提交拉取請求。
    -   為了提交拉取請求，請分叉此回購併從分叉的回購中提交 PR。
    -   詳細說明您的 PR 修復/增強/添加的內容。
    -   在我們合併之前，每個 PR 都必須獲得批准。

## 貢獻者✨

感謝這些優秀的人（[表情符號鍵](https://allcontributors.org/docs/en/emoji-key)):

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

該項目遵循[所有貢獻者](https://github.com/all-contributors/all-contributors)規格。歡迎任何形式的貢獻！
