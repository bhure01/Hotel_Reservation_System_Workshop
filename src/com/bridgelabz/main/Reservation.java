package com.bridgelabz.main;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Reservation {
    ArrayList<Hotel> hotelList = new ArrayList<>();
//    public void welcomeMessage() {
//        System.out.println("Welcome to the Hotel Reservation Program");
//    }

    public void addHotelDetails() {
        hotelList.add(new Hotel("Lakewood", 110, 80,90,80));
        hotelList.add(new Hotel("Bridgewood", 160, 110,60,50));
        hotelList.add(new Hotel("Ridgewood", 220, 100,150,40));
    }


    // Calculating rates based on period of stay at hotel
    public String calculateCheapestHotelAndRate(String dateOfArrival, String dateOfDeparture) throws Exception {

        Date dateofArrival = convertStringToDate(dateOfArrival);
        Date dateofDeparture = convertStringToDate(dateOfDeparture);
        long totalPeriodOfStay = 0;
        totalPeriodOfStay = (dateofDeparture.getTime() - dateofArrival.getTime());


        int totalDays = (int) TimeUnit.DAYS.convert(totalPeriodOfStay,TimeUnit.MILLISECONDS);
        addHotelDetails();

        for (int hotel = 0; hotel < hotelList.size(); hotel++) {
            int totalRate = hotelList.get(hotel).getWeekDayRateRegularCustomer() * (totalDays+1);
            hotelList.get(hotel).setWeekDayRateRegularCustomer(totalRate);
        }

        int regularHotelRate = hotelList.stream().min(Comparator.comparing(Hotel::getWeekDayRateRegularCustomer)).get().getWeekDayRateRewardCustomer();
        String hotelName = hotelList.stream().min(Comparator.comparing(Hotel::getWeekEndRateRegularCustomer)).get().getHotelName();

        System.out.println("The Cheapest Hotel is "+hotelName+" with cost for respective date as "+regularHotelRate+"$");
        return hotelName;

    }

    public Date convertStringToDate(String date) throws Exception{
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("YYYYMMDD").parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }
}


