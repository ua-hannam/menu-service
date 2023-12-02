package com.uahannam.menu.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class MenuException extends RuntimeException{

    private final ErrorCode errorCode;

    private final HttpStatus httpStatus;

}
