package com.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anuradhawick on 8/31/16.
 */
public class MessageTemplate {
    public boolean error = false;
    public String message = null;
    public String type = null;
    public List<Object> array = null;

    public MessageTemplate() {
        array = new ArrayList<Object>();
    }

}
