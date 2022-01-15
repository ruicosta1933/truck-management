package com.projeto.Classes.LinkedList;

import java.util.Iterator;

import com.projeto.Classes.Camiao;
import com.projeto.Classes.CargaDescarga.CargaDescarga;
import com.projeto.Classes.Queue.CircularArrayQueue;
import com.projeto.Classes.Armazem;

public class LinkedList<T> {
  public Node<Camiao> head;
  private Node<Camiao> tail;
  CircularArrayQueue<Camiao> listaDeEspera = new CircularArrayQueue<>() ;
  private int capacidade;
  
  public LinkedList() {
    head = null;
    tail = null;
    capacidade = 0;
  }
  
  public int getCapacidade(){
    return capacidade;
  }

  Node<Camiao> cais = new Node<>();
  public void createCais() {
    
    for (int i = 0; i < 6; i++) {
      if (head == null) {
        head = cais;
        head.setNext(null);
      } else if (tail == null) {
        tail = cais;
        tail.setNext(null);
        head.setNext(tail);
      } else {
        tail.setNext(cais);
        tail = cais;
      }
    }

   
  }

  // Adding to end of LinkedList
    public void add(Camiao camiao) {
      
        Node<Camiao> newNode = new Node<>(camiao);
        Node<Camiao> oldHead = head;

        if(this.capacidade >= 6){
          listaDeEspera.enqueue(camiao);
        }
        else{
          if (head == null) {
            head = newNode;
            newNode.setNext(tail);
          }  else {
              head = newNode;
              newNode.setNext(oldHead);
            }
            capacidade++;
        }

      
                    
    }

  // Removing a chosen camiao
  public Camiao remove(Camiao camiao){
    boolean found = false;
    Node<Camiao> previous = null;
    Node<Camiao> current = head;

    if (head == null) {
      System.out.println("Nao da para eliminar");;
    }
    
    while (current != null && !found) {
      if (camiao.equals(current.getCamiao())) {
        found = true;
        }   else {
            previous = current;
            current = current.getNext();
          }
        }

      if (!found) {
        System.out.println("Nao existe esse camiao");;
      }

      if (this.capacidade == 1) { head = tail = null; } 

      else if (current.equals(head)) { head = current.getNext(); } 

      else if (current.equals(tail)) {
        tail = previous;
        tail.setNext(null);
      } 

      else {previous.setNext(current.getNext());}

      capacidade--;
      return current.getCamiao();

    }


    public Iterator iterator() {
      return null;
    }

    public void sortList() {
      Node<Camiao> current = head, index = null, tempo = null;
      Camiao temp;
      String result = "";
      int count=0;

      if (head == null) {return;}

      else {
        while (current != null) {

          index = current.getNext();
          
          while (index != null) {

            if (current.getCamiao().getCarga() > index.getCamiao().getCarga()) {

              temp = current.getCamiao();
              current.setCamiao(index.getCamiao());
              index.setCamiao(temp);

            }
            index = index.getNext();
          }
          current = current.getNext();
        }
      } 
     escreverCamioes();
    }

    public void sortFuncao() {
      Node<Camiao> current = head, index = null;
      Camiao temp;
      CargaDescarga tipo = CargaDescarga.valueOf("CARGA");

      if (head == null) {
        return;
      }
          else {
                    while (current != null) {
                      index = current.getNext();
                      
                      while (index != null) {
                        if (current.getCamiao().getFuncao() == tipo) {
                          temp = current.getCamiao();
                          current.setCamiao(index.getCamiao());
                          index.setCamiao(temp);
              
            }
            index = index.getNext();
          }
          current = current.getNext();
        }
      }
      sortFuncao2();
      escreverCamioes();
    }

    public void sortFuncao2() {
      Node<Camiao> current = head, index = null;
      Camiao temp;
      
      if (head == null) {
        return;
      }
      else {
        while (current != null) {
          index = current.getNext();
          
          while (index != null) {
            double x,z;
            int y,j;

            x=current.getCamiao().getCarga();
            y=current.getCamiao().getCapacidade();
            z=index.getCamiao().getCarga();
            j=index.getCamiao().getCapacidade();

            if (current.getCamiao().getFuncao() == index.getCamiao().getFuncao()) {
              if (y-x > j-z) {
                  temp = current.getCamiao();
                  current.setCamiao(index.getCamiao());
                  index.setCamiao(temp);
              }
            }
            
            index = index.getNext();
          }
          current = current.getNext();
        }
      }
    }


    public Camiao getNextToLeaveHours() {
      Node<Camiao> current = head;
      double horasMax = 0;
      Camiao toLeave = null;
  
      while (current != null) {
        if (current.getCamiao().getTempo() > horasMax && current.getCamiao().getTempo() >= 24) {
          toLeave = current.getCamiao();
          horasMax = current.getCamiao().getTempo();
        }
        current = current.getNext();
      }
  
      return toLeave;

    }


    public void escreverCamioes() {
      Node<Camiao> current = head;
      String result = "";
      int count = 1;
     
      System.out.println("                    < ============================================= >");
      System.out.println("                    < ============ |  No Armazem  | =============== >");
      System.out.println("                    < ============================================= >");
      System.out.println();
      System.out.println();
      for(int i = 0 ; i<6 ; i++){
        if(current == null){
          System.out.println("Cais " + (i+1) + " Vazio");
        }
        else if (current != null) {
          
          result += "Camiao " + count + ": " + current.getCamiao().toString() + "\n";
          current = current.getNext();
          count++;
        }
      }
      System.out.println();
      System.out.println();
    if(result == ""){
      System.out.println("                           <-- Nao há Camioes no Armazem -->");
      System.out.println();
      System.out.println();
    }
    else{
      System.out.println(result);
      System.out.println();
      System.out.println();
      System.out.println();
    }
      
         
      
    }

    public void pesquisaCamioes(Double min, Double max) {
      Node<Camiao> current = head;
      String result = "";
      int count = 1;
      sortList();
      while (current != null) {
        if(current.getCamiao().getCarga()>min && current.getCamiao().getCarga()<max){

        System.out.println("\n\n " + current.getCamiao().getCarga() + " ----- " + max + " ----- " + min + "\n\n ");
        result += "Camiao " + count + ": " + current.getCamiao().toString() + "\n";
        
        count++;
      }
      current = current.getNext();
    }
    System.out.println(result);
    }


}
