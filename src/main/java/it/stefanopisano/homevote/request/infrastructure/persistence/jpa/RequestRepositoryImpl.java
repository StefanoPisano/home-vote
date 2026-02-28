package it.stefanopisano.homevote.request.infrastructure.persistence.jpa;

import it.stefanopisano.homevote.request.domain.Request;
import it.stefanopisano.homevote.request.domain.RequestRepository;
import it.stefanopisano.homevote.request.infrastructure.persistence.jpa.entity.RequestEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class RequestRepositoryImpl implements RequestRepository {

    private final SpringDataRequestRepository springDataRequestRepository;

    public RequestRepositoryImpl(SpringDataRequestRepository springRepository) {
        this.springDataRequestRepository = springRepository;
    }

    @Override
    public void save(Request request) {
        final RequestEntity toSave = RequestMapper.toEntity(request);

        springDataRequestRepository.save(toSave);
    }

    @Override
    public Optional<Request> findById(UUID id) {
        final Optional<RequestEntity> found = springDataRequestRepository.findById(id);

        return found.map(RequestMapper::toDomain);
    }
}