package com.xx.nextfilm.controller.back;

import com.google.gson.Gson;
import com.xx.nextfilm.dto.editor.CinemaEditor;
import com.xx.nextfilm.dto.editor.ShowingFilmEditor;
import com.xx.nextfilm.dto.shower.CinemaShower2;
import com.xx.nextfilm.dto.shower.FilmShower3;
import com.xx.nextfilm.entity.CinemaEntity;
import com.xx.nextfilm.entity.HallEntity;
import com.xx.nextfilm.exception.CinemaNotExistException;
import com.xx.nextfilm.exception.FilmNotExistException;
import com.xx.nextfilm.exception.UserNotLoginException;
import com.xx.nextfilm.service.CinemaService;
import com.xx.nextfilm.service.FCMService;
import com.xx.nextfilm.service.FilmService;
import com.xx.nextfilm.service.HallService;
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

import javax.validation.Valid;
import java.util.*;

/**
 * Created by CuiH on 2016/5/16.
 */
@Controller
public class CinemaController {

    @Autowired
    CinemaService cinemaService;

    @Autowired
    FilmService filmService;

    @Autowired
    HallService hallService;

    @Autowired
    FCMService fcmService;

    @Autowired
    MessageSource messageSource;


    @RequestMapping(value = "/add_cinema", method = RequestMethod.GET)
    public String addCinema(ModelMap modelMap) {
        CinemaEditor cinemaEditor = new CinemaEditor();
        modelMap.addAttribute("cinemaEditor", cinemaEditor);

        return "add_cinema";
    }

    @ResponseBody
    @RequestMapping(value = "/add_cinema", method = RequestMethod.POST)
    public String addCinemaHandler(@Valid CinemaEditor cinemaEditor, BindingResult result) {
        if (result.hasErrors()) {

            return "{\"result\": \"fail\", \"reason\": \"maybe you forgot to fill in some fields\"}";
        }

        // 检查city是否合法
        String city = cinemaEditor.getCity();
        if (!ValidatorUtils.isCityValid(city)) {
            FieldError cityError = new FieldError("cinemaEditor", "city",
                    messageSource.getMessage("CH.invalid.city", null, Locale.getDefault()));
            result.addError(cityError);

            return "{\"result\": \"fail\", \"reason\": \"your city is not valid\"}";
        }

        try {
            cinemaService.createCinema(cinemaEditor);
        } catch (UserNotLoginException e) {

            return "{\"result\": \"fail\", \"reason\": \"not login\"}";
        }

        return "{\"result\": \"success\", \"reason\": \"no content\"}";
    }


    @ResponseBody
    @RequestMapping(value = "/edit_showing_film", method = RequestMethod.POST)
    public String increaseFilmHandler(ShowingFilmEditor showingFilmEditor) {
        try {
            fcmService.updateFCM(showingFilmEditor.getCinemaId(), showingFilmEditor.getFilmIds());

            return "{\"result\": \"success\", \"reason\": \"no content\"}";
        } catch (CinemaNotExistException e) {

            return "{\"result\": \"fail\", \"reason\": \"unknown cinema\"}";
        } catch (FilmNotExistException e) {

            return "{\"result\": \"fail\", \"reason\": \"unknown film\"}";
        } catch (UserNotLoginException e) {

            return "{\"result\": \"fail\", \"reason\": \"not login\"}";
        }
    }


    @RequestMapping(value = "/show_all_cinema", method = RequestMethod.GET)
    public String showAllCinema(ModelMap modelMap) {
        List<CinemaShower2> allCinemas = cinemaService.findAllCinemasWithShower2();
        modelMap.addAttribute("cinemas", allCinemas);

        return "show_all_cinema";
    }


    @RequestMapping(value = "/edit_cinema", method = RequestMethod.GET)
    public String editCinema(@RequestParam Long id, ModelMap modelMap) {
        try {
            CinemaEditor cinemaEditor = cinemaService.getCinemaEditorById(id);
            modelMap.addAttribute("cinemaEditor", cinemaEditor);

            return "edit_cinema";
        } catch (CinemaNotExistException e) {

            return "redirect:/fail";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/edit_cinema", method = RequestMethod.POST)
    public String editCinemaHandler(@Valid CinemaEditor cinemaEditor, BindingResult result) {
        if (result.hasErrors()) {

            return "{\"result\": \"fail\", \"reason\": \"maybe you forgot to fill in some fields\"}";
        }

        // 检查city是否合法
        String city = cinemaEditor.getCity();
        if (!ValidatorUtils.isCityValid(city)) {
            FieldError cityError = new FieldError("cinemaEditor", "city",
                    messageSource.getMessage("CH.invalid.city", null, Locale.getDefault()));
            result.addError(cityError);

            return "{\"result\": \"fail\", \"reason\": \"your city is not valid\"}";
        }

        try {
            boolean r = cinemaService.updateCinema(cinemaEditor);

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
    @RequestMapping(value = "/delete_cinema", method = RequestMethod.GET)
    public String deleteCinema(@RequestParam Long id) {
        try {
            CinemaEntity cinema = cinemaService.findCinemaById(id, false, true, false);

            // 要先删hall信息，再删FCM的条目，但是hibernate删除的顺序有问题，只好手动删除
            // 而且如果放在service里做也不行，不知道为什么
            List<HallEntity> halls = cinema.getHalls();
            if (halls != null) {
                for (HallEntity hall: halls) {
                    hallService.deleteHall(hall);
                }
            }

            cinemaService.deleteCinema(cinema);

            return "{\"result\": \"success\", \"reason\": \"no content\"}";
        } catch (CinemaNotExistException e) {

            return "{\"result\": \"fail\", \"reason\": \"unknown cinema\"}";
        } catch (UserNotLoginException e) {

            return "{\"result\": \"fail\", \"reason\": \"not login\"}";
        }
    }


    @ModelAttribute("categories")
    public String[] initializeCategories() {
        return new String[]{"喜剧", "惊悚", "剧情"};
    }

    @ModelAttribute("cities")
    public String[] initializeCities() {
        return new String[]{"北京", "广州", "上海"};
    }

}
