package com.example.dao.impl;

import com.example.dao.IRentVideoDAO;
import com.example.mapper.RentVideoMapper;
import com.example.model.RentVideo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RentVideoDAO extends AbstractDAO<RentVideo> implements IRentVideoDAO {

    @Override
    public Long create(RentVideo rentVideo) {
        String sql = "insert into rentvideo(rentdate, expiredate, totaldate, totalmoney, videoid) " +
                " values(?,?,?,?,?)";

        return insert(sql,rentVideo.getRentDate(),rentVideo.getExpireDate(),rentVideo.getTotalDate(),rentVideo.getTotalMoney(),rentVideo.getVideoId());
    }

    @Override
    public RentVideo findById(Long id) {
        String sql = "select * from rentvideo where id = ?";
        List<RentVideo> list = query(sql,new RentVideoMapper(),id);
        if(!list.isEmpty()){
            return list.get(0);
        }
        else return null;
    }

    @Override
    public List<RentVideo> findAll() {
        String sql = "select * from rentvideo";
        return query(sql,new RentVideoMapper());
    }
}
