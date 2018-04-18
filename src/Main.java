
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
import javafx.scene.web.WebView;

import java.nio.file.Paths;

public class Main extends Application {

    private Logic log;
    private Resources res;
    private TextField text = new TextField ();
    private TextField text1 = new TextField ();
    private Image image;
    private int count = 0;
    private int incorrect = 1;
    private int correct = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Setting up resources
        res = new Resources();
        log = new Logic();
        image = new Image(res.returnList().get(0).getURL());
        Media media = new Media(res.returnIntroMusic().get(count));
        Media media1 = new Media(res.returnMusic().get(count));
        AudioClip clip = new AudioClip(Paths.get("resources/correct.wav").toUri().toString());
        AudioClip clip1 = new AudioClip(Paths.get("resources/wrong.wav").toUri().toString());
        AudioClip endClip = new AudioClip(Paths.get("resources/bigApplause.wav").toUri().toString());
        
        //Setting up logic
        MediaPlayer IntroMusic= new MediaPlayer(media);
        IntroMusic.setAutoPlay(true);
        IntroMusic.setCycleCount(MediaPlayer.INDEFINITE);
        IntroMusic.setVolume(1);
        MediaView mediaView = new MediaView(IntroMusic);

        MediaPlayer MainMusic = new MediaPlayer(media1);
        MainMusic.setCycleCount(MediaPlayer.INDEFINITE);
        MainMusic.setVolume(1.2);
        MediaView mediaView1 = new MediaView(MainMusic);
        
        clip.setVolume(0.2);
        clip1.setVolume(0.2);
        //endClip.setVolume(0.5);

        ImageView iv1  =  new ImageView();
        iv1.setImage(image);
        iv1.setFitWidth(500);
        iv1.setFitHeight(400);

        //Making root nodes
        StackPane rootPane = new StackPane();
        StackPane stackPane = new StackPane();

        //Making Scenes(No pun intended)
        Scene scene = new Scene(stackPane, 700, 700);
        Scene scene1 = new Scene(rootPane, 700, 700);

        //Adding nodes and leaf nodes for "Scene"
        scene1.getStylesheets().add("/resources/style.css");
        Label choose = new Label("Choose between 1 and 20 questions to answer.");
        Label chosen = new Label();
        Label Error = new Label();
        Label IntroText = new Label("Welcome to the Capital Quiz. All questions are in english, so please answer in english.");
        IntroText.setStyle("-fx-font-size: 13pt;");
        
        Button Play = new Button("Play");
        Play.setPrefSize(200,50);
        Play.setPrefWidth(100);
        Play.setPrefHeight(10);

        VBox questionNumber = new VBox();
        questionNumber.getChildren().addAll(IntroText,choose,text1,Play,Error,chosen);
        questionNumber.setAlignment(Pos.CENTER);
        questionNumber.setSpacing(10);
        stackPane.getChildren().addAll(questionNumber,mediaView);

        text1.setMaxWidth(60);

        //Adding nodes and leaf nodes for "Scene1"
        Button AnswerButton = new Button("Answer");
        Button quit = new Button("Quit");
        Button restartButton = new Button("Restart");

        Label CorrectAnswers = new Label();
        Label CountryName = new Label("What's the capital of " + res.returnList().get(0).getCountry());
        Label OutOf = new Label("Question nr: " + incorrect + " out of: " + log.getIndex() + "                    Number of correct answers: " + correct);
        Label AnswerQuestion = new Label();
        Label RightAnswer = new Label();

        VBox box = new VBox();
        rootPane.getChildren().add(box);
        box.getChildren().addAll(RightAnswer,CountryName,iv1,text,AnswerButton,OutOf,AnswerQuestion,CorrectAnswers,mediaView1);
        box.setSpacing(8);
        box.setAlignment(Pos.CENTER);

        text.setMaxWidth(200);
        text.positionCaret(6);

        scene.getStylesheets().add("/resources/style.css");

        //Handling EventHandles
        Play.setOnAction(e->{
            try {
                if(Integer.parseInt(text1.getText()) > 20 || Integer.parseInt(text1.getText()) <= 0){
                    Error.setText("Please select number of questions in range");
                    chosen.setText("");
                    text1.clear();
                }
                else if(Integer.parseInt(text1.getText()) <= 20) {
                    log.setIndex(Integer.parseInt(text1.getText()));
                    OutOf.setText("Question nr: " + incorrect + " out of: " + log.getIndex() + "                    Number of correct answers: " + correct);
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
                count++;
                incorrect++;
                log.setIncorrect(incorrect);
                image = new Image(res.returnList().get(count).getURL());
                iv1.setImage(image);
                CountryName.setText("What's the capital of " + res.returnList().get(count).getCountry());
                if (text.getText().equalsIgnoreCase(res.returnList().get(count -1).getCity())) {
                    correct++;
                    log.setCorrect(correct);
                    AnswerButton.setStyle("-fx-background-color:green");
                    RightAnswer.setText("Question nr. " + Integer.toString(incorrect - 1) + " was correct!");
                    RightAnswer.setStyle("-fx-background-color:green");
                    OutOf.setText("Question nr: " + incorrect + " out of: " + log.getIndex() + "                    Number of correct answers: " + correct);
                }
                else if (!text.getText().equalsIgnoreCase(res.returnList().get(count -1).getCity())) {
                    AnswerButton.setStyle("-fx-background-color:red");
                    OutOf.setText("Question nr: " + incorrect + " out of: " + log.getIndex() + "                    Number of correct answers: " + correct);
                    RightAnswer.setText("Question nr. " + Integer.toString(incorrect - 1) + " was incorrect! The right answer was " + res.returnList().get(count -1).getCity());
                    RightAnswer.setStyle("-fx-background-color:red");
                    text.clear();
                }
                if (text.getText().equalsIgnoreCase(res.returnList().get(count -1).getCity()) && incorrect < log.getIndex() + 1){
                    clip.play();
                }
                if (!text.getText().equalsIgnoreCase(res.returnList().get(count -1).getCity())&& incorrect < log.getIndex() + 1){
                    clip1.play();
                }
               text.clear();
               log.EndGame(endClip,RightAnswer,incorrect, restartButton, box, rootPane, OutOf, CountryName, iv1,text,quit,CorrectAnswers,AnswerButton);
            }catch (IllegalArgumentException g){System.out.println(g);}
        });
        restartButton.setOnAction(e->{Main app=new Main();
            try {
                MainMusic.stop();
                endClip.stop();
                app.start(primaryStage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });


        //Adding hotkeys
        quit.setOnAction(e->{
            primaryStage.close();
            endClip.stop();
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