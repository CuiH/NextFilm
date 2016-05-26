package com.xx.nextfilm.controller;

import com.xx.nextfilm.dto.editor.FilmEditor;
import com.xx.nextfilm.dto.shower.FilmShower2;
import com.xx.nextfilm.entity.FilmEntity;
import com.xx.nextfilm.exception.FilmNotExistException;
import com.xx.nextfilm.service.ActorService;
import com.xx.nextfilm.service.FilmService;
import com.xx.nextfilm.utils.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

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

        return "add_film";
    }

    @ResponseBody
    @RequestMapping(value = "/add_film", method = RequestMethod.POST)
    public String addFilmHandler(@Valid FilmEditor filmEditor, BindingResult result) {
        if (result.hasErrors()) {

            return "fail";
        }

        // 检查onDate是否合法
        String onDate = filmEditor.getOnDate();
        if (!ValidatorUtils.isDateValid(onDate)) {
            FieldError onDateError = new FieldError("filmEditor", "onDate",
                    messageSource.getMessage("CH.invalid.date", null, Locale.getDefault()));
            result.addError(onDateError);

            return "fail";
        }

        filmService.createFilm(filmEditor);

        return "success";
    }


    @RequestMapping(value = "/show_all_film", method = RequestMethod.GET)
    public String showAllFilm(ModelMap modelMap) {
        List<FilmShower2> allFilms = filmService.findAllFilmsWithShower2();
        modelMap.addAttribute("films", allFilms);

        return "show_all_film";
    }


    @RequestMapping(value = "/edit_film", method = RequestMethod.GET)
    public String editFilm(@RequestParam Long id, ModelMap modelMap) {
        try {
            FilmEditor filmEditor = filmService.getFilmEditorById(id);
            modelMap.addAttribute("filmEditor", filmEditor);

            return "edit_film";
        } catch (FilmNotExistException e) {

            return "redirect:/fail";
        }
    }


    @ResponseBody
    @RequestMapping(value = "/edit_film", method = RequestMethod.POST)
    public String editFilmHandler(@Valid FilmEditor filmEditor, BindingResult result) {
        if (result.hasErrors()) {

            return "fail";
        }

        // 检查birthday是否合法
        String onDate = filmEditor.getOnDate();
        if (!ValidatorUtils.isDateValid(onDate)) {
            FieldError onDateError = new FieldError("filmEditor", "onDate",
                    messageSource.getMessage("CH.invalid.date", null, Locale.getDefault()));
            result.addError(onDateError);

            return "fail";
        }

        filmService.updateFilm(filmEditor);

        return "success";
    }


    @RequestMapping(value = "/delete_film", method = RequestMethod.GET)
    public String deleteFilm(@RequestParam Long id) {
        try {
            FilmEntity filmEntity = filmService.findFilmById(id, false, false);
            filmService.deleteFilm(filmEntity);

            return "redirect:/success";
        } catch (FilmNotExistException e) {

            return "redirect:/fail";
        }
    }


    @ModelAttribute("types")
    public String[] initializeTypes() {
        return new String[]{"2D", "3D"};
    }

    @ModelAttribute("categories")
    public String[] initializeCategories() {
        return new String[]{"喜剧", "惊悚", "剧情"};
    }

}
