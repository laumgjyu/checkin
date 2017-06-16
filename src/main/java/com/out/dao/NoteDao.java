package com.out.dao;

import com.out.model.Note;

import java.util.List;

/**
 * Created by lmy on 2017/6/16.
 */
public interface NoteDao {
    Note dao = new Note();

    List<Note> listNotes(int userId);

    void add(int userId, String theme, String content);

    void editNote(int id, String theme, String content);
}
