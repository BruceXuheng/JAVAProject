package com.csw.jcs.StrategyPattern;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }


        //对于url当中的中文字符进行编码
        public static String encodeUrl(String url) throws UnsupportedEncodingException {
            String path = URLEncoder.encode(url, "utf-8");
            return path;

        }

        public static void main(String[] args) {
            String str = "wadadadaw@.com";

            try {
                System.out.println(encodeUrl(str));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

//            String base64_1 = null;
//            try {
//                base64_1 = Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
//                System.out.println(base64_1);
//                System.out.println("*******");
//
//                byte[] bs_1 = base64_1.decode(base64_1);
//                System.out.println(new String(bs_1, "utf-8"));
//                System.out.println("*******");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }


        }


}