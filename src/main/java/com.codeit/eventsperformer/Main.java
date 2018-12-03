package com.codeit.eventsperformer;

import com.codeit.eventsperformer.logic.Application;

/**
 * @author Vitalii Usatyi
 */
public class Main {
    public static final long startTime = System.currentTimeMillis();

    public static void main(String[] args) {
        Application.instance().run();
    }
}
