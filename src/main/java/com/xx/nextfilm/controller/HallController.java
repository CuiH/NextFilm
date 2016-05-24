package com.xx.nextfilm.controller;

import com.xx.nextfilm.dto.HallEditor;
import com.xx.nextfilm.entity.HallEntity;
import com.xx.nextfilm.service.CinemaService;
import com.xx.nextfilm.service.HallService;
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


    @RequestMapping(value = "/add_hall", method = RequestMethod.GET)
    public String addHall(@RequestParam Long cinemaId, ModelMap modelMap) {
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

        if (!ValidatorUtils.isShortValid(hallEditor.getRowNum())) {
            FieldError rowNumError = new FieldError("hallEditor", "rowNum",
                    messageSource.getMessage("CH.invalid.num", null, Locale.getDefault()));
            result.addError(rowNumError);

            return "add_hall";
        }

        if (!ValidatorUtils.isShortValid(hallEditor.getColumnNum())) {
            FieldError columnNumError = new FieldError("hallEditor", "columnNum",
                    messageSource.getMessage("CH.invalid.num", null, Locale.getDefault()));
            result.addError(columnNumError);

            return "add_hall";
        }

        boolean r = hallService.createHall(hallEditor);

        if (r) {
            return "redirect:/success";
        } else {
            return "redirect:/fail";
        }
    }


    @RequestMapping(value = "/edit_hall", method = RequestMethod.GET)
    public String editHall(@RequestParam Long id, ModelMap modelMap) {
        HallEditor hallEditor = hallService.getHallEditorById(id);

        if (hallEditor == null) {
            return "redirect:/fail";
        }

        modelMap.addAttribute(hallEditor);

        return "edit_hall";
    }


    @RequestMapping(value = "/edit_hall", method = RequestMethod.POST)
    public String editHallHandler(@Valid HallEditor hallEditor, BindingResult result) {
        if (result.hasErrors()) {
            return "edit_hall";
        }

        if (!ValidatorUtils.isShortValid(hallEditor.getRowNum())) {
            FieldError rowNumError = new FieldError("hallEditor", "rowNum",
                    messageSource.getMessage("CH.invalid.num", null, Locale.getDefault()));
            result.addError(rowNumError);

            return "add_hall";
        }

        if (!ValidatorUtils.isShortValid(hallEditor.getColumnNum())) {
            FieldError columnNumError = new FieldError("hallEditor", "columnNum",
                    messageSource.getMessage("CH.invalid.num", null, Locale.getDefault()));
            result.addError(columnNumError);

            return "add_hall";
        }

        boolean r = hallService.updateHall(hallEditor);

        if (r) {
            return "redirect:/success";
        } else {
            return "redirect:/fail";
        }
    }


    @RequestMapping(value = "/delete_hall", method = RequestMethod.GET)
    public String deleteHall(@RequestParam Long id) {
        HallEntity hallEntity = hallService.findHallById(id, false);

        if (hallEntity == null) {
            return "redirect:/fail";
        }

        hallService.deleteHall(hallEntity);

        return "redirect:/success";
    }

}
