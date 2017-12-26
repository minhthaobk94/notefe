package com.thaontm.project.notefecore.dao;

import com.thaontm.project.notefecore.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostDao extends CrudRepository<Post, Long> {
}
