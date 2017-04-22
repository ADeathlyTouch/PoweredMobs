package com.collinriggs.electricmobs.util;

//Created by Bread10 at 14:13 on 22/04/2017
public class MathHelper {

    public static int max(int n, int max) {
        if (n > max) {
            return max;
        }
        return n;
    }

    public static int min(int n, int min) {
        if (n < min) {
            return min;
        }
        return n;
    }

    public static int clamp(int n, int min, int max) {
        if (n > max)
            return max;
        if (n < min)
            return min;
        return n;
    }

}