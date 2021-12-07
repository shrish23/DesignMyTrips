package com.example.songpad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.RealmResults;

public class NotesAdaptor extends RecyclerView.Adapter<NotesAdaptor.NotesViewHolder> {

    Context context;
    RealmResults<NotesDomain> noteList;
    public NotesAdaptor(Context context, RealmResults<NotesDomain> noteList) {
        this.context = context;
        this.noteList = noteList;
    }

    @NonNull
    @Override


    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        NotesDomain note = noteList.get(position);
        holder.noteNameDisplay.setText(note.getNoteName());
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder {
        TextView noteNameDisplay;

        public NotesViewHolder(View itemView) {
            super(itemView);
            noteNameDisplay = itemView.findViewById(R.id.noteNameDisplay);
        }
    }
}
