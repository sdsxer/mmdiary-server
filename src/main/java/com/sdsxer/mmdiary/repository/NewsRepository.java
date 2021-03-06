package com.sdsxer.mmdiary.repository;

import com.sdsxer.mmdiary.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {

}
