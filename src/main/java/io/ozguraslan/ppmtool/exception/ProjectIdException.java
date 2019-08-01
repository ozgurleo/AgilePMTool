package io.ozguraslan.ppmtool.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)//elke keer dit incident word opgeroept de status zal badrequest zijn.
public class ProjectIdException extends RuntimeException {//exception zichzelfs


    public ProjectIdException(String message) {
        super(message);
    }
}
