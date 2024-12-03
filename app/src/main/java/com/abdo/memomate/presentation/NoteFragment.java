package com.abdo.memomate.presentation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.abdo.memomate.R;
import com.abdo.memomate.data.NoteRepository;
import com.abdo.memomate.databinding.FragmentNoteListBinding;
import com.abdo.memomate.repository.NotesRepositoryImpl;


public class NoteFragment extends Fragment {
    private NoteViewModel noteViewModel;

    public NoteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = requireContext(); // Ensure context is non-null
        NoteRepository noteRepository = new NotesRepositoryImpl(context);
        NoteViewModelFactory factory = new NoteViewModelFactory(noteRepository);

        noteViewModel = new ViewModelProvider(this, factory).get(NoteViewModel.class);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
    ) {

        FragmentNoteListBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_note_list, container, false
        );
        noteViewModel.state.observe(getViewLifecycleOwner(), noteUiState -> {
            if (noteUiState != null) {
                binding.setNote(noteUiState); // Update binding with the new state
                binding.list.setAdapter(new MyNoteRecyclerViewAdapter(noteUiState.getNoteList()));
            }
        });
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.fab.setOnClickListener(view -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_noteFragment_to_detailsFragment);
//            noteViewModel.addNote();
        });
        return binding.getRoot();
    }

}

