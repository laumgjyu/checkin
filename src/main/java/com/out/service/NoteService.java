package com.out.service;

import com.out.model.Note;

import java.util.List;

/**
 * Created by lmy on 2017/6/16.
 */
public interface NoteService {
    List<Note> listNotes(int userId);

    void addNote(int userId, String theme, String content);

    void deleteNote(int id);

    Note findById(int id);

    void editNote(int id, String theme, String content);

}
