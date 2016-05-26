package com.xx.nextfilm.dao;

import com.xx.nextfilm.dto.editor.ShowingEditor2;
import com.xx.nextfilm.entity.ShowingEntity;

/**
 * Created by CuiH on 2016/5/17.
 */
public interface ShowingDao {

    ShowingEntity findById(Long id, boolean needFcm, boolean needSeats);

    void doSave(ShowingEntity showing);

    void doUpdate(ShowingEntity showing);

    boolean doUpdateManually(ShowingEditor2 showing);

    void doDelete(ShowingEntity showing);

}
