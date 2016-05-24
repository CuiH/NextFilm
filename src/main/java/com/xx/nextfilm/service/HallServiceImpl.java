package com.xx.nextfilm.service;

import com.xx.nextfilm.dao.CinemaDao;
import com.xx.nextfilm.dao.HallDao;
import com.xx.nextfilm.dto.HallEditor;
import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.entity.HallEntity;
import com.xx.nextfilm.utils.ConverterUtils;
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


    public HallEditor getHallEditorById(Long id) {
        HallEntity hallEntity = findHallById(id, false);

        if (hallEntity == null) return null;

        HallEditor hallEditor = new HallEditor();

        hallEditor.setId(hallEntity.getId());
        hallEditor.setName(hallEntity.getName());
        hallEditor.setType(hallEntity.getType());
        hallEditor.setRowNum(ConverterUtils.convertShortToString(hallEntity.getRowNum()));
        hallEditor.setColumnNum(ConverterUtils.convertShortToString(hallEntity.getColumnNum()));

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
        hallEntity.setColumnNum(ConverterUtils.convertStringToShort(hallEditor.getColumnNum()));
        hallEntity.setRowNum(ConverterUtils.convertStringToShort(hallEditor.getColumnNum()));
        hallEntity.setType(hallEditor.getType());

        return hallEntity;
    }

}
