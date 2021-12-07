package com.example.songpad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import io.realm.Sort;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton addNoteBTNJ = findViewById(R.id.addNoteBTN);
        Button mLogoutbutton = findViewById(R.id.logout);
        addNoteBTNJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, add_note.class));
            }
        });

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();
        RealmResults<NotesDomain> noteList = realm.where(NotesDomain.class).findAll();
        RecyclerView recyclerView = findViewById(R.id.recyclerViewNotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NotesAdaptor notesAdaptor = new NotesAdaptor(getApplicationContext(),noteList);
        recyclerView.setAdapter(notesAdaptor);

        noteList.addChangeListener(new RealmChangeListener<RealmResults<NotesDomain>>() {
            @Override
            public void onChange(RealmResults<NotesDomain> notesDomains) {
                notesAdaptor.notifyDataSetChanged();
            }
        });

        mLogoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();
            }
        });

    }


}