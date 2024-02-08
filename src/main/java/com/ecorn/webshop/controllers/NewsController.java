package com.ecorn.webshop.controllers;

import com.ecorn.webshop.dao.NewsRepository;
import com.ecorn.webshop.entity.News;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class NewsController {
    NewsRepository newsRepository;

    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    private List<News> newsList = new ArrayList<>();

    @GetMapping("/")
    public String showNews(Model model) {
        List<News> news = newsRepository.findAll();
        List<News> last = null;
        if(news.size() > 6){
            int x = news.size() - (news.size() - 6);
            last = new ArrayList<>();
            for(int i = news.size();i>x;i--){

            }
        }
        model.addAttribute("newsList", news);
        model.addAttribute("newNews", new News());
        return "index";
    }

    @PostMapping("/addNews")
    public String addNews(@ModelAttribute("newNews") News newNews) {
        newsRepository.save(newNews);
        newsList.add(newNews);
        return "redirect:/";
    }

    @GetMapping("/news/{id}")
    public String showNew(@PathVariable("id") Long id, Model model){
        News news = newsRepository.getReferenceById(id);
        model.addAttribute("news", news);
        return "news";
    }
}
