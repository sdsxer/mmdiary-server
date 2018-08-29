package com.sdsxer.mmdiary.repository;

import com.sdsxer.mmdiary.domain.Biography;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiographyRepository extends JpaRepository<Biography, Integer> {

}
