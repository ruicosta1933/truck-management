package com.projeto.Classes;

import com.projeto.Classes.LinkedList.LinkedList;
import com.projeto.Classes.Queue.CircularArrayQueue;

public class Armazem {
  private String local;
  private LinkedList<Camiao> cais ;
  private CircularArrayQueue listaDeEspera;


  public Armazem(String local, LinkedList<Camiao> cais) {
    this.local = local;
    this.cais = cais;
    this.listaDeEspera = new CircularArrayQueue<>() ;
  }

  public String getLocal() {
    return this.local;
  }

  public CircularArrayQueue<Camiao> getEspera() {
    return this.listaDeEspera;
  }

  public void setLocal(String local) {
    this.local = local;
  }

  public LinkedList<Camiao> getCais() {
    return this.cais;
  }

  public void setCais(LinkedList<Camiao> cais) {
    this.cais = cais;
  }

  public CircularArrayQueue getListaDeEspera() {
    return this.listaDeEspera;
  }

  public void setListaDeEspera(CircularArrayQueue listaDeEspera) {
    this.listaDeEspera = listaDeEspera;
  }
}