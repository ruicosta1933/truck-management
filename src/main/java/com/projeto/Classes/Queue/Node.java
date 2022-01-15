package com.projeto.Classes.Queue;

public class Node<Camiao> {
  private Camiao element;
  private Node<Camiao> next;

  public Node(Camiao element) {
    this.element = element;
    this.next = null;
  }

  public Camiao getElement() {
    return element;
  }

  public void setElement(Camiao element) {
    this.element = element;
  }

  public Node<Camiao> getNext() {
    return next;
  }

  public void setNext(Node<Camiao> next) {
    this.next = next;
  }
}
