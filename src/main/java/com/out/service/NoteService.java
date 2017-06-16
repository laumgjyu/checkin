package com.out.service;

import com.out.model.Note;

import java.util.List;

/**
 * Created by lmy on 2017/6/16.
 */
public interface NoteService {
    List<Note> listNotes(int userId);
}
