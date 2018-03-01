package com.thaontm.project.notefeapp.backend.core.dao;

import com.thaontm.project.notefeapp.backend.core.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostDao extends CrudRepository<Post, Long> {
}
