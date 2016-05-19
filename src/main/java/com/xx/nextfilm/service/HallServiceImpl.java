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

    public HallEntity findHallById(Long id, boolean needCinema) {
        return hallDao.findById(id, needCinema);
    }


    public HallEditor getHallEditorById(Long id, boolean needCinema) {
        HallEntity hallEntity = findHallById(id, needCinema);

        if (hallEntity == null) return null;

        HallEditor hallEditor = new HallEditor();

        hallEditor.setId(hallEntity.getId());
        hallEditor.setName(hallEntity.getName());
        hallEditor.setType(hallEntity.getType());
        hallEditor.setRowNum(Utils.convertShortToString(hallEntity.getRowNum()));
        hallEditor.setColumnNum(Utils.convertShortToString(hallEntity.getColumnNum()));

        return hallEditor;
    }


    // 如果cinema不存在，返回false
    public boolean createHall(HallEditor hallEditor) {
        CinemaEntity cinemaEntity = cinemaDao.findById(hallEditor.getCinemaId(), false, false, false);
        if (cinemaEntity == null) return false;

        HallEntity hallEntity = getEntityFromEditor(hallEditor, false);
        hallEntity.setCinema(cinemaEntity);

        hallDao.doSave(hallEntity);

        return true;
    }


    // 只可改变hall信息，不可改变其所属cinema
    public boolean updateHall(HallEditor hallEditor) {
        return hallDao.doUpdateManually(hallEditor);
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
