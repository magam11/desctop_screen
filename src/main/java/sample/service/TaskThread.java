package sample.service;

import sample.Constant;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import java.util.Random;
import java.util.stream.LongStream;

public class TaskThread implements Runnable {
    Service service = Service.getInstance();

    public static Long randomNumber() {
        Random rand = new Random();
        LongStream longStream = rand.longs(2, 8);
        return longStream.findFirst().getAsLong();

    }

    @Override
    public void run() {
        try {
            BufferedImage image = service.captureScreen();
            service.senImageToServer(Constant.SERVER_ADDRES +Constant.SEND_IMAGE_URI,image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(randomNumber()*60000);
//            Thread.sleep(8000);
//            run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
