package com.xx.nextfilm.controller;

import com.google.gson.Gson;
import com.xx.nextfilm.dto.*;
import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.entity.HallEntity;
import com.xx.nextfilm.exception.CinemaNotExistException;
import com.xx.nextfilm.service.CinemaService;
import com.xx.nextfilm.service.FilmService;
import com.xx.nextfilm.service.HallService;
import com.xx.nextfilm.utils.BuilderUtils;
import com.xx.nextfilm.utils.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by CuiH on 2016/5/16.
 */
@Controller
public class CinemaController {

    @Autowired
    CinemaService cinemaService;

    @Autowired
    FilmService filmService;

    @Autowired
    HallService hallService;

    @Autowired
    MessageSource messageSource;


    @RequestMapping(value = "/add_cinema", method = RequestMethod.GET)
    public String addCinema(ModelMap modelMap) {
        CinemaEditor cinemaEditor = new CinemaEditor();
        modelMap.addAttribute("cinemaEditor", cinemaEditor);

        return "add_cinema";
    }

    @RequestMapping(value = "/add_cinema", method = RequestMethod.POST)
    public String addCinemaHandler(@Valid CinemaEditor cinemaEditor, BindingResult result) {
        if (result.hasErrors()) {
            return "add_cinema";
        }

        // 检查city是否合法
        String city = cinemaEditor.getCity();
        if (!ValidatorUtils.isCityValid(city)) {
            FieldError cityError = new FieldError("cinemaEditor", "city",
                    messageSource.getMessage("CH.invalid.city", null, Locale.getDefault()));
            result.addError(cityError);

            return "add_cinema";
        }

        cinemaService.createCinema(cinemaEditor);

        return "redirect:/success";
    }


    // 返回的“response”为状态，“films”为所有影片信息（包括是否上映）
    @ResponseBody
    @RequestMapping(value = "/increase_film", method = RequestMethod.GET)
    public String increaseFilm(@RequestParam Long cinemaId) {
        try {
            List<Long> filmIds = cinemaService.getAllShowingFilmIdsById(cinemaId);
            List<FilmShower3> allFilms = filmService.findAllFilmsWithShower3();

            Gson gson = new Gson();

            return "{\"result\": \"success\", \"films\": " +
                    gson.toJson(BuilderUtils.getShowingFilmShower(allFilms, filmIds)) + "}";
        } catch (CinemaNotExistException e) {
            return "{\"result\": \"fail\", \"reason\": \"cinema not exist\"}";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/increase_film", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> increaseFilmHandler(
            @RequestParam Long cinemaId, ShowingFilmEditor showingFilmEditor) {

        Map<String, String> response = new HashMap<String, String>();
        response.put("result", "success");
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
    }


    @RequestMapping(value = "/show_all_cinema", method = RequestMethod.GET)
    public String showAllCinema(ModelMap modelMap) {
        List<CinemaShower2> allCinemas = cinemaService.findAllCinemasWithShower2();
        modelMap.addAttribute("cinemas", allCinemas);

        return "show_all_cinema";
    }


    @RequestMapping(value = "/edit_cinema", method = RequestMethod.GET)
    public String editCinema(@RequestParam Long id, ModelMap modelMap) {
        CinemaEditor cinemaEditor = cinemaService.getCinemaEditorById(id, true, true, true);

        if (cinemaEditor == null) {
            return "redirect:/fail";
        }

        modelMap.addAttribute("cinemaEditor", cinemaEditor);

        return "edit_cinema";
    }


    @RequestMapping(value = "/edit_cinema", method = RequestMethod.POST)
    public String editCinemaHandler(@Valid CinemaEditor cinemaEditor, BindingResult result) {
        if (result.hasErrors()) {
            return "edit_cinema";
        }

        // 检查city是否合法
        String city = cinemaEditor.getCity();
        if (!ValidatorUtils.isCityValid(city)) {
            FieldError cityError = new FieldError("cinemaEditor", "city",
                    messageSource.getMessage("CH.invalid.city", null, Locale.getDefault()));
            result.addError(cityError);

            return "edit_cinema";
        }

        cinemaService.updateCinema(cinemaEditor);

        return "redirect:/success";
    }



    @RequestMapping(value = "/delete_cinema/{id}", method = RequestMethod.GET)
    public String deleteCinema(@PathVariable Long id) {
        // 要获取hall手动删除
        CinemaEntity cinema = cinemaService.findCinemaById(id, false, true, false);

        if (cinema == null) {
            return "redirect:/fail";
        }

        // 要先删hall信息，再删FCM的条目，但是hibernate删除的顺序有问题，只好手动删除
        // 而且如果放在service里做也不行，不知道为什么
        List<HallEntity> halls = cinema.getHalls();
        if (halls != null) {
            for (HallEntity hall: halls) {
                hallService.deleteHall(hall);
            }
        }

        cinemaService.deleteCinema(cinema);

        return "redirect:/success";
    }

}
