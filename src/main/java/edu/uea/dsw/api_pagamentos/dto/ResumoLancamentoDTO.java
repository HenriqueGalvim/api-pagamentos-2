package edu.uea.dsw.api_pagamentos.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import edu.uea.dsw.api_pagamentos.model.TipoLancamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumoLancamentoDTO {
    private Long codigo;
    private String descricao;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private BigDecimal valor;
    private TipoLancamento tipo;
    private String categoria;
    private String pessoa;
}
