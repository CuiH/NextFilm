package com.xx.nextfilm.service;

import com.xx.nextfilm.dao.CinemaDao;
import com.xx.nextfilm.dto.CinemaEditor;
import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by CuiH on 2016/5/16.
 */
@Transactional
@Service("cinemaService")
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    CinemaDao dao;


    public CinemaEntity findCinemaById(Long id) {
        return dao.findById(id);
    }


    public CinemaEditor getCinemaEditorById(Long id) {
        CinemaEntity cinemaEntity = findCinemaById(id);

        if (cinemaEntity == null) return null;

        CinemaEditor cinemaEditor = new CinemaEditor();

        cinemaEditor.setId(cinemaEntity.getId());
        cinemaEditor.setName(cinemaEntity.getName());
        cinemaEditor.setCity(Utils.convertCityCodeToCity(cinemaEntity.getCityCode()));
        cinemaEditor.setAddress(cinemaEntity.getAddress());
        cinemaEditor.setPhone(cinemaEntity.getPhone());
        cinemaEditor.setBrief(cinemaEntity.getBrief());
        cinemaEditor.setImageUrl(cinemaEntity.getImageUrl());
        cinemaEditor.setDescription(cinemaEntity.getDescription());

        return cinemaEditor;
    }


    public List<CinemaEntity> findCinemaByName(String name) {
        return dao.findByName(name);
    }


    public List<CinemaEntity> findCinemaByCityCode(String cityCode) {
        return dao.findByCityCode(cityCode);
    }


    public void createCinema(CinemaEditor cinemaEditor) {
        CinemaEntity cinemaEntity = new CinemaEntity();

        cinemaEntity.setName(cinemaEditor.getName());
        cinemaEntity.setCityCode(Utils.convertCityToCityCode(cinemaEditor.getCity()));
        cinemaEntity.setAddress(cinemaEditor.getAddress());
        cinemaEntity.setPhone(cinemaEditor.getPhone());
        cinemaEntity.setBrief(cinemaEditor.getBrief());
        cinemaEntity.setImageUrl(cinemaEditor.getImageUrl());
        cinemaEntity.setDescription(cinemaEditor.getDescription());

        dao.doSave(cinemaEntity);
    }

    public void updateCinema(CinemaEditor cinemaEditor) {
        CinemaEntity cinemaEntity = new CinemaEntity();

        cinemaEntity.setId(cinemaEditor.getId());
        cinemaEntity.setName(cinemaEditor.getName());
        cinemaEntity.setCityCode(Utils.convertCityToCityCode(cinemaEditor.getCity()));
        cinemaEntity.setAddress(cinemaEditor.getAddress());
        cinemaEntity.setPhone(cinemaEditor.getPhone());
        cinemaEntity.setBrief(cinemaEditor.getBrief());
        cinemaEntity.setImageUrl(cinemaEditor.getImageUrl());
        cinemaEntity.setDescription(cinemaEditor.getDescription());

        dao.doUpdate(cinemaEntity);
    }


    public void deleteCinema(CinemaEntity cinema) {
        dao.doDelete(cinema);
    }


    public List<CinemaEntity> findAllCinemas() {
        return dao.findAll();
    }

}
