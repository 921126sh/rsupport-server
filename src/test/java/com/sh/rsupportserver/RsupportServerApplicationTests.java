package com.sh.rsupportserver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sh.rsupportserver.notice.api.transferobject.NoticeRequest;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@AutoConfigureMockMvc
@Transactional
@Ignore
@SpringBootTest
class RsupportServerApplicationTests {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach()
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .alwaysDo(print()).build();
    }

    @Test
    public void retrieveNoticeList() throws Exception {
        MultiValueMap<String, String> info = new LinkedMultiValueMap<>();

        info.add("page", "1");
        info.add("size", "100");

        this.mvc.perform(get("/notices")
                .params(info))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    public void registerNotice() throws Exception {
        String content = objectMapper.writeValueAsString(new NoticeRequest("테스트 공지 제목", "테스트 공지 내용"));

        this.mvc.perform(post("/notices")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void editNotice() throws Exception {
        String content = objectMapper.writeValueAsString(new NoticeRequest("222", "222"));

        this.mvc.perform(put("/notices/{noticeNo}", 1)
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andDo(print());
    }

    @Test
    public void deleteNotice() throws Exception {
        this.mvc.perform(delete("/notices/{noticeNo}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andDo(print());
    }
}
