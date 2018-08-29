package com.sdsxer.mmdiary.repository;

import com.sdsxer.mmdiary.domain.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends JpaRepository<Story, Integer> {

}
