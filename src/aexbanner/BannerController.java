/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aexbanner;

import java.util.List;
import java.util.Timer;
import javafx.application.Platform;

public class BannerController {

    private AEXBanner banner;
    private IEffectenbeurs effectenbeurs;
    private Timer pollingTimer;
    private List<IFonds> fondsen;

    public BannerController(AEXBanner banner) {

        this.banner = banner;
        this.effectenbeurs = new MockEffectenbeurs();
        
        // Start polling timer: update banner every two seconds
        pollingTimer = new Timer();
        
        class PeriodiekeActie extends java.util.TimerTask {
            String alleFondsen = "";
            @Override
            public void run() {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    fondsen = effectenbeurs.getKoersen();
                    for (IFonds f : fondsen){
                        alleFondsen = alleFondsen + " " +  f.getNaam() + " " + f.getKoers();
                    }
                    
                    banner.setKoersen(alleFondsen);
                    alleFondsen = "";
                    fondsen.clear();
                }
            });
            }
        }
        pollingTimer.schedule(new PeriodiekeActie(),0,2000);
        

    }

    // Stop banner controller
    public void stop() {
        pollingTimer.cancel();
        // Stop simulation timer of effectenbeurs
        // TODO
    }
}

