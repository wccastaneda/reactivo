package co.com.bancolombia.usecase.account;

import co.com.bancolombia.model.account.Account;
import co.com.bancolombia.model.account.gateways.AccountRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RequiredArgsConstructor
public class AccountUseCase {

    private final AccountRepository accountRepository;

    public Mono<Account> registerAccount(String accountName) {

        return getStatus(accountName)
                .flatMap(status -> validateBusinessRequisites(accountName)
                        .map(businessValidations -> Account.newAccount(1L, accountName, status)))
                .flatMap(this::doFinalValidations)
                .flatMap(this::saveAccount);
    }

    public Mono<Tuple2<String, Integer>> validateBusinessRequisites(String accountName) {
        return Mono.zip(
                validateLegalRequisites(accountName),
                validateDisponibility()
        );
    }

    public Mono<String> validateLegalRequisites(String accountName) {
        return Mono.just(accountName).delayElement(Duration.ofSeconds(2));
    }

    public Mono<Integer> validateDisponibility() {
        return Mono.just(9).delayElement(Duration.ofSeconds(2));
    }

    public Mono<String> getStatus(String accountName) {
        return Mono.just("OK");
    }

    public Mono<Account> doFinalValidations(Account account) {
        return Mono.just(account);
    }

    public Mono<Account> saveAccount(Account account) {
        return Mono.just(account);
    }

    public Mono<Account> getAccount(Long id) {
        return accountRepository.findAccountById(id);
    }
}
