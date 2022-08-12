package com.example.mapper;

import com.example.model.Video;

import java.sql.ResultSet;

public class VideoMapper implements RowMapper<Video>{
    //mapping data resultset to model
    @Override
    public Video mapRow(ResultSet resultSet) {
        Video video = new Video();
        try{
            video.setId(resultSet.getLong("id"));
            video.setName(resultSet.getString("name"));
            video.setIssueDate(resultSet.getDate("issueDate"));
            video.setAuthor(resultSet.getString("author"));
            video.setLength(resultSet.getInt("length"));
            video.setCategory(resultSet.getString("category"));
            video.setPrice(resultSet.getFloat("price"));
            video.setQuality(resultSet.getString("quality"));
            return video;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
