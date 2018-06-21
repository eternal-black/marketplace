package com.marketplace.util;

import java.util.Random;

public class CommonUtil {
    public static String generateImageNumber() {
        int FIRST_IMG_NUMBER = 1;
        int IMG_COUNT = 6;
        return String.valueOf(new Random().nextInt(IMG_COUNT) + FIRST_IMG_NUMBER);
    }
}
