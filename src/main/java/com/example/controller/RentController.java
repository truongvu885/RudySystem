package com.example.controller;

import com.example.model.Video;
import com.example.service.IBookOnTapeService;
import com.example.service.IFurnitureService;
import com.example.service.IRentVideoService;
import com.example.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RentController {

    @Autowired
    private IRentVideoService rentVideoService;
    @Autowired
    private IVideoService videoService;

    @Autowired
    private IBookOnTapeService bookOnTapeService;

    @Autowired
    private IFurnitureService furnitureService;

    @PostMapping("/rent/video")
    public ModelAndView rentVideo(@RequestParam("id")Long id,@RequestParam("numberDate")Integer date){
        ModelAndView mav = new ModelAndView();
        if(rentVideoService.save(id,date)){
            List<Video> videoList = videoService.findAll();
            mav.addObject("videoList",videoList);
            mav.addObject("message","Insert successful");
            mav.addObject("alert", "success");
            mav.setViewName("rent");
            return mav;
        }
        return new ModelAndView("home");
    }

}
