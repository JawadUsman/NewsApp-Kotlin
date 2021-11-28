# Android NewsApp-Kotlin

A News app is a sample app consist of three screens: Splash, News list and News details. The App uses combined MVVM and Clean Architecture and Repository patterns. The application is written entirely in Kotlin.

## Libraries
Android Jetpack is used as an Architecture glue including but not limited to ViewModel, Coroutine scope, LiveData, Lifecycles, and Navigation. And the application does network HTTP requests via Retrofit, OkHttp and GSON.

## Test Library
For testing framework used Espresso (UI test)
JUnit4 used to test classes

## Download code and Run the project
Click on the green-colored `Code` button, select HTTPS tab and then copy the hyperlink

Step 1: Go to `Android Studio` and click the `File > New > Project from Version Control`.<br>
Step 2: The pop-up screen will appear, Select Git for `Version control` from the drop-down menu. <br>
Step 3: Paste the project link in the URL and choose the project your directory. Than click on the 'Clone' button.

### The project will be download to the given directory
Use the following setps to run the project
Step 1: Connect android device to the system(development machine) with a USB cable.<br>
Step 2: Enable `USB debugging` in the `Developer options` from the phone settings.<br>
Step 3: In the Android Studio, select the device that you want to run the NewsApp on from the target device drop-down menu.<br>
Step 4: Click on Run icon (Green play icon) or press Shift + F10. 

or

Step 4: Run `./gradlew runApp` in the terminal, studio will builds and install the debug apk on the current connected device.

### Test cases
Navigate to the `src/test/java` folder and right click. Then click `Run Test in 'com.android.newsapp'`
or
Run `./gradlew runUnitTests` in the terminal tab to execute unit tests.

### Coverage reports

Run `./gradlew runTestCoverage` in the terminal tab, studio will exicute the reports code coverage on tests within the Android codebase.


## Scenario
- Populate the list of most popular news article.
- Select period from the left top menu button.
- Tap on news item to see the detailed news.
