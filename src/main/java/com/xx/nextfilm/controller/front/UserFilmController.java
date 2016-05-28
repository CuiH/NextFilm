package com.xx.nextfilm.controller.front;

import com.google.gson.Gson;
import com.xx.nextfilm.entity.FilmEntity;
import com.xx.nextfilm.service.FilmService;
import com.xx.nextfilm.utils.BuilderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cuihao on 2016/5/28.
 */
@Controller
public class UserFilmController {

    @Autowired
    FilmService filmService;

    @ResponseBody
    @RequestMapping(value = "/get_film", method = RequestMethod.GET, produces = "plain/text; charset=UTF-8")
    public String viewReservation(@RequestParam String name) {
        List<FilmEntity> filmEntities = filmService.findFilmsByName(name, true, true);

        if (filmEntities.size() == 0) {

            return "{\"result\": \"fail\", \"reason\": \"no such film\"}";
        }

        Gson gson = new Gson();

        return "{\"result\": \"success\", \"data\": " +
                gson.toJson(BuilderUtils.getFilmShower4sFromFilmEntities(filmEntities)) + "}";
    }

}
