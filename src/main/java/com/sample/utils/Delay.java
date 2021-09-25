package com.sample.utils;

public class Delay {
    public void seconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000L);
    }
}