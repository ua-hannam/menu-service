package com.uahannam.menu.domain;

import com.uahannam.menu.dto.MenuResponseDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "menu")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Menu {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    @Column(nullable = false)
    private String menuName;

    @Column(nullable = false)
    private int menuPrice;

    @Column
    private String menuDesc;

    @ManyToOne
    @JoinColumn(name = "menu_group_id", nullable = false)
    private MenuGroup menuGroup;

    @ManyToOne
    @JoinColumn(name = "catalog_id", nullable = false)
    private Catalog catalog;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modDate;

    public MenuResponseDto toDto() {
        return MenuResponseDto.builder()
                .menuName(menuName)
                .menuPrice(menuPrice)
                .menuDesc(menuDesc)
                .build();
    }

}
