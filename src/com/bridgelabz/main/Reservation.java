package com.bridgelabz.main;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class Reservation {
    ArrayList<Hotel> hotelList = new ArrayList<>();

    public void addHotelDetails() {
        hotelList.add(new Hotel("Lakewood", 110, 80,90,80));
        hotelList.add(new Hotel("Bridgewood", 160, 110,60,50));
        hotelList.add(new Hotel("Ridgewood", 220, 100,150,40));
    }

    private static long countWeekDaysMath(LocalDate start, LocalDate end) {
        long count = 0;
        final DayOfWeek weekStart = start.getDayOfWeek();
        final DayOfWeek weekEnd = end.getDayOfWeek();

        final long days = ChronoUnit.DAYS.between(start, end);
        final long daysWithoutWeekends = days - 2 * ((days + weekStart.getValue()) / 7);

        // adjust for starting and ending on a Sunday:
        count = daysWithoutWeekends + (weekStart == DayOfWeek.SUNDAY ? 1 : 0) + (weekEnd == DayOfWeek.SUNDAY ? 1 : 0);
        return count;
    }

    /* Find cheapest hotel */
    public ArrayList<String> findCheapestCost(long weekDays, long weekendDays) {
        ArrayList<String> hotel = new ArrayList<>();
        long minmumCostLakeWood = (hotelList.get(0).getWeekDayRateRegularCustomer()
                + hotelList.get(0).getWeekEndRateRegularCustomer());
        long minimumCostBridgeWood = (hotelList.get(1).getWeekDayRateRegularCustomer()
                + hotelList.get(1).getWeekEndRateRegularCustomer());
        long minimumCostRidgeWood = (hotelList.get(2).getWeekDayRateRegularCustomer()
                + hotelList.get(2).getWeekEndRateRegularCustomer());
        long minCostHotel = Math.min(minimumCostRidgeWood, Math.min(minimumCostBridgeWood, minmumCostLakeWood));
        if (minCostHotel == minmumCostLakeWood)
            hotel.add("LakeWood");
        if (minCostHotel == minimumCostBridgeWood)
            hotel.add("BridgeWood");
        if (minCostHotel == minimumCostRidgeWood)
            hotel.add("RidgeWood");
        System.out.println("The minimum cost for Hotel is "+ minCostHotel);
        return hotel;
    }

    // Calculating Rate based on period of stay at hotel
    public ArrayList<String> calculateCheapestHotelAndRate(String dateOfArrival, String dateOfDeparture) throws Exception {
        LocalDate dateArrival = LocalDate.parse(dateOfArrival);
        LocalDate dateDeparture = LocalDate.parse(dateOfDeparture);
        long totalDays = ChronoUnit.DAYS.between(dateArrival, dateDeparture) + 1;
        long weekDays = countWeekDaysMath(dateArrival, dateDeparture);
        long weekendDays = totalDays - weekDays;
        return findCheapestCost(weekDays, weekendDays);
    }

    @Test
    public void givenDate_shouldReturnCheaperHotel() throws Exception {
        Reservation hotelReservation = new Reservation();
        hotelReservation.addHotelDetails();
        String cheapestHotel = String.valueOf(hotelReservation.calculateCheapestHotelAndRate("16March2020", "17March2020"));
        Assert.assertEquals("Lakewood", cheapestHotel);
    }
}

