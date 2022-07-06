package com.lsp.utils;
import java.util.Random;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;



public class EmalUtils{
    public static String yzm;

//    public static void main(String args[]) {
//        yzm = random1();
//        sendEmail();
//    }


    public static String sendEmail(String email) {
        HtmlEmail send = new HtmlEmail();

        String resultCode = random1();
        try {
            send.setHostName("smtp.qq.com");
            send.setAuthentication("1960116887@qq.com", "lfglwtommybsbbdc");

            send.setFrom("1960116887@qq.com", "我的验证吗");
            send.setSmtpPort(465);
            send.setSSLOnConnect(true);
            send.setCharset("utf-8");
            send.addTo(email);
            send.setSubject("测试测试");
            send.setMsg("HelloWorld!<font color='red'>您的验证码:</font>   " + resultCode + " ，五分钟后失效");
            send.send();  //发送
        } catch (EmailException e) {
            e.printStackTrace();
        }
        return resultCode;
    }




    public static String random1(){
        String code = "";
        Random rd=new Random();
        for (int i = 0; i < 6; i++) {
            int r = rd.nextInt(10);
            code = code + r;
        }
        System.out.println(code);
        return code;
    }
}