package co.com.bancolombia.r2dbc.repository.account.data;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class AccountData {

    @Id
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String status;
}
