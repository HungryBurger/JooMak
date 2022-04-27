package com.joomak.backend.controller.common;

import com.joomak.backend.domain.common.AttachmentRepository;
import com.joomak.backend.domain.common.AttachmentType;
import com.joomak.backend.domain.common.FileStore;
import com.joomak.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/common")
public class CommonController {

    private final AttachmentRepository attachmentRepository;
    private final FileStore fileStore;

    private final AuthService authService;

    //인증번호 발송
    //세션값으로 어떻게 생성하는지 확인이 필요하다.
    @GetMapping(value ="/digit/{memberId}", produces={MediaType.APPLICATION_JSON_VALUE})
    public int getAuthNum(@PathVariable("memberId") Long memberId){
        int authNum = authService.getAuthNum(memberId);
        return authNum;
    }

    @PostMapping(value = "/file")
    public String fileSave(@RequestPart MultipartFile multipartFile, @RequestPart AttachmentType attachmentType) {
        try {
            System.out.println(multipartFile.getName());
            fileStore.storeFile(multipartFile, attachmentType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return multipartFile.getName();
    }


}
