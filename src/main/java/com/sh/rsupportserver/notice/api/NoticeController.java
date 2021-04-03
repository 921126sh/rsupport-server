package com.sh.rsupportserver.notice.api;

import com.sh.rsupportserver.notice.api.transferobject.NoticePageResponse;
import com.sh.rsupportserver.notice.api.transferobject.NoticeRequest;
import com.sh.rsupportserver.notice.api.transferobject.NoticeResponse;
import com.sh.rsupportserver.notice.application.ChangeNoticeService;
import com.sh.rsupportserver.notice.application.RetrieveNoticeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 공지 REST 컨트롤러이다.
 *
 * @author seonghyun
 */
@RestController
@AllArgsConstructor
@RequestMapping("/notices")
public class NoticeController {
    /**
     * 공지 조회 서비스
     */
    private final RetrieveNoticeService retrieveNoticeService;

    /**
     * 공지 변경 서비스
     */
    private final ChangeNoticeService changeNoticeService;

    @ApiOperation(value = "공지 목록을 조회한다.", nickname = "retrieveNoticeList")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = NoticeResponse.class)})
    @GetMapping(value = "")
    public @ResponseBody
    ResponseEntity<NoticePageResponse> retrieveNoticeList(@RequestParam("page") int page, @RequestParam("size") int size) {
        ResponseEntity<NoticePageResponse> responseEntity;

        // 공지 목록을 조회한다.
        NoticePageResponse responses = retrieveNoticeService.retrieveNoticeList(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "noticeNo")));
        if (responses == null) {
            // 응답(내용없음)을 설정한다.
            responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            // 응답(성공)을 설정한다.
            responseEntity = new ResponseEntity<>(responses, HttpStatus.OK);
        }

        return responseEntity;
    }

    @ApiOperation(value = "공지를 조회한다.", nickname = "retrieveNotice")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = NoticeResponse.class)})
    @GetMapping(value = "/{notice-no}")
    public @ResponseBody
    ResponseEntity<NoticeResponse> retrieveNotice(@PathVariable("notice-no") Long noticeNo) {
        // 공지를 조회한다.
        NoticeResponse response = retrieveNoticeService.retrieveNotice(noticeNo);

        // 응답(성공)을 설정한다.
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "공지를 등록한다.", nickname = "registerNotice")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success")})
    @PostMapping(value = "")
    public @ResponseBody
    HttpEntity<Void> registerNotice(@RequestBody NoticeRequest noticeRequest) {
        // 공지를 등록한다.
        changeNoticeService.registerNotice(noticeRequest);

        // 응답(생성)을 설정한다.
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "공지를 수정한다.", nickname = "editNotice")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success")})
    @PutMapping(value = "/{notice-no}")
    public @ResponseBody
    HttpEntity<Void> editNotice(@PathVariable("notice-no") Long noticeNo, @RequestBody NoticeRequest noticeRequest) {
        // 공지를 수정한다.
        changeNoticeService.editNotice(noticeNo, noticeRequest);

        // 응답(내용없음)을 설정한다.
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "공지를 삭제한다.", nickname = "deleteNotice")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success")})
    @DeleteMapping(value = "/{notice-no}")
    public @ResponseBody
    HttpEntity<Void> deleteNotice(@PathVariable("notice-no") Long noticeNo) {
        // 공지를 삭제한다.
        changeNoticeService.deleteNotice(noticeNo);

        // 응답(내용없음)을 설정한다.
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
