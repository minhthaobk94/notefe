package com.thaontm.project.notefeapp.backend.api;

import com.thaontm.project.notefeapp.backend.scrapper.Scrapper;
import com.thaontm.project.notefeapp.backend.core.model.Post;
import com.thaontm.project.notefeapp.backend.core.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    Scrapper scrapper;

    @GetMapping(path = "/post")
    public ResponseEntity<Iterable<Post>> getPosts() throws IOException, ParseException {
        return new ResponseEntity<>(scrapper.getPosts(), HttpStatus.OK);
    }

    @GetMapping(path = "/post/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
    }

}