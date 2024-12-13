package com.abdo.memomate.presentation.shared;

public interface NoteInteractionListener {
    void onClickNoteItem(NoteItemUiState item);
    void onClickAddNote();
    void onClickDeleteButton();
    void onClickBackButton();
    void onClickSaveButton();
}
