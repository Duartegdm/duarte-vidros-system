package com.duartevidros.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "servicos")
public class Servico {

    public Servico() {
    }

    public Servico(Cliente cliente, Funcionario vendedor,
                   Funcionario instalador, Distribuidora distribuidora,
                   String tipoServico, BigDecimal valorMateriais, BigDecimal valorMaoObra,
                   BigDecimal valorGasolina, BigDecimal valorOutrosGastos,
                   LocalDate dataOrcamento, LocalDate dataMedicao, LocalDate dataInstalacao,
                   StatusModel status) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.instalador = instalador;
        this.distribuidora = distribuidora;
        this.tipoServico = tipoServico;
        this.valorMateriais = valorMateriais;
        this.valorMaoObra = valorMaoObra;
        this.valorGasolina = valorGasolina;
        this.valorOutrosGastos = valorOutrosGastos;
        this.dataOrcamento = dataOrcamento;
        this.dataMedicao = dataMedicao;
        this.dataInstalacao = dataInstalacao;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "vendedor_id", referencedColumnName = "id", nullable = false)
    private Funcionario vendedor;

    @ManyToOne
    @JoinColumn(name = "instalador_id", referencedColumnName = "id", nullable = false)
    private Funcionario instalador;

    @ManyToOne
    @JoinColumn(name = "distribuidora_id", referencedColumnName = "id", nullable = false)
    private Distribuidora distribuidora;

    private String tipoServico;
    private BigDecimal valorMateriais;
    private BigDecimal valorMaoObra;
    private BigDecimal valorGasolina;
    private BigDecimal valorOutrosGastos;

    @Column(nullable = false)
    private LocalDate dataOrcamento;

    private LocalDate dataMedicao;
    private LocalDate dataInstalacao;

    @Enumerated(EnumType.STRING)
    private StatusModel status;


    public BigDecimal calcularCustoTotal() {
        return valorMateriais
                .add(valorMaoObra)
                .add(valorGasolina)
                .add(valorOutrosGastos);
    }

    //Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }

    public Funcionario getInstalador() {
        return instalador;
    }

    public void setInstalador(Funcionario instalador) {
        this.instalador = instalador;
    }

    public Distribuidora getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(Distribuidora distribuidora) {
        this.distribuidora = distribuidora;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public BigDecimal getValorMateriais() {
        return valorMateriais;
    }

    public void setValorMateriais(BigDecimal valorMateriais) {
        this.valorMateriais = valorMateriais;
    }

    public BigDecimal getValorMaoObra() {
        return valorMaoObra;
    }

    public void setValorMaoObra(BigDecimal valorMaoObra) {
        this.valorMaoObra = valorMaoObra;
    }

    public BigDecimal getValorGasolina() {
        return valorGasolina;
    }

    public void setValorGasolina(BigDecimal valorGasolina) {
        this.valorGasolina = valorGasolina;
    }

    public BigDecimal getValorOutrosGastos() {
        return valorOutrosGastos;
    }

    public void setValorOutrosGastos(BigDecimal valorOutrosGastos) {
        this.valorOutrosGastos = valorOutrosGastos;
    }

    public LocalDate getDataOrcamento() {
        return dataOrcamento;
    }

    public void setDataOrcamento(LocalDate dataOrcamento) {
        this.dataOrcamento = dataOrcamento;
    }

    public LocalDate getDataMedicao() {
        return dataMedicao;
    }

    public void setDataMedicao(LocalDate dataMedicao) {
        this.dataMedicao = dataMedicao;
    }

    public LocalDate getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(LocalDate dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public StatusModel getStatus() {
        return status;
    }

    public void setStatus(StatusModel status) {
        this.status = status;
    }
}
