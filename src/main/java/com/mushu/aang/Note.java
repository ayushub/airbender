package com.mushu.aang;

import java.util.Objects;

public class Note {
    private long id;
    private String note;
    private String title;
    private String user; //convert to User class

    public Note() { }

    public Note(long id, String note, String title, String user) {
        this.id = id;
        this.note = note;
        this.title = title;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNote() {
        return note; //decrypt
    }

    public void setNote(String note) {
        this.note = note; //encrypt
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note1 = (Note) o;
        return getId() == note1.getId() ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNote(), getTitle(), getUser());
    }
}
