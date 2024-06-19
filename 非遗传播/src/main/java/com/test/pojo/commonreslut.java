package com.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class commonreslut<T> {
    public commonreslut(int code, String msg){
        this(code,msg,null);
    }

    private int code;
    private String msg;
    private T data;
}
