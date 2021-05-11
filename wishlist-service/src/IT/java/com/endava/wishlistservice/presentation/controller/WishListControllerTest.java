package com.endava.wishlistservice.presentation.controller;

import com.endava.wishlistservice.presentation.dto.WishListDTO;
import com.endava.wishlistservice.presentation.dto.WishListDetailsDto;
import com.endava.wishlistservice.service.WishListService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static com.endava.wishlistservice.presentation.utils.WishListConverterUtils.convertToWishListDto;
import static com.endava.wishlistservice.testutils.WishlistUtilsIT.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WishListControllerTest extends AbstractIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    WishListService wishListService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testGetAllWishLists() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                get(ENDPOINT)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String actual = mvcResult.getResponse().getContentAsString();
        List<WishListDTO> expectedDtos = convertToWishListDto(wishListService.getWishlists());
        String expected = objectMapper.writeValueAsString(expectedDtos);

        assertThat(actual).isEqualToIgnoringWhitespace(expected);
    }

    @Test
    void testSaveWishlist() throws Exception {
        mockMvc.perform(
                post((ENDPOINT))
                        .content(objectMapper.writeValueAsString(VALID_DTO_TO_SAVE))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @ParameterizedTest
    @MethodSource("com.endava.wishlistservice.testutils.WishlistUtilsIT#badRequestWishlists")
    void testSaveWishlist_whenNotValidated_thenBadRequest(WishListDetailsDto dtoToSave) throws Exception {
        mockMvc.perform(
                post((ENDPOINT))
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dtoToSave)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testDeleteWishlist() throws Exception {
        mockMvc.perform(
                delete(ENDPOINT + "/{id}", EXISTING_ID)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id")
                        .value(String.valueOf(EXISTING_ID)));
    }
}