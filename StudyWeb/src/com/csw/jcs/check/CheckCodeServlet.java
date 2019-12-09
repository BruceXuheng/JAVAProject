package com.csw.jcs.check;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "CheckCodeServlet", urlPatterns = "/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int width = 100;
        int height = 50;

        //1.创建一对象，在内存中对象（验证码图片对象）
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2.美化图片
        Graphics g = image.getGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, width, height);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijkklmnopqrstuvwxyz1234567890";

            Random random = new Random();
            g.setColor(Color.CYAN);
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            //写验证码：
            g.drawString(String.valueOf(ch), width/5*i, height/2);

        }

        g.setColor(Color.YELLOW);

        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }


        g.setColor(Color.BLUE);
        g.draw3DRect(0, 0, width - 1, height - 1, true);


        //3.
        ImageIO.write(image, "jpg", response.getOutputStream());

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
