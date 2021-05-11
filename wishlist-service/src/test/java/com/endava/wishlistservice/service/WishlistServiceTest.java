package com.endava.wishlistservice.service;

import com.endava.wishlistservice.persistence.entity.WishList;
import com.endava.wishlistservice.persistence.repository.WishListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.endava.wishlistservice.testutils.WishlistUtilsUT.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WishlistServiceTest {

    @Mock
    WishListRepository wishlistRepository;

    @InjectMocks
    WishListService wishlistService;

    @Test
    void testGetWishlists() {
        when(wishlistRepository.findAll()).thenReturn(LIST_OF_WISHLISTS);

        List<WishList> actual = wishlistService.getWishlists();

        verify(wishlistRepository, times(1)).findAll();
        assertThat(actual).isEqualTo(LIST_OF_WISHLISTS);
    }

    @Test
    void testSave() {
        when(wishlistRepository.save(DEFAULT_WISHLIST)).thenReturn(DEFAULT_WISHLIST);

        WishList actual = wishlistService.save(DEFAULT_WISHLIST);

        verify(wishlistRepository, times(1)).save(DEFAULT_WISHLIST);
        assertThat(actual).isEqualTo(DEFAULT_WISHLIST);
    }

    @Test
    void testDeleteWishList() {
        when(wishlistRepository.findById(EXISTING_ID)).thenReturn(Optional.of(EXISTING_WISHLIST));

        Long actual = wishlistService.deleteWishListById(EXISTING_ID);

        verify(wishlistRepository,times(1)).deleteById(EXISTING_ID);
        assertThat(actual).isEqualTo(EXISTING_ID);
    }

    @Test
    void whenDeleteNonexistentWishlist_ShouldThrow_WishListNotFound() {
        when(wishlistRepository.findById(EXISTING_ID)).thenReturn(Optional.empty());

        assertThatThrownBy(
                () -> wishlistService.deleteWishListById(EXISTING_ID)
        );
    }
}