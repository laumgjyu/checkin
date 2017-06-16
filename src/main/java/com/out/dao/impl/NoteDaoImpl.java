package com.out.dao.impl;

import com.jfinal.plugin.activerecord.Db;
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

    public void add(int userId, String theme, String content) {
        String sql = "INSERT INTO t_note SET u_id=?,theme=?,content=?";
        Db.update(sql, userId, theme, content);
    }

    public void editNote(int id, String theme, String content) {
        Db.update("UPDATE t_note SET theme=?,content=? WHERE id=?", theme, content, id);
    }

}
