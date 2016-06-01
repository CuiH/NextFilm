package com.xx.nextfilm.controller.front;

import com.google.gson.Gson;
import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.exception.CinemaNotExistException;
import com.xx.nextfilm.service.CinemaService;
import com.xx.nextfilm.utils.BuilderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by CuiH on 2016/5/29.
 */
@Controller
public class UserCinemaController {

    @Autowired
    CinemaService cinemaService;


    @ResponseBody
    @RequestMapping(value = "/get_cinema", method = RequestMethod.GET, produces = "application/javascript; charset=utf-8")
    public String getCinema(@RequestParam String name, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        List<CinemaEntity> cinemas = cinemaService.findCinemasByName(name, true, false, false);

        if (cinemas.size() == 0) {

            return "cjs({\"result\": \"fail\", \"reason\": \"no such cinema\"})";
        }

        Gson gson = new Gson();

        return "cjs({\"result\": \"success\", \"data\": " +
                gson.toJson(BuilderUtils.getCinemaShower3sFromCinemaEntities(cinemas)) + "})";
    }

    @ResponseBody
    @RequestMapping(value = "/view_cinema", method = RequestMethod.GET, produces = "application/javascript; charset=utf-8")
    public String viewCinema(@RequestParam Long id, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        try {
            CinemaEntity cinemaEntity = cinemaService.findCinemaById(id, false, false, false);

            Gson gson = new Gson();

            return "{\"result\": \"success\", \"data\": " +
                    gson.toJson(BuilderUtils.getCinemaShower1FromCinemaEntity(cinemaEntity)) + "}";
        } catch (CinemaNotExistException e) {

            return "{\"result\": \"fail\", \"reason\": \"unknown cinema\"}";
        }
    }


    @ResponseBody
    @RequestMapping(value = "/get_some_cinema", method = RequestMethod.GET, produces = "application/javascript; charset=utf-8")
    public String getSomeCinema(@RequestParam int num, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        List<CinemaEntity> cinemaEntities = cinemaService.findSomeCinemas(num, false, false, false);

        if (cinemaEntities.size() == 0) {

            return "cjs({\"result\": \"fail\", \"reason\": \"no such cinema\"})";
        }

        Gson gson = new Gson();

        return "cjs({\"result\": \"success\", \"data\": " +
                gson.toJson(BuilderUtils.getCinemaShower2sFromCinemaEntities(cinemaEntities)) + "})";
    }

}
