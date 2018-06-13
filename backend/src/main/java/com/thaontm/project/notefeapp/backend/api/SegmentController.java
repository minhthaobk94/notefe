package com.thaontm.project.notefeapp.backend.api;

import com.thaontm.project.notefeapp.backend.core.model.Segment;
import com.thaontm.project.notefeapp.backend.core.service.SegmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SegmentController {

    private final SegmentService segmentService;

    @Autowired
    public SegmentController(final SegmentService segmentService) {
        this.segmentService = segmentService;
    }

    @GetMapping(path = "/segment")
    public ResponseEntity<Iterable<Segment>> getSegments() {
        return new ResponseEntity<>(segmentService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/segment/{id}")
    public ResponseEntity<Segment> getSegmentById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(segmentService.findById(id), HttpStatus.OK);
    }
}
