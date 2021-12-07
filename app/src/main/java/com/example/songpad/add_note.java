package com.example.songpad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import io.realm.Realm;

public class add_note extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        EditText etNoteNameJ = findViewById(R.id.etNoteName);
        MaterialButton createNewNoteBTNJ = findViewById(R.id.createNewNoteBTN);
        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        createNewNoteBTNJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noteName = etNoteNameJ.getText().toString();
                realm.beginTransaction();

                NotesDomain note = realm.createObject(NotesDomain.class);
                note.setNoteName(noteName);
                realm.commitTransaction();
                Toast.makeText(getApplicationContext(), "Note Saved!!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(add_note.this,MainActivity.class));
            }
        });
    }
}