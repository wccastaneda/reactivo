package co.com.bancolombia.r2dbc.repository.account;

import co.com.bancolombia.model.account.Account;
import co.com.bancolombia.model.account.gateways.AccountRepository;
import co.com.bancolombia.r2dbc.repository.account.data.AccountData;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class AccountDataRepositoryAdapter implements AccountRepository {

    private final AccountDataRepository repository;
    private final ObjectMapper objectMapper;

    @Override
    public Mono<Account> findAccountById(Long id) {
        return repository.findById(id).map(this::toEntity);
    }

    private Account toEntity (AccountData data) {
        return objectMapper.mapBuilder(data, Account.AccountBuilder.class).build();
    }

    private AccountData toData (Account data) {
        return objectMapper.mapBuilder(data, AccountData.AccountDataBuilder.class).build();
    }
}
