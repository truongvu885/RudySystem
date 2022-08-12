package com.example.controller;

import com.example.model.BookOnTape;
import com.example.model.Furniture;
import com.example.model.Video;
import com.example.service.IBookOnTapeService;
import com.example.service.IFurnitureService;
import com.example.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private IVideoService videoService;

    @Autowired
    private IBookOnTapeService bookOnTapeService;

    @Autowired
    private IFurnitureService furnitureService;


    @GetMapping("/video/search")
    public ModelAndView searchVideo(@RequestParam("in_search")String name){
        ModelAndView mav = new ModelAndView("video");
        List<Video> list = videoService.findByName(name);
        mav.addObject("list",list);
        return mav;
    }
    @GetMapping("/book-tape/search")
    public ModelAndView searchBookTape(@RequestParam("in_search")Long id){
        ModelAndView mav = new ModelAndView("bookontape");
        BookOnTape book = bookOnTapeService.findById(id);
        mav.addObject("book",book);
        return mav;
    }
    @GetMapping("/furniture/search")
    public ModelAndView searchFurniture(@RequestParam("in_search")Long id){
        ModelAndView mav = new ModelAndView("furniture");
        Furniture furniture = furnitureService.findById(id);
        mav.addObject("furniture",furniture);
        return mav;
    }
}
