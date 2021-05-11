package com.endava.wishlistservice.testutils;

import com.endava.wishlistservice.persistence.entity.WishList;
import com.endava.wishlistservice.presentation.dto.WishListDTO;

import java.util.List;
import java.util.stream.Stream;

public class WishlistUtilsUT {

    public static final List<WishList> LIST_OF_WISHLISTS =
            List.of(new WishList(), new WishList());

    public static final WishList DEFAULT_WISHLIST =
            new WishList();

    public static final Long EXISTING_ID = 1L;

    public static final WishList EXISTING_WISHLIST =
            WishList.builder().id(EXISTING_ID).build();
}
