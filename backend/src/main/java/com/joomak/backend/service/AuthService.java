package com.joomak.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthService {

    private final CommonService commonService;

    public int getAuthNum(Long memberId){
        int authNum = commonService.getNumberGen(6);
        //이메일 발송
        //sendEmail(memberId,authNum,emailType);
        return authNum;
    }

    public String sendEmail(){
        String message ="";
        return message;
    }
}
