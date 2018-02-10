package com.thaontm.project.notefeapp.backend.utils;

import com.thaontm.project.notefecore.model.Language;
import com.thaontm.project.notefecore.model.Post;
import com.thaontm.project.notefecore.model.Segment;
import com.thaontm.project.notefecore.model.SegmentType;
import com.thaontm.project.notefecore.service.LanguageService;
import com.thaontm.project.notefecore.service.PostService;
import com.thaontm.project.notefecore.service.SegmentService;
import com.thaontm.project.notefecore.service.SegmentTypeService;

import java.util.Date;

public class TestData {
    private TestData() {
    }

    public static void addSegment(PostService postService, SegmentService segmentService, SegmentTypeService segmentTypeService) {
        for (Post p : postService.findAll()) {
            segmentService.save(new Segment(0L, "this is title of " + p.getId(), p, segmentTypeService.findById(1L)));
            segmentService.save(new Segment(1L, "this is the first line of " + p.getId(), p, segmentTypeService.findById(2L)));
            segmentService.save(new Segment(2L, "this is the second line of " + p.getId(), p, segmentTypeService.findById(2L)));
            segmentService.save(new Segment(3L, "this is the third line of " + p.getId(), p, segmentTypeService.findById(2L)));
            segmentService.save(new Segment(4L, "this is the fourth line of " + p.getId(), p, segmentTypeService.findById(2L)));
        }
    }

    public static void addPost(PostService postService) {
        postService.save(new Post("post_link_1", new Date(), "img_link_1", "audio_link_1"));
        postService.save(new Post("post_link_2", new Date(), "img_link_2", "audio_link_2"));
        postService.save(new Post("post_link_3", new Date(), "img_link_3", "audio_link_3"));
    }

    public static void addSegmentType(SegmentTypeService segmentTypeService) {
        segmentTypeService.save(new SegmentType("title"));
        segmentTypeService.save(new SegmentType("body"));
        segmentTypeService.save(new SegmentType("vocab"));
    }

    public static void addLanguage(LanguageService languageService) {
        languageService.save(new Language("en", "English"));
        languageService.save(new Language("vi", "Vietnamese"));
    }
}
