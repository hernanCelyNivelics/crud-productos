package com.producto.demoProductos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        ApiException apiException = new ApiException(e.getMessage(), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> handleNodataFoundException(
            NoDataFoundException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND);
        body.put("message", ex.getMessage());


        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  HttpHeaders headers,
//                                                                  HttpStatus status,
//                                                                  WebRequest request) {
//        List<String> details = new ArrayList<>();
//        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
//            details.add(error.getDefaultMessage());
//        }
//        ErrorMessage error = new ErrorMessage("Validation Failed", details);
//        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
//    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseResult BodyMissingExceptionHandler(HttpMessageNotReadableException e) {
        //log.error("", e);
        return new ResponseResult(ResultEnum.PARAMETER_ERROR.getCode(), "El cuerpo del parámetro no puede estar vacío");

    }
}