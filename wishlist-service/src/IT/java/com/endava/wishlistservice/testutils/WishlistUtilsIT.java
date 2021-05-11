package com.endava.wishlistservice.testutils;

import com.endava.wishlistservice.persistence.entity.WishList;
import com.endava.wishlistservice.presentation.dto.WishListDTO;
import com.endava.wishlistservice.presentation.dto.WishListDetailsDto;

import java.util.List;
import java.util.stream.Stream;

public class WishlistUtilsIT {

    public static final String ENDPOINT = "/api/wishlists";

    public static final Integer EXISTING_ID = 1;

    public static final WishListDetailsDto VALID_DTO_TO_SAVE =
            WishListDetailsDto.builder().title("abc").eventType("OTHER").build();

    public static Stream<WishListDetailsDto> badRequestWishlists() {
        return Stream.of(
                WishListDetailsDto.builder().title(null).eventType("OTHER").build(),
                WishListDetailsDto.builder().title("").eventType("OTHER").build(),
                WishListDetailsDto.builder().title(" ").eventType("OTHER").build(),
                WishListDetailsDto.builder().title(null).eventType("OTHER").build(),
                WishListDetailsDto.builder().title("abc").eventType(null).build(),
                WishListDetailsDto.builder().title("abc").eventType("").build()
                );
    }
}
