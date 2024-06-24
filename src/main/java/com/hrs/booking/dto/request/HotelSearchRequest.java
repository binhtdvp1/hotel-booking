package com.hrs.booking.dto.request;

public class HotelSearchRequest {

    private String address;
    private String hotelName;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address != null && address.isEmpty()) {
            address = null;
        }
        this.address = address;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        if (hotelName != null && hotelName.isEmpty()) {
            hotelName = null;
        }
        this.hotelName = hotelName;
    }
}
