package com.joseaugustopaivajr.testesantander.infrastructure.adapter.gateway;

import com.joseaugustopaivajr.testesantander.application.dto.CepResponse;
import com.joseaugustopaivajr.testesantander.domain.port.out.ZipGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@RequiredArgsConstructor
public class ZipGatewayImpl implements ZipGateway {

    private final RestTemplate restTemplate;

    @Value("${secrets.url}")
    private String url;
    @Override
    public CepResponse findZipCode(Integer zipCode) {
        String url = this.url + zipCode;
        return restTemplate.getForObject(url, CepResponse.class);
    }
}
