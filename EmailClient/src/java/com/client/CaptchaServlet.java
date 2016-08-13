
package com.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;
import javax.imageio.ImageIO;


public class CaptchaServlet {
     protected void processRequest() throws IOException{
         int width = 150;
        int height = 50;
        char [] data = new char[6];
        CaptchaGenerate obj = CaptchaSingleton.getInstance();
        BufferedImage bufferedImage = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = bufferedImage.createGraphics();

        Font font = new Font("Georgia", Font.BOLD, 18);
        g2d.setFont(font);

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        GradientPaint gp = new GradientPaint(7, 10, 
        Color.red, 0, height/2, Color.blue, true);

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);

        g2d.setColor(new Color(255, 153, 0));

        Random r = new Random();
    
        String captcha = obj.captcha();
        EmailServer.cipher=captcha;
        data=captcha.toCharArray();

        int x = 0; 
        int y = 0;

        for (int i=0; i<data.length; i++) {
            x += 10 + (Math.abs(r.nextInt()) % 15);
            y = 20 + Math.abs(r.nextInt()) % 20;
            g2d.drawChars(data, i, 1, x, y);
        }

        g2d.dispose();

        File fp = new File("C:\\Users\\007\\Documents\\NetBeansProjects\\EmailClient\\web\\image.png");
        ImageIO.write(bufferedImage,"png",fp);
    }
}
