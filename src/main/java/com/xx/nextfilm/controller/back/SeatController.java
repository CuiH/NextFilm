package com.xx.nextfilm.controller.back;

import com.xx.nextfilm.dto.editor.SeatEditor;
import com.xx.nextfilm.entity.SeatEntity;
import com.xx.nextfilm.exception.SeatNotExistException;
import com.xx.nextfilm.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cuihao on 2016/5/28.
 */
@Controller
public class SeatController {

    @Autowired
    SeatService seatService;


    @ResponseBody
    @RequestMapping(value = "/edit_seat", method = RequestMethod.POST)
    public String editSeat(SeatEditor seatEditor) {
        if (seatEditor.getStatus() == null || seatEditor. getStatus().equals("")
                || (!seatEditor.getStatus().equals("0") && !seatEditor.getStatus().equals("1"))) {

            return "{\"result\": \"fail\", \"reason\": \"invalid status\"}";
        }

        boolean flag = seatService.updateSeatStatusById(seatEditor.getId(), seatEditor.getStatus());

        if (flag == false) {

            return "{\"result\": \"fail\", \"reason\": \"unknown seat\"}";
        } else {

            return "{\"result\": \"success\", \"reason\": \"no content\"}";
        }
    }

}
