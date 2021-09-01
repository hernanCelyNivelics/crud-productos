package com.hcely.crudproductos.exception;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Builder
public class ErrorMessage {

    private HttpStatus status;

    private String error_code;

    private String message;

    private String detail;
    private LocalDateTime timeStamp;

    public static final class ErrorMessageBuilder {
        private HttpStatus status;
        private String error_code;
        private String message;
        private String detail;
        private LocalDateTime timeStamp;

        public ErrorMessageBuilder() {
        }

        public static ErrorMessageBuilder anApiErrorResponse() {
            return new ErrorMessageBuilder();
        }

        public ErrorMessage build() {
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.status = this.status;
            errorMessage.error_code = this.error_code;
            errorMessage.detail = this.detail;
            errorMessage.message = this.message;
            errorMessage.timeStamp = this.timeStamp;
            return errorMessage;
        }
    }
}

