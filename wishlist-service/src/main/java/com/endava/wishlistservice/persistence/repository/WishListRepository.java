package com.endava.wishlistservice.persistence.repository;

import com.endava.wishlistservice.persistence.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {
}
