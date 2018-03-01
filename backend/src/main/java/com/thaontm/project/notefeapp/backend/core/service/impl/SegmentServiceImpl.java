package com.thaontm.project.notefeapp.backend.core.service.impl;

import com.thaontm.project.notefeapp.backend.core.dao.SegmentDao;
import com.thaontm.project.notefeapp.backend.core.model.Segment;
import com.thaontm.project.notefeapp.backend.core.service.SegmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SegmentServiceImpl implements SegmentService {

    @Autowired
    private SegmentDao segmentDao;

    @Override
    public Segment save(Segment entity) {
        return segmentDao.save(entity);
    }

    @Override
    public Segment findById(Long primaryKey) {
        return segmentDao.findOne(primaryKey);
    }

    @Override
    public Iterable<Segment> findAll() {
        return segmentDao.findAll();
    }

    @Override
    public long count() {
        return segmentDao.count();
    }

    @Override
    public void delete(Segment entity) {
        segmentDao.delete(entity);
    }
}
