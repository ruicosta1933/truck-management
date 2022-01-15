package com.projeto.Classes.LinkedList;

import com.projeto.Classes.Camiao;

public class Node<Camiao> {


  private Node<Camiao> next;
  private Camiao camiao;

  public Node() {
    next = null;
    camiao = null;
  }
  
  public Node(Camiao cam) {
    this.next = null;
    camiao = cam;
  }

  public Node<Camiao> getNext() {
    return next;
  }

  public void setNext(Node<Camiao> node) {
    next = node;
  }

  public Camiao getCamiao() { 
    return camiao;
  }

  public void setCamiao(Camiao cam) {
    camiao = cam;
  }

  public void escreve() { 
    System.out.print(camiao);
  }

}
