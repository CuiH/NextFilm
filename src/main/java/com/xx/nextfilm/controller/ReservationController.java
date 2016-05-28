package com.xx.nextfilm.controller;

import com.google.gson.Gson;
import com.xx.nextfilm.dto.editor.ReservationEditor;
import com.xx.nextfilm.entity.CustomUserInfo;
import com.xx.nextfilm.entity.PurchaseOrderEntity;
import com.xx.nextfilm.entity.UserEntity;
import com.xx.nextfilm.exception.SeatHasBeenReservedException;
import com.xx.nextfilm.exception.SeatNotExistException;
import com.xx.nextfilm.exception.ShowingNotExistException;
import com.xx.nextfilm.exception.UserNotLoginException;
import com.xx.nextfilm.service.ReservationService;
import com.xx.nextfilm.utils.BuilderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cuihao on 2016/5/28.
 */
@Controller
public class ReservationController {

    @Autowired
    ReservationService reservationService;


    @ResponseBody
    @RequestMapping(value = "/make_reservation", method = RequestMethod.POST)
    public String makeReservation(ReservationEditor reservation) {
        if (reservation.getSeats() == null || reservation.getSeats().isEmpty()) {

            return "{\"result\": \"fail\", \"reason\": \"no seat selected\"}";
        }

        UserEntity userEntity;
        try {
            userEntity = getCurrentUser();
        } catch(UserNotLoginException e) {

            return "{\"result\": \"fail\", \"reason\": \"not login\"}";
        }

        try {
            reservationService.makeReservation(userEntity, reservation);

            return "{\"result\": \"success\", \"reason\": \"not content\"}";
        } catch (SeatNotExistException e) {

            return "{\"result\": \"fail\", \"reason\": \"unknown seat\"}";
        } catch (ShowingNotExistException e) {

            return "{\"result\": \"fail\", \"reason\": \"not showing\"}";
        } catch (SeatHasBeenReservedException e) {

            return "{\"result\": \"fail\", \"reason\": \"seat has already been reserved\"}";
        }
    }


    @ResponseBody
    @RequestMapping(value = "/view_all_reservation", method = RequestMethod.GET, produces = "plain/text; charset=UTF-8")
    public String viewAllReservation() {
        UserEntity userEntity;
        try {
            userEntity = getCurrentUser();
        } catch(UserNotLoginException e) {

            return "{\"result\": \"fail\", \"reason\": \"not login\"}";
        }

        List<PurchaseOrderEntity> purchaseOrders = reservationService.findReservationsByUser(userEntity);

        Gson gson = new Gson();

        return "{\"result\": \"success\", \"data\": " +
                gson.toJson(BuilderUtils.getPurchaseOrderShowersFromPurchaseOrderEntities(purchaseOrders)) + "}";
    }


    public UserEntity getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof CustomUserInfo) {

            return ((CustomUserInfo) principal).getUserEntity();
        } else {

            throw new UserNotLoginException();
        }
    }

}


