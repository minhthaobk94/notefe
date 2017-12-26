package com.thaontm.project.notefecore.service.impl;

import com.thaontm.project.notefecore.dao.LanguageDao;
import com.thaontm.project.notefecore.model.Language;
import com.thaontm.project.notefecore.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageDao languageDao;

    @Override
    public Language save(Language entity) {
        return languageDao.save(entity);
    }

    @Override
    public Language findById(Long primaryKey) {
        return languageDao.findOne(primaryKey);
    }

    @Override
    public Iterable<Language> findAll() {
        return languageDao.findAll();
    }

    @Override
    public long count() {
        return languageDao.count();
    }

    @Override
    public void delete(Language entity) {
        languageDao.delete(entity);
    }
}
