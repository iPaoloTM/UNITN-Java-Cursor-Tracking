/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pannello;

import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *ascoltatore esterno per gestire eventi 
 * @author paoloaliprandi
 */
public class CambiaStatoListener implements EventHandler {
    
    MyPane app = null;
    
    CambiaStatoListener(MyPane a) {
        app = a;
    }
    
    @Override
    public void handle(Event t) {
        app.controllo();
        
        if(app.abilitato == true) {app.stato.setText("DISABILITATO"); app.abilitato = false;}
        else {app.stato.setText("ABILITATO"); app.abilitato = true;}
    }
}
