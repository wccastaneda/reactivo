package co.com.bancolombia.model.exceptions;

import co.com.bancolombia.model.exceptions.message.BusinessErrorMessage;
import co.com.bancolombia.model.exceptions.message.TechnicalErrorMessage;
import lombok.Getter;

@Getter
public class TechnicalException extends RuntimeException {

    private final TechnicalErrorMessage errorMessage;

    public TechnicalException(TechnicalErrorMessage technicalErrorMessage) {
        super(technicalErrorMessage.getMessage());
        this.errorMessage = technicalErrorMessage;
    }

    public TechnicalException(Throwable cause, TechnicalErrorMessage technicalErrorMessage) {
        super(technicalErrorMessage.getMessage(), cause);
        this.errorMessage = technicalErrorMessage;
    }
}
