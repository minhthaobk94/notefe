package com.thaontm.project.notefeapp.backend.core.dao;

import com.thaontm.project.notefeapp.backend.core.model.Segment;
import org.springframework.data.repository.CrudRepository;

public interface SegmentDao extends CrudRepository<Segment, Long> {
}
