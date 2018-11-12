package com.baizhi.service;

import com.baizhi.dao.GurnDAO;
import com.baizhi.entity.Gurn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GurnServiceImpl implements GurnService {
        @Autowired
    private GurnDAO gurnDAO;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Gurn> findByPage(Integer page, Integer rows) {
        // System.out.println("service测试"+page+"   "+rows);
        int start = (page - 1) * rows;
        return gurnDAO.findByPage(start,rows);
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return gurnDAO.findTotals();
    }
    @Override
    public void save(Gurn gurn) {
        gurn.setId(UUID.randomUUID().toString());
        gurnDAO.save(gurn);
    }
    @Override
    public void update(Gurn gurn){
       gurnDAO.update(gurn);
    }
    @Override
    public void delete(String id){
        gurnDAO.delete(id);
    }
    @Override
    public Gurn queryOne(String id) {
        return gurnDAO.queryOne(id);
    }

    @Override
    public List<Gurn > findAll() {
        List<Gurn> list = gurnDAO.findAll();
        return list;
    }

}
