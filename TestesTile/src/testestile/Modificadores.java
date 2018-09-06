/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testestile;

import java.awt.Color;

/**
 *
 * @author User
 */
public class Modificadores {
    private Color cor=null;
    private double atributo = 0.0;
    private String nome = null;
    
    public  Modificadores(Color cor,double atributo,String nome){
        this.nome = nome;
        this.atributo = atributo;
        this.cor=cor;
    }

    public Color getCor() {
        return cor;
    }

    public double getAtributo() {
        return atributo;
    }

    public String getNome() {
        return nome;
    }
    
    
}
