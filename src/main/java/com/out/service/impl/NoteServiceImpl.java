package com.out.service.impl;

import com.out.dao.NoteDao;
import com.out.dao.impl.NoteDaoImpl;
import com.out.model.Note;
import com.out.service.NoteService;

import java.util.List;

/**
 * Created by lmy on 2017/6/16.
 */
public class NoteServiceImpl implements NoteService {

    NoteDao dao = new NoteDaoImpl();

    public List<Note> listNotes(int userId) {
        return dao.listNotes(userId);
    }
}
