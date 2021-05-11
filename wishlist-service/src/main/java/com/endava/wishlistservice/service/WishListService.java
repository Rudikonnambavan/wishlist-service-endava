package com.endava.wishlistservice.service;

import com.endava.wishlistservice.exception.WishListNotFoundException;
import com.endava.wishlistservice.persistence.entity.WishList;
import com.endava.wishlistservice.persistence.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final WishListRepository wishListRepository;

    public List<WishList> getWishlists() {
        return wishListRepository.findAll();
    }

    public WishList save(WishList wishlist) {
        return wishListRepository.save(wishlist);
    }

    public Long deleteWishListById(Long id) {
        WishList wishList = wishListRepository.findById(id)
                .orElseThrow(() -> new WishListNotFoundException(id));
        wishListRepository.deleteById(wishList.getId());
        return wishList.getId();
    }
}
