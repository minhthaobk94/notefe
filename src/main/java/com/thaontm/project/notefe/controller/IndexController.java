package com.thaontm.project.notefe.controller;

import com.thaontm.project.notefe.model.News;
import com.thaontm.project.notefe.utils.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    Data data = new Data();
    List<News> newsList = new ArrayList<>();
    boolean isToday;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomepage(Map<String, Object> model) {
        List<String> titles = data.getTitles();
        int size = titles.size();
        for (int i = 0; i < size; i++) {
            String topic = titles.get(i);
            String title = data.getTitle(topic);
            String date = data.getDateSt(topic);
            News news = new News(i, title, date);
            Date date1 = data.parseDate1(date);
            isToday = data.isToday(date1);
            newsList.add(news);
        }
        model.put("newsList", newsList);
        model.put("title", newsList.get(0).getTitle());
        model.put("content", data.formatContent(data.getContent(0)));
        model.put("isToday", isToday);
        return "home";
    }

    @RequestMapping(value = "/{index}", method = RequestMethod.GET)
    public String getContent(Map<String, Object> model, @PathVariable("index") Integer index) {
        model.put("newsList", newsList);
        model.put("title", newsList.get(index).getTitle());
        model.put("content", data.formatContent(data.getContent(index)));
        model.put("isToday", isToday);
        return "home";
    }
}
