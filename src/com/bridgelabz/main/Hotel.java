package com.bridgelabz.main;

public class Hotel {


    // variables
    public String hotelName;
//    public int regularRate;
    public int weekDayRateRegularCustomer;
    public int weekDayRateRewardCustomer;
    public int weekEndRateRegularCustomer;
    public int weekEndRateRewardCustomer;

    //Parameterized Constructor
    public Hotel(String hotelName, int regularRate, int weekDayRateRegularCustomer, int weekDayRateRewardCustomer,int weekEndRateRegularCustomer,int weekEndRateRewardCustomer) {
        this.hotelName = hotelName;
        int weekDayRateRegularCustomer1 = this.weekDayRateRegularCustomer;
        int weekDayRateRewardCustomer1 = this.weekDayRateRewardCustomer;
        int weekEndRateRegularCustomer1 = this.weekEndRateRegularCustomer;
        int weekEndRateRewardCustomer1 = this.weekEndRateRewardCustomer;
    }

    public Hotel(String lakewood, int weekDayRateRegularCustomer, int weekDayRateRewardCustomer, int weekEndRateRegularCustomer, int weekEndRateRewardCustomer) {
    }

    public Hotel(String bridgewood, int i, int i1) {
    }

    // Getter And Setter Methods
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getWeekDayRateRegularCustomer() {
        return weekDayRateRegularCustomer;
    }

    public void setWeekDayRateRegularCustomer(int weekDayRateRegularCustomer) {
        this.weekDayRateRegularCustomer = weekDayRateRegularCustomer;
    }

    public int getWeekDayRateRewardCustomer() {
        return weekDayRateRewardCustomer;
    }

    public void setWeekDayRateRewardCustomer(int weekDayRateRewardCustomer) {
        this.weekDayRateRewardCustomer = weekDayRateRewardCustomer;
    }

    public int getWeekEndRateRegularCustomer() {
        return weekEndRateRegularCustomer;
    }

    public void setWeekEndRateRegularCustomer(int weekEndRateRegularCustomer) {
        this.weekEndRateRegularCustomer = weekEndRateRegularCustomer;
    }

    public int getWeekEndRateRewardCustomer() {
        return weekEndRateRewardCustomer;
    }

    public void setWeekEndRateRewardCustomer(int weekEndRateRewardCustomer) {
        this.weekEndRateRewardCustomer = weekEndRateRewardCustomer;
    }
}
