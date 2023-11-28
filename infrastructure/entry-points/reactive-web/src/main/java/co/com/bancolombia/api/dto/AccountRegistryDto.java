package co.com.bancolombia.api.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AccountRegistryDto {

    private String name;
    private String statusId;
}
