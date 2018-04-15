package sample;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;

import java.awt.*;
import java.nio.file.Paths;

public class Logic {
    private TextField questionRange = new TextField();
    private TextField text = new TextField();
    private Resources res;
    private Image image;
    private ImageView imageView;
    private String City = "";
    private String Country = "";
    private String Flag = "";
    private Label label;
    private int count;
    private int correct ;
    private int incorrect = 1;
    private int index = 0;
    //Constructor for Logic class
    public Logic(){
        res = new Resources();
        imageView = new ImageView();
        image = new Image(Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/no.png").toUri().toString());
        label = new Label("0");
        setCount(count);
        setIncorrect(incorrect);
        setCorrect(correct);
    }

    //Getters and setters
    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public TextField getQuestionRange() { return questionRange; }

    public void setQuestionRange(TextField questionRange) { this.questionRange = questionRange; }

    public int getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(int incorrect) { this.incorrect = incorrect; }

    public int getCount() { return count; }

    public void setCount(int count) {
        this.count = count;
    }

    public Label getLabel() { return label; }

    public void setLabel(Label label) { this.label = label; }

    public Image getIm() { return image; }

    public void setIm(Image im) { this.image = im; }

    public String getCity() { return City; }

    public void setCity(String city) { City = city; }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) { Country = country; }

    public String getFlag() { return Flag; }

    public void setFlag(String flag) { Flag = flag; }

    //Comparing answer from user input
    public boolean answers(String text){
        for (Questions s : res.returnList()){
            if(text.replaceAll("\\s+","").equalsIgnoreCase(s.getCity().replaceAll("\\s+",""))) {
                return true;
            }
        }
        return false;
    }
    //Correct and Incorrect answer
    public void AnswerCounter(AudioClip clip, AudioClip clip1, String text, Label label1, Label label2,Button button, Label CorrectAnswers) {

        if (answers(text) == true) {
            correct++;
            System.out.println(getCorrect());
            incorrect++;
            clip.play(0.8);
            button.setStyle("-fx-background-color:green");

        } else if (answers(text) == false) {
            incorrect++;
            clip1.play(0.8);
            button.setStyle("-fx-background-color:red");
        }
        label1.setText("Question nr: " + getIncorrect()  + " out of: " + getIndex());
        CorrectAnswers.setText("Number of correct answers: " + getCorrect());
    }
    //Returns string for endGame
    public String returnString(){
        String string1 = "Question nr: " + getIncorrect() + " out of: " + getIndex();
        return string1;
    }
    //Changes picture on EventHandle and makes Strings for object Resources
    public void setPicture(Image image, ImageView iv1){
        count++;
        image = new Image(res.returnList().get(count).getURL());
        iv1.setImage(image);
        Country = res.returnList().get(count).getCountry();
        City = res.returnList().get(count).getCity();
        Flag = res.returnList().get(count).getURL();
    }
    //Setting up for end screen
    public void EndGame(Button restart, VBox box,StackPane pane, Label fail, Label label1, ImageView iv1, TextField text, Button quit, Label CorrectAnswers,Button button1
    )
    {
        if (incorrect == index + 1) {
            box.getChildren().removeAll(fail,label,CorrectAnswers);
            Image end = new Image(Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/Resources/end.jpg").toUri().toString());
            incorrect = incorrect-1;
            label1.setText("Thanks for playing. You had: " + Integer.toString(getCorrect()) + " out of: " + getIncorrect()+ " correct answers");
            pane.getChildren().remove(text);
            iv1.setImage(end);
            text.setDisable(true);
            box.getChildren().remove(button1);
            box.getChildren().addAll(restart,quit);
        }
    }
}
