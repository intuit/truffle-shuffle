<div align="center">
<img width="400"
src=".github/truffleshuffle_logo_with_name.svg">
</div>

<div align="center"><a href="https://travis-ci.com/intuit/truffle-shuffle"><img src="https://travis-ci.com/intuit/truffle-shuffle.svg?token=DzNXw1x7X4t62Ts76we5&branch=master" alt="TravisCI Build Status" /></a>

Truffle Shuffle es una libreria de un componente de Android UI de una galeria de tarjetas con una animacion divertida. La galeria es muy facil de personalizar y es derivada de los datos basado en la cantidad de objetos de una coleccion y el contenido dentro de dichos objectos. La galeria de tarjetas utiliza un Android ViewGroup personalizado con vistas de atributos personalizados para especificar el tamano de las tarjetas individuales como el porcentaje del tamano del ViewGroup. Esta galeria de tarjetas es usada en la aplicacion mobil de TurboTax. Truffle Shuffle esta escrita al 100% en Kotlin!



<p align="center">
    <img src=".github/TurboTaxCards.gif" width="300" alt="TurboTax cards"/>
    <img src=".github/textcontentvideo.gif" width="300" alt="Text content video"/>
    <img src=".github/textcontentvideowithmargins.gif" width="300" alt="Text content with margins video"/>
    <img src=".github/textcontentvideo3cards.gif" width="300" alt="Text content with 3 cards video"/>
    <img src=".github/textcardswithtitle.gif" width="300" alt="Text content with titles video"/>
    
</p>
</div>

# Inicio Rapido

Para ejecutar el proyecto de ejemplo, clona el repo y ejecuta la aplicacion de Android via [Android Studio](https://developer.android.com/studio/) en un Emulator.
Puedes jugar con el ejemplo de las siguientes maneras
- Cambiando el diseno dentro de las tarjetas en app/src/main/res/layout/card_layout.xml
- Cambiando el numero de tarjetas en la coleccion en getCardDetails() en app/src/main/kotlin/com/intuit/truffle/shuffle/MainActivity.kt
- Cambiando los porcentajes del group de vista o "view group" en app/src/main/res/values/card_view_group_percentages.xml

Para contribuir a este proyecto, asegurate que el codigo realizado corresponde con los estandares de formato de este proyecto.

Para reformatear o chequear que el codigo realizado es conforme, sigue uno de las siguientes opcines:

#### Use tareas de Gradle (recomendado - [ktlint docs](https://ktlint.github.io/)):

 - `./gradlew ktlint` 
    <p> Use este comando para chequear que las reglas de formato hayan sido cubiertas </p>
 - `/gradlew ktlintFormat` 
    <p> Use este comando para reformatear codigo que no cumple con las reglas de formato de este proyecto. </p> 

#### Use ktlint engine ([ktlint docs](https://ktlint.github.io/)):

 - `ktlint`
    <p> Use este comando para chequear que las reglas de formato hayan sido cubiertas </p>
 - `ktlint "src/**/*.kt" "!src/**/*Test.kt"`
    <p> Chequee solo ciertas locaciones (Prefije ! para invalidar el patron) </p>     
 - `ktlint -F`
    <p> Use este comando para reformatear codigo que no cumple con las reglas de formato de este proyecto.
    (si algunos errores no pueden ser arreglados automaticamente, seran impresos a stderr) </p> 
 - `ktlint -F "src/**/*.kt"`
    <p> Chequee solo ciertas locaciones (Prefije ! para invalidar el patron)  . 
    (si algunos errores no pueden ser arreglados automaticamente, seran impresos a stderr) </p>    
 - `ktlint --install-git-pre-commit-hook`
    <p> Instale git hook para chequear archivos y buscar violaciones de estilo en el commit. </p>       
    
# Usando Truffle Shuffle

Para agregar esto a su propia aplicacion de Android, siga los siguientes pasos:

1. Agruegue la dependencia al archivo del build.gradle de su proyecto bajo "dependencies" o dependencias:
```
dependencies {
    implementation 'com.intuit.truffleshuffle:truffleshuffle:1.0.0'
}
```
Asegurese que jcenter() sea anadido al build.gradle de su aplicacion
```
repositories {
    jcenter()
}
```

2. Agregue com.intuit.truffleshuffle.CardViewGroup al archivo xml donde quiera ubicar la galeria de tarjetas, como en app/src/main/res/layout/activity_main.xml
    - agregue los porcentajes que desee a los atributos personalizados del CardViewGroup en el archivo xml 
        - custom:dashboardCardHeightPercentage, custom:widthPercentage, custom:topSpacingPercentage, custom:bottomSpacingPercentage
3. Agregue un xml layout (card_layout.xml) para los contenidos de sus tarjetas similar a app/src/main/res/layout/card_layout.xml
4. Cree una carpeta cardGallery con 2 archivos:
    - CardContent similar a app/src/main/kotlin/com/intuit/truffle/shuffle/cardGallery/CardContent.kt
        - Este es su objeto de datos para los contenidos de las tarjetas
    - CustomizeAdapter similar a app/src/main/kotlin/com/intuit/truffle/shuffle/cardGallery/CustomizeAdapter.kt
        - El constructor deberia toma un ArrayList<CardContent> y deberia extender CardContentAdapter<CardContent>
        - Anule la funcion getViewContent() para establecer el contenido de data en el cardContent a las vistas en su card_layout.xml, ie. estableciendo el texto en un textView
5. En la Activity donde usted estara usando este compnente de UI,
    - Instancie el CustomizeAdapter que acaba de definir y pase en un arrayList de CardContents y el recurso de id de adentro de la tarjeta ie. R.layout.card_layout
    - Use el metodo setupAdapter() en el CustomizeAdapter que acaba de crear con el CardViewGroup usando findViewById()
6. Ahora el componente UI TruffleShuffle esta listo para usar!

# Comunicación y Contribución

- Si usted **necesita ayuda**, abra un "github issue"y agrege el tag `help wanted`.
- Si usted **encontro un error**, abra un "github issue"y agrege el tag `bug`.
- Si usted **tiene una solicitud de una nueva funcionalidad**, abra un "github issue" y agregue el tag  `feature`.
- Si usted **desea contribuir**, por favor referirse a la documentacion "Contributing documentation" y envie un pull request.
  - Para enviar un pull request, por favor haga "fork" a este repo y envie un PR (pull request) del repo que hizo "fork".
  - Incluya un mensaje detallado con informacion acerca de los arreglos/mejoras/cambios que proporciona su PR.
  - Cada PR debe tener aprobacion antes de fucionar.
