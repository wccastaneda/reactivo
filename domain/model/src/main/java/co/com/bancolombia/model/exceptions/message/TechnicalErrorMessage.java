package co.com.bancolombia.model.exceptions.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TechnicalErrorMessage {

    CONNECTION_REFUSED("01", "Connection refused");

    private final String code;
    private final String message;
}
