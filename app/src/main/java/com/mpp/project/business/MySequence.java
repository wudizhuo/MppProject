package com.mpp.project.business;

/**
 * Created by prageeth on 3/7/17.
 */


import java.util.Random;

/**
 * Created by prageeth on 3/7/17.
 */

public final class MySequence {
//    private AtomicLong currentValue = new AtomicLong(0L);
//    public long getNextValue() {
//        return currentValue.getAndIncrement();
//    }

    // Next way of making a human readable ID
    //private final static char[] idchars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private final static char[] idchars = "0123456789".toCharArray();
    public static int createId(int len) {
        char[] id = new char[len];
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0;  i < len;  i++) {
            id[i] = idchars[r.nextInt(idchars.length)];
            // TODO: Will this create similar ids ?
        }
        //return new String(id);
        return Integer.parseInt(id.toString());
    }
}