package com.joseaugustopaivajr.testesantander.domain.service;

import com.joseaugustopaivajr.testesantander.application.dto.CepResponse;
import com.joseaugustopaivajr.testesantander.domain.entity.LogEntity;
import com.joseaugustopaivajr.testesantander.domain.exception.CepNotFoundException;
import com.joseaugustopaivajr.testesantander.domain.port.in.FindZipCodeUse;
import com.joseaugustopaivajr.testesantander.domain.port.out.ZipGateway;
import com.joseaugustopaivajr.testesantander.infrastructure.adapter.repository.LogRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindZipCodeService implements FindZipCodeUse {

    private final ZipGateway zipGateway;

    private final LogRepositoryImpl logRepository;
    @Override
    public CepResponse findZipCode(Integer cep) {
      CepResponse response = zipGateway.findZipCode(cep);
      if (response == null) {
          throw new CepNotFoundException();
      }
        logRepository.save(new LogEntity(cep, response.getAddress(), response.getCity(), response.getState()));
        return response;
    }
}
