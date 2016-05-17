package com.xx.nextfilm.controller;

import com.xx.nextfilm.dto.ShowingEditor;
import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.entity.FilmEntity;
import com.xx.nextfilm.entity.HallEntity;
import com.xx.nextfilm.service.CinemaService;
import com.xx.nextfilm.service.ShowingService;
import com.xx.nextfilm.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * Created by CuiH on 2016/5/17.
 */
@Controller
public class ShowingController {

    @Autowired
    ShowingService showService;

    @Autowired
    CinemaService cinemaService;

    @Autowired
    MessageSource messageSource;


    @RequestMapping(value = "/edit_cinema/{cinemaId}/add_show", method = RequestMethod.GET)
    public String addShow(@PathVariable Long cinemaId, ModelMap modelMap) {
        CinemaEntity cinemaEntity = cinemaService.findCinemaById(cinemaId, true, true ,false);

        if (cinemaEntity == null) {
            return "redirect:/fail";
        }

        ShowingEditor showingEditor = new ShowingEditor();
        showingEditor.setCinemaId(cinemaId);
        modelMap.addAttribute("showingEditor", showingEditor);

        List<FilmEntity> films = cinemaEntity.getFilms();
        modelMap.addAttribute("films", films);
        List<HallEntity> halls = cinemaEntity.getHalls();
        modelMap.addAttribute("halls", halls);

        return "add_show";
    }


    @RequestMapping(value = "/add_show", method = RequestMethod.POST)
    public String addShowHandler(@Valid ShowingEditor showingEditor, BindingResult result) {
        if (result.hasErrors()) {
            return "add_show";
        }

        if (!Utils.isDateValid(showingEditor.getStartTime())) {
            FieldError startTimeError = new FieldError("showingEditor", "startTime",
                    messageSource.getMessage("CH.invalid.date", null, Locale.getDefault()));
            result.addError(startTimeError);

            return "add_show";
        }

        if (!Utils.isDateValid(showingEditor.getEndTime())) {
            FieldError endTimeError = new FieldError("showingEditor", "endTime",
                    messageSource.getMessage("CH.invalid.date", null, Locale.getDefault()));
            result.addError(endTimeError);

            return "add_show";
        }

        boolean r = showService.createShow(showingEditor);

        if (r == true) {
            return "redirect:/success";
        } else {
            return "redirect:/fail";
        }
    }

}
