package com.sdsxer.mmdiary.controller;

import com.sdsxer.mmdiary.response.RestResponse;
import com.sdsxer.mmdiary.domain.Notice;
import com.sdsxer.mmdiary.service.NoticeService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notice")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public RestResponse add(@RequestBody Notice notice) {
        return null;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public RestResponse get(@RequestParam(name = "id") int id) {
        return null;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public RestResponse update(@RequestBody Notice notice) {
        return null;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public RestResponse delete(@RequestParam(name = "id") int id) {
        return null;
    }

    @RequestMapping(value = "/revoke", method = RequestMethod.GET)
    public RestResponse revoke(@RequestParam(name = "id") int id) {
        return null;
    }

    @RequestMapping(value = "/release", method = RequestMethod.GET)
    public RestResponse release(@RequestParam(name = "id") int id) {
        return null;
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public RestResponse list(@RequestBody Pageable pageable) {
        return null;
    }
}
