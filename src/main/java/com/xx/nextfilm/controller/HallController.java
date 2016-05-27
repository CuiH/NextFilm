package com.xx.nextfilm.controller;

import com.xx.nextfilm.dto.editor.HallEditor;
import com.xx.nextfilm.entity.HallEntity;
import com.xx.nextfilm.exception.CinemaNotExistException;
import com.xx.nextfilm.exception.HallNotExistException;
import com.xx.nextfilm.service.CinemaService;
import com.xx.nextfilm.service.HallService;
import com.xx.nextfilm.utils.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

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

    @ResponseBody
    @RequestMapping(value = "/add_hall", method = RequestMethod.POST)
    public String addHallHandler(@Valid HallEditor hallEditor, BindingResult result) {
        if (result.hasErrors()) {

            return "{\"result\": \"fail\", \"reason\": \"maybe you forgot to fill in some fields\"}";
        }

        if (!ValidatorUtils.isShortValid(hallEditor.getRowNum())) {
            FieldError rowNumError = new FieldError("hallEditor", "rowNum",
                    messageSource.getMessage("CH.invalid.num", null, Locale.getDefault()));
            result.addError(rowNumError);

            return "{\"result\": \"fail\", \"reason\": \"your row num is not valid\"}";
        }

        if (!ValidatorUtils.isShortValid(hallEditor.getColumnNum())) {
            FieldError columnNumError = new FieldError("hallEditor", "columnNum",
                    messageSource.getMessage("CH.invalid.num", null, Locale.getDefault()));
            result.addError(columnNumError);

            return "{\"result\": \"fail\", \"reason\": \"your column num is not valid\"}";
        }

        try {
            hallService.createHall(hallEditor);

            return "{\"result\": \"success\", \"reason\": \"no content\"}";
        } catch (CinemaNotExistException e) {

            return "{\"result\": \"fail\", \"reason\": \"unknown cinema\"}";
        }
    }


    @RequestMapping(value = "/edit_hall", method = RequestMethod.GET)
    public String editHall(@RequestParam Long cinemaId, @RequestParam Long id, ModelMap modelMap) {
        try {
            HallEditor hallEditor = hallService.getHallEditorById(id);
            modelMap.addAttribute("hallEditor", hallEditor);
            modelMap.addAttribute("cinemaId", cinemaId);

            return "edit_hall";
        } catch (HallNotExistException e) {

            return "redirect:/fail";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/edit_hall", method = RequestMethod.POST)
    public String editHallHandler(@Valid HallEditor hallEditor, BindingResult result) {
        if (result.hasErrors()) {

            return "{\"result\": \"fail\", \"reason\": \"maybe you forgot to fill in some fields\"}";
        }

        if (!ValidatorUtils.isShortValid(hallEditor.getRowNum())) {
            FieldError rowNumError = new FieldError("hallEditor", "rowNum",
                    messageSource.getMessage("CH.invalid.num", null, Locale.getDefault()));
            result.addError(rowNumError);

            return "{\"result\": \"fail\", \"reason\": \"your row num is not valid\"}";
        }

        if (!ValidatorUtils.isShortValid(hallEditor.getColumnNum())) {
            FieldError columnNumError = new FieldError("hallEditor", "columnNum",
                    messageSource.getMessage("CH.invalid.num", null, Locale.getDefault()));
            result.addError(columnNumError);

            return "{\"result\": \"fail\", \"reason\": \"your column num is not valid\"}";
        }

        boolean r = hallService.updateHall(hallEditor);

        if (r) {

            return "{\"result\": \"success\", \"reason\": \"no content\"}";
        } else {

            return "{\"result\": \"fail\", \"reason\": \"unknown error\"}";
        }
    }


    @ResponseBody
    @RequestMapping(value = "/delete_hall", method = RequestMethod.GET)
    public String deleteHall(@RequestParam Long id) {
        try {
            HallEntity hallEntity = hallService.findHallById(id, false);
            hallService.deleteHall(hallEntity);

            return "{\"result\": \"success\", \"reason\": \"no content\"}";
        } catch (HallNotExistException e) {

            return "{\"result\": \"fail\", \"reason\": \"unknown hall\"}";
        }
    }


    @ModelAttribute("types")
    public String[] initializeTypes() {
        return new String[]{"普通", "巨幕", "IMAX"};
    }

}
