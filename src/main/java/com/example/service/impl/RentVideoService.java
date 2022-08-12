package com.example.service.impl;

import com.example.dao.IRentVideoDAO;
import com.example.dao.IVideoDAO;
import com.example.model.RentVideo;
import com.example.model.Video;
import com.example.service.IRentVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class RentVideoService implements IRentVideoService {

    @Autowired
    private IRentVideoDAO rentVideoDAO;

    @Autowired
    private IVideoDAO videoDAO;
    @Override
    public boolean save(Long id, Integer date) {
        Video video = videoDAO.findById(id);

        if(video!=null){
            RentVideo rentVideo = new RentVideo();
            Float priceAday = video.getPrice();
            Timestamp rentD = new Timestamp(System.currentTimeMillis());
            int d = rentD.getDate();
            d = d + date;
            Timestamp exD = new Timestamp(System.currentTimeMillis());// expireDate = rentDate + totalDate
            exD.setDate(d);
            rentVideo.setTotalDate(date);
            rentVideo.setRentDate(rentD);
            rentVideo.setExpireDate(exD);
            rentVideo.setVideoId(id);
            rentVideo.setTotalMoney(priceAday*date);
            Long index = rentVideoDAO.create(rentVideo);
            if(index>0){
                return true;
            }else return false;
        }
        return false;
    }
}
