package com.nhungtester.entity;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class Unit {
    public static String formatCurrency(double value) {
        NumberFormat formatCur = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        formatCur.setMinimumFractionDigits(3);
        //formatCur.setMaximumFractionDigits(5);
        formatCur.setRoundingMode(RoundingMode.HALF_EVEN);
        return formatCur.format(value);
    };


 }
