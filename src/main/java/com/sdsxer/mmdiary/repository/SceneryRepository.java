package com.sdsxer.mmdiary.repository;

import com.sdsxer.mmdiary.domain.Scenery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SceneryRepository extends JpaRepository<Scenery, Integer> {

}
