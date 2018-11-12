package com.baizhi.service;

import com.baizhi.dao.CarouselDAO;
import com.baizhi.entity.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselDAO carouselDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Carousel> findByPage(Integer page, Integer rows) {
       // System.out.println("service测试"+page+"   "+rows);
        int start = (page - 1) * rows;
        return carouselDAO.findByPage(start,rows);
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return carouselDAO.findTotals();
    }
    @Override
    public void save(Carousel carousel) {
        carousel.setId(UUID.randomUUID().toString());
        carouselDAO.save(carousel);
    }
    @Override
    public void update(Carousel carousel){
        carousel.setCreateDate(new Date());
        carouselDAO.update(carousel);
    }
    @Override
    public void delete(String id){
        carouselDAO.delete(id);
    }
    @Override
    public Carousel queryOne(String id) {
       return carouselDAO.queryOne(id);
    }

    @Override
    public List<Carousel> findAll() {
        List<Carousel> list = carouselDAO.findAll();
        return list;
    }

}



