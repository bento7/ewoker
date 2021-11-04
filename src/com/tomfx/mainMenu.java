package com.tomfx;

import com.zetcode.*;
import javafx.animation.AnimationTimer;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Class manages everything for the user interface
 * Charging every font, images and musics
 * Creating the menu and the game environment
 * Update position of every element each 60 ms
 */

public class mainMenu extends Application {
    private static final double WIDTH = 1425;
    private static final double HEIGHT = 712;

    private List<Pair<String, Runnable>>
            menuData = Arrays.asList(
            new Pair<String, Runnable>("Single Player Basic", () -> {}),
            new Pair<String, Runnable>("Single Player infinite", () -> {}),
            new Pair<String, Runnable>("Two Player infinite", () -> {}),

            new Pair<String, Runnable>("Exit", Platform::exit));

    private Stage mainstage = new Stage();

    private Scene menuScene;
    private Scene gameScene;

    public Pane root;
    public Pane testroot;

    private final VBox menuBox = new VBox(-5);

    private Line line;

    Frog frog;
    Frog frog2;
    int nbfrog;

    String changing = "Menu";
    public Text scoretxt1 = new Text();
    public Text scoretxt2 = new Text();

    Reseau reseau;


    // Importing all images

    Image pauseMenu = new Image("res/menu/pauseMenu.png");
    ImageView ivpm = new ImageView(pauseMenu);

    Image GameOver = new Image("res/menu/overmenu.png");
    ImageView ivgo = new ImageView(GameOver);

    Image StartMenu = new Image("res/menu/startmenu.png");
    ImageView ivsm = new ImageView(StartMenu);

    Image StartMenu2 = new Image("res/menu/startmenu2ply.png");
    ImageView ivsm2 = new ImageView(StartMenu2);

    Image GameWon = new Image("res/menu/icon.jpg");
    ImageView ivgw = new ImageView(GameWon);

    Image ewok = new Image("res/element/ewok.png");
    ImageView iv1 = new ImageView(ewok);

    Image ewokadv = new Image("res/element/ewokadv.png");
    ImageView iv2 = new ImageView(ewokadv);

    Image v1 = new Image("res/background/7.jpg");
    ImageView ivVoi1 = new ImageView(v1);

    Image c1 = new Image("res/element/falcon.png");
    ImageView ivCar1 = new ImageView(c1);

    Image c2 = new Image("res/element/falcon.png");
    ImageView ivCar2 = new ImageView(c2);

    Image c3 = new Image("res/element/falcon.png");
    ImageView ivCar3 = new ImageView(c3);

    Image v2 = new Image("res/background/6.jpg");
    ImageView ivVoi2 = new ImageView(v2);

    Image c4 = new Image("res/element/falcon.png");
    ImageView ivCar4 = new ImageView(c4);

    Image c5 = new Image("res/element/falcon.png");
    ImageView ivCar5 = new ImageView(c5);

    Image c6 = new Image("res/element/falcon.png");
    ImageView ivCar6 = new ImageView(c6);

    Image v3 = new Image("res/background/5.png");
    ImageView ivVoi3 = new ImageView(v3);

    Image c7 = new Image("res/element/speeder.png");
    ImageView ivCar7 = new ImageView(c7);

    Image c8 = new Image("res/element/speeder.png");
    ImageView ivCar8 = new ImageView(c8);

    Image c9 = new Image("res/element/speeder.png");
    ImageView ivCar9 = new ImageView(c9);

    Image v4 = new Image("res/background/4.jpg");
    ImageView ivVoi4 = new ImageView(v4);

    Image c10 = new Image("res/element/falcon.png");
    ImageView ivCar10 = new ImageView(c10);

    Image c11 = new Image("res/element/falcon.png");
    ImageView ivCar11 = new ImageView(c11);

    Image c12 = new Image("res/element/falcon.png");
    ImageView ivCar12 = new ImageView(c12);

    Image v5 = new Image("res/background/3.jpg");
    ImageView ivVoi5 = new ImageView(v5);

    Image c13 = new Image("res/element/falcon.png");
    ImageView ivCar13 = new ImageView(c13);

    Image c14 = new Image("res/element/falcon.png");
    ImageView ivCar14 = new ImageView(c14);

    Image c15 = new Image("res/element/falcon.png");
    ImageView ivCar15 = new ImageView(c15);

    Image v6 = new Image("res/background/2.png");
    ImageView ivVoi6 = new ImageView(v6);

    Image c16 = new Image("res/element/speeder.png");
    ImageView ivCar16 = new ImageView(c16);

    Image c17 = new Image("res/element/speeder.png");
    ImageView ivCar17 = new ImageView(c17);

    Image c18 = new Image("res/element/speeder.png");
    ImageView ivCar18 = new ImageView(c18);

    Image v7 = new Image("res/background/1.jpg");
    ImageView ivVoi7 = new ImageView(v7);

    Image c19 = new Image("res/element/falcon.png");
    ImageView ivCar19 = new ImageView(c19);

    Image c20 = new Image("res/element/falcon.png");
    ImageView ivCar20 = new ImageView(c20);

    Image c21 = new Image("res/element/falcon.png");
    ImageView ivCar21 = new ImageView(c21);

    // Listing images
    public List<ImageView> ListIvEl = Arrays.asList(
            ivVoi1 , ivCar1, ivCar2, ivCar3,
            ivVoi2, ivCar4, ivCar5, ivCar6,
            ivVoi3, ivCar7, ivCar8, ivCar9,
            ivVoi4, ivCar10, ivCar11, ivCar12,
            ivVoi5, ivCar13, ivCar14, ivCar15,
            ivVoi6, ivCar16, ivCar17, ivCar18,
            ivVoi7, ivCar19, ivCar20, ivCar21,
            iv1, iv2
            );

    public int j = 0;
    public boolean paused = true;


    /**
     * Initialisation of the menu interface
     * Creating 3 options to click on
     */
    private Parent initMenu(){
        addBackground();
        addTitle();

        double lineX = WIDTH / 2 - 50;
        double lineY = HEIGHT / 3 + 20;

        addLine(lineX, lineY, root);
        addMenuOption(lineX + 5,lineY + 5, "Single Player Basic", "onebasic");
        addMenuOption(lineX + 5,lineY + 5, "Single Player infinite", "oneinf");
        addMenuOption(lineX + 5,lineY + 5, "Two Player infinite", "twoinf");

        root.getChildren().addAll(menuBox);
        startAnimation(menuBox);

        return root;
    }

    /**
     * Charging and plotting the menu background
     */
    private void addBackground() {
        Image image = new Image("res/menu/font.png");
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(WIDTH);
        imageView.setFitHeight(HEIGHT);

        root.getChildren().add(imageView);
    }

    /**
     * Creating a Title from the Title.java
     */
    private void addTitle() {
        Title title = new Title("Ewoker");

        title.setTranslateX(WIDTH / 2 - title.getTitleWidth() / 2);
        title.setTranslateY(HEIGHT / 3 - title.getTitleHeight());
        root.getChildren().add(title);
    }

    /**
     * Adding a line for a beautiful menu
     * Use : esthetics
     */
    private void addLine(double x, double y, Pane r){
        line = new Line(x, y, x, y+300);
        line.setStrokeWidth(3);
        line.setStroke(Color.color(1,1,1, 0.75));
        line.setEffect(new DropShadow(5, Color.BLACK));
        line.setScaleY(0);
        r.getChildren().add(line);
    }

    /**
     * Animating the line and menu options
     * The line will scale up
     * The menu options will come from the left
     */
    private void startAnimation(VBox mb) {
        ScaleTransition st = new ScaleTransition(Duration.seconds(1), line);
        st.setToY(1);
        st.setOnFinished(e -> {
            for (int i = 0; i < mb.getChildren().size(); i++) {
                Node n = mb.getChildren().get(i);
                TranslateTransition tt = new TranslateTransition(Duration.seconds(1 + i * 0.15), n);
                tt.setToX(0);
                tt.setOnFinished(e2 -> n.setClip(null));
                tt.play();
            }
        });
        st.play();
    }

    /**
     * Creating a game option
     * Setting the name of the option
     * Setting Mouse Event (when clicked)
     */
    private void addMenuOption(double x, double y, String gmode, String strchg) {
        menuBox.setTranslateX(x);
        menuBox.setTranslateY(y);

        com.tomfx.MenuItem item = new com.tomfx.MenuItem(gmode);
        item.setTranslateX(-300);

        Rectangle clip = new Rectangle(300, 30);
        clip.translateXProperty().bind(item.translateXProperty().negate());

        item.setonAction();

        //Creating the mouse event handler
        EventHandler<MouseEvent> eventHandler = e -> {
            changing = strchg;
            change();
        };

        //Registering the event filter
        item.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        //Registering the event filter
        item.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        item.setClip(clip);

        menuBox.getChildren().add(item);
    }

    /**
     * Method used to show the menu Scene or a game scene
     * String "changing" is either: menu, onebasic, oneinf, twoinf
     * Depending on this string, a new game is created and can start
     */
    public void change(){
        if (changing == "Menu") {
            System.out.println("Go to Menu");
            mainstage.setScene(menuScene);
            mainstage.show();
        }
        else if (changing == "onebasic"){
            changing = "Menu";
            createinfinite(0);
            mainstage.setScene(gameScene);
            mainstage.show();}
        else if (changing == "oneinf"){
            changing = "Menu";
            createinfinite(1);
            mainstage.setScene(gameScene);
            mainstage.show();}

       else if (changing == "twoinf"){
            changing = "Menu";
            System.out.println("Go to Game, two player, infinite mode");
            createinfinite(2);
            mainstage.setScene(gameScene);
            mainstage.show();
       }
    }

    /**
     * Use of a mediaplayer to play a back music
     * Goal : better gameplay
     */
    public void music() {
        File f = new File("src/res/music/forcetheme.mp3");
        Media m = new Media(f.toURI().toString());
        MediaPlayer mp = new MediaPlayer(m);
        mp.play();
    }

    /**
     * When the game is started, all elements must be actualised
     * This method relocates the imageviews of the elements
     *
     * @param iv The Imageview which will be moved
     * @param el The Element corresponding (access to x and y)
     */
    private void moveElement(ImageView iv, Element el) {
        if(!paused){
            iv.relocate(el.x, el.y);
        }
    }

    /**
     * When the game is started, the roads are actualised
     * @param iv Imageview to move
     * @param v Voi corresponding (access to x and y)
     */
    private void moveVoie (ImageView iv, Voie v) {
        if(!paused){iv.relocate(v.x, v.y);}
    }

    @Override
    public void start(Stage primaryStage){

        //running music at the beginning
        music();

        // managing the mainwindow
        mainstage.setTitle("Ewoker 4.2");
        mainstage.getIcons().add(new Image("res/menu/icon.jpg"));

        mainstage.setWidth(WIDTH);
        mainstage.setHeight(HEIGHT);

        root = new Pane();
        menuScene = new Scene(initMenu());

        mainstage.setScene(menuScene);
        mainstage.show();
    }

    /**
     * This method will go through each element of the list of imageview
     * created at the beginning and actualise its x, y coordinates
     * This method is called every 60ms
     * @param board Many informations needed from the controller board
     */
    private void actualiseboard(Board board){
        j = 0;
        reseau = board.reseau;
        frog = board.frog;
        frog2 = board.frog2;

        // Setting the score of each frog
        int scoref1 = frog.score;
        scoretxt1.setText(String.valueOf(scoref1));
        int scoref2 = frog2.score;
        scoretxt2.setText(String.valueOf(scoref2));

        // Getting the mode (0, 1, 3) of the game played
        nbfrog = board.nbfrog;

        for (Voie voi : reseau) {
            moveVoie(ListIvEl.get(j), voi);
            j++;
            for (Vroum car : voi) {

                // reversing the image according to the direction it's heading
                if (voi.leftDirection){
                    ListIvEl.get(j).setRotationAxis(Rotate.Y_AXIS);
                    ListIvEl.get(j).setRotate(180);}
                if (voi.rightDirection){
                    ListIvEl.get(j).setRotationAxis(Rotate.Y_AXIS);
                    ListIvEl.get(j).setRotate(0);}
                moveElement(ListIvEl.get(j), car);
                j++;
            }
        }
        moveElement(ListIvEl.get(j), frog);
        if (nbfrog == 2){
            ListIvEl.get(ListIvEl.size()-1).setVisible(true);
            moveElement(ListIvEl.get(j+1), frog2);
        }
        else{
            ListIvEl.get(ListIvEl.size()-1).setVisible(false);
        }
    }

    /**
     * This method initiates and manages the game
     * depending on the chosen mode (0, 1, 2)
     * It will manage initialisation of every imageview
     * Creation of the AnimationTimer
     * Creation of the KeyEvents for both froggers and global managing of the game
     *
     * @param mode 0 : finite, 1 : one player infinite, 2 : two players infinite
     */
    private void createinfinite(int mode) {
        testroot = new Pane();
        gameScene = new Scene(testroot);

        Board board = new Board();
        board.nbfrog = mode;

        board.initGame();

        ListIvEl.forEach((iv) -> testroot.getChildren().add(iv));

        paused = false;
        board.refresh();
        actualiseboard(board);
        paused = true;

        setscore(scoretxt1, 0);
        if (mode == 2){
            setcenteredim(ivsm2);
            ivsm2.setVisible(true);
            setscore(scoretxt2, 1000);}
        else if (mode == 0 || mode == 1){
            setcenteredim(ivsm);
            ivsm.setVisible(true);}

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Here, actualisation every 60ms

                // Disable the start menu
                ivsm.setVisible(false);
                ivsm2.setVisible(false);

                // Refreshing the game interface
                if (board.inGame){
                    board.refresh();
                    actualiseboard(board);}

                // When the game is stopped
                else{
                    if(board.win){
                        setcenteredim(ivgw);
                        ivgw.setVisible(true);
                        paused = true;
                        board.win = false;
                    }
                    // gestion du gagnant en infini
                    else if(mode == 1){
                        setcenteredim(ivgo);
                        ivgo.setVisible(true);
                        paused = true;
                    }
                    else if(mode ==2){
                        if (frog.score == winner()){
                            scoretxt1.setText(String.valueOf(frog.score));
                        }
                        else{
                            scoretxt2.setText(String.valueOf(frog2.score));
                        }
                        setcenteredim(ivgo);
                        ivgo.setVisible(true);
                        paused = true;
                    }
                }
            }
        };

        //Creating the key event handler for first frog
        EventHandler<KeyEvent> kef1 = e -> {
            switch (e.getCode()) {
                case Q -> board.moveFrog("left", frog);
                case Z -> board.moveFrog("up", frog);
                case S -> board.moveFrog("down", frog);
                case D -> board.moveFrog("right", frog);
            }
        };
        //Creating the key event handler for second frog
        EventHandler<KeyEvent> kef2 = e -> {
            switch (e.getCode()) {
                case O -> board.moveFrog("up", frog2);
                case K -> board.moveFrog("left", frog2);
                case L -> board.moveFrog("down", frog2);
                case M -> board.moveFrog("right", frog2);
            }
        };
        //Creating the key event handler for managing the game with keyboard
        EventHandler<KeyEvent> manage = e -> {
            switch(e.getCode()) {
                case SPACE:
                    if (paused && board.inGame) {
                        paused = false;
                        ivpm.setVisible(false);
                        timer.start();
                    } else if (!paused && board.inGame){
                        paused = true;
                        setcenteredim(ivpm);
                        ivpm.setVisible(true);
                        timer.stop();
                    } else {
                        timer.stop();
                        if(mode == 0){changing = "onebasic";}
                        else if(mode == 1){changing = "oneinf";}
                        else{changing = "twoinf";}
                        change();
                    }
                    break;

                case G: // Back to menu
                    if(paused){
                        paused = false;
                        ivgo.setVisible(false);
                        timer.stop();
                        change();
                    }
                    break;

                case R: // Restart game
                    if (paused){
                        timer.stop();
                        if(mode == 0){changing = "onebasic";}
                        else if(mode == 1){changing = "oneinf";}
                        else{changing = "twoinf";}
                        change();
                    }
                    break;
            }
        };
        gameScene.addEventFilter(KeyEvent.KEY_PRESSED, kef1);

        if (board.nbfrog == 2){
            gameScene.addEventFilter(KeyEvent.KEY_PRESSED, kef2);}

        gameScene.addEventFilter(KeyEvent.KEY_PRESSED, manage);

    }

    /**
     * This method takes an imageview and plot it in the center of the window
     * @param iv Imageview to plot
     */
    private void setcenteredim(ImageView iv) {
        Pane p = new Pane(iv);
        iv.relocate((WIDTH - iv.getLayoutBounds().getWidth())/2, (HEIGHT - iv.getLayoutBounds().getHeight() )/2);
        testroot.getChildren().add(p);
    }

    /**
     * This method sets the score of both frogger
     * @param scoretxt Name of the future text
     * @param space Spacing between different scoretexts
     */
    private void setscore(Text scoretxt, int space){

        File f = new File("src/res/font/starjedi.ttf");
        scoretxt.setTranslateX(WIDTH/10 + space);
        scoretxt.setTranslateY(HEIGHT/10);
        scoretxt.setFont((Font.loadFont(f.toURI().toString(), 60.0)));
        
        scoretxt.toFront();
        scoretxt.setFill(Color.WHITE);
        
        testroot.getChildren().addAll(scoretxt);
    }

    /**
     * This method calculates which of both frogs is the winner
     * based on their score
     * @return the best score between the 2 frogs
     */
    private int winner(){
        int score1 = frog.score;
        int score2 = frog2.score;
        return(Math.max(score1, score2));
    }

    public static void main(String[] args) {
        launch();
    }
}