package com.jie.helloservice.controller;

import com.jie.helloservice.common.http.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class UrlListenerController {

    private final Logger logger = LoggerFactory.getLogger(UrlListenerController.class);

    @GetMapping(value = "/hello")
    public String index() {
        return "hello success!";
    }

    @GetMapping(value = "/url")
    public String url(@RequestParam String url) throws Exception {
        String fileName = "/Users/babijava/Downloads/temp/" + UUID.randomUUID().toString().replaceAll("-", "") + ".html";
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        String json = HttpUtils.requestUseGet(url, null);
        PrintWriter writer = new PrintWriter(new FileWriter(file), true);
        writer.println(json);

        String matcher = ">「(.*?)开售」<";
        Matcher m = Pattern.compile(matcher).matcher(json);
        if (m.find()) {
            return m.group(1);
        }
        return json;
    }

    @GetMapping(value = "/news/get")
    public String getNews(String url) throws Exception {
        String fileName = "/Users/babijava/Downloads/temp/" + UUID.randomUUID().toString().replaceAll("-", "") + ".html";
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        PrintWriter writer = new PrintWriter(new FileWriter(file), true);
        String json = HttpUtils.requestUseGet(url, null);
        writer.println(json);

        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = null;
        PrintWriter writer2 = new PrintWriter("/Users/babijava/Downloads/temp/" + UUID.randomUUID().toString().replaceAll("-", "") + "1111.html");
        while ((s = br.readLine()) != null) {
            String matcher = "<div class=\"video\" id=\"(.*?)\">.*?<a href=\"(.*?)\" title=\"(.*?)\">.*?<div class=\"id\">(.*?)</div>.*?<img src=\"(.*?)\".*?;\".*?/>.*?<div class=\"title\".*?>(.*?)</div>.*?</a>.*?<div class=\"toolbar\">.*?</a></div></div>";
            Matcher m = Pattern.compile(matcher).matcher(s);
            while (m.find()) {
                writer2.println(m.group(2).replaceFirst(".", ""));
                System.out.println(m.group(2).replaceFirst(".", ""));
                writer2.println(m.group(4));
                System.out.println("the prefix: " + m.group(4));
                writer2.println(m.group(6));
                System.out.println("the title: " + m.group(6));
                writer2.println(m.group(5));
                System.out.println("the imgUrl: " + m.group(5));
                writer2.println("----------------------------------------");
                System.out.println("----------------------------------------");
            }
        }
        writer.close();
        br.close();
        writer2.close();
        return json;
    }

    //解析网页返回内容
//    public static void main(String[] args) throws Exception {
//        FileOutputStream fo = new FileOutputStream("/Users/babijava/Downloads/temp/" + UUID.randomUUID().toString().replaceAll("-", "") + "1111.jpg");     // new File(imageName)相对绝对路径
//        byte[] buf = new byte[1024];
//        int length = 0;
//        System.out.println("start download!");
//        while ((length = in.read(buf, 0, buf.length)) != -1) {
//            fo.write(buf, 0, length);
//        }
//        fo.close();
//        in.close();
//    }
//    public static void main(String[] args) {
//        List<String> listImgSrc = new ArrayList<>();
//        listImgSrc.add("pics.dmm.co.jp/mono/movie/adult/9mide471/9mide471ps.jpg");
//        try {
//            for (String url : listImgSrc) {
//                String imageName = url.substring(url.lastIndexOf("/") + 1, url.length());
//                URL uri = new URL(url);
//                InputStream in = uri.openStream();
//                FileOutputStream fo = new FileOutputStream("/Users/babijava/Downloads/temp/" + UUID.randomUUID().toString().replaceAll("-", "") + "1111.jpg");     // new File(imageName)相对绝对路径
//                byte[] buf = new byte[1024];
//                int length = 0;
//                System.out.println("开始下载:" + url);
//                while ((length = in.read(buf, 0, buf.length)) != -1) {
//                    fo.write(buf, 0, length);
//                }
//                in.close();
//                fo.close();
//                System.out.println(imageName + "下载完成");
//            }
//        } catch (Exception e) {
//            System.out.println("下载失败");
//        }
//    }
}
