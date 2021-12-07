package com.example.songpad;

import io.realm.Realm;
import io.realm.RealmObject;

public class PagesDomain extends RealmObject {
    String title;
    String Description;
    long time;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
