package com.tomfx;

import com.zetcode.Frog;
import com.zetcode.Reseau;
//import com.zetcode.Vroum;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.GraphicsContext;

public class GameFX extends Scene {
    public final Pane testroot ; // or any other kind of pane, or  Group...
    private boolean inGame = true;

    Reseau reseau = new Reseau();
    Frog frog = new Frog();
    private static final double WIDTH = 1425;
    private static final double HEIGHT = 712;

    public GameFX(Pane testroot) {
        super(testroot);
        this.testroot = testroot;
    }
}