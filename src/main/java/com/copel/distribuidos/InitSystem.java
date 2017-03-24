/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.copel.distribuidos;

import java.util.Scanner;

/**
 *
 * @author allan
 */
public class InitSystem {
    
        public static void main (String[] args) {
                    
            
                  String nome = "nome";
                  System.out.println("aquii");
                  Multcast multcast = new Multcast();
                  multcast.setArgs(nome);
//                  multcast.setProducts();
//                  multcast.run();
//                  multcast.close();
                  System.out.println("Nome");
                  Scanner ler = new Scanner(System.in);
                  Leiloero leiloero = new Leiloero();
                  leiloero.setNome(ler.next());
                  System.out.println("Senha Publica");
                  leiloero.setKeyPublicA(ler.next());
                  System.out.println("Senha Privada");
                  leiloero.setKeyPrivateA(ler.next());
                  leiloero.setMult(multcast);
                  leiloero.getMult().run();
                  
                  
                  
                  
                  
                  
             
         
                  
                  
                  
        }
}
