package com.endava.wishlistservice.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WishListNotFoundException extends RuntimeException {

    private Long id;

    public WishListNotFoundException(Long id) {
        super("Nonexistent wishlist id: " + id);
        this.id = id;
    }
}
