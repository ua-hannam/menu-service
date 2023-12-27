package com.uahannam.menu.domain;

import com.uahannam.menu.dto.MenuResponseDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "menu")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long menuId;

    @Column(name = "menu_name", nullable = false)
    private String menuName;

    @Column(name = "menu_desc")
    private String menuDesc;

    @ManyToOne
    @JoinColumn(name = "menu_group_id", nullable = false)
    private MenuGroup menuGroup;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


    @OneToMany(mappedBy = "menu", orphanRemoval = true, cascade = CascadeType.ALL)
    private final List<MenuStore> store = new ArrayList<>();

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

    public void setStore(List<MenuStore> list) {
        for (MenuStore menuStore : list) {
            if (!this.store.contains(menuStore)) {
                this.store.add(menuStore);
                menuStore.setParent(this);
            }
        }
    }

}
