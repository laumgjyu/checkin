package com.out.dao.impl;

import com.out.dao.NoteDao;
import com.out.model.Note;

import java.util.List;

/**
 * Created by lmy on 2017/6/16.
 */
public class NoteDaoImpl implements NoteDao {
    public List<Note> listNotes(int userId) {

        return dao.find("SELECT * FROM t_note WHERE u_id=?", userId);
    }
}
