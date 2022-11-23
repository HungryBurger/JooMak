package com.joomak.backend.service;

import com.joomak.backend.exception.ServiceGuideException;
import com.joomak.backend.model.member.dto.*;
import com.joomak.backend.model.member.entity.Member;
import com.joomak.backend.model.member.entity.Store;
import com.joomak.backend.model.member.enums.StoreState;
import com.joomak.backend.repository.MemberRepository;
import com.joomak.backend.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StoreService {

    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    public StoreRetrieveResponse storeRetrieve(StoreState storeState){
        return null;
    }
    @Transactional
    public StoreCreateResponse createStore(StoreCreateRequest storeCreateRequest) {
        Optional<Member> member = memberRepository.findById(storeCreateRequest.getMemberId());

        Store store = storeCreateRequest.DtoToEntity(storeCreateRequest);
        store.setMember(member.get());

        StoreCreateResponse storeCreateResponse = new StoreCreateResponse().EntityToDto(store);

        return storeCreateResponse;
    }
}
