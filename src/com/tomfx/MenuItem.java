package com.tomfx;

import javafx.beans.binding.Bindings;
import javafx.scene.effect.*;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;

/**
 * Class creates the MenuItem
 * Puts them into Polygons (esthetics)
 * The MenuItem have some nice features and effects
 * Goal : esthetics and gameplay
 */

public class MenuItem extends Pane {
    private Text text;

    private Effect shadow = new DropShadow(5, Color.BLACK);
    private Effect blur = new BoxBlur(1, 1, 2);

    public MenuItem(String name){
        Polygon bg = new Polygon(
          0, 0,
          200, 0,
          215, 15,
          200, 30,
          0, 30
        );
        bg.setStroke(Color.color(1,1,1,0.75));
        bg.setEffect((new GaussianBlur()));

        bg.fillProperty().bind(
                Bindings.when(pressedProperty())
                        .then(Color.color(0,0,0,0.75))
                        .otherwise(Color.color(0,0,0,0.25))
        );

        text = new Text(name);
        text.setTranslateX(10);
        text.setTranslateY(20);


        File f = new File("src/res/font/starjedi.ttf");
        text.setFont((Font.loadFont(f.toURI().toString(), 15.0)));
        text.setFill(Color.WHITE);

        text.effectProperty().bind(
                Bindings.when(hoverProperty())
                        .then(shadow)
                        .otherwise(blur)
        );

        getChildren().addAll(bg, text);
    }

    /**
     * This method calls a music when the MenuItem is clicked
     */
    public void setonAction() { setOnMouseClicked(e -> music());}

    /**
     * This methods plays the music
     */
    private void music() {File f = new File("src/res/music/lightsaber.mp3");
        Media m = new Media(f.toURI().toString());
        MediaPlayer mp = new MediaPlayer(m);
        mp.play();
    }

}