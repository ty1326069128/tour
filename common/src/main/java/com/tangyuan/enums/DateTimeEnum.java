package com.tangyuan.enums;


import lombok.Getter;

@Getter
public enum DateTimeEnum {


    yyyy_MM_dd(1, "yyyy-MM-dd"),
    yyyy_MM_dd_hh_mm_ss(2, "yyyy-MM-dd hh:mm:ss");


    int code;
    String name;

    DateTimeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }


}
