package com.xx.nextfilm.controller;

import com.xx.nextfilm.dto.editor.ShowingEditor1;
import com.xx.nextfilm.dto.editor.ShowingEditor2;
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


    @RequestMapping(value = "/add_showing", method = RequestMethod.POST)
    public String addShowingHandler(@Valid ShowingEditor1 showingEditor1, BindingResult result) {
        if (result.hasErrors()) {

            return "add_showing";
        }

        if (!ValidatorUtils.isDateValid(showingEditor1.getStartTime())) {
            FieldError startTimeError = new FieldError("showingEditor1", "startTime",
                    messageSource.getMessage("CH.invalid.date", null, Locale.getDefault()));
            result.addError(startTimeError);

            return "add_showing";
        }

        if (!ValidatorUtils.isDateValid(showingEditor1.getEndTime())) {
            FieldError endTimeError = new FieldError("showingEditor1", "endTime",
                    messageSource.getMessage("CH.invalid.date", null, Locale.getDefault()));
            result.addError(endTimeError);

            return "add_showing";
        }

        try {
            showingService.createShowing(showingEditor1);

            return "redirect:/success";
        } catch (CinemaNotExistException e) {

            return "redirect:/fail";
        } catch (HallNotExistException e) {

            return "redirect:/fail";
        } catch (FilmNotExistException e) {

            return "redirect:/fail";
        } catch (FCMNotExistException e) {

            return "redirect:/fail";
        }
    }


    @RequestMapping(value = "/show_all_showing", method = RequestMethod.GET)
    public String showAllShowing(@RequestParam Long cinemaId, @RequestParam Long filmId, ModelMap modelMap) {
        try {
            CinemaEntity cinemaEntity = cinemaService.findCinemaById(cinemaId, false, false, false);
            FilmEntity filmEntity = filmService.findFilmById(filmId, false, false);

            List<ShowingShower2> showingShower2s = showingService.findShowingsByCinemaAndFilm(cinemaEntity, filmEntity);
            modelMap.addAttribute("showings", showingShower2s);
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
            modelMap.addAttribute("showingEditor2", showingEditor2);
            modelMap.addAttribute("cinemaId", cinemaId);

            return "edit_showing";
        } catch (ShowingNotExistException e) {

            return "redirect:/fail";
        }
    }


    @RequestMapping(value = "/edit_showing", method = RequestMethod.POST)
    public String editShowingHandler(@Valid ShowingEditor2 showingEditor2, BindingResult result) {
        if (result.hasErrors()) {

            return "edit_showing";
        }

        if (!ValidatorUtils.isDateValid(showingEditor2.getStartTime())) {
            FieldError startTimeError = new FieldError("showingEditor1", "startTime",
                    messageSource.getMessage("CH.invalid.date", null, Locale.getDefault()));
            result.addError(startTimeError);

            return "add_showing";
        }

        if (!ValidatorUtils.isDateValid(showingEditor2.getEndTime())) {
            FieldError endTimeError = new FieldError("showingEditor1", "endTime",
                    messageSource.getMessage("CH.invalid.date", null, Locale.getDefault()));
            result.addError(endTimeError);

            return "add_showing";
        }

        boolean r = showingService.updateShowing(showingEditor2);

        if (r) {

            return "redirect:/success";
        } else {

            return "redirect:/fail";
        }
    }

    @RequestMapping(value = "/delete_showing", method = RequestMethod.GET)
    public String deleteHall(@RequestParam Long id) {
        try {
            ShowingEntity showingEntity = showingService.findShowingById(id, false, false);
            showingService.deleteShowing(showingEntity);

            return "redirect:/success";
        } catch (ShowingNotExistException e) {

            return "redirect:/fail";
        }
    }

}
