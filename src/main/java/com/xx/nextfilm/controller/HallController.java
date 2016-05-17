package com.xx.nextfilm.controller;

import com.xx.nextfilm.dto.HallEditor;
import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.entity.HallEntity;
import com.xx.nextfilm.service.CinemaService;
import com.xx.nextfilm.service.HallService;
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
import java.util.Locale;

/**
 * Created by CuiH on 2016/5/17.
 */
@Controller
public class HallController {

    @Autowired
    HallService hallService;

    @Autowired
    CinemaService cinemaService;

    @Autowired
    MessageSource messageSource;


    @RequestMapping(value = "/edit_cinema/{cinemaId}/add_hall", method = RequestMethod.GET)
    public String addHall(@PathVariable Long cinemaId, ModelMap modelMap) {
        HallEditor hallEditor = new HallEditor();
        hallEditor.setCinemaId(cinemaId);
        modelMap.addAttribute(hallEditor);

        return "add_hall";
    }

    @RequestMapping(value = "/add_hall", method = RequestMethod.POST)
    public String addHallHandler(@Valid HallEditor hallEditor, BindingResult result) {
        if (result.hasErrors()) {
            return "add_hall";
        }

        if (!Utils.isNumValid(hallEditor.getRowNum())) {
            FieldError birthdayError = new FieldError("hallEditor", "rowNum",
                    messageSource.getMessage("CH.invalid.num", null, Locale.getDefault()));
            result.addError(birthdayError);

            return "add_hall";
        }

        if (!Utils.isNumValid(hallEditor.getColumnNum())) {
            FieldError birthdayError = new FieldError("hallEditor", "columnNum",
                    messageSource.getMessage("CH.invalid.num", null, Locale.getDefault()));
            result.addError(birthdayError);

            return "add_hall";
        }

        boolean r = hallService.createHall(hallEditor);

        if (r == true) {
            return "redirect:/success";
        } else {
            return "redirect:/fail";
        }
    }


    @RequestMapping(value = "/edit_cinema/{cinemaId}/edit_hall/{hallId}", method = RequestMethod.GET)
    public String editHall(@PathVariable Long cinemaId, @PathVariable Long hallId, ModelMap modelMap) {
        HallEditor hallEditor = hallService.getHallEditorById(hallId);

        if (hallEditor == null) {
            return "redirect:/fail";
        }

        hallEditor.setCinemaId(cinemaId);

        modelMap.addAttribute(hallEditor);

        return "edit_hall";
    }


    @RequestMapping(value = "/edit_hall", method = RequestMethod.POST)
    public String editHallHandler(@Valid HallEditor hallEditor, BindingResult result) {
        if (result.hasErrors()) {
            return "edit_hall";
        }

        if (!Utils.isNumValid(hallEditor.getRowNum())) {
            FieldError birthdayError = new FieldError("hallEditor", "rowNum",
                    messageSource.getMessage("CH.invalid.num", null, Locale.getDefault()));
            result.addError(birthdayError);

            return "add_hall";
        }

        if (!Utils.isNumValid(hallEditor.getColumnNum())) {
            FieldError birthdayError = new FieldError("hallEditor", "columnNum",
                    messageSource.getMessage("CH.invalid.num", null, Locale.getDefault()));
            result.addError(birthdayError);

            return "add_hall";
        }

        boolean r = hallService.updateHall(hallEditor);

        return "redirect:/success";
    }


    @RequestMapping(value = "/delete_hall/{id}", method = RequestMethod.GET)
    public String deleteHall(@PathVariable Long id) {
        HallEntity hallEntity = hallService.findHallById(id);
        if (hallEntity == null) {
            return "redirect:/fail";
        }

        hallService.deleteHall(hallEntity);

        return "redirect:/success";
    }

}
