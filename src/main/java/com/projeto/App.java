package com.projeto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.projeto.Classes.Armazem;
import com.projeto.Classes.Camiao;
import com.projeto.Classes.CargaDescarga.CargaDescarga;
import com.projeto.Classes.LinkedList.Cais;
import com.projeto.vista.Menu;
import com.projeto.vista.MenuCamiao;
import com.projeto.Classes.LinkedList.LinkedList;
import com.projeto.Classes.LinkedList.Node;
import com.projeto.Classes.Queue.CircularArrayQueue;

public class App {
    public static void main(String[] args) {
        // Escolha para o menu a seguir
        int escolha;

        //Criação do cais para o armazem
        LinkedList<Camiao> cais1 = new LinkedList<>(); 
        LinkedList<Camiao> cais2 = new LinkedList<>();  
        LinkedList<Camiao> cais3 = new LinkedList<>();  
        LinkedList<Camiao> cais4 = new LinkedList<>();  
        LinkedList<Camiao> cais5 = new LinkedList<>();  
        LinkedList<Camiao> cais6 = new LinkedList<>();  
        LinkedList<Camiao> cais7 = new LinkedList<>(); 
        LinkedList<Camiao> cais8 = new LinkedList<>();    
          
        //Lista de Espera
        CircularArrayQueue<Camiao> listaDeEspera = new CircularArrayQueue<>() ;

        //Criação de todos os armazens
        Armazem armazem1 = new Armazem("Portugal", cais1 );
        Armazem armazem2 = new Armazem("Portugal 2", cais2 );
        Armazem armazem3 = new Armazem("Espanha", cais3 );
        Armazem armazem4 = new Armazem("Espanha 2", cais4);
        Armazem armazem5 = new Armazem("França", cais5);
        Armazem armazem6 = new Armazem("França 2", cais6);
        Armazem armazem7 = new Armazem("Italia", cais7);
        Armazem armazem8 = new Armazem("Alemanha", cais8);

        //Criacao de array list para guardar todos os armazens para a facil transmissao de dados
        ArrayList<Armazem> armazens = new ArrayList<>() ;

        //Adicionar os armazens à array
        armazens.add(armazem1);
        armazens.add(armazem2); 
        armazens.add(armazem3);
        armazens.add(armazem4);
        armazens.add(armazem5);
        armazens.add(armazem6);
        armazens.add(armazem7);
        armazens.add(armazem8);

            
        System.out.println(listaDeEspera.toString());
            do {
                Scanner opcao = new Scanner(System.in);
                Menu.menu();
                System.out.println("Qual armazem quer entrar -> ");
                escolha = opcao.nextInt();

                if(escolha < 1 || escolha >9){
                    System.out.println("Escolha um armazem existente");
                }

                    else if(escolha == 9){
                        break;
                    }

                        else{
                            Armazem armazem;
                            armazem = armazens.get(escolha-1);
                            //Abre o formulario do armazem enviando o armazem escolhido (escolha)
                            GestaoCamiao.formularioVista(armazem);
                        }
            }  while (escolha != 0);
    }
}
