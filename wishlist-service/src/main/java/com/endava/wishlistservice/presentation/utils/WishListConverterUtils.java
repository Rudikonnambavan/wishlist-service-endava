package com.endava.wishlistservice.presentation.utils;

import com.endava.wishlistservice.persistence.entity.EventType;
import com.endava.wishlistservice.persistence.entity.PrivacyType;
import com.endava.wishlistservice.persistence.entity.WishList;
import com.endava.wishlistservice.presentation.dto.WishListDTO;
import com.endava.wishlistservice.presentation.dto.WishListDetailsDto;
import com.endava.wishlistservice.exception.InvalidValueException;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.endava.wishlistservice.persistence.entity.PrivacyType.PRIVATE;

@NoArgsConstructor
public final class WishListConverterUtils {

    public static List<WishListDTO> convertToWishListDto(List<WishList> wishLists) {
        return wishLists.stream()
                .map(wishList -> WishListDTO.builder()
                        .id(wishList.getId())
                        .title(wishList.getTitle())
                        .wishListDate(wishList.getWishListDate())
                        .build())
                .collect(Collectors.toList());
    }

    public static WishList convertWishlistDtoToWishlist(WishListDetailsDto wishListDetailsDto) {
        return WishList.builder()
                .title(wishListDetailsDto.getTitle())
                .description(wishListDetailsDto.getDescription())
                .eventType(getEventTypeIfPresent(wishListDetailsDto.getEventType()))
                .privacyType(getPrivacyTypeIfPresent(wishListDetailsDto.getPrivacyType()))
                .wishListDate(Objects.requireNonNullElseGet(wishListDetailsDto.getWishListDate(), LocalDateTime::now))
                .build();
    }
    private static EventType getEventTypeIfPresent(String eventType) {
        if (EventType.notContains(eventType)) {
            throw new InvalidValueException("eventType", eventType);
        }
        return EventType.valueOf(eventType);
    }
    private static PrivacyType getPrivacyTypeIfPresent(String privacyType) {
        if (PrivacyType.notContains(privacyType) && privacyType != null) {
            throw new InvalidValueException("privacyType", privacyType);
        }
        return PRIVATE;
    }

}