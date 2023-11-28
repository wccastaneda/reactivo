package co.com.bancolombia.model.account;
import co.com.bancolombia.model.exceptions.BusinessException;
import co.com.bancolombia.model.exceptions.message.BusinessErrorMessage;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class Account {

    private Long id;
    private String name;
    private String status;

    public static Account newAccount(Long id, String name, String status) {
        if(name.equals("error")) {
            throw new BusinessException(BusinessErrorMessage.INVALID_NAME);
        }
        return new Account(id, name, status);
    }
}
