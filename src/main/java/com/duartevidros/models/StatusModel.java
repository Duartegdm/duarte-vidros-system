package com.duartevidros.models;

public enum StatusModel {
    ORCAMENTO("Orçamento"),
    MEDICAO("Medição"),
    PEDIDO_MATERIAL("Pedido de Material"),
    EM_EXECUCAO("Em Execução"),
    FINALIZADO("Finalizado");

    private final String descricao;

    StatusModel(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
