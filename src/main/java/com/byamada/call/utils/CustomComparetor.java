package com.byamada.call.utils;

import com.byamada.call.domain.Car;

import java.util.Comparator;

public class CustomComparetor implements Comparator {

    public int compare(Car o, Car t1) {
        return Integer.compare(o.getId(), t1.getId());
    }

    @Override
    public int compare(Object o, Object t1) {
        return 0;
    }
}
