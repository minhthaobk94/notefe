package com.thaontm.project.notefeapp.backend.core.dao;

import com.thaontm.project.notefeapp.backend.core.model.Language;
import org.springframework.data.repository.CrudRepository;

public interface LanguageDao extends CrudRepository<Language, Long> {
}
