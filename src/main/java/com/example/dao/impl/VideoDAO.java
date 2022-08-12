package com.example.dao.impl;

import com.example.dao.IVideoDAO;
import com.example.model.Video;
import com.example.mapper.VideoMapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class VideoDAO extends AbstractDAO<Video> implements IVideoDAO {

    @Override
    public List<Video> findAll() {
        String sql = "select * from video";
        return query(sql,new VideoMapper());
    }

    @Override
    public List<Video> findByName(String name) {
        String sql = "select * from video where name = ?";
        List<Video> list = query(sql,new VideoMapper(),name);
        if(!list.isEmpty()){
            return list;
        }
        else return null;
    }

    @Override
    public Video findById(Long id) {
        String sql = "select * from video where id = ?";
        List<Video> list = query(sql,new VideoMapper(), id);
        if(!list.isEmpty()){
            return list.get(0);
        }
        else return null;
    }

    @Override
    public Long create(Video video) {
        String sql = "insert into video( name, issuedate, author, length, category, quality, price)\n" +
                "values (?,?,?,?,?,?,?);";
        return insert(sql,video.getName(),video.getIssueDate(),video.getAuthor(),video.getLength(),video.getCategory(),video.getQuality(),video.getPrice());
    }

}
