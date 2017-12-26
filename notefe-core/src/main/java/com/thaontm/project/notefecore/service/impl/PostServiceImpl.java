package com.thaontm.project.notefecore.service.impl;

import com.thaontm.project.notefecore.dao.PostDao;
import com.thaontm.project.notefecore.model.Post;
import com.thaontm.project.notefecore.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public Post save(Post entity) {
        return postDao.save(entity);
    }

    @Override
    public Post findById(Long primaryKey) {
        return postDao.findOne(primaryKey);
    }

    @Override
    public Iterable<Post> findAll() {
        return postDao.findAll();
    }

    @Override
    public long count() {
        return postDao.count();
    }

    @Override
    public void delete(Post entity) {
        postDao.delete(entity);
    }
}
