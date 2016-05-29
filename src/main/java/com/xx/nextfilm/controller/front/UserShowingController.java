package com.xx.nextfilm.controller.front;

import com.google.gson.Gson;
import com.xx.nextfilm.dto.shower.FilmShower2;
import com.xx.nextfilm.dto.shower.FilmShowingShower;
import com.xx.nextfilm.dto.shower.ShowingShower2;
import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.entity.FCMEntity;
import com.xx.nextfilm.exception.CinemaNotExistException;
import com.xx.nextfilm.service.CinemaService;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by CuiH on 2016/5/29.
 */
@Controller
public class UserShowingController {

    @Autowired
    ShowingService showingService;

    @Autowired
    CinemaService cinemaService;


    @ResponseBody
    @RequestMapping(value = "/get_showing", method = RequestMethod.GET, produces = "application/javascript; charset=utf-8")
    public String getShowing(@RequestParam Long cinemaId, @RequestParam String date) {
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
            FilmShowingShower filmShowingShower = new FilmShowingShower();
            filmShowingShower.setFilm(BuilderUtils.getFilmShower2FromFilmEntity(fcm.getFilm()));
            filmShowingShower.setShowings(BuilderUtils.
                    getShowingShower2sFromShowingEntities(showingService.
                            findShowingsByFCMAndDate(fcm, ConverterUtils.convertStringToDate(date))));

            results.add(filmShowingShower);
        }

        Gson gson = new Gson();

        return "ljy({\"result\": \"success\", \"data\": " + gson.toJson(results) + "})";
    }

}
