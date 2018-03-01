package com.thaontm.project.notefeapp.backend.core.dao;

import com.thaontm.project.notefeapp.backend.core.model.Translation;
import org.springframework.data.repository.CrudRepository;

public interface TranslationDao extends CrudRepository<Translation, Long> {
}
