package com.joomak.backend.repository;

import com.joomak.backend.model.member.entity.Store;
import com.joomak.backend.model.member.enums.StoreState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findByStoreState(StoreState storeState);
}
