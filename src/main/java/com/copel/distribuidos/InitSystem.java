/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.copel.distribuidos;

import apresentacao.Inicio;
import java.lang.management.ManagementFactory;


/**
 *
 * @author allan
 */
public class InitSystem {
    
        public static void main (String[] args) {
          
           Inicio inicio = new Inicio();
         
           String name = ManagementFactory.getRuntimeMXBean().getName();
           System.out.println("Name =" + name);
           GeraChave gchave = new GeraChave();
           gchave.geraChave();   
           byte[] chavePrivada = gchave.getChavePrivada();
           byte[] chavePublica = gchave.getChavePublica();
            
           Leiloero leiloero = new Leiloero(name, chavePrivada, chavePublica);  
           Comprador comprador = new Comprador(name, chavePrivada, chavePublica);
           
           WritingThread wt = new WritingThread();        
           ReadingThread rt = new ReadingThread();
           
           new Thread(wt).start();
           new Thread(rt).start();
           
          
                  
                  
        }
}
