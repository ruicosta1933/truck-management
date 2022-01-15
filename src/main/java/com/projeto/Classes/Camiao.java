package com.projeto.Classes;

import com.projeto.Classes.CargaDescarga.CargaDescarga;

public class Camiao {
    private Double carga;
    private int capacidade;
    private int tempo;
    private Armazem destino;
    private String data_entrada;
    private String matricula;
    private String hora_entrada;
    private CargaDescarga funcao;


    public Camiao(Double carga, int capacidade, int tempo, Armazem destino, String data_entrada, String matricula, String hora_entrada, CargaDescarga funcao) {
        this.carga = carga;
        this.capacidade = capacidade;
        this.tempo = tempo;
        this.destino = destino;
        this.data_entrada = data_entrada;
        this.matricula = matricula;
        this.hora_entrada = hora_entrada;
        this.funcao = funcao;
    }



    public Double getCarga() {
        return this.carga;
    }

    public void setCarga(Double carga) {
        this.carga = carga;
    }

    public int getCapacidade() {
        return this.capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getTempo() {
        return this.tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public Armazem getDestino() {
        return this.destino;
    }

    public void setDestino(Armazem destino) {
        this.destino = destino;
    }

    public String getData_entrada() {
        return this.data_entrada;
    }

    public void setData_entrada(String data_entrada) {
        this.data_entrada = data_entrada;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getHora_entrada() {
        return this.hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public CargaDescarga getFuncao() {
        return this.funcao;
    }

    public void setFuncao(CargaDescarga funcao) {
        this.funcao = funcao;
    }
    

    @Override
    public String toString() {
        return " matricula=" + getMatricula() + "" +
               "\n           capacidade=" + getCapacidade() + " kg" +
               "\n           tempo=" + getTempo() + " horas" +
               "\n           destino=" + getDestino() + "" +
               "\n           data_entrada=" + getData_entrada() + "" +
               "\n           carga=" + getCarga() + "" +
               "\n           hora_entrada=" + getHora_entrada() + "" +
               "\n           funcao=" + getFuncao() + "" +
               "\n";
    }

    

}