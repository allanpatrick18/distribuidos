/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.copel.distribuidos;

import java.util.List;

/**
 *
 * @author allan
 */
public class Leiloero {
    
    public String nome;
    public Multcast mult = new Multcast();
    public  Unicast unicast = new Unicast();
    private String keyPrivateA;
    private String keyPublicA;
    private String KeyAB;
    private List<Product> products;
    


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Multcast getMult() {
        return mult;
    }

    public void setMult(Multcast mult) {
        this.mult = mult;
    }

    public Unicast getUnicast() {
        return unicast;
    }

    public void setUnicast(Unicast unicast) {
        this.unicast = unicast;
    }

    public String getKeyPrivateA() {
        return keyPrivateA;
    }

    public void setKeyPrivateA(String keyPrivateA) {
        this.keyPrivateA = keyPrivateA;
    }

    public String getKeyPublicA() {
        return keyPublicA;
    }

    public void setKeyPublicA(String keyPublicA) {
        this.keyPublicA = keyPublicA;
    }

    public String getKeyAB() {
        return KeyAB;
    }

    public void setKeyAB(String KeyAB) {
        this.KeyAB = KeyAB;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    
}
