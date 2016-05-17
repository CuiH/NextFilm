package com.xx.nextfilm.controller;

import com.xx.nextfilm.dto.CinemaEditor;
import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.service.CinemaService;
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
 * Created by CuiH on 2016/5/16.
 */
@Controller
public class CinemaController {

    @Autowired
    CinemaService cinemaService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "/add_cinema", method = RequestMethod.GET)
    public String addCinema(ModelMap modelMap) {
        CinemaEditor cinemaEditor = new CinemaEditor();
        modelMap.addAttribute(cinemaEditor);

        return "add_cinema";
    }

    @RequestMapping(value = "/add_cinema", method = RequestMethod.POST)
    public String addActorHandler(@Valid CinemaEditor cinemaEditor, BindingResult result) {
        if (result.hasErrors()) {
            return "add_cinema";
        }

        // 检查city是否合法
        String city = cinemaEditor.getCity();
        if (!Utils.isCityValid(city)) {
            FieldError cityError = new FieldError("cinemaEditor", "city",
                    messageSource.getMessage("CH.invalid.city", null, Locale.getDefault()));
            result.addError(cityError);

            return "add_cinema";
        }

        cinemaService.createCinema(cinemaEditor);

        return "redirect:/success";
    }


    @RequestMapping(value = "/show_all_cinema", method = RequestMethod.GET)
    public String showAllActor(ModelMap modelMap) {
        List<CinemaEntity> allCinemas = cinemaService.findAllCinemas();

        modelMap.addAttribute("cinemas", allCinemas);

        return "show_all_cinema";
    }


    @RequestMapping(value = "/edit_cinema/{id}", method = RequestMethod.GET)
    public String editCinema(@PathVariable Long id, ModelMap modelMap) {
        CinemaEditor cinemaEditor = cinemaService.getCinemaEditorById(id);

        if (cinemaEditor == null) {
            return "redirect:/fail";
        }

        modelMap.addAttribute(cinemaEditor);

        return "edit_cinema";
    }


    @RequestMapping(value = "/edit_cinema", method = RequestMethod.POST)
    public String editCinemaHandler(@Valid CinemaEditor cinemaEditor, BindingResult result) {
        if (result.hasErrors()) {
            return "edit_cinema";
        }

        // 检查city是否合法
        String city = cinemaEditor.getCity();
        if (!Utils.isCityValid(city)) {
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
        CinemaEntity cinemaEntity = cinemaService.findCinemaById(id);
        if (cinemaEntity == null) {
            return "redirect:/fail";
        }

        cinemaService.deleteCinema(cinemaEntity);

        return "redirect:/success";
    }

}
