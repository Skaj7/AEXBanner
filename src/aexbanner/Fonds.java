/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import java.util.Random;

/**
 *
 * @author HP user
 */
public class Fonds implements IFonds{
    Random rnd = new Random();
    int a;
    public Fonds(int a){
        this.a = a;
    }
            
    public enum Names {
    philips,Sony,LG,HP;
    }
    
    @Override
    public String getNaam() {
        
        switch(a){
            case(1):                          
                return Names.Sony.toString();
            case(2):
                return Names.LG.toString();    
            case(3):
                return Names.HP.toString();
            default:
                return Names.philips.toString();
        }
        
               
    }

    @Override
    public double getKoers() {
        int a = rnd.nextInt(50);
        return a;
    }
    
}
