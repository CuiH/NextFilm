package com.xx.nextfilm.controller;

import com.xx.nextfilm.dto.ActorShower2;
import com.xx.nextfilm.dto.FilmEditor;
import com.xx.nextfilm.dto.FilmShower1;
import com.xx.nextfilm.entity.FilmEntity;
import com.xx.nextfilm.service.ActorService;
import com.xx.nextfilm.service.FilmService;
import com.xx.nextfilm.utils.ConverterUtils;
import com.xx.nextfilm.utils.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * Created by CuiH on 2016/5/15.
 */
@Controller
public class FilmController {

    @Autowired
    FilmService filmService;

    @Autowired
    ActorService actorService;

    @Autowired
    MessageSource messageSource;


    @RequestMapping(value = "/add_film", method = RequestMethod.GET)
    public String addFilm(ModelMap modelMap) {
        FilmEditor filmEditor = new FilmEditor();
        modelMap.addAttribute("filmEditor", filmEditor);

        List<ActorShower2> actors = actorService.findAllActorsWithShower2();
        modelMap.addAttribute("actors", actors);
        modelMap.addAttribute("directors", actors);

        return "add_film";
    }

    @RequestMapping(value = "/add_film", method = RequestMethod.POST)
    public String addFilmHandler(@Valid FilmEditor filmEditor, BindingResult result) {
        if (result.hasErrors()) {
            return "add_film";
        }

        // 检查onDate是否合法
        String onDate = filmEditor.getOnDate();
        if (!ValidatorUtils.isDateValid(onDate)) {
            FieldError onDateError = new FieldError("filmEditor", "onDate",
                    messageSource.getMessage("CH.invalid.date", null, Locale.getDefault()));
            result.addError(onDateError);

            return "add_film";
        }

        filmService.createFilm(filmEditor);

        return "redirect:/success";
    }


    @RequestMapping(value = "/show_all_film", method = RequestMethod.GET)
    public String showAllFilm(ModelMap modelMap) {
        List<FilmShower1> allFilms = filmService.findAllFilmsWithShower1();
        modelMap.addAttribute("films", allFilms);

        return "show_all_film";
    }


    @RequestMapping(value = "/edit_film", method = RequestMethod.GET)
    public String editFilm(@RequestParam Long id, ModelMap modelMap) {
        FilmEditor filmEditor = filmService.getFilmEditorById(id);

        if (filmEditor == null) {
            return "redirect:/fail";
        }

        modelMap.addAttribute("filmEditor", filmEditor);

        List<ActorShower2> actors = actorService.findAllActorsWithShower2();
        modelMap.addAttribute("actors", actors);
        modelMap.addAttribute("directors", actors);

        return "edit_film";
    }


    @RequestMapping(value = "/edit_film", method = RequestMethod.POST)
    public String editFilmHandler(@Valid FilmEditor filmEditor, BindingResult result) {
        if (result.hasErrors()) {
            return "edit_film";
        }

        // 检查birthday是否合法
        String onDate = filmEditor.getOnDate();
        if (!ValidatorUtils.isDateValid(onDate)) {
            FieldError onDateError = new FieldError("filmEditor", "onDate",
                    messageSource.getMessage("CH.invalid.date", null, Locale.getDefault()));
            result.addError(onDateError);

            return "edit_film";
        }

        filmService.updateFilm(filmEditor);

        return "redirect:/success";
    }


    @RequestMapping(value = "/delete_film", method = RequestMethod.GET)
    public String deleteFilm(@RequestParam Long id) {
        FilmEntity filmEntity = filmService.findFilmById(id, false, false);

        if (filmEntity == null) {
            return "redirect:/fail";
        }

        filmService.deleteFilm(filmEntity);

        return "redirect:/success";
    }

}
