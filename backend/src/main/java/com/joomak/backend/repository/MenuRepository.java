package com.joomak.backend.repository;

import com.joomak.backend.domain.MenuBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MenuRepository {

    private final EntityManager em;

    public void save(MenuBase menu) {
        em.persist(menu);
    }

    public MenuBase findOne(Long id) {
        return em.find(MenuBase.class, id);
    }
    public List<MenuBase> findAll() {
        return em.createQuery("select m from MenuBase m", MenuBase.class)
                .getResultList();
    }
}
