<div align="center">
<img width="400"
src=".github/truffleshuffle_logo_with_name.svg">
</div>

<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->

[![All Contributors](https://img.shields.io/badge/all_contributors-11-orange.svg?style=flat-square)](#contributors-)

<!-- ALL-CONTRIBUTORS-BADGE:END -->

Truffle Shuffle 是一个带有有趣动画的 Android UI 组件卡库库。图库易于定制，并基于数组中的对象数量和这些对象内部的内容进行数据驱动。卡片库使用具有自定义视图属性的定制 Android ViewGroup 来指定各个卡片的大小，作为 ViewGroup 大小的百分比。该卡片库用于产品系列中的 TurboTax 移动应用程序。 Truffle Shuffle 100% 用 Kotlin 编写！

<p align="center">
    <img src=".github/TurboTaxCards.gif" width="300" alt="TurboTax cards"/>
    <img src=".github/textcontentvideo.gif" width="300" alt="Text content video"/>
    <img src=".github/textcontentvideowithmargins.gif" width="300" alt="Text content with margins video"/>
    <img src=".github/textcontentvideo3cards.gif" width="300" alt="Text content with 3 cards video"/>
    <img src=".github/textcardswithtitle.gif" width="300" alt="Text content with titles video"/>
    
</p>
</div>

# 快速开始

要运行示例项目，请克隆 repo 并通过以下方式运行 Android 应用程序[安卓工作室](https://developer.android.com/studio/)在模拟器上。
你可以玩这个例子

-   更改 app/src/main/res/layout/card_layout.xml 中卡片的布局
-   在 app/src/main/kotlin/com/intuit/truffle/shuffle/MainActivity.kt 中的 getCardDetails() 中更改数组中的卡片数量
-   在 app/src/main/res/values/card_view_group_percentages.xml 中更改视图组的百分比

要为此项目做出贡献，请确保提交的代码符合该项目的格式标准。

要重新格式化或检查提交的代码是否合规，请遵循以下选项之一：

#### 使用 Gradle 任务（推荐 -[ktlint 文档](https://ktlint.github.io/)):

-   `./gradlew ktlint`
     <p> Use this command to check the formatting rules are covered </p>
-   `/gradlew ktlintFormat`
     <p> Use this command to re-format code that is not compliant with this project's formatting rules. </p> 

#### 使用 ktlint 引擎（[ktlint 文档](https://ktlint.github.io/)):

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
     

# 使用松露洗牌

要将其添加到您自己的 Android 应用程序中，请完成以下步骤：

1.  将依赖项添加到您项目的 build.gradle 文件中的依赖项下：


    dependencies {
        implementation 'com.intuit.truffleshuffle:truffleshuffle:1.0.0'
    }

并确保将 jcenter() 添加到您的应用 build.gradle

    repositories {
        jcenter()
    }

2.  将 com.intuit.truffleshuffle.CardViewGroup 添加到您想要卡片库的 xml 文件中，例如 app/src/main/res/layout/activity_main.xml
    -   将你想要的百分比添加到 xml 文件中 CardViewGroup 的自定义属性中
        -   自定义：dashboardCardHeightPercentage，自定义：widthPercentage，自定义：topSpacingPercentage，自定义：bottomSpacingPercentage
3.  Add an xml layout (card_layout.xml) for the contents of your cards similar to app/src/main/res/layout/card_layout.xml
4.  创建一个包含 2 个文件的文件夹 cardGallery：
    -   CardContent 类似于 app/src/main/kotlin/com/intuit/truffle/shuffle/cardGallery/CardContent.kt
        -   这是卡片内容的数据对象
    -   自定义适配器类似于 app/src/main/kotlin/com/intuit/truffle/shuffle/cardGallery/CustomizeAdapter.kt
        -   构造函数应该采用一个 ArrayList<CardContent>并且应该扩展 CardContentAdapter<CardContent>
        -   覆盖 getViewContent() 函数以将 cardContent 中的数据内容设置为 card_layout.xml 中的视图，即。在 textView 中设置文本
5.  在您将使用此 UI 组件的 Activity 中：
    -   实例化您刚刚定义的 CustomizeAdapter 并传入 CardContents 的 arrayList 和卡片内部的资源 ID，即。 R.layout.card_layout
    -   使用 findViewById() 在您刚刚使用 CardViewGroup 创建的 CustomizeAdapter 上调用 setupAdapter()
6.  现在 TruffleShuffle UI 组件可以使用了！

# 沟通与贡献

-   如果你**需要帮忙**，打开一个问题并标记为`help wanted`.
-   如果你**发现了一个错误**，打开一个问题并标记为`bug`.
-   如果你**有一个功能请求**，打开一个问题并标记为`feature`.
-   如果你**想贡献**，请参阅贡献文档并提交拉取请求。
    -   为了提交拉取请求，请 fork 这个 repo 并从你的 fork repo 提交 PR。
    -   详细说明您的 PR 修复/增强/添加的内容。
    -   在我们合并之前，每个 PR 都必须获得批准。

## 贡献者✨

感谢这些优秀的人（[表情符号键](https://allcontributors.org/docs/en/emoji-key)):

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
  </tr>
</table>

<!-- markdownlint-restore -->

<!-- prettier-ignore-end -->

<!-- ALL-CONTRIBUTORS-LIST:END -->

该项目遵循[所有贡献者](https://github.com/all-contributors/all-contributors)规格。欢迎任何形式的贡献！
