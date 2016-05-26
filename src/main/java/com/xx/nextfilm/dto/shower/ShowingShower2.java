package com.xx.nextfilm.dto.shower;

/**
 * Created by CuiH on 2016/5/18.
 *
 * 用于影院详情页面（放在cinema的fcm中）
 */
public class ShowingShower2 {

    private Long id;

    private String startTime;
    private String endTime;
    private String priceManual;

    private HallShower2 hall;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    public String getPriceManual() {
        return priceManual;
    }

    public void setPriceManual(String priceManual) {
        this.priceManual = priceManual;
    }


    public HallShower2 getHall() {
        return hall;
    }

    public void setHall(HallShower2 hall) {
        this.hall = hall;
    }

}
