package io.ozguraslan.ppmtool.exception;

import io.ozguraslan.ppmtool.domain.Project;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice// voor global exception handling
public class ProjectIdExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectIdException (ProjectIdException exc, WebRequest webRequest){


        ProjectIdExceptionRespond projectIdExceptionRespond = new ProjectIdExceptionRespond(exc.getMessage());

        return new  ResponseEntity(projectIdExceptionRespond, HttpStatus.BAD_REQUEST);

    }


}
