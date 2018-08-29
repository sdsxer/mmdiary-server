package com.sdsxer.mmdiary.repository;

import com.sdsxer.mmdiary.domain.Dialect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DialectRepository extends JpaRepository<Dialect, Integer> {

}
