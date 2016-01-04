A testing development pipeline defines what to test and how

- Test automation is key to successful software development.
- Testable code is required to write specific types of tests.
- Some developers start writing tests without knowing what to test and how to test it.
- The quality and reliability of our tests are not always as good as they should be.
- A testing development pipeline is necessary to define what to test and how to test it.


- Test the business logic independently of the framework or library.
- Test the Server Side API integration.
- Test the acceptance criteria written from the user’s point of view in a black box scenario.

One of the keys to dramatically improve the test quality is by checking the software state at the end of the execution while avoiding to verify the interactions with other components. This is because even if the interaction between your components is correct, the state can be incorrect. 

The grain of the test should be as small as the scope of the test under consideration.

 When following the Dependency Inversion Principle we will be able to test our business logic independently from the framework or library in the production code. We can create an isolated environment with repeatable easy to write and design tests. Additionally, we can easily choose the amount of production code to test and replace this code with test doubles to simulate the behaviour and different scenarios.
 
 - Clean Architecture by Uncle Bob. https://blog.8thlight.com/uncle-bob/2012/08/13/the-clean-architecture.html
 - World-Class Testing Development Pipeline for Android
	- http://blog.karumi.com/world-class-testing-development-pipeline-for-android/
	- http://blog.karumi.com/world-class-testing-development-pipeline-for-android-part-2/
 

Links
-----

- [Android Testing Codelab](https://codelabs.developers.google.com/codelabs/android-testing/index.html#2)
- [Android Testing Support Library](https://developer.android.com/tools/testing-support-library/index.html)


Scratches
-----

- `scratch_30` libraries definitions
- hola


Project structure
----


- Model: `Notes`, `NotesRepository`, `NotesServiceApi`
- Presenters: 
	- `NotesPresenter` that loads a list of notes from the API.
	- `NoteDetailPresenter` that loads a single note.
	- `AddNotePresenter` saves a new note



Highlights
------


The Android Testing Support library (ATSL) provides a great framework for testing your Android app. It has a JUnit 4-compatible test runner (AndroidJUnitRunner) and functional UI testing through Espresso and UI Automator. 

The Model-View-Presenter pattern moves the logic away from the activities/fragments that become passive views, towards a Presenter that can be tested. 

MVP View consist of two interfaces `XxxContract.View` and `XxxContract.UserActionsListener`. MVP Views are *implemented* by an Android View (Fragment, Activity, ? extend view), they are not the fragments... themselves. `XxxContract.View` handles the display of data (ie. the model). User actions `XxxContract.UserActionsListener` are forwarded to the presenter. 


