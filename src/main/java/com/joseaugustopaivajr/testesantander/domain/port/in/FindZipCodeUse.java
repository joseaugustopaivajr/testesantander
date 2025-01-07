package com.joseaugustopaivajr.testesantander.domain.port.in;

import com.joseaugustopaivajr.testesantander.application.dto.CepResponse;

public interface FindZipCodeUse {
    CepResponse findZipCode(Integer cep);
}
