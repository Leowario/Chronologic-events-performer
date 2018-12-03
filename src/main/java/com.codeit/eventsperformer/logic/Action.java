package com.codeit.eventsperformer.logic;

import com.codeit.eventsperformer.Main;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Vitalii Usatyi
 */
public class Action extends TimerTask {
    private String massage;
    private Timer timer;
    private boolean isLast;

    private Action() {

    }

    Action(String massage) {
        this.massage = massage;
    }

    Action(String massage, Timer timer, boolean isLast) {
        this.massage = massage;
        this.timer = timer;
        this.isLast = isLast;
    }

    @Override
    public void run() {
        System.out.println(massage);
        cancel();
        long milliseconds = System.currentTimeMillis() - Main.startTime;
        System.out.println("Current time: " + milliseconds / 1000 + " s " + milliseconds % 1000 + " ms");
        if (isLast) {
            timer.cancel();
        }
    }
}
