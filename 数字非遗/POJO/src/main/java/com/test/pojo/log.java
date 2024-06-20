package com.test.pojo;

import lombok.Data;

import java.time.format.DateTimeFormatter;

@Data
public class log {
    private int id;
    private String requestip;
    private int requestport;
    private String requestpcname;
    private String requesturl;
    private String requestdate;
    private int requestcount;
}
