/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.copel.distribuidos;

/**
 *
 * @author allan
 */
public class InitSystem {
    
        public static void main (String[] args) {
 
                  Multcast multcast = new Multcast();
                  Thread threadMulticast =new Thread();
                  threadMulticast.run();
                  
                  
        }
}
