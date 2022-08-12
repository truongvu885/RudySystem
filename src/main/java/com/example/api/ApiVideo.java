package com.example.api;

import com.example.model.Video;
import com.example.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiVideo {

    @Autowired
    private IVideoService videoService;

    @PostMapping("/api/video")
    public Video createVideo(@RequestBody Video video){
        return videoService.create(video);
    }
}
