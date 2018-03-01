package com.thaontm.project.notefeapp.backend.core.service.impl;

import com.thaontm.project.notefeapp.backend.core.dao.SegmentTypeDao;
import com.thaontm.project.notefeapp.backend.core.model.SegmentType;
import com.thaontm.project.notefeapp.backend.core.service.SegmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SegmentTypeServiceImpl implements SegmentTypeService {

    @Autowired
    private SegmentTypeDao segmentTypeDao;

    @Override
    public SegmentType save(SegmentType entity) {
        return segmentTypeDao.save(entity);
    }

    @Override
    public SegmentType findById(Long primaryKey) {
        return segmentTypeDao.findOne(primaryKey);
    }

    @Override
    public Iterable<SegmentType> findAll() {
        return segmentTypeDao.findAll();
    }

    @Override
    public long count() {
        return segmentTypeDao.count();
    }

    @Override
    public void delete(SegmentType entity) {
        segmentTypeDao.delete(entity);
    }
}
