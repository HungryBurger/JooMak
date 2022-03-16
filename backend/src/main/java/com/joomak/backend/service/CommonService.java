package com.joomak.backend.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Slf4j
@Service
@Transactional(readOnly = true)
public class CommonService {
    public int getNumberGen(int numberOfDigit){
        Random random = new Random();
        return random.nextInt((10*numberOfDigit)-1);
    }
}
