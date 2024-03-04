## This project is an android app designed to fetch Movies data using the Free Movies API from [themoviedb.org](https://developer.themoviedb.org/). It follows the clean architecture pattern to organize the app's components and utilizes the Model-View-Intent (MVI) pattern for the presentation layer.

## Architecture and Presentation Pattern

The app follows the clean architecture pattern, which separates the codebase into layers based on the level of abstraction. This allows for easier maintenance, testability, and scalability. The layers include:

- Presentation Layer: This layer is responsible for displaying information to the user and handling user input. It follows the Model-View-Intent (MVI) pattern, which provides a reactive and unidirectional flow of data. The MVI pattern helps in managing the app's state and simplifies testing.

- Domain Layer: The domain layer contains the business logic of the app. It defines the use cases and interacts with the data layer to fetch and manipulate data.

- Data Layer: The data layer is responsible for fetching and storing data. It communicates with external data sources, such as APIs or databases, and provides the necessary data to the domain layer.

The app utilizes the following libraries and frameworks to implement the architecture and presentation pattern:

- Orbit: [Orbit](https://orbit-mvi.org/) is a library that provides a framework-agnostic implementation of the MVI pattern. It helps in managing the app's state and handling side effects.

## Dependencies

The project includes the following dependencies:

- JetPack Compose: androidx.compose.ui:ui, androidx.activity:activity-compose, androidx.compose.foundation:foundation
- Material3: androidx.compose.material3:material3
- JUnit: junit:junit
- Android Jetpack Navigation: androidx.navigation:navigation-compose, androidx.navigation:navigation-fragment-ktx, androidx.navigation:navigation-ui-ktx
- Retrofit: com.squareup.retrofit2:retrofit
- Retrofit Gson Converter: com.squareup.retrofit2:converter-gson
- Dagger Hilt: androidx.hilt:hilt-navigation-compose, com.google.dagger:hilt-android, com.google.dagger:hilt-android-compiler
- Orbit Core: org.orbit-mvi:orbit-core
- Orbit ViewModel: org.orbit-mvi:orbit-viewmodel
- Orbit Test: org.orbit-mvi:orbit-test
- Orbit Compose: org.orbit-mvi:orbit-compose
- Chucker: com.github.chuckerteam.chucker:library, com.github.chuckerteam.chucker:library-no-op
- Coil Compose: io.coil-kt:coil-compose
- Fixture: com.appmattus.fixture:fixture
- Mockito: org.mockito.kotlin:mockito-kotlin
- MockK: io.mockk:mockk

## Usage

To use this project, you need to sign up for a free themoviedb.org account and obtain an API key. Once you have the API key, you can replace the placeholder key in the code with your actual key.

## License

MIT License

Copyright (c) 2024 Eslam Waheed

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER INAN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
