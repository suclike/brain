/** UnitTesting **/
/** android-testing/app/src/test/java/com/example/android/testing/notes/notedetail/NotesDetailPresenterTest.java **/

package com.example.android.testing.notes.notedetail;



public class NotesDetailPresenterTest {

    /** The guy you want to test **/
    private NoteDetailPresenter mNotesDetailsPresenter;

    /** MockitoAnnotations.initMocks(this); **/
    @Mock private NotesRepository mNotesRepository;
    @Mock private NoteDetailContract.View mNoteDetailView;

    /**
     * {@link ArgumentCaptor} is a powerful Mockito API to capture argument values and use them to
     * perform further actions or assertions on them.
     */
    @Captor private ArgumentCaptor<NotesRepository.GetNoteCallback> mGetNoteCallbackCaptor;


    @Before
    public void setupNotesPresenter() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        // Get a reference to the class under test
        mNotesDetailsPresenter = new NoteDetailPresenter(mNotesRepository, mNoteDetailView);
    }


    @Test
    public void getUnknownNoteFromRepositoryAndLoadIntoView() {
        // When loading of a note is requested with an invalid note ID.
        mNotesDetailsPresenter.openNote(INVALID_ID);

        // Then note with invalid id is attempted to load from model, callback is captured and
        // progress indicator is shown.
        verify(mNoteDetailView).setProgressIndicator(true);
        verify(mNotesRepository).getNote(eq(INVALID_ID), mGetNoteCallbackCaptor.capture());

        // When note is finally loaded
        mGetNoteCallbackCaptor.getValue().onNoteLoaded(null); // Trigger callback

        // Then progress indicator is hidden and missing note UI is shown
        verify(mNoteDetailView).setProgressIndicator(false);
        verify(mNoteDetailView).showMissingNote();
    }
}
