package edu.uea.dsw.api_pagamentos.dto;

import edu.uea.dsw.api_pagamentos.model.Endereco;
import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {
    private Long codigo;
    
    @NotNull
    @Size(min = 3, max = 50)
    private String nome;
    
    @NotNull
    private Boolean ativo;

    @NotNull(message = "O endereço é obrigatório")
    @Valid
    @Embedded
    private Endereco endereco;
}
