package com.joseaugustopaivajr.testesantander.application.web;

import com.joseaugustopaivajr.testesantander.application.dto.CepResponse;
import com.joseaugustopaivajr.testesantander.domain.port.in.FindZipCodeUse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Cep Controller", description = "Service responsible for checking ZIP codes")
public class CepController {

    private final FindZipCodeUse findZipCodeUse;

    @GetMapping("/cep/{cep}")
    public ResponseEntity<CepResponse> buscarCep(@PathVariable Integer cep) {
        return ResponseEntity.ok(findZipCodeUse.findZipCode(cep));
    }
}
