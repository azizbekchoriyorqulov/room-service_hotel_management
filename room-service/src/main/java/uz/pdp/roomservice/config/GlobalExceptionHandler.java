package uz.pdp.roomservice.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.pdp.roomservice.exaption.DataNotFoundException;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {DataNotFoundException.class})
    public ResponseEntity<String> DataNotFoundExceptionHandler(
            DataNotFoundException e
    ) {
        return ResponseEntity.status(401).body(e.getMessage());
    }


}
