package com.sdsxer.mmdiary.service;

import com.sdsxer.mmdiary.common.ItemStatus;
import com.sdsxer.mmdiary.domain.Notice;
import com.sdsxer.mmdiary.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    public Notice add(Notice notice) {
        notice.setStatus(ItemStatus.VERIFYING.getValue());
        notice.setCreateTime(new Date(System.currentTimeMillis()));
        return noticeRepository.saveAndFlush(notice);
    }

    public Notice get(int id) {
        Optional<Notice> noticeOptional = noticeRepository.findById(id);
        return noticeOptional.get();
    }

    public Notice update(Notice notice) {
        notice.setStatus(ItemStatus.VERIFYING.getValue());
        notice.setLastModifyTime(new Date(System.currentTimeMillis()));
        return noticeRepository.saveAndFlush(notice);
    }

    public void revoke(int id) {
        Optional<Notice> noticeOptional = noticeRepository.findById(id);
        if(noticeOptional.isPresent()) {
            Notice notice = noticeOptional.get();
            long now = System.currentTimeMillis();
            notice.setLastModifyTime(new Date(now));
            notice.setRevokeTime(new Date(now));
            notice.setStatus(ItemStatus.REVOKED.getValue());
            noticeRepository.saveAndFlush(notice);
        }
    }
    public void release(int id) {
        Optional<Notice> noticeOptional = noticeRepository.findById(id);
        if(noticeOptional.isPresent()) {
            Notice notice = noticeOptional.get();
            long now = System.currentTimeMillis();
            notice.setLastModifyTime(new Date(now));
            notice.setReleaseTime(new Date(now));
            notice.setStatus(ItemStatus.NORMAL.getValue());
            noticeRepository.saveAndFlush(notice);
        }
    }

    public Page<Notice> list(Pageable pageable) {
        return noticeRepository.findAll(pageable);
    }
}
