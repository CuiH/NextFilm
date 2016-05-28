package com.xx.nextfilm.controller.back;

import com.google.gson.Gson;
import com.xx.nextfilm.dto.editor.ReservationEditor;
import com.xx.nextfilm.entity.CustomUserInfo;
import com.xx.nextfilm.entity.PurchaseOrderEntity;
import com.xx.nextfilm.entity.UserEntity;
import com.xx.nextfilm.exception.*;
import com.xx.nextfilm.service.ReservationService;
import com.xx.nextfilm.service.UserService;
import com.xx.nextfilm.utils.BuilderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cuihao on 2016/5/28.
 */
@Controller
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @Autowired
    UserService userService;


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
    @RequestMapping(value = "/view_reservation", method = RequestMethod.GET, produces = "plain/text; charset=UTF-8")
    public String viewReservation(@RequestParam Long id) {
        try {
            PurchaseOrderEntity purchaseOrderEntity = reservationService.findReservationById(id, true);

            Gson gson = new Gson();

            return "{\"result\": \"success\", \"data\": " +
                    gson.toJson(BuilderUtils.getPurchaseOrderShower1FromPurchaseOrderEntity(purchaseOrderEntity)) + "}";
        } catch (PurchaseOrderNotExistException e) {

            return "{\"result\": \"fail\", \"reason\": \"unknown reservation\"}";
        }
    }


    // 当前用户的所有订单
    @ResponseBody
    @RequestMapping(value = "/view_all_reservation", method = RequestMethod.GET, produces = "plain/text; charset=UTF-8")
    public String viewAllReservation() {
        UserEntity userEntity;
        try {
            userEntity = getCurrentUser();
        } catch(UserNotLoginException e) {

            return "{\"result\": \"fail\", \"reason\": \"not login\"}";
        }

        List<PurchaseOrderEntity> purchaseOrders = reservationService.findReservationsByUser(userEntity, false);

        Gson gson = new Gson();

        return "{\"result\": \"success\", \"data\": " +
                gson.toJson(BuilderUtils.getPurchaseOrderShower2sFromPurchaseOrderEntities(purchaseOrders)) + "}";
    }


    // 根据username找其所有订单，后台管理用
    @ResponseBody
    @RequestMapping(value = "/find_reservation", method = RequestMethod.GET, produces = "plain/text; charset=UTF-8")
    public String findReservation(@RequestParam String userName) {
        UserEntity userEntity;
        try {
            userEntity = userService.findUserByUsername(userName, false, false);

        } catch(UserNotExistException e) {

            return "{\"result\": \"fail\", \"reason\": \"unknown user\"}";
        }

        List<PurchaseOrderEntity> purchaseOrders = reservationService.findReservationsByUser(userEntity, false);

        if (purchaseOrders.size() == 0) {
            return "{\"result\": \"fail\", \"reason\": \"no reservation\"}";
        }

        Gson gson = new Gson();

        return "{\"result\": \"success\", \"data\": " +
                gson.toJson(BuilderUtils.getPurchaseOrderShower2sFromPurchaseOrderEntities(purchaseOrders)) + "}";
    }


    @RequestMapping(value = "/show_all_reservation", method = RequestMethod.GET)
    public String showAllReservation() {

        return "show_all_reservation";
    }


    @ResponseBody
    @RequestMapping(value = "/delete_reservation", method = RequestMethod.GET)
    public String deleteReservation(@RequestParam Long id) {
        try {
            PurchaseOrderEntity purchaseOrderEntity = reservationService.findReservationById(id, false);

            reservationService.deleteReservation(purchaseOrderEntity);

            return "{\"result\": \"success\", \"reason\": \"no content\"}";
        } catch (PurchaseOrderNotExistException e) {

            return "{\"result\": \"fail\", \"reason\": \"unknown reservation\"}";
        } catch (UserNotLoginException e) {

            return "{\"result\": \"fail\", \"reason\": \"not login\"}";
        }
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


