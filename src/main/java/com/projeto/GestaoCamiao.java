package com.projeto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.company.Queue.Node;
import com.projeto.Classes.Armazem;
import com.projeto.Classes.Camiao;
import com.projeto.Classes.CargaDescarga.CargaDescarga;
import com.projeto.Classes.LinkedList.LinkedList;
import com.projeto.Classes.Queue.CircularArrayQueue;
import com.projeto.vista.MenuCamiao;
import com.projeto.vista.MenuEditar;

public class GestaoCamiao {
    public static void formularioVista(Armazem armazem){
        
        Scanner opcao = new Scanner(System.in);
        int escolha;
        
        MenuCamiao.MenuCamiao();
        
        System.out.print("Opção -> ");
        escolha = opcao.nextInt();
        
        switch (escolha) {
            case 1: criarCamiao(armazem); formularioVista(armazem); break;
            
            case 2: verCamioes(armazem); formularioVista(armazem); break;
            
            case 3: orderCarga(armazem); formularioVista(armazem);break;
            
            case 4: pesquisaCamioes(armazem); formularioVista(armazem); break;
            
            case 5: ordenarFuncao(armazem); formularioVista(armazem); break;
            
            case 6: ordenarSaida(armazem); formularioVista(armazem); break;
            
            case 0:  break;
            
            default: System.out.println("Opção Inválida!"); formularioVista(armazem); break;
        }
    }
    
    private static void orderCarga(Armazem armazem) {
        LinkedList<Camiao> cais;
        cais = armazem.getCais();

        cais.sortFuncao2();
        verCamioes(armazem);
    }

    //Pesquisa de camioes com limites ditos pelo utilizador
    private static void pesquisaCamioes(Armazem armazem) {
        
        Scanner scanner = new Scanner(System.in);
        Double cargaMin, cargaMax;
        Double carguita=0.0;
        
        System.out.print("Limite inferior -> ");
        cargaMin = scanner.nextDouble(); 
        System.out.print("Limite maximo -> ");
        cargaMax = scanner.nextDouble(); 
        
        //Caso o utilizador se engane e coloque ao contrario faz-se a troca
        if( cargaMin> cargaMax){
            cargaMin = carguita;
            cargaMin = cargaMax;
            cargaMax = carguita;
        }
        
        LinkedList<Camiao> cais;
        cais=armazem.getCais();
        
        //Envia para a funcao com parametros o que foi inserido pelo utilizador
        cais.pesquisaCamioes(cargaMin, cargaMax);
    }
    
    //Ordenar Camioes por ordem de saida
    private static void ordenarSaida(Armazem armazem) {
        LinkedList<Camiao> cais;
        cais = armazem.getCais();
        
        cais.sortList();
    }
    
    //Ordenar Camioes por Carga / Descarga
    private static void ordenarFuncao(Armazem armazem) {
        LinkedList<Camiao> cais;
        cais = armazem.getCais();
        
        cais.sortFuncao();
    }
    
    //Lista os Camioes da LinkedList
    public static void verCamioes(Armazem armazem ){
        LinkedList<Camiao> cais;
        cais=armazem.getCais();
        escreverfila(armazem);
        cais.escreverCamioes();
    }
    
    //Formulario para criar o Camiao
    public static void criarCamiao(Armazem armazem){
        Double carga;
        int capacidade, tempo , escolhaFuncao;
        String matricula,hora_entrada;
        LinkedList<Camiao> cais;
        CircularArrayQueue<Camiao> ListadeEspera;
        CargaDescarga funcao;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Insira a matrícula do Camião: ");     
        matricula = scanner.next();  
        
        //Caso o utilizador nao escolha nenhuma das opcoes pede novamente
        do{
            System.out.print("Qual o trabalho que vai desempenha (1 - Carga/ 2 - Descarga): ");    
            escolhaFuncao = scanner.nextInt();
        }while(escolhaFuncao != 2 && escolhaFuncao!=1);
        
        //Caso o utilizador insira um carga maior que a capacidade maxima pede a inserção novamente
        do{
            System.out.print("Insira a carga máxima do Camião (Kg): ");     
            capacidade = scanner.nextInt();    
            System.out.print("Insira a carga que o camião tem neste momento (Kg): ");    
            carga = scanner.nextDouble();
            
            if(capacidade<carga){
                System.out.println("Carga é maior que a capacidade");
            }
        }while(capacidade<carga);
        
        //Caso seja inserido uma hora maior que 24horas pede novamente
        
            System.out.print("Quanto tempo no armazem: ");    
            tempo = scanner.nextInt();
            
        
        System.out.print("Quando entrou no armazem: ");    
        hora_entrada = scanner.next();
        
        cais=armazem.getCais();
        ListadeEspera = armazem.getEspera();
        
        if(escolhaFuncao == 1){
            CargaDescarga tipo = CargaDescarga.valueOf("CARGA");
            
            
            Camiao camiao5 = new Camiao(1000.0, 3500, 20 , armazem, "20/02/2021", "27-FO-31", "20:59", tipo);
            Camiao camiao2 = new Camiao(2000.0, 3000, 20 , armazem, "07/06/2021", "46-RZ-48", "13:01", tipo);
            Camiao camiao3 = new Camiao(1500.0, 3000, 20 , armazem, "20/02/2021", "27-HX-31", "20:59", tipo);
            Camiao camiao4 = new Camiao(1000.0, 2000, 20 , armazem, "07/06/2021", "46-PO-48", "13:01" ,tipo);

            Camiao camiao1 = new Camiao(carga , capacidade , tempo, armazem , hora_entrada , matricula , hora_entrada, tipo);

            if (ListadeEspera.enqueue(camiao1)) {
                if (cais.getCapacidade() == 6) {
                    if (cais.getNextToLeaveHours() != null) {
                        cais.remove(cais.getNextToLeaveHours());
                        cais.add(ListadeEspera.dequeue());
                    }
                } 
                else {
                    cais.add(ListadeEspera.dequeue());
                }
            }

            if (ListadeEspera.enqueue(camiao2)) {
                if (cais.getCapacidade() == 6) {
                    if (cais.getNextToLeaveHours() != null) {
                        cais.remove(cais.getNextToLeaveHours());
                        cais.add(ListadeEspera.dequeue());
                    }
                } else {
                    cais.add(ListadeEspera.dequeue());
                }
            }
            if (ListadeEspera.enqueue(camiao3)) {
                if (cais.getCapacidade() == 6) {
                    if (cais.getNextToLeaveHours() != null) {
                        cais.remove(cais.getNextToLeaveHours());
                        cais.add(ListadeEspera.dequeue());
                    }
                } else {
                    cais.add(ListadeEspera.dequeue());
                }
            }
            if (ListadeEspera.enqueue(camiao4)) {
                if (cais.getCapacidade() == 6) {
                    if (cais.getNextToLeaveHours() != null) {
                        cais.remove(cais.getNextToLeaveHours());
                        cais.add(ListadeEspera.dequeue());
                    }
                } else {
                    cais.add(ListadeEspera.dequeue());
                }
            }
            if (ListadeEspera.enqueue(camiao5)) {
                if (cais.getCapacidade() == 6) {
                    if (cais.getNextToLeaveHours() != null) {
                        cais.remove(cais.getNextToLeaveHours());
                        cais.add(ListadeEspera.dequeue());
                    }
                } else {
                    cais.add(ListadeEspera.dequeue());
                }
            }
        }
        
        else if (escolhaFuncao == 2) {
            CargaDescarga tipo = CargaDescarga.valueOf("DESCARGA");
            Camiao camiao1 = new Camiao(carga , capacidade , tempo, armazem , hora_entrada , matricula , hora_entrada, tipo);


            Camiao camiao5 = new Camiao(1000.0, 3500, 20 , armazem, "20/02/2021", "27-FO-31", "20:59", tipo);
            Camiao camiao2 = new Camiao(2000.0, 3000, 20 , armazem, "07/06/2021", "46-RZ-48", "13:01", tipo);
            Camiao camiao3 = new Camiao(1500.0, 3000, 20 , armazem, "20/02/2021", "27-HX-31", "20:59",tipo);
            Camiao camiao4 = new Camiao(1000.0, 2000, 20 , armazem, "07/06/2021", "46-PO-48", "13:01" ,tipo);


            if (ListadeEspera.enqueue(camiao1)) {
                if (cais.getCapacidade() == 6) {
                    if (cais.getNextToLeaveHours() != null) {
                        cais.remove(cais.getNextToLeaveHours());
                        cais.add(ListadeEspera.dequeue());
                    }
                } else {
                    cais.add(ListadeEspera.dequeue());
                }
            }
            if (ListadeEspera.enqueue(camiao2)) {
                if (cais.getCapacidade() == 6) {
                    if (cais.getNextToLeaveHours() != null) {
                        cais.remove(cais.getNextToLeaveHours());
                        cais.add(ListadeEspera.dequeue());
                    }
                } else {
                    cais.add(ListadeEspera.dequeue());
                }
            }
            if (ListadeEspera.enqueue(camiao3)) {
                if (cais.getCapacidade() == 6) {
                    if (cais.getNextToLeaveHours() != null) {
                        cais.remove(cais.getNextToLeaveHours());
                        cais.add(ListadeEspera.dequeue());
                    }
                } else {
                    cais.add(ListadeEspera.dequeue());
                }
            }
            if (ListadeEspera.enqueue(camiao4)) {
                if (cais.getCapacidade() == 6) {
                    if (cais.getNextToLeaveHours() != null) {
                        cais.remove(cais.getNextToLeaveHours());
                        cais.add(ListadeEspera.dequeue());
                    }
                } else {
                    cais.add(ListadeEspera.dequeue());
                }
            }
            if (ListadeEspera.enqueue(camiao5)) {
                if (cais.getCapacidade() == 6) {
                    if (cais.getNextToLeaveHours() != null) {
                        cais.remove(cais.getNextToLeaveHours());
                        cais.add(ListadeEspera.dequeue());
                    }
                } else {
                    cais.add(ListadeEspera.dequeue());
                }
            }

        }
        
        escreverfila(armazem);
    
       cais.escreverCamioes();

        
    }

    private static void escreverfila(Armazem armazem) {
        CircularArrayQueue<Camiao> ListadeEspera;
        ListadeEspera = armazem.getEspera();

        System.out.println();
        System.out.println();
        System.out.println("                    < ============================================= >");
        System.out.println("                    < ============== |  Em espera  | ============== >");
        System.out.println("                    < ============================================= >");
        System.out.println();
        System.out.println();
      if(ListadeEspera.isEmpty()){
        System.out.println("                           <-- Ninguem na lista de espera -->");
        System.out.println();
        System.out.println();
      }
      else  {
        System.out.println(ListadeEspera.toString()); 
      }
    }
    
    
}

