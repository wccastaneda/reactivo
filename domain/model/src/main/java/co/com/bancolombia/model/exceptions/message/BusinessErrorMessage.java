package co.com.bancolombia.model.exceptions.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BusinessErrorMessage {

    INVALID_NAME("01", "Invalid name"),
    INVALID_REQUEST("02", "Invalid request");

    private final String code;
    private final String message;
}
