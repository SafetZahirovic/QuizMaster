
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
    private AudioClip hundred;
    //Constructor for Logic class
    public Logic(){
        res = new Resources();
        imageView = new ImageView();
        image = new Image(Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/no.png").toUri().toString());
        label = new Label("0");
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
    
    public AudioClip getHundred() { return hundred; }

    public void setHundred(AudioClip hundred) { hundred = hundred; }
    
    //Setting up for end screen
    public void EndGame(AudioClip hundred,Label RightAnswer,int incorrect1, Button restart, VBox box,StackPane pane, Label fail, Label label1, ImageView iv1, TextField text, Button quit, Label CorrectAnswers,Button button1
    )
    {
        if (incorrect1 == index + 1) {
            if((correct * 100) / index <= 10){
                AudioClip ten = new AudioClip(Paths.get("resources/fakeApplause.wav").toUri().toString());
                ten.play();
            }else
            if((correct * 100) / index <= 40){
                AudioClip forty = new AudioClip(Paths.get("resources/smallApplause.wav").toUri().toString());
                forty.play();
            }else
            if((correct * 100) / index <= 80){
                AudioClip eigthy = new AudioClip(Paths.get("resources/mediumApplause.wav").toUri().toString());
                eigthy.play();
            }
            if(getCorrect() == index ){
                hundred.play();
            }

            box.getChildren().removeAll(fail,label,CorrectAnswers);
            Image end = new Image("/resources/end.jpg");
            incorrect = incorrect-1;
            label1.setText("Thanks for playing. You had: " + Integer.toString(getCorrect()) + " out of: " + getIncorrect()+ " correct answers");
            pane.getChildren().remove(text);
            iv1.setImage(end);
            iv1.setFitWidth(300);
            text.setDisable(true);
            button1.setDisable(true);
            box.getChildren().remove(RightAnswer);
            box.getChildren().remove(button1);
            box.getChildren().addAll(restart,quit);
        }
    }

}
