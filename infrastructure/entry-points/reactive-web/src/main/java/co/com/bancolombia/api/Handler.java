package co.com.bancolombia.api;

import co.com.bancolombia.api.dto.AccountRegistryDto;
import co.com.bancolombia.model.account.Account;
import co.com.bancolombia.model.exceptions.BusinessException;
import co.com.bancolombia.model.exceptions.message.BusinessErrorMessage;
import co.com.bancolombia.usecase.account.AccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final AccountUseCase accountUseCase;

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenGETAccount(ServerRequest serverRequest) {
        return accountUseCase.getAccount(Long.parseLong(serverRequest.pathVariable("id")))
                .flatMap(account -> ServerResponse.ok().bodyValue(account));
    }

    public Mono<ServerResponse> listenPOSTregisterAccount(ServerRequest serverRequest) {

        return serverRequest.bodyToMono(AccountRegistryDto.class)
                .switchIfEmpty(Mono.error(() -> new BusinessException(BusinessErrorMessage.INVALID_REQUEST)))
                .flatMap(request -> accountUseCase.registerAccount(request.getName()))
                .flatMap(accountRegistered -> ServerResponse.ok().bodyValue(accountRegistered));
    }
}
