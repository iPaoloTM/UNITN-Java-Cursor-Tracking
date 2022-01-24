/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pannello;

import javafx.scene.control.TextField;

/**
 *label non editabile dall'utente
 * @author paoloaliprandi
 */
public class MyTextField extends TextField {
    
    MyTextField(String s) {
        super(s);
        
        this.setEditable(false);
        this.setMaxWidth(60);
    }
}

