package com.example.songpad;

import io.realm.RealmObject;

public class NotesDomain extends RealmObject {
    String noteName;

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }
}
