package com.example.banco2.Registro;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.NonNull;

import java.util.List;
@Entity
@Table(name="registro")
public class DadosPessoais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
        private String nomeCompleto;
        private String dataNascimento;
        private String nacionalidade;
        private String naturalidade;
        private String estadoCivil;
        private String nomePai;
        private String nomeMae;
        private String email;
        private String cpf;

        private String tipoConta;  // Tipo de conta
        private String agencia;  // Número da agência
        private List<String> cartoes;  // Lista de cartões
        private String rua;  // Endereço
        private String numero;  // Número da residência
        private String complemento;  // Complemento
        private String bairro;  // Bairro
        private String cidade;  // Cidade
        private String estado;  // Estado
        private String cep;  // CEP

        public DadosPessoais(Dadostotais dados) {
            this.nomeCompleto = dados.nomeCompleto();
            this.dataNascimento = dados.dataNascimento();
            this.nacionalidade = dados.nacionalidade();
            this.naturalidade = dados.naturalidade();
            this.estadoCivil = dados.estadoCivil();
            this.nomePai = dados.nomePai();
            this.nomeMae = dados.nomeMae();
            this.email = dados.email();
            this.cpf = dados.cpf();
            this.tipoConta = dados.tipoConta();
            this.agencia = dados.agencia();
            this.cartoes = dados.cartoes();
            this.rua = dados.rua();
            this.numero = dados.numero();
            this.complemento = dados.complemento();
            this.bairro = dados.bairro();
            this.cidade = dados.cidade();
            this.estado = dados.estado();
            this.cep = dados.cep();
        }

        public Long getId() {
            return id;
        }


    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }


    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DadosPessoais() {
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
// Getters and Setters


    public List<String> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<String> cartoes) {
        this.cartoes = cartoes;
    }
}
