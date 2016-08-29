package com.lei.logic;

import com.utils.LogicEnum;

/**
 * Created by anuradhawick on 8/30/16.
 */
public class LogicDetector {
    public static Class getLogic(LogicEnum logic) {
        switch (logic) {
            case comparator:
                return Comparators.class;
            case locator:
                return Locator.class;
        }
        return null;
    }
}
