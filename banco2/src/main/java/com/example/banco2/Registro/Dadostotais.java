package com.example.banco2.Registro;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record Dadostotais(@NotNull
                              @Size(min = 1)
                              String nomeCompleto,

                          @NotNull
                              String dataNascimento,

                          @NotNull
                              @Size(min = 1)
                              String nacionalidade,

                          @NotNull
                              @Size(min = 1)
                              String naturalidade,

                          @NotNull
                              String estadoCivil,

                          String nomePai,

                          @NotNull
                              String nomeMae,

                          @NotNull
                              @Email
                              String email,

                          @NotNull
                              @Size(min = 11, max = 11)  // CPF com 11 caracteres (sem pontuação)
                              String cpf,

                          @NotNull
                              String tipoConta,  // Tipo de conta: conta-corrente, poupança, etc.

                          @NotNull
                              String agencia,  // Número da agência bancária

                          String cartoes,  // Cartões desejados: débito, crédito, etc.

                          @NotNull
                              String rua,  // Endereço (rua)

                          String numero,  // Número da residência

                          String complemento,  // Complemento do endereço (opcional)

                          @NotNull
                              String bairro,  // Bairro

                          @NotNull
                              String cidade,  // Cidade

                          @NotNull
                              String estado,  // Estado

                          @NotNull
                              String cep  // CEP
) {
    public Dadostotais(DadosPessoais registro) {
        this(registro.getNomeCompleto(),registro.getDataNascimento(),registro.getNacionalidade(),registro.getNaturalidade(),registro.getEstadoCivil(),registro.getNomePai(),registro.getNomeMae(),registro.getEmail(),registro.getCpf(),registro.getTipoConta(),registro.getAgencia(),registro.getCartoes(),registro.getRua(), registro.getNumero(),registro.getComplemento(), registro.getBairro(), registro.getCidade(), registro.getEstado(), registro.getCep());
    }
}
