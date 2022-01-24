/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pannello;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *campo testuale
 * @author paoloaliprandi
 */
public class MyText extends Text {
    
    MyText(String s) {
        super(s);
        
        this.setFont(Font.font("Arial", FontWeight.BOLD, 15));
    }
    
}