package com.example.managerConsole;

import com.example.dao.IVideoDAO;
import com.example.dao.impl.VideoDAO;
import com.example.model.Video;

import java.sql.Date;
import java.util.*;

public class VideosManager {

    public List<Video> videoList = new ArrayList<>();
    private IVideoDAO videoDAO = new VideoDAO();

    public void inputData(){
        Scanner input = new Scanner(System.in);
        Video video = new Video();
        System.out.println("Input data of video");
        System.out.print("Name: ");
        video.setName(input.nextLine());
        System.out.print("Issue date: ");
        video.setIssueDate(Date.valueOf(input.nextLine()));
        System.out.print("Author: ");
        video.setAuthor(input.nextLine());
        System.out.print("Length: ");
        video.setLength(Integer.parseInt(input.nextLine()));
        System.out.print("Category: ");
        video.setCategory(input.nextLine());
        System.out.print("Quality: ");
        video.setQuality(input.nextLine());
        System.out.print("Price of one day: ");
        video.setPrice(Float.parseFloat(input.nextLine()));
        Long id = videoDAO.create(video);
        Video newV =videoDAO.findById(id);
        if(newV!=null){
            System.out.println("Insert successful");
            System.out.println(newV.getDescription());
        }
        else {
            System.err.print("Insert fail");
        }
    }
    public List<Video> getAll(){
        return videoDAO.findAll();
    }
    public void showAll(){
            for (Video v:getAll()) {
                System.out.println(v.getDescription());
            }
    }
    public void findById(Long id){
        Video video = videoDAO.findById(id);
        if(video!=null){
            System.out.println(video.getDescription());
        }else {
            System.err.println("Can't find your id "+ id);
        }
    }
    public void sortVideosDesc(){
        List<Video> list = getAll();
        Collections.sort(list, new Comparator<Video>() {
            @Override
            public int compare(Video o1, Video o2) {
                return o2.getPrice().compareTo(o1.getPrice());
            }
        });
        for (Video v:list) {
            System.out.println(v.getDescription());
        }
    }
    public void sortVideosAsc(){
        List<Video> list = getAll();
        Collections.sort(list, new Comparator<Video>() {
            @Override
            public int compare(Video o1, Video o2) {
                return o1.getPrice().compareTo(o2.getPrice());
            }
        });
        for (Video v:list) {
            System.out.println(v.getDescription());
        }
    }
}
