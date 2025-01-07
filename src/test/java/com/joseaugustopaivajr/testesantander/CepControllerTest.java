package com.joseaugustopaivajr.testesantander;

import com.joseaugustopaivajr.testesantander.application.dto.CepResponse;
import com.joseaugustopaivajr.testesantander.application.web.CepController;
import com.joseaugustopaivajr.testesantander.domain.exception.CepNotFoundException;
import com.joseaugustopaivajr.testesantander.domain.port.in.FindZipCodeUse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CepController.class)
class CepControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FindZipCodeUse findZipCodeUse;

    @Test
    @WithMockUser
    void buscarCep_Success() throws Exception {
        Integer cep = 12345678;
        CepResponse cepResponse = new CepResponse("Rua Exemplo", "Cidade", "Estado");
        when(findZipCodeUse.findZipCode(cep)).thenReturn(cepResponse);
        mockMvc.perform(get("/cep/{cep}", cep)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.address").value("Rua Exemplo"))
                .andExpect(jsonPath("$.city").value("Cidade"))
                .andExpect(jsonPath("$.state").value("Estado"));
    }

    @Test
    @WithMockUser
    void buscarCep_NotFound() throws Exception {

        Integer cep = 12345678;

        when(findZipCodeUse.findZipCode(cep)).thenThrow(new CepNotFoundException());

        mockMvc.perform(get("/cep/{cep}", cep)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadGateway());
    }

    @Test
    @WithMockUser
    void buscarCep_InvalidCep() throws Exception {
        String invalidCep = "abc";
        mockMvc.perform(get("/cep/{cep}", invalidCep)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
