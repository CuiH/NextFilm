package com.xx.nextfilm.service;

import com.xx.nextfilm.dao.CinemaDao;
import com.xx.nextfilm.dao.HallDao;
import com.xx.nextfilm.dto.HallEditor;
import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.entity.HallEntity;
import com.xx.nextfilm.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by CuiH on 2016/5/17.
 */
@Transactional
@Service("hallService")
public class HallServiceImpl implements HallService {

    @Autowired
    HallDao hallDao;

    @Autowired
    CinemaDao cinemaDao;

    public HallEntity findHallById(Long id) {
        return hallDao.findById(id);
    }


    public HallEditor getHallEditorById(Long id) {
        HallEntity hallEntity = findHallById(id);

        if (hallEntity == null) return null;

        HallEditor hallEditor = new HallEditor();

        hallEditor.setId(hallEntity.getId());
        hallEditor.setName(hallEntity.getName());
        hallEditor.setType(hallEntity.getType());
        hallEditor.setRowNum(Utils.convertShortToString(hallEntity.getRowNum()));
        hallEditor.setColumnNum(Utils.convertShortToString(hallEntity.getColumnNum()));

        return hallEditor;
    }


    public boolean createHall(HallEditor hallEditor) {
        CinemaEntity cinemaEntity = cinemaDao.findById(hallEditor.getCinemaId(), false, false, false);
        if (cinemaEntity == null) return false;

        HallEntity hallEntity = getEntityFromEditor(hallEditor, false);
        hallEntity.setCinema(cinemaEntity);

        hallDao.doSave(hallEntity);

        return true;
    }


    public boolean updateHall(HallEditor hallEditor) {
        CinemaEntity cinemaEntity = cinemaDao.findById(hallEditor.getCinemaId(), false, false, false);
        if (cinemaEntity == null) return false;

        HallEntity hallEntity = getEntityFromEditor(hallEditor, true);
        hallEntity.setCinema(cinemaEntity);

        hallDao.doUpdate(hallEntity);

        return true;
    }


    public void deleteHall(HallEntity hallEntity) {
        hallDao.doDelete(hallEntity);
    }


    private HallEntity getEntityFromEditor(HallEditor hallEditor, boolean needId) {
        HallEntity hallEntity = new HallEntity();

        if (needId) {
            hallEntity.setId(hallEditor.getId());
        }

        hallEntity.setName(hallEditor.getName());
        hallEntity.setColumnNum(Utils.convertStringToShort(hallEditor.getColumnNum()));
        hallEntity.setRowNum(Utils.convertStringToShort(hallEditor.getColumnNum()));
        hallEntity.setType(hallEditor.getType());

        return hallEntity;
    }

}
