package com.xx.nextfilm.dao;

import com.xx.nextfilm.dto.editor.HallEditor;
import com.xx.nextfilm.entity.HallEntity;

/**
 * Created by CuiH on 2016/5/17.
 */
public interface HallDao {

    HallEntity findById(Long id, boolean needCinema);

    void doSave(HallEntity hall);

    void doUpdate(HallEntity hall);

    boolean doUpdateManually(HallEditor hall);

    void doDelete(HallEntity hall);

}
