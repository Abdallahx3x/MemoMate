package com.abdo.memomate.presentation.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdo.memomate.databinding.FragmentNoteItemBinding;
import com.abdo.memomate.presentation.shared.NoteInteractionListener;
import com.abdo.memomate.presentation.shared.NoteItemUiState;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.ViewHolder> {
    private final List<NoteItemUiState> items;
    private final NoteInteractionListener interactionListener;

    public NoteListAdapter(List<NoteItemUiState> items, NoteInteractionListener interactionListener) {
        this.items = items;
        this.interactionListener = interactionListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentNoteItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        NoteItemUiState item = items.get(position);
        holder.bind(item, interactionListener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final FragmentNoteItemBinding binding;

        public ViewHolder(FragmentNoteItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(NoteItemUiState item, NoteInteractionListener listener) {
            binding.noteTitle.setText(item.title);
            binding.content.setText(item.details);
            itemView.setOnClickListener(v -> listener.onClickNoteItem(item));
        }
    }
}