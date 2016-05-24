package com.xx.nextfilm.service;

import com.xx.nextfilm.dto.HallEditor;
import com.xx.nextfilm.entity.HallEntity;

import java.util.List;

/**
 * Created by CuiH on 2016/5/17.
 */
public interface HallService {

    HallEntity findHallById(Long id, boolean needCinema);

    HallEditor getHallEditorById(Long id);

    boolean createHall(HallEditor hallEditor);

    boolean updateHall(HallEditor hallEditor);

    void deleteHall(HallEntity hallEntity);

}
