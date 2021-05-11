package com.endava.wishlistservice.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wishlist")
public class WishList {

    @Id
    @SequenceGenerator(name = "wishlist_seq", sequenceName = "wishlist_seq", allocationSize = 1, initialValue = 4)
    @GeneratedValue(strategy = SEQUENCE, generator = "wishlist_seq")
    private Long id;

    private String title;

    @Column(name = "wishlist_date")
    private LocalDateTime wishListDate;

    private String description;

    @Enumerated(EnumType.STRING)
    private PrivacyType privacyType;

    @Enumerated(EnumType.STRING)
    private EventType eventType;
}
