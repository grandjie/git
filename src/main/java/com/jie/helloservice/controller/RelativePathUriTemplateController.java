package com.jie.helloservice.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.json.stream.JsonGenerationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@Controller
//@RequestMapping("/relative/path")
public class RelativePathUriTemplateController {

    //    @ResponseBody
    @GetMapping(value = "/upload", consumes = {"text/plain", "application/*"})
    public String upload(HttpServletRequest request, HttpServletResponse response, String contentType2) throws IOException {
        System.out.println("come in");
        String content = null;
        Map map = new HashMap();
        ObjectMapper mapper = new ObjectMapper();

        map.put("fileName", "a.txt");
        try {
            content = mapper.writeValueAsString(map);
            System.out.println(content);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    //    @ResponseBody
    @GetMapping(value = "/accept")
    public String accept(String title) {
        System.out.println("111");
        List<String> list = new ArrayList<>();
        list.add(title);
        new Thread(() -> test(list)).start();
        return "success";
    }

    public static void test(List<String> list) {
        System.out.println(list.get(0));
    }
}
