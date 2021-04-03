package com.sh.rsupportserver.notice.api.transferobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.pojomatic.annotations.AutoProperty;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Getter
@Setter
@AutoProperty
@NoArgsConstructor
@AllArgsConstructor
public class NoticePageResponse {
    /**
     * 데이터건수
     */
    private int total;

    /**
     * 페이징정보
     */
    private Pageable pageable;

    /**
     * 컨텐츠 목록
     */
    private List<NoticeResponse> contentList;
}
