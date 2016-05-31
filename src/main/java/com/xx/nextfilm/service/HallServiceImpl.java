package com.xx.nextfilm.service;

import com.xx.nextfilm.controller.back.MainController;
import com.xx.nextfilm.dao.CinemaDao;
import com.xx.nextfilm.dao.HallDao;
import com.xx.nextfilm.dto.editor.HallEditor;
import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.entity.HallEntity;
import com.xx.nextfilm.exception.CinemaNotExistException;
import com.xx.nextfilm.exception.HallNotExistException;
import com.xx.nextfilm.exception.UserNotLoginException;
import com.xx.nextfilm.utils.ConverterUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by CuiH on 2016/5/17.
 */
@Transactional
@Service("hallService")
public class HallServiceImpl implements HallService {

    private static final Logger LOG = LogManager.getLogger("com.xx.nextfilm");

    @Autowired
    HallDao hallDao;

    @Autowired
    CinemaDao cinemaDao;

    public HallEntity findHallById(Long id, boolean needCinema) throws HallNotExistException {
        return hallDao.findById(id, needCinema);
    }


    public HallEditor getHallEditorById(Long id) throws HallNotExistException {
        HallEntity hallEntity = findHallById(id, false);

        HallEditor hallEditor = new HallEditor();

        hallEditor.setId(hallEntity.getId());
        hallEditor.setName(hallEntity.getName());
        hallEditor.setType(hallEntity.getType());
        hallEditor.setRowNum(ConverterUtils.convertShortToString(hallEntity.getRowNum()));
        hallEditor.setColumnNum(ConverterUtils.convertShortToString(hallEntity.getColumnNum()));

        return hallEditor;
    }


    public void createHall(HallEditor hallEditor) throws CinemaNotExistException, UserNotLoginException {
        CinemaEntity cinemaEntity = cinemaDao.findById(hallEditor.getCinemaId(), false, false, false);

        HallEntity hallEntity = getEntityFromEditor(hallEditor, false);
        hallEntity.setCinema(cinemaEntity);

        hallDao.doSave(hallEntity);

        LOG.info(MainController.getCurrentUsername() + " : add hall - #" + hallEntity.getId());
    }


    // 只可改变hall信息，不可改变其所属cinema
    public boolean updateHall(HallEditor hallEditor) throws UserNotLoginException {
        boolean flag = hallDao.doUpdateManually(hallEditor);

        LOG.info(MainController.getCurrentUsername() + " : edit hall - #" + hallEditor.getId());

        return  flag;
    }


    public void deleteHall(HallEntity hallEntity) throws UserNotLoginException {
        hallDao.doDelete(hallEntity);

        LOG.info(MainController.getCurrentUsername() + " : delete hall - #" + hallEntity.getId());
    }


    private HallEntity getEntityFromEditor(HallEditor hallEditor, boolean needId) {
        HallEntity hallEntity = new HallEntity();

        if (needId) {
            hallEntity.setId(hallEditor.getId());
        }

        hallEntity.setName(hallEditor.getName());
        hallEntity.setColumnNum(ConverterUtils.convertStringToShort(hallEditor.getColumnNum()));
        hallEntity.setRowNum(ConverterUtils.convertStringToShort(hallEditor.getRowNum()));
        hallEntity.setType(hallEditor.getType());

        return hallEntity;
    }

}
