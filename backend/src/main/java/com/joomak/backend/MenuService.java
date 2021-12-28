package com.joomak.backend;

import com.joomak.backend.domain.MenuBase;
import com.joomak.backend.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor  // final 있는 것만 constructor 생성 allargsConstructor 은
public class MenuService {
    private final MenuRepository menuRepository;

    //메뉴 생성
    @Transactional(readOnly = false)
    public Long create(MenuBase menuBase){   // 중복 회원 검증
        menuRepository.save(menuBase);
        return menuBase.getId();
    }
    //메뉴 전체 조회
    public List<MenuBase> findAllMenu(){
        return menuRepository.findAll();
    }

}
