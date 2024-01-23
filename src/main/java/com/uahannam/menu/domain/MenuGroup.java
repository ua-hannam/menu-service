package com.uahannam.menu.domain;

import com.uahannam.menu.dto.MenuGroupResponseDto;
import com.uahannam.menu.dto.MenuResponseDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "menu_group")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class MenuGroup extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_group_id")
    private Long menuGroupId;

    @Column(name = "menu_group_name", nullable = false)
    private String menuGroupName;

    public MenuGroupResponseDto toDto() {
        return MenuGroupResponseDto.builder()
                .menuGroupId(this.menuGroupId)
                .menuGroupName(this.menuGroupName)
                .build();
    }

    public MenuGroup(long menuGroupId) {
        this.menuGroupId = menuGroupId;
    }
}
