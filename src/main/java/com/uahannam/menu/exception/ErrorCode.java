package com.uahannam.menu.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum ErrorCode {
    DUPLICATE_MENU_ITEM(HttpStatus.BAD_REQUEST, "Duplicate menu item"),
    MENU_ITEM_NOT_FOUND(HttpStatus.NOT_FOUND, "Menu item not found"),
    MENU_ITEM_NOT_VALID(HttpStatus.BAD_REQUEST, "Menu item not valid"),
    MENU_ITEM_NOT_AVAILABLE(HttpStatus.BAD_REQUEST, "Menu item not available"),
    MENU_ITEM_NOT_IN_MENU(HttpStatus.BAD_REQUEST, "Menu item not in menu"),
    MENU_ITEM_NOT_IN_ORDER(HttpStatus.BAD_REQUEST, "Menu item not in order"),
    MENU_ITEM_NOT_IN_CART(HttpStatus.BAD_REQUEST, "Menu item not in cart"),
    MENU_ITEM_NOT_IN_WISHLIST(HttpStatus.BAD_REQUEST, "Menu item not in wishlist"),;

    public static final String ERROR_CODE_PREFIX = "ERR_";
    public static final String ERROR_CODE_SUFFIX = "_CODE";

    private final HttpStatus httpStatus;

    private final String message;

    public String getCode() {
        return ERROR_CODE_PREFIX + this.name() + ERROR_CODE_SUFFIX;
    }

}
