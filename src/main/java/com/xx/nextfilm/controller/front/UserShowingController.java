package com.xx.nextfilm.controller.front;

import com.google.gson.Gson;
import com.xx.nextfilm.dto.shower.CinemaShowingShower;
import com.xx.nextfilm.dto.shower.FilmShowingShower;
import com.xx.nextfilm.entity.*;
import com.xx.nextfilm.exception.CinemaNotExistException;
import com.xx.nextfilm.exception.FilmNotExistException;
import com.xx.nextfilm.exception.ShowingNotExistException;
import com.xx.nextfilm.service.CinemaService;
import com.xx.nextfilm.service.FCMService;
import com.xx.nextfilm.service.FilmService;
import com.xx.nextfilm.service.ShowingService;
import com.xx.nextfilm.utils.BuilderUtils;
import com.xx.nextfilm.utils.ConverterUtils;
import com.xx.nextfilm.utils.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by CuiH on 2016/5/29.
 */
@Controller
public class UserShowingController {

    @Autowired
    ShowingService showingService;

    @Autowired
    CinemaService cinemaService;

    @Autowired
    FilmService filmService;

    @Autowired
    FCMService fcmService;


    // 某个影院某个日期的所有电影及场次
    @ResponseBody
    @RequestMapping(value = "/get_showing", method = RequestMethod.GET, produces = "application/javascript; charset=utf-8")
    public String getShowing(@RequestParam Long cinemaId, @RequestParam String date, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        if (date == null || !ValidatorUtils.isDateValid(date)) {

            return "ljy({\"result\": \"fail\", \"reason\": \"invalid date\"})";
        }

        CinemaEntity cinemaEntity;
        try {
            cinemaEntity = cinemaService.findCinemaById(cinemaId, false, false, true);
        } catch (CinemaNotExistException e) {

            return "ljy({\"result\": \"fail\", \"reason\": \"unknown cinema\"})";
        }

        List<FilmShowingShower> results = new ArrayList<FilmShowingShower>();
        List<FCMEntity> fcms = cinemaEntity.getFcms();
        for (FCMEntity fcm: fcms) {
            List<ShowingEntity> showings = showingService.
                    findShowingsByFCMAndDate(fcm, ConverterUtils.convertStringToDate(date));

            if (showings.size() == 0) continue;

            FilmShowingShower filmShowingShower = new FilmShowingShower();
            filmShowingShower.setFilm(BuilderUtils.getFilmShower2FromFilmEntity(fcm.getFilm()));
            filmShowingShower.setShowings(BuilderUtils.getShowingShower2sFromShowingEntities(showings));

            results.add(filmShowingShower);
        }

        Gson gson = new Gson();

        return "ljy({\"result\": \"success\", \"data\": " + gson.toJson(results) + "})";
    }


    // 某部电影当天当前时间之后在三个影院的各一个场次
    @ResponseBody
    @RequestMapping(value = "/get_showing2", method = RequestMethod.GET, produces = "application/javascript; charset=utf-8")
    public String getShowing2(@RequestParam Long filmId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        FilmEntity filmEntity;
        try {
            filmEntity = filmService.findFilmById(filmId, false, false);
        } catch (FilmNotExistException e) {

            return "ljy({\"result\": \"fail\", \"reason\": \"unknown film\"})";
        }

        List<FCMEntity> fcms = fcmService.findSomeFCMsByFilm(filmEntity, 10);

        List<CinemaShowingShower> results = new ArrayList<CinemaShowingShower>();
        for (FCMEntity fcm: fcms) {
            if (results.size() >= 3) break;

            List<ShowingEntity> showings = showingService.findSomeShowingsByFCMAndDate(fcm, new Date(), 1);

            if (showings.size() == 0) continue;

            CinemaShowingShower cinemaShowingShower = new CinemaShowingShower();
            cinemaShowingShower.setCinema(BuilderUtils.getCinemaShower2FromCinemaEntity(fcm.getCinema()));
            cinemaShowingShower.setShowings(BuilderUtils.getShowingShower2sFromShowingEntities(showings));

            results.add(cinemaShowingShower);
        }

        Gson gson = new Gson();

        return "ljy({\"result\": \"success\", \"data\": " + gson.toJson(results) + "})";
    }

    @ResponseBody
    @RequestMapping(value = "/view_showing", method = RequestMethod.GET, produces = "application/javascript; charset=utf-8")
    public String viewShowing(@RequestParam Long id, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        ShowingEntity showingEntity;
        try {
            showingEntity = showingService.findShowingById(id, true, true, true);
        } catch (ShowingNotExistException e) {

            return "ljy({\"result\": \"fail\", \"reason\": \"unknown showing\"})";
        }

        Gson gson = new Gson();

        return "ljy({\"result\": \"success\", \"data\": " +
                gson.toJson(BuilderUtils.getShowingShower1FromShowingEntity(showingEntity)) + "})";
    }

}
