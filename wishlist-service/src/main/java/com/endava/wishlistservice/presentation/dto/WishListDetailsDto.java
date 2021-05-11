package com.endava.wishlistservice.presentation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Builder
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class WishListDetailsDto {

    private Long id;

    @NotBlank
    @Size(min = 1, max = 25)
    private String title;
    private LocalDateTime wishListDate;
    private String description;
    private String privacyType;

    @NotBlank
    private String eventType;
}
