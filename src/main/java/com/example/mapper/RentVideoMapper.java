package com.example.mapper;

import com.example.dao.IVideoDAO;
import com.example.dao.impl.VideoDAO;
import com.example.model.RentVideo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RentVideoMapper implements RowMapper<RentVideo>{

    private IVideoDAO videoDAO = new VideoDAO();
    @Override
    public RentVideo mapRow(ResultSet resultSet) {
        RentVideo rentVideo = new RentVideo();
        try{
            rentVideo.setId(resultSet.getLong("id"));
            rentVideo.setRentDate(resultSet.getTimestamp("rentDate"));
            rentVideo.setExpireDate(resultSet.getTimestamp("expiredate"));
            rentVideo.setName(videoDAO.findById(resultSet.getLong("videoid")).getName());
            rentVideo.setTotalDate(resultSet.getInt("totaldate"));
            rentVideo.setTotalMoney(resultSet.getFloat("totalmoney"));
            return rentVideo;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
