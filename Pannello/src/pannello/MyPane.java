/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pannello;

/**
 *
 * @author paoloaliprandi
 */
import java.util.Random;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *interfaccia grafica
 * @author paoloaliprandi
 */

public class MyPane extends BorderPane {
    
    //valore bool per tracking mouse
    Boolean abilitato;
    Random generatore = new Random(System.currentTimeMillis());
    
    /*contenitore_H superiore
    */
    HBox top = new HBox();
    
    /*contenitore_V a destra
    
    */
    VBox xy = new VBox();
    /*conteniti in xy, sono le coord X e Y
    
    */
    HBox x_c = new HBox();
    HBox y_c = new HBox();
    
    /*pulsante
    
    */
    Button cambia_stato = new Button("Cambia Stato");
    /*mostra lo stato del pulsante
    
    */
    Label stato = new Label("DISABILITATO");
    
    MyText x = new MyText("X = ");
    MyText y = new MyText("Y = ");
    
    /*coord x
    
    */
    public int coo_x = 0;
    /*coord y
    
    */
    public int coo_y = 0;
    
    MyTextField x_f = new MyTextField("" + coo_x);
    MyTextField y_f = new MyTextField("" + coo_y);
    
    Pane pannello = new Pane();
    
    
    MyPane() {
        
        x_c.getChildren().addAll(x, x_f);
        y_c.getChildren().addAll(y, y_f);
        
        y_c.setPadding(new Insets(5,0,0,0));
        
        xy.setPadding(new Insets(0,0,0,50));
        xy.getChildren().addAll(x_c, y_c);
        
        stato.setPadding(new Insets(0,0,0,20));
        stato.setAlignment(Pos.CENTER);
        
        top.setPadding(new Insets(0,0,10,0));
        top.getChildren().addAll(cambia_stato, stato, xy);
        
        BorderPane.setAlignment(top, Pos.TOP_CENTER);
        this.setTop(top);
        
        top.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
        
        pannello.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        pannello.setPrefSize(USE_PREF_SIZE, Double.MAX_VALUE);
        
        BorderPane.setAlignment(pannello, Pos.CENTER);
        this.setCenter(pannello);
        
        CambiaStatoListener csl = new CambiaStatoListener(this);
        cambia_stato.setOnAction(csl);
        
        pannello.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                controllo();
                
                if(abilitato == true) {
                    x_f.setText("" + t.getX());
                    y_f.setText("" + t.getY());
                }
            }
        });
        
        pannello.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                
                /*
                *genera dei punti dove il mouse clicca, di colore casuale
                *@param t evento da Mouse
                *
                */
                
                controllo();
                
                if(abilitato == true) {
               
                    Text text = new Text(t.getX(), t.getY(), "O");
                    text.setFill(Color.rgb(generatore.nextInt(256), generatore.nextInt(256), generatore.nextInt(256)));
                    
                    pannello.getChildren().add(text);
                } else {t.consume();}
            }
        });
    }
    
    public void controllo() {
        /*
        *abilita o disabilita il tracking del mouse in Pannello
        *
        */
        
        if(stato.getText().equals("ABILITATO")) {abilitato = true;}
        if(stato.getText().equals("DISABILITATO")) {abilitato = false;}
    }
}
