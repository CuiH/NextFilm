package com.xx.nextfilm.controller;

import com.google.gson.Gson;
import com.xx.nextfilm.dto.editor.ShowingEditor1;
import com.xx.nextfilm.dto.editor.ShowingEditor2;
import com.xx.nextfilm.dto.shower.ShowingShower1;
import com.xx.nextfilm.dto.shower.ShowingShower2;
import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.entity.FilmEntity;
import com.xx.nextfilm.entity.ShowingEntity;
import com.xx.nextfilm.exception.*;
import com.xx.nextfilm.service.CinemaService;
import com.xx.nextfilm.service.FilmService;
import com.xx.nextfilm.service.ShowingService;
import com.xx.nextfilm.utils.BuilderUtils;
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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * Created by CuiH on 2016/5/17.
 */
@Controller
public class ShowingController {

    @Autowired
    ShowingService showingService;

    @Autowired
    CinemaService cinemaService;

    @Autowired
    FilmService filmService;

    @Autowired
    MessageSource messageSource;


    @RequestMapping(value = "/add_showing", method = RequestMethod.GET)
    public String addShowing(@RequestParam Long cinemaId, @RequestParam Long filmId, ModelMap modelMap) {
        try {
            CinemaEntity cinemaEntity = cinemaService.findCinemaById(cinemaId, false, true ,false);
            FilmEntity filmEntity = filmService.findFilmById(filmId, false, false);

            ShowingEditor1 showingEditor1 = new ShowingEditor1();
            showingEditor1.setCinemaId(cinemaId);
            showingEditor1.setFilm(BuilderUtils.getFilmShower3FromFilmEntity(filmEntity));

            modelMap.addAttribute("showingEditor1", showingEditor1);

            modelMap.addAttribute("halls", BuilderUtils.getHallShower2sFromHallEntities(cinemaEntity.getHalls()));

            return "add_showing";
        } catch (CinemaNotExistException e) {

            return "redirect:/fail";
        } catch (FilmNotExistException e) {

            return "redirect:/fail";
        }
    }


    @ResponseBody
    @RequestMapping(value = "/add_showing", method = RequestMethod.POST)
    public String addShowingHandler(@Valid ShowingEditor1 showingEditor1, BindingResult result) {
        if (result.hasErrors()) {

            return "{\"result\": \"fail\", \"reason\": \"maybe you forgot to fill in some fields\"}";
        }

        System.out.println(showingEditor1.getStartTime());

        if (!ValidatorUtils.isDateTimeValid(showingEditor1.getStartTime())) {
            FieldError startTimeError = new FieldError("showingEditor1", "startTime",
                    messageSource.getMessage("CH.invalid.date", null, Locale.getDefault()));
            result.addError(startTimeError);

            return "{\"result\": \"fail\", \"reason\": \"your start time is not valid\"}";
        }

        if (!ValidatorUtils.isDateTimeValid(showingEditor1.getEndTime())) {
            FieldError endTimeError = new FieldError("showingEditor1", "endTime",
                    messageSource.getMessage("CH.invalid.date", null, Locale.getDefault()));
            result.addError(endTimeError);

            return "{\"result\": \"fail\", \"reason\": \"your end time is not valid\"}";
        }

        try {
            showingService.createShowing(showingEditor1);

            return "{\"result\": \"success\", \"reason\": \"no content\"}";
        } catch (CinemaNotExistException e) {

            return "{\"result\": \"fail\", \"reason\": \"unknown cinema\"}";
        } catch (HallNotExistException e) {

            return "{\"result\": \"fail\", \"reason\": \"unknown hall\"}";
        } catch (FilmNotExistException e) {

            return "{\"result\": \"fail\", \"reason\": \"unknown film\"}";
        } catch (FCMNotExistException e) {

            return "{\"result\": \"fail\", \"reason\": \"unknown film_cinema_map\"}";
        } catch (UserNotLoginException e) {

            return "{\"result\": \"fail\", \"reason\": \"not login\"}";
        }
    }


    @RequestMapping(value = "/show_all_showing", method = RequestMethod.GET)
    public String showAllShowing(@RequestParam Long cinemaId, @RequestParam Long filmId, ModelMap modelMap) {
        try {
            CinemaEntity cinemaEntity = cinemaService.findCinemaById(cinemaId, false, false, false);
            FilmEntity filmEntity = filmService.findFilmById(filmId, false, false);

            List<ShowingShower2> showingShower2s = showingService.findShowingsByCinemaAndFilmWithShower2(cinemaEntity, filmEntity);
            modelMap.addAttribute("showings", showingShower2s);

            // 定向用
            modelMap.addAttribute("cinemaId", cinemaId);
            modelMap.addAttribute("filmId", filmEntity.getId());
            modelMap.addAttribute("filmName", filmEntity.getName());

            return "show_all_showing";
        } catch (CinemaNotExistException e) {

            return "redirect:/fail";
        } catch (FilmNotExistException e) {

            return "redirect:/fail";
        } catch (FCMNotExistException e) {

            return "redirect:/fail";
        }
    }


    @RequestMapping(value = "/edit_showing", method = RequestMethod.GET)
    public String editShowing(@RequestParam Long cinemaId, @RequestParam Long id, ModelMap modelMap) {
        try {
            ShowingEditor2 showingEditor2 = showingService.getShowingEditor2ById(id);
            showingEditor2.setCinemaId(cinemaId);

            modelMap.addAttribute("showingEditor2", showingEditor2);

            return "edit_showing";
        } catch (ShowingNotExistException e) {

            return "redirect:/fail";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/edit_showing", method = RequestMethod.POST)
    public String editShowingHandler(@Valid ShowingEditor2 showingEditor2, BindingResult result) {
        if (result.hasErrors()) {

            return "{\"result\": \"fail\", \"reason\": \"maybe you forgot to fill in some fields\"}";
        }

        if (!ValidatorUtils.isDateTimeValid(showingEditor2.getStartTime())) {
            FieldError startTimeError = new FieldError("showingEditor1", "startTime",
                    messageSource.getMessage("CH.invalid.date", null, Locale.getDefault()));
            result.addError(startTimeError);

            return "{\"result\": \"fail\", \"reason\": \"your start time is not valid\"}";
        }

        if (!ValidatorUtils.isDateTimeValid(showingEditor2.getEndTime())) {
            FieldError endTimeError = new FieldError("showingEditor1", "endTime",
                    messageSource.getMessage("CH.invalid.date", null, Locale.getDefault()));
            result.addError(endTimeError);

            return "{\"result\": \"fail\", \"reason\": \"your end time is not valid\"}";
        }

        try {
            boolean r = showingService.updateShowing(showingEditor2);

            if (r) {

                return "{\"result\": \"success\", \"reason\": \"no content\"}";
            } else {

                return "{\"result\": \"fail\", \"reason\": \"unknown error\"}";
            }
        } catch (UserNotLoginException e) {

            return "{\"result\": \"fail\", \"reason\": \"not login\"}";
        }
    }


    @ResponseBody
    @RequestMapping(value = "/view_showing", method = RequestMethod.GET, produces = "plain/text; charset=UTF-8")
    public String getShowing(@RequestParam Long id) {
        try {
            ShowingEntity showingEntity = showingService.findShowingById(id, true, true, true);

            Gson gson = new Gson();

            return "{\"result\": \"success\", \"data\": " +
                    gson.toJson(BuilderUtils.getShowingShower1FromShowingEntity(showingEntity)) + "}";
        } catch (ShowingNotExistException e) {


            return "{\"result\": \"fail\", \"reason\": \"unknown showing\"}";
        }
    }


    @ResponseBody
    @RequestMapping(value = "/delete_showing", method = RequestMethod.GET)
    public String deleteHall(@RequestParam Long id) {
        try {
            ShowingEntity showingEntity = showingService.findShowingById(id, false, false, false);
            showingService.deleteShowing(showingEntity);

            return "{\"result\": \"success\", \"reason\": \"no content\"}";
        } catch (ShowingNotExistException e) {

            return "{\"result\": \"fail\", \"reason\": \"unknown showing\"}";
        } catch (UserNotLoginException e) {

            return "{\"result\": \"fail\", \"reason\": \"not login\"}";
        }
    }

}
