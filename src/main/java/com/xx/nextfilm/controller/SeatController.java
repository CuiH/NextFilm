package com.xx.nextfilm.controller;

import com.xx.nextfilm.dao.SeatDao;
import com.xx.nextfilm.entity.SeatEntity;
import com.xx.nextfilm.exception.SeatNotExistException;
import com.xx.nextfilm.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by CuiH on 2016/5/18.
 */
@Controller
public class SeatController {

    @Autowired
    SeatService seatService;


    @RequestMapping(value = "/update_seat/{id}", method = RequestMethod.GET)
    public String updateSeat(@PathVariable Long id, String status) {
        try {
            SeatEntity seatEntity = seatService.findSeatById(id);
            seatService.updateSeatStatus(id, status);

            return "redirect:/success";
        } catch (SeatNotExistException e) {

            return "redirect:/fail";
        }
    }
}
