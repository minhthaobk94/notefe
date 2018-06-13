package com.thaontm.project.notefeapp.backend.api;

import com.thaontm.project.notefeapp.backend.core.model.Post;
import com.thaontm.project.notefeapp.backend.core.service.PostService;
import com.thaontm.project.notefeapp.backend.scrapper.Scrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    private final PostService postService;
    private final Scrapper scrapper;

    @Autowired
    public PostController(final PostService postService, final Scrapper scrapper) {
        this.postService = postService;
        this.scrapper = scrapper;
    }

    @GetMapping(path = "/post")
    public ResponseEntity<Iterable<Post>> getPosts() {
        return new ResponseEntity<>(scrapper.getPosts(), HttpStatus.OK);
    }

    @GetMapping(path = "/post/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
    }

}
