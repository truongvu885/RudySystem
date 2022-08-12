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
public class HomeController {

    @Autowired
    private IVideoService videoService;

    @Autowired
    private IBookOnTapeService bookOnTapeService;

    @Autowired
    private IFurnitureService furnitureService;

    @GetMapping("/home")
    public ModelAndView homePage(){
        return new ModelAndView("home");
    }
    @GetMapping("/video")
    public ModelAndView videoPage(){
        ModelAndView mav = new ModelAndView("video");
        List<Video> list = videoService.findAll();
        mav.addObject("list",list);
        return mav;
    }
    @GetMapping("/book-tape")
    public ModelAndView bookTapePage(){
        ModelAndView mav = new ModelAndView("bookontape");
        List<BookOnTape> list = bookOnTapeService.findAll();
        mav.addObject("list",list);
        return mav;
    }
    @GetMapping("/furniture")
    public ModelAndView furniturePage(){
        ModelAndView mav = new ModelAndView("furniture");
        List<Furniture> list = furnitureService.findAll();
        mav.addObject("list",list);
        return mav;
    }
    @GetMapping("/rent")
    public ModelAndView rentPage(){
        ModelAndView mav = new ModelAndView("rent");
        List<Video> videoList = videoService.findAll();
        mav.addObject("videoList",videoList);
        List<BookOnTape> bookList = bookOnTapeService.findAll();
        mav.addObject("bookList", bookList);
        List<Furniture> furnitureList = furnitureService.findAll();
        mav.addObject("furnitureList",furnitureList);
        return mav;
    }
}
