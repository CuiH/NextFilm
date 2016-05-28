package com.xx.nextfilm.controller.back;

import com.google.gson.Gson;
import com.xx.nextfilm.dto.editor.ActorEditor;
import com.xx.nextfilm.dto.shower.ActorShower1;
import com.xx.nextfilm.entity.ActorEntity;
import com.xx.nextfilm.entity.CustomUserInfo;
import com.xx.nextfilm.exception.ActorNotExistException;
import com.xx.nextfilm.exception.UserNotLoginException;
import com.xx.nextfilm.service.ActorService;
import com.xx.nextfilm.utils.BuilderUtils;
import com.xx.nextfilm.utils.ValidatorUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
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

    @ResponseBody
    @RequestMapping(value = "/add_actor", method = RequestMethod.POST)
    public String addActorHandler(@Valid ActorEditor actorEditor, BindingResult result) {
        if (result.hasErrors()) {

            return "{\"result\": \"fail\", \"reason\": \"maybe you forgot to fill in some fields\"}";
        }

        // 检查birthday是否合法
        String birthday = actorEditor.getBirthday();
        if (!ValidatorUtils.isDateValid(birthday)) {
            FieldError birthdayError = new FieldError("actorEditor", "birthday",
                    messageSource.getMessage("CH.invalid.birthday", null, Locale.getDefault()));
            result.addError(birthdayError);

            return "{\"result\": \"fail\", \"reason\": \"your birthday is not valid\"}";
        }

        try {
            actorService.createActor(actorEditor);
        } catch (UserNotLoginException e) {

            return "{\"result\": \"fail\", \"reason\": \"not login\"}";
        }


        return "{\"result\": \"success\", \"reason\": \"no content\"}";
    }


    @RequestMapping(value = "/show_all_actor", method = RequestMethod.GET)
    public String showAllActor(ModelMap modelMap) {
        List<ActorShower1> allActors = actorService.findAllActorsWithShower1();

        modelMap.addAttribute("actors", allActors);

        return "show_all_actor";
    }


    @RequestMapping(value = "/edit_actor", method = RequestMethod.GET)
    public String editActor(@RequestParam Long id, ModelMap modelMap) {
        try {
            ActorEditor actorEditor = actorService.getActorEditorById(id);
            modelMap.addAttribute(actorEditor);

            return "edit_actor";
        } catch (ActorNotExistException e) {

            return "redirect:/fail";
        }
    }


    @ResponseBody
    @RequestMapping(value = "/edit_actor", method = RequestMethod.POST)
    public String editActorHandler(@Valid ActorEditor actorEditor, BindingResult result) {
        if (result.hasErrors()) {

            return "{\"result\": \"fail\", \"reason\": \"maybe you forgot to fill in some fields\"}";
        }

        // 检查birthday是否合法
        String birthday = actorEditor.getBirthday();
        if (!ValidatorUtils.isDateValid(birthday)) {
            FieldError birthdayError = new FieldError("actorEditor", "birthday",
                    messageSource.getMessage("CH.invalid.birthday", null, Locale.getDefault()));
            result.addError(birthdayError);

            return "{\"result\": \"fail\", \"reason\": \"your birthday is not valid\"}";
        }

        try {
            actorService.updateActor(actorEditor);
        } catch (UserNotLoginException e) {

            return "{\"result\": \"fail\", \"reason\": \"not login\"}";
        }


        return "{\"result\": \"success\", \"reason\": \"no content\"}";
    }


    @ResponseBody
    @RequestMapping(value = "/find_actor", method = RequestMethod.GET, produces = "plain/text; charset=UTF-8")
    public String findActor(@RequestParam String name) {
        List<ActorEntity> actors = actorService.findActorsByName(name);

        if (actors.size() == 0) {

            return "{\"result\": \"fail\", \"reason\": \"no such actor\"}";
        } else {
            Gson gson = new Gson();

            return "{\"result\": \"success\", \"data\": " +
                    gson.toJson(BuilderUtils.getActorShower2sFromActorEntities(actors)) + "}";
        }
    }


    @ResponseBody
    @RequestMapping(value = "/delete_actor", method = RequestMethod.GET)
    public String deleteActor(@RequestParam Long id) {
        try {
            ActorEntity actorEntity = actorService.findActorById(id);

            actorService.deleteActor(actorEntity);

            return "{\"result\": \"success\", \"reason\": \"no content\"}";
        } catch (ActorNotExistException e) {

            return "{\"result\": \"fail\", \"reason\": \"unknown actor\"}";
        } catch (UserNotLoginException e) {

            return "{\"result\": \"fail\", \"reason\": \"not login\"}";
        }
    }

}
