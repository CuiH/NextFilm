package com.xx.nextfilm.service;

import com.xx.nextfilm.controller.back.MainController;
import com.xx.nextfilm.dao.*;
import com.xx.nextfilm.dto.editor.ShowingEditor1;
import com.xx.nextfilm.dto.editor.ShowingEditor2;
import com.xx.nextfilm.dto.shower.ShowingShower2;
import com.xx.nextfilm.entity.*;
import com.xx.nextfilm.exception.*;
import com.xx.nextfilm.utils.BuilderUtils;
import com.xx.nextfilm.utils.ConverterUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by CuiH on 2016/5/17.
 */
@Transactional
@Service("showService")
public class ShowingServiceImpl implements ShowingService {

    private static final Logger LOG = LogManager.getLogger("com.xx.nextfilm");

    @Autowired
    ShowingDao showingDao;

    @Autowired
    HallDao hallDao;

    @Autowired
    CinemaDao cinemaDao;

    @Autowired
    FCMDao fcmDao;

    @Autowired
    FilmDao filmDao;

    @Autowired
    SeatDao seatDao;


    public ShowingEntity findShowingById(Long id, boolean needFcm, boolean needSeats, boolean needCinema)
            throws ShowingNotExistException {
        return showingDao.findById(id, needFcm, needSeats, needCinema);
    }


    public List<ShowingShower2> findShowingsByCinemaAndFilmWithShower2(CinemaEntity cinemaEntity, FilmEntity filmEntity)
            throws FCMNotExistException{
        FCMEntity fcmEntity = fcmDao.findByFilmAndCinema(filmEntity, cinemaEntity);

        return BuilderUtils.getShowingShower2sFromShowingEntities(showingDao.findByFCM(fcmEntity));
    }


    public List<ShowingEntity> findShowingsByFCMAndDate(FCMEntity fcmEntity, Date date) {
        return showingDao.findByFCMAndDate(fcmEntity, date);
    }


    public List<ShowingEntity> findSomeShowingsByFCMAndDate(FCMEntity fcmEntity, Date date, int num) {
        return showingDao.findSomeByFCMAndDate(fcmEntity, date, num);
    }


    public ShowingEditor2 getShowingEditor2ById(Long id) throws ShowingNotExistException {
        ShowingEntity showingEntity = findShowingById(id, true, true, false);

        ShowingEditor2 showingEditor2 = new ShowingEditor2();

        showingEditor2.setId(showingEntity.getId());
        showingEditor2.setHallName(showingEntity.getHall().getName());
        showingEditor2.setStartTime(ConverterUtils.convertDateTimeToString(showingEntity.getStartTime()));
        showingEditor2.setEndTime(ConverterUtils.convertDateTimeToString(showingEntity.getEndTime()));
        showingEditor2.setPriceManual(ConverterUtils.convertDoubleToString(showingEntity.getPriceManual()));
        showingEditor2.setFilm(BuilderUtils.getFilmShower3FromFilmEntity(showingEntity.getFcm().getFilm()));
        showingEditor2.setSeats(BuilderUtils.getSeatShowersFromSeatEntities(showingEntity.getSeats()));

        return showingEditor2;
    }


    public void createShowing(ShowingEditor1 showingEditor1)
            throws HallNotExistException, FilmNotExistException,
            CinemaNotExistException, FCMNotExistException, UserNotLoginException {
        HallEntity hall = hallDao.findById(showingEditor1.getHallId(), false);
        FilmEntity film = filmDao.findById(showingEditor1.getFilmId(), false, false);
        CinemaEntity cinema = cinemaDao.findById(showingEditor1.getCinemaId(), false, false, false);
        FCMEntity fcm = fcmDao.findByFilmAndCinema(film, cinema);

        ShowingEntity showingEntity = getEntityFromEditor(showingEditor1, false);
        showingEntity.setHall(hall);
        showingEntity.setFcm(fcm);

        showingDao.doSave(showingEntity);

        LOG.info(MainController.getCurrentUsername() + " : add showing - #" + showingEntity.getId());

        // 根据hall大小添加座位
        Short rowNum = hall.getRowNum();
        Short columnNum = hall.getColumnNum();
        for (Short row = 1; row <= rowNum; row++) {
            for (Short column = 1; column <= columnNum; column++) {
                SeatEntity seat = new SeatEntity();
                seat.setRowPos(row);
                seat.setColumnPos(column);
                seat.setShowing(showingEntity);
                seat.setStatus("1");
                seatDao.doSave(seat);
            }
        }
    }



    // 只可改变showing信息，不可改变所属hall、关联的影片
    public boolean updateShowing(ShowingEditor2 showingEditor2) throws UserNotLoginException {
        boolean flag =  showingDao.doUpdateManually(showingEditor2);

        LOG.info(MainController.getCurrentUsername() + " : edit showing - #" + showingEditor2.getId());

        return flag;
    }


    public void deleteShowing(ShowingEntity showingEntity) throws UserNotLoginException {
        showingDao.doDelete(showingEntity);

        LOG.info(MainController.getCurrentUsername() + " : delete showing - #" + showingEntity.getId());
    }


    private ShowingEntity getEntityFromEditor(ShowingEditor1 showingEditor1, boolean needId) {
        ShowingEntity showingEntity = new ShowingEntity();

        if (needId) {
            showingEntity.setId(showingEditor1.getId());
        }

        showingEntity.setStartTime(ConverterUtils.convertStringToDateTime(showingEditor1.getStartTime()));
        showingEntity.setEndTime(ConverterUtils.convertStringToDateTime(showingEditor1.getEndTime()));
        showingEntity.setPriceManual(ConverterUtils.convertStringToDouble(showingEditor1.getPriceManual()));

        return showingEntity;
    }


    public void admin(Long fcmId) {
        HallEntity hall1 = hallDao.findById(33l, false);
        HallEntity hall2 = hallDao.findById(34l, false);
        HallEntity hall3 = hallDao.findById(35l, false);
        HallEntity hall4 = hallDao.findById(36l, false);

        List<HallEntity> halls = new ArrayList<HallEntity>();
        halls.add(hall1);
        halls.add(hall2);
        halls.add(hall3);
        halls.add(hall4);

        FCMEntity fcm = fcmDao.findById(fcmId);

        Random random = new Random();
        int index;

        // 6.21
        index = random.nextInt(4);
        tem("2016-6-21T11:00", halls.get(index), fcm, 48d);
        random = new Random();
        index = random.nextInt(4);
        tem("2016-6-21T15:00", halls.get(index), fcm, 49d);
        random = new Random();
        index = random.nextInt(4);
        tem("2016-6-21T18:00", halls.get(index), fcm, 50d);
        if (index == 1) {
            tem("2016-6-21T21:00", halls.get(random.nextInt(4)), fcm, 50d);
            tem("2016-6-21T22:00", halls.get(random.nextInt(4)), fcm, 50d);
            tem("2016-6-21T23:00", halls.get(random.nextInt(4)), fcm, 50d);
        } else if (index == 2) {
            tem("2016-6-21T21:00", halls.get(random.nextInt(4)), fcm, 50d);
            tem("2016-6-21T22:00", halls.get(random.nextInt(4)), fcm, 50d);
        } else if(index == 3) {
            tem("2016-6-21T21:00", halls.get(random.nextInt(4)), fcm, 50d);
        }

        // 6.22
        random = new Random();
        index = random.nextInt(4);
        tem("2016-6-22T11:00", halls.get(index), fcm, 51d);
        random = new Random();
        index = random.nextInt(4);
        tem("2016-6-22T16:00", halls.get(index), fcm, 52d);
        random = new Random();
        index = random.nextInt(4);
        tem("2016-6-22T19:00", halls.get(index), fcm, 53d);
        if (index == 1) {
            tem("2016-6-22T21:00", halls.get(random.nextInt(4)), fcm, 50d);
            tem("2016-6-22T22:00", halls.get(random.nextInt(4)), fcm, 50d);
            tem("2016-6-22T23:00", halls.get(random.nextInt(4)), fcm, 50d);
        } else if (index == 2){
            tem("2016-6-22T21:00", halls.get(random.nextInt(4)), fcm, 50d);
            tem("2016-6-22T22:00", halls.get(random.nextInt(4)), fcm, 50d);
        } else if(index == 3) {
            tem("2016-6-22T21:00", halls.get(random.nextInt(4)), fcm, 50d);
        }

        // 6.23
        random = new Random();
        index = random.nextInt(4);
        tem("2016-6-23T11:00", halls.get(index), fcm, 54d);
        random = new Random();
        index = random.nextInt(4);
        tem("2016-6-23T17:00", halls.get(index), fcm, 55d);
        random = new Random();
        index = random.nextInt(4);
        tem("2016-6-23T20:00", halls.get(index), fcm, 56d);
        if (index == 1) {
            tem("2016-6-23T21:00", halls.get(random.nextInt(4)), fcm, 50d);
            tem("2016-6-23T22:00", halls.get(random.nextInt(4)), fcm, 50d);
            tem("2016-6-23T23:00", halls.get(random.nextInt(4)), fcm, 50d);
        } else if (index == 2){
            tem("2016-6-23T21:00", halls.get(random.nextInt(4)), fcm, 50d);
            tem("2016-6-23T22:00", halls.get(random.nextInt(4)), fcm, 50d);
        } else if(index == 3) {
            tem("2016-6-23T21:00", halls.get(random.nextInt(4)), fcm, 50d);
        }
    }

    private void tem(String startTime, HallEntity hall, FCMEntity fcm, Double price){
        ShowingEntity showingEntity = new ShowingEntity();
        showingEntity.setEndTime(ConverterUtils.convertStringToDateTime("1111-11-11T11:11"));
        showingEntity.setPriceManual(price);

        showingEntity.setStartTime(ConverterUtils.convertStringToDateTime(startTime));
        showingEntity.setHall(hall);
        showingEntity.setFcm(fcm);

        showingDao.doSave(showingEntity);

        // 根据hall大小添加座位
        Short rowNum = hall.getRowNum();
        Short columnNum = hall.getColumnNum();
        for (Short row = 1; row <= rowNum; row++) {
            for (Short column = 1; column <= columnNum; column++) {
                SeatEntity seat = new SeatEntity();
                seat.setRowPos(row);
                seat.setColumnPos(column);
                seat.setShowing(showingEntity);
                seat.setStatus("1");
                seatDao.doSave(seat);
            }
        }
    }

}
