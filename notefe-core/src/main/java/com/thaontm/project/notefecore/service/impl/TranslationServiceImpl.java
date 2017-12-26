package com.thaontm.project.notefecore.service.impl;

import com.thaontm.project.notefecore.dao.TranslationDao;
import com.thaontm.project.notefecore.model.Translation;
import com.thaontm.project.notefecore.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationServiceImpl implements TranslationService {

    @Autowired
    private TranslationDao translationDao;

    @Override
    public Translation save(Translation entity) {
        return translationDao.save(entity);
    }

    @Override
    public Translation findById(Long primaryKey) {
        return translationDao.findOne(primaryKey);
    }

    @Override
    public Iterable<Translation> findAll() {
        return translationDao.findAll();
    }

    @Override
    public long count() {
        return translationDao.count();
    }

    @Override
    public void delete(Translation entity) {
        translationDao.delete(entity);
    }
}
