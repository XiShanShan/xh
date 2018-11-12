package com.baizhi.service;

import com.baizhi.dao.ChapterDAO;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements  ChapterService {

    @Autowired
    private ChapterDAO chapterDAO;

    @Override
    public List<Chapter> findByPage(Integer page, Integer rows) {
        return null;
    }

    @Override
    public Long findTotals() {
        return null;
    }

    @Override
    public void save(Chapter chapter) {
        chapter.setId(UUID.randomUUID().toString());
        chapter.setUpLoadDate(new Date());
        chapterDAO.save(chapter);
    }

    @Override
    public void update(Chapter chapter) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Chapter queryOne(String id) {
        return null;
    }

    @Override
    public List<Chapter> findAll() {
        return null;
    }
}
