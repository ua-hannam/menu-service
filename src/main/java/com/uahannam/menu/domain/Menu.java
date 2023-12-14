package com.uahannam.menu.domain;

import com.uahannam.menu.dto.MenuResponseDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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

    @Column
    private String menuDesc;

    @ManyToOne
    @JoinColumn(name = "menu_group_id", nullable = false)
    private MenuGroup menuGroup;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


    @ManyToMany(mappedBy = "menus")
    private Set<MenuStore> menuStores = new HashSet<>();

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modDate;

    public MenuResponseDto toDto() {
        return MenuResponseDto.builder()
                .menuName(menuName)
                .menuDesc(menuDesc)
                .build();
    }

}
