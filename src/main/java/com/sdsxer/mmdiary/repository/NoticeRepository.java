package com.sdsxer.mmdiary.repository;

import com.sdsxer.mmdiary.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {


}
