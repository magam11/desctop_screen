package sample.controller;

import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.LongStream;

public class Test1 {
    static Timer timer = new Timer();

    static class Task extends TimerTask {

        public static long randomNumber() {
            Random rand = new Random();
            LongStream longStream = rand.longs(2, 10);
            return longStream.findFirst().getAsLong();

        }
        @Override
        public void run() {
            System.out.println("run");
            long delay = randomNumber() * 1000;
            timer.schedule(new Task(), delay);
            System.out.println(new Date());
        }

    }

    public static void main(String[] args) throws Exception {
        new Task().run();
    }
}