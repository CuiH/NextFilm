package com.xx.nextfilm.controller;

import com.xx.nextfilm.dto.ActorEditor;
import com.xx.nextfilm.dto.ActorShower1;
import com.xx.nextfilm.dto.Visitor;
import com.xx.nextfilm.entity.ActorEntity;
import com.xx.nextfilm.service.ActorService;
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
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * Created by CuiH on 2016/5/15.
 */
@Controller
public class ActorController {

    @Autowired
    ActorService actorService;

    @Autowired
    MessageSource messageSource;


    @RequestMapping(value = "/add_actor", method = RequestMethod.GET)
    public String addActor(ModelMap modelMap) {
        ActorEditor actorEditor = new ActorEditor();
        modelMap.addAttribute(actorEditor);

        return "add_actor";
    }

    @RequestMapping(value = "/add_actor", method = RequestMethod.POST)
    public String addActorHandler(@Valid ActorEditor actorEditor, BindingResult result) {
        if (result.hasErrors()) {
            return "add_actor";
        }

        // 检查birthday是否合法
        String birthday = actorEditor.getBirthday();
        if (!Utils.isDateValid(birthday)) {
            FieldError birthdayError = new FieldError("actorEditor", "birthday",
                    messageSource.getMessage("CH.invalid.birthday", null, Locale.getDefault()));
            result.addError(birthdayError);

            return "add_actor";
        }

        actorService.createActor(actorEditor);

        return "redirect:/success";
    }


    @RequestMapping(value = "/show_all_actor", method = RequestMethod.GET)
    public String showAllActor(ModelMap modelMap) {
        List<ActorShower1> allActors = actorService.findAllActorsWithShower1();

        modelMap.addAttribute("actors", allActors);

        return "show_all_actor";
    }


    @RequestMapping(value = "/edit_actor", method = RequestMethod.GET)
    public String editActor(@RequestParam Long id, ModelMap modelMap) {
        ActorEditor actorEditor = actorService.getActorEditorById(id);

        if (actorEditor == null) {
            return "redirect:/fail";
        }

        modelMap.addAttribute(actorEditor);

        return "edit_actor";
    }


    @RequestMapping(value = "/edit_actor", method = RequestMethod.POST)
    public String editActorHandler(@Valid ActorEditor actorEditor, BindingResult result) {
        if (result.hasErrors()) {
            return "edit_actor";
        }

        // 检查birthday是否合法
        String birthday = actorEditor.getBirthday();
        if (!Utils.isDateValid(birthday)) {
            FieldError birthdayError = new FieldError("actorEditor", "birthday",
                    messageSource.getMessage("CH.invalid.birthday", null, Locale.getDefault()));
            result.addError(birthdayError);

            return "edit_actor";
        }

        actorService.updateActor(actorEditor);

        return "redirect:/success";
    }


    @RequestMapping(value = "/delete_actor", method = RequestMethod.GET)
    public String deleteActor(@RequestParam Long id) {
        ActorEntity actorEntity = actorService.findActorById(id);
        if (actorEntity == null) {
            return "redirect:/fail";
        }

        actorService.deleteActor(actorEntity);

        return "redirect:/success";
    }

}
