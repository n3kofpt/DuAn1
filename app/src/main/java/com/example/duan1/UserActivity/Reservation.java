package com.example.duan1.UserActivity;

import java.util.List;

public class Reservation {
    private String name;
    private String phoneNumber;
    private String address;
    private int tablePosition ;
    private int hour;
    private int minute;
    private List<Menu> menus;


    public Reservation(int tablePosition){
        this.tablePosition = tablePosition;
    }

    public Reservation(List<Menu> menus) {
        this.menus = menus;
    }

    public Reservation(String name, String phoneNumber, String address, int hour, int minute) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Reservation(String name, String phoneNumber, String address, int tablePosition , String time, List<Menu> menus) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.tablePosition = tablePosition ;
        this.menus = menus;
    }







    public int getTablePosition() {
        return tablePosition;
    }

    public void setTablePosition(int tablePosition) {
        this.tablePosition = tablePosition;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int gettablePosition () {
        return tablePosition ;
    }

    public void settablePosition (int tablePosition ) {
        this.tablePosition  = tablePosition ;
    }



    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}

