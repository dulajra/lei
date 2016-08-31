package com.utils;

import java.util.ArrayList;

/**
 * Created by anuradhawick on 8/31/16.
 */
public class MessageTemplate {
    public String error = null;
    public String message = null;
    public String type = null;
    public ArrayList<Object> array = null;

    public MessageTemplate() {
        array = new ArrayList<Object>();
    }

}
