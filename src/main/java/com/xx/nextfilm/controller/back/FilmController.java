package com.xx.nextfilm.controller.back;

import com.google.gson.Gson;
import com.xx.nextfilm.dto.editor.FilmEditor;
import com.xx.nextfilm.dto.shower.FilmShower2;
import com.xx.nextfilm.entity.ActorEntity;
import com.xx.nextfilm.entity.FilmEntity;
import com.xx.nextfilm.exception.ActorNotExistException;
import com.xx.nextfilm.exception.FilmNotExistException;
import com.xx.nextfilm.exception.UserNotLoginException;
import com.xx.nextfilm.service.ActorService;
import com.xx.nextfilm.service.FilmService;
import com.xx.nextfilm.utils.BuilderUtils;
import com.xx.nextfilm.utils.ValidatorUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
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

            return "{\"result\": \"fail\", \"reason\": \"maybe you forgot to fill in some fields\"}";
        }

        // 检查onDate是否合法
        String onDate = filmEditor.getOnDate();
        if (!ValidatorUtils.isDateValid(onDate)) {
            FieldError onDateError = new FieldError("filmEditor", "onDate",
                    messageSource.getMessage("CH.invalid.date", null, Locale.getDefault()));
            result.addError(onDateError);

            return "{\"result\": \"fail\", \"reason\": \"your onDate is not valid\"}";
        }

        try {

            filmService.createFilm(filmEditor);

            return "{\"result\": \"success\", \"reason\": \"no content\"}";
        } catch (ActorNotExistException e) {

            return "{\"result\": \"fail\", \"reason\": \"unknown actor\"}";
        } catch (UserNotLoginException e) {

            return "{\"result\": \"fail\", \"reason\": \"not login\"}";
        }
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
    @RequestMapping(value = "/edit_film", method = RequestMethod.POST, produces = "plain/text; charset=UTF-8")
    public String editFilmHandler(@Valid FilmEditor filmEditor, BindingResult result) {
        if (result.hasErrors()) {

            return "{\"result\": \"fail\", \"reason\": \"maybe you forgot to fill in some fields\"}";
        }

        // 检查birthday是否合法
        String onDate = filmEditor.getOnDate();
        if (!ValidatorUtils.isDateValid(onDate)) {
            FieldError onDateError = new FieldError("filmEditor", "onDate",
                    messageSource.getMessage("CH.invalid.date", null, Locale.getDefault()));
            result.addError(onDateError);

            return "{\"result\": \"fail\", \"reason\": \"your onDate is not valid\"}";
        }

        try {
            filmService.updateFilm(filmEditor);

            return "{\"result\": \"success\", \"reason\": \"no content\"}";
        } catch (ActorNotExistException e) {

            return "{\"result\": \"fail\", \"reason\": \"unknown actor\"}";
        } catch (UserNotLoginException e) {

            return "{\"result\": \"fail\", \"reason\": \"not login\"}";
        }
    }


    @ResponseBody
    @RequestMapping(value = "/find_film", method = RequestMethod.GET)
    public String findActor(@RequestParam String name) {
        List<FilmEntity> films = filmService.findFilmsByName(name);

        if (films.size() == 0) {

            return "{\"result\": \"fail\", \"reason\": \"no such film\"}";
        } else {
            Gson gson = new Gson();

            return "{\"result\": \"success\", \"data\": " +
                    gson.toJson(BuilderUtils.getFilmShower2sFromFilmEntities(films)) + "}";
        }
    }


    @ResponseBody
    @RequestMapping(value = "/delete_film", method = RequestMethod.GET)
    public String deleteFilm(@RequestParam Long id) {
        try {
            FilmEntity filmEntity = filmService.findFilmById(id, false, false);
            filmService.deleteFilm(filmEntity);

            return "{\"result\": \"success\", \"reason\": \"no content\"}";
        } catch (FilmNotExistException e) {

            return "{\"result\": \"fail\", \"reason\": \"unknown film\"}";
        } catch (UserNotLoginException e) {

            return "{\"result\": \"fail\", \"reason\": \"not login\"}";
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
