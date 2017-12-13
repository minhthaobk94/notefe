package com.thaontm.project.notefe.controller;

import com.thaontm.project.notefe.model.News;
import com.thaontm.project.notefe.utils.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    Data data = new Data();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomepage(Map<String, Object> model) {
        List<News> newsList = new ArrayList<>();
        for (int i = 1; i < data.getLinks().size(); i++) {
            News news = new News(data.getLinks().get(i), data.getTitles().get(i));
            newsList.add(news);
        }
        model.put("newsList",newsList);
        return "index";
    }
}
