package com.endava.wishlistservice.presentation.controller;

import com.endava.wishlistservice.persistence.entity.WishList;
import com.endava.wishlistservice.presentation.dto.WishListDTO;
import com.endava.wishlistservice.presentation.dto.WishListDetailsDto;
import com.endava.wishlistservice.service.WishListService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

import static com.endava.wishlistservice.presentation.utils.WishListConverterUtils.convertToWishListDto;
import static com.endava.wishlistservice.presentation.utils.WishListConverterUtils.convertWishlistDtoToWishlist;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
@CrossOrigin
public class WishListController {

    private final WishListService wishListService;

    @GetMapping("/wishlists")
    public ResponseEntity<List<WishListDTO>> getAllWishLists() {
        return ResponseEntity
            .ok()
            .body(convertToWishListDto(wishListService.getWishlists()));
    }

    @PostMapping("/wishlists")
    public ResponseEntity<WishListDetailsDto> addWishList(@RequestBody @Valid WishListDetailsDto wishListDetailsDto) {

        WishList wishlist = wishListService.save(convertWishlistDtoToWishlist(wishListDetailsDto));

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(WishListDetailsDto.builder().id(wishlist.getId()).build());
    }

    @DeleteMapping("/wishlists/{id}")
    public ResponseEntity<WishListDTO> deleteWishListById(@PathVariable Long id) {

        Long deletedWishListId = wishListService.deleteWishListById(id);

        return ResponseEntity
            .ok()
            .body(WishListDTO.builder().id(deletedWishListId).build());
    }
}