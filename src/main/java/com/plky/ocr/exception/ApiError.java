package com.plky.ocr.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
public class ApiError {

    private Error error;

    public ApiError(HttpStatus code, String message) {
        this.error = new Error(code, message, null);
    }

    @Data
    class Error {
        private HttpStatus status;
        private String message;
        private List<Detail> details;

        Error(HttpStatus status, String message, List<String> details) {
            log.error("An Error Has Occurred: {} {}", status, message);

            this.status = status;
            this.message = message;

            if (details != null && !details.isEmpty()) {
                this.details = new ArrayList<>();

                for(String detail : details) {
                    this.details.add(new Detail(detail));
                }
            }
        }

        @Data
        @AllArgsConstructor
        class Detail {
            private String message;
        }
    }
}
