package com.exemplo;

public class CriptoMoeda {

    private String nome;
    private double taxaConversao;
    private static CriptoMoeda instance;

    private CriptoMoeda(String nome, double taxaConversao) {
        this.nome = nome;
        this.taxaConversao = taxaConversao;
    }

    public static CriptoMoeda getInstance(String nome, double taxaConversao) {
        if (instance == null) {
            instance = new CriptoMoeda(nome, taxaConversao);
        }
        return instance;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTaxaConversao() {
        return taxaConversao;
    }

    public void setTaxaConversao(double taxaConversao) {
        this.taxaConversao = taxaConversao;
    }

    public double converter(double quantidade, double taxaConversaoOutro) {
        return quantidade * taxaConversao / taxaConversaoOutro;
    }

    @Override
    public String toString() {
        return "CriptoMoeda{" +
                "nome='" + nome + '\'' +
                ", taxaConversao=" + taxaConversao +
                '}';
    }
}
