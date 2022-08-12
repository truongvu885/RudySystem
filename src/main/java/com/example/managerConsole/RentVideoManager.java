package com.example.managerConsole;

import com.example.dao.IRentVideoDAO;
import com.example.dao.IVideoDAO;
import com.example.dao.impl.RentVideoDAO;
import com.example.dao.impl.VideoDAO;
import com.example.model.RentVideo;
import com.example.model.Video;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentVideoManager {
    private IVideoDAO videoDAO = new VideoDAO();
    private IRentVideoDAO rentVideoDAO = new RentVideoDAO();

    public void inputData() {

        System.out.println("Input your data");
        Scanner input = new Scanner(System.in);
        RentVideo rentVideo = new RentVideo();

        List<Video> videoList = videoDAO.findAll();
        List<String> videoNames = new ArrayList<>();
        for (Video v : videoList) {
            videoNames.add(v.getName());
        }
        for (String str : videoNames) {
            System.out.print("\t|" + str + "| ");
        }
        System.out.println();
        System.out.print("Choice video: ");
        String name = input.nextLine();
        Video video = videoDAO.findByName(name).get(0);
        System.out.print("Number of rental day: ");
        rentVideo.setTotalDate(Integer.parseInt(input.nextLine()));
        rentVideo.setVideoId(video.getId());
        Timestamp tr = new Timestamp(System.currentTimeMillis());
        rentVideo.setRentDate(tr);
        int d = tr.getDate();
        d = d + rentVideo.getTotalDate();
        Timestamp te = new Timestamp(System.currentTimeMillis());
        te.setDate(d);
        rentVideo.setExpireDate(te);
        rentVideo.setTotalMoney(video.getPrice() * rentVideo.getTotalDate());
        Long id = rentVideoDAO.create(rentVideo);
        RentVideo rentV = rentVideoDAO.findById(id);
        if (rentV != null) {
            System.out.println("Insert successful");
            System.out.println(rentV.getDescription());
        } else {
            System.err.println("Insert fail");
        }
    }

    public void showAll() {
        List<RentVideo> list = rentVideoDAO.findAll();
        if (!list.isEmpty()) {
            for (RentVideo r : list) {
                System.out.println(r.getDescription());
            }
        } else {
            System.err.println("Can't load data");
        }
    }
}
