package it.stefanopisano.homevote.request.infrastructure.configuration;

import it.stefanopisano.homevote.request.application.usecases.CreateRequestUseCase;
import it.stefanopisano.homevote.request.application.usecases.UpdateRequestUseCase;
import it.stefanopisano.homevote.request.domain.RequestRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CreateRequestUseCase createRequestUseCase(RequestRepository repository) {
        return new CreateRequestUseCase(repository);
    }

    @Bean
    public UpdateRequestUseCase updateRequestUseCase(RequestRepository repository) {
        return new UpdateRequestUseCase(repository);
    }

}