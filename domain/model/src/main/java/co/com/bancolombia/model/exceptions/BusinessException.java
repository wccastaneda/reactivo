package co.com.bancolombia.model.exceptions;

import co.com.bancolombia.model.exceptions.message.BusinessErrorMessage;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final BusinessErrorMessage errorMessage;

    public BusinessException(BusinessErrorMessage businessErrorMessage) {
        super(businessErrorMessage.getMessage());
        this.errorMessage = businessErrorMessage;
    }

    public BusinessException(Throwable cause, BusinessErrorMessage businessErrorMessage) {
        super(businessErrorMessage.getMessage(), cause);
        this.errorMessage = businessErrorMessage;
    }
}
