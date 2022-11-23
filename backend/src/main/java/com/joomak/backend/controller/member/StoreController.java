package com.joomak.backend.controller.member;


import com.joomak.backend.model.member.dto.*;
import com.joomak.backend.model.member.entity.Store;
import com.joomak.backend.model.member.enums.StoreState;
import com.joomak.backend.service.LoginService;
import com.joomak.backend.service.MemberService;
import com.joomak.backend.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreController {
    private final StoreService storeService;

    @GetMapping
    public ResponseEntity<StoreRetrieveResponse> retrieveStores(StoreState storeState) {
        StoreRetrieveResponse storeRetrieveResponse = storeService.storeRetrieve(storeState);
        return new ResponseEntity<>(storeRetrieveResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StoreCreateResponse> createMember(@RequestBody StoreCreateRequest storeCreateRequest) {
        StoreCreateResponse storeCreateResponse = storeService.createStore(storeCreateRequest);
        return new ResponseEntity<>(storeCreateResponse, HttpStatus.OK);
    }

}
