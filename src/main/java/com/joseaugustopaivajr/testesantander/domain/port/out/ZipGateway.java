package com.joseaugustopaivajr.testesantander.domain.port.out;

import com.joseaugustopaivajr.testesantander.application.dto.CepResponse;

public interface ZipGateway {

    CepResponse findZipCode(Integer zipCode);
}
