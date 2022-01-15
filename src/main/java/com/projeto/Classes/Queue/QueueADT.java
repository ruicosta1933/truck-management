package com.projeto.Classes.Queue;

public interface QueueADT<Camiao> {
  public void enqueue(Camiao camiao);

  public Node<Camiao> dequeue();

  public Node<Camiao> first();

  public boolean isEmpty();

  public int size();

  public String toString();
}
