package com.tomfx;

import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;
import java.util.Collections;

/**
 * Class makes a beautiful title for the Game Menu
 */
public class Title extends Pane {
    private final Text text;

    public Title(String name){
        String spread = "";

        for (char c : name.toCharArray()) {
            spread += c +" ";
        }

        text = new Text(spread);

        File f = new File("src/res/font/starjedi.ttf");

        text.setFont((Font.loadFont(f.toURI().toString(), 60.0)));
        text.setFill(Color.WHITE);

        text.setEffect(new DropShadow(10, Color.BLACK));

        getChildren().addAll(Collections.singleton(text));

    }
    public double getTitleWidth() {return text.getLayoutBounds().getWidth(); }
    public double getTitleHeight() {return text.getLayoutBounds().getHeight(); }
}