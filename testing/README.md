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


