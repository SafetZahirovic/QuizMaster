package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class Main extends Application {

    private Logic log;
    private Resources res;
    private TextField text = new TextField ();
    private TextField text1 = new TextField ();
    private Image image;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        //Setting up resources
        res = new Resources();
        log = new Logic();
        image = new Image(res.returnList().get(0).getURL());
        Media media = new Media(Paths.get("/Users/safetzahirovic/Documents/CardGame/Quiz_Beta1/src/resources/kahoot.mp3").toUri().toString());
        Media media1 = new Media(Paths.get("/Users/safetzahirovic/Documents/CardGame/Quiz_Beta1/src/resources/Where.mp3").toUri().toString());
        AudioClip clip = new AudioClip(Paths.get("/Users/safetzahirovic/Documents/CardGame/Quiz_Beta1/src/resources/aallrighty.wav").toUri().toString());
        AudioClip clip1 = new AudioClip(Paths.get("/Users/safetzahirovic/Documents/CardGame/Quiz_Beta1/src/resources/laugh.wav").toUri().toString());

        //Setting up logic
        MediaPlayer IntroMusic= new MediaPlayer(media);
        IntroMusic.setAutoPlay(true);
        IntroMusic.setCycleCount(MediaPlayer.INDEFINITE);
        IntroMusic.setVolume(1);
        MediaView mediaView = new MediaView(IntroMusic);

        MediaPlayer MainMusic = new MediaPlayer(media1);
        MainMusic.setCycleCount(MediaPlayer.INDEFINITE);
        MainMusic.setVolume(1);
        MediaView mediaView1 = new MediaView(MainMusic);

        ImageView iv1  =  new ImageView();
        iv1.setImage(image);
        iv1.setFitWidth(500);
        iv1.setFitHeight(400);


        //Making root nodes
        StackPane rootPane = new StackPane();
        StackPane stackPane = new StackPane();

        //Making Scenes(No pun intended)
        Scene scene = new Scene(stackPane, 600, 600);
        Scene scene1 = new Scene(rootPane, 600, 600);

        //Adding nodes and leaf nodes for "Scene"
        scene1.getStylesheets().add("/resources/style.css");
        Label choose = new Label("Choose between 1 and 30 questions to answer.");
        Label chosen = new Label();
        Label Error = new Label();

        Button Play = new Button("Play");
        Play.setPrefSize(200,50);
        Play.setPrefWidth(100);
        Play.setPrefHeight(10);

        VBox questionNumber = new VBox();
        questionNumber.getChildren().addAll(choose,text1,Play,Error,chosen);
        questionNumber.setAlignment(Pos.CENTER);
        questionNumber.setSpacing(10);
        stackPane.getChildren().addAll(questionNumber,mediaView);

        text1.setMaxWidth(60);

        //Adding nodes and leaf nodes for "Scene1"
        Button AnswerButton = new Button("Answer");
        Button success = new Button("Quit");
        Button restartButton = new Button("Restart");

        Label CorrectAnswers = new Label("Number of correct answers: " + log.getCorrect());
        Label CountryName = new Label("What's the capital of " + res.returnList().get(0).getCountry());
        Label OutOf = new Label();
        Label AnswerQuestion = new Label("");

        VBox box = new VBox();
        rootPane.getChildren().add(box);
        box.getChildren().addAll(CountryName,iv1,text,AnswerButton,OutOf,AnswerQuestion,CorrectAnswers,mediaView1);
        box.setSpacing(8);
        box.setAlignment(Pos.CENTER);

        text.setMaxWidth(200);
        text.positionCaret(6);

        scene.getStylesheets().add("/resources/style.css");

        //Handling EventHandles
        Play.setOnAction(e->{
            try {
                if(Integer.parseInt(text1.getText()) > 30){
                    Error.setText("Please select number of questions in range");
                    chosen.setText("");
                    text1.clear();
                }
                else if(Integer.parseInt(text1.getText()) <= 30) {
                    log.setIndex(Integer.parseInt(text1.getText()));
                    log.returnString();
                    OutOf.setText(log.returnString());
                    chosen.setText("You choose " + log.getIndex() + " questions");
                    IntroMusic.stop();
                    primaryStage.setScene(scene1);
                    MainMusic.play();
                    text1.clear();
                }
            }catch (NumberFormatException g){
                Error.setText("");
                chosen.setText("Please enter the number of desired questions");}
        });
        AnswerButton.setOnAction( e-> {
            try {
                log.setPicture(image, iv1);
                CountryName.setText(log.getCountry());
                log.AnswerCounter(clip, clip1, text.getText(), OutOf, AnswerQuestion, AnswerButton, CorrectAnswers);
                log.answers(text.getText());
                text.clear();
                log.EndGame(restartButton, box, rootPane, OutOf, CountryName, iv1,text,success,CorrectAnswers,AnswerButton);

            }catch (IllegalArgumentException g){System.out.println(g);}
        });
        restartButton.setOnAction(e->{Main app=new Main();
            try {
                app.start(primaryStage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });


        //Adding hotkeys
        success.setOnAction(e->{
            primaryStage.close();
        });
        rootPane.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER)
                AnswerButton.fire();
        });
        stackPane.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER)
                Play.fire();
        });
        //Launching Stage
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.setTitle("Welcome  " + " ( ͡ ° ͜ʖ ͡ ° )");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main (String[]args){
        launch(args);
    }
}