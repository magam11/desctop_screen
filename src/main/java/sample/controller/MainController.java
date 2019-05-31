package sample.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import sample.service.Service;
import sample.service.TaskThread;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.LongStream;


public class MainController {
    @FXML
    public Button start_stop_Button;
    static Service service = Service.getInstance();


    public static Long randomNumber() {
        Random rand = new Random();
        LongStream longStream = rand.longs(2, 10);
        return longStream.findFirst().getAsLong();

    }

    @FXML
    public void startOrStopScreen(MouseEvent mouseEvent) {
        if (start_stop_Button.getText().equals("Start")) {
            start_stop_Button.setText("Stop");
            Platform.runLater(() -> {
            task();
            });

        } else {
            start_stop_Button.setText("Start");
            System.exit(0);
        }
    }

    public void task() {
        Thread thread = new Thread(new TaskThread());
        thread.start();
        try {
            thread.join();
            thread = null;
//            System.gc();
            task();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    static Timer timer = new Timer();
//
//    static class Task extends TimerTask {
//
//        public static long randomNumber() {
//            Random rand = new Random();
//            LongStream longStream = rand.longs(2, 10);
//            return longStream.findFirst().getAsLong();
//
//        }
//
//        @Override
//        public void run() {
//            long delay = randomNumber() * 60000;
//            timer.schedule(new Test1.Task(), delay, delay);
//            task();
//
//        }
//
//        public void task() {
//            String desktopPath = System.getProperty("user.home") + "\\Desktop\\";
//            File file = new File(desktopPath + System.currentTimeMillis());
//            file.mkdirs();
//            try {
//                BufferedImage image = service.captureScreen(desktopPath + System.currentTimeMillis() + ".png");
////            service.senImageToServer(Constant.SERVER_ADDRES +Constant.SEND_IMAGE_URI,image);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

//    }

}
