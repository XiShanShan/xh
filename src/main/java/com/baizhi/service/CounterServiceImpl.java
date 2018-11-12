package com.baizhi.service;

import com.baizhi.dao.CounterDAO;
import com.baizhi.entity.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CounterServiceImpl implements CounterService{
@Autowired
    private CounterDAO counterDAO;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Counter> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        //System.out.println("start:"+start);
        // System.out.println("page:"+page);
        // System.out.println("rows:"+rows);
        return counterDAO.findByPage(start,rows);
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return counterDAO.findTotals();
    }
    @Override
    public void save(Counter counter) {
        counter.setId(UUID.randomUUID().toString());
        // course.setUpLoadDate(new Date());
        counterDAO.save(counter);
    }

    @Override
    public void update(Counter counter) {
        counterDAO.update(counter);
    }

    @Override
    public void delete(String id) {
        counterDAO.delete(id);
    }

    @Override
    public Counter queryOne(String id) {
        return counterDAO.queryOne(id);
    }

    @Override
    public List<Counter> findAll() {
        List<Counter> list = counterDAO.findAll();
        return list;
    }
}
