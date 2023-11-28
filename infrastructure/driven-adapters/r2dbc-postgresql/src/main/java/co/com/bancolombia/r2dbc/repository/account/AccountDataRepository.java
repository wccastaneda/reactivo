package co.com.bancolombia.r2dbc.repository.account;

import co.com.bancolombia.r2dbc.repository.account.data.AccountData;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

// TODO: This file is just an example, you should delete or modify it
    public interface AccountDataRepository extends ReactiveCrudRepository<AccountData, Long>, ReactiveQueryByExampleExecutor<AccountData> {

}
