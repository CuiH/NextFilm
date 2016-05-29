package com.xx.nextfilm.controller.front;

import com.google.gson.Gson;
import com.xx.nextfilm.dto.editor.FilmEditor;
import com.xx.nextfilm.entity.FilmEntity;
import com.xx.nextfilm.exception.FilmNotExistException;
import com.xx.nextfilm.service.FilmService;
import com.xx.nextfilm.utils.BuilderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by cuihao on 2016/5/28.
 */
@Controller
public class UserFilmController {

    @Autowired
    FilmService filmService;

    @ResponseBody
    @RequestMapping(value = "/get_film", method = RequestMethod.GET, produces = "application/javascript; charset=utf-8")
    public String viewReservation(@RequestParam String name, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        List<FilmEntity> filmEntities = filmService.findFilmsByName(name, true, true);

        if (filmEntities.size() == 0) {

            return "ch({\"result\": \"fail\", \"reason\": \"no such film\"})";
        }

        Gson gson = new Gson();

        return "ch({\"result\": \"success\", \"data\": " +
                gson.toJson(BuilderUtils.getFilmShower4sFromFilmEntities(filmEntities)) + "})";
    }


    @ResponseBody
    @RequestMapping(value = "/view_film", method = RequestMethod.GET, produces = "application/javascript; charset=UTF-8")
    public String viewFilm(@RequestParam Long id) {
        try {
            FilmEntity filmEntity = filmService.findFilmById(id, true, true);

            Gson gson = new Gson();

            return "ch({\"result\": \"success\", \"data\": " +
                    gson.toJson(BuilderUtils.getFilmShower1FromFilmEntity(filmEntity)) + "})";
        } catch (FilmNotExistException e) {

            return "ch({\"result\": \"fail\", \"reason\": \"unknown film\"})";
        }
    }


    @ResponseBody
    @RequestMapping(value = "/get_some_film", method = RequestMethod.GET, produces = "application/javascript; charset=UTF-8")
    public String getSomeFilm(@RequestParam int num, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        List<FilmEntity> filmEntities = filmService.findSomeFilms(num, false, false);

        if (filmEntities.size() == 0) {

            return "ch({\"result\": \"fail\", \"reason\": \"no such film\"})";
        }

        Gson gson = new Gson();

        return "ch({\"result\": \"success\", \"data\": " +
                gson.toJson(BuilderUtils.getFilmShower2sFromFilmEntities(filmEntities)) + "})";
    }

}
