package com.projeto.vista;
import java.util.Scanner;

import com.projeto.Classes.Armazem; 
public class MenuArmazem {
    public static void menuArmazem() {
        Scanner opcao = new Scanner(System.in);
		int escolha;
        do {
            System.out.println("\n\n                             ### Cenas de Armazem ###");
            System.out.println("\n                            ===========================");
            System.out.println("                            |     1 - Ver capacidade   |");
            System.out.println("                            |     2 - Ver Cais         |");
            System.out.println("                            ============================\n");
    
            System.out.println("Opção -> ");
            escolha = opcao.nextInt();
            switch (escolha) {
            case 1: 
                break;
            case 2:MenuCamiao.MenuCamiao();
    
                break;
                       //case3 , 4  , etc...
            case 3: 
    
                break;
            case 0:
                break;
            default:
                System.out.println("Opção Inválida!");
                break;
            }
        } while (escolha != 0);
       
      
      }
}
