package br.com.danielverdi.domain;

import java.util.Objects;

public class Cliente  {

    private String nomeCompleto;
    private Long cpf;
    private Long tel;
    private String endereco;
    private Long num;
    private String cidade;
    private String estado;

    public Cliente(String nomeCompleto, String cpf, String tel, String endereco, String num, String cidade, String estado){
        this.nomeCompleto = nomeCompleto;
        this.cpf = Long.valueOf(cpf);
        this.tel = Long.valueOf(tel);
        this.endereco = endereco;
        this.num = Long.valueOf(num);
        this.cidade = cidade;
        this.estado = estado;
    }


    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nomeCompleto='" + nomeCompleto + '\'' +
                ", cpf=" + cpf +
                '}';
    }
}
