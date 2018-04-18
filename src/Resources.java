 

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Resources {
    private ArrayList<Questions> questions;
    private ArrayList<String>music;
    private ArrayList<String>introMusic;
    //Adding resources to Object "Questions"
    public Resources() {
        //Adding questions
        questions = new ArrayList<>();
        questions.add(new Questions("Oslo", "Norway", "/resources/no.png"));
        questions.add(new Questions("Stockholm", "Sweden","/resources/se.png"));
        questions.add(new Questions("Berlin", "Germany", "/resources/de.png"));
        questions.add(new Questions("Athens", "Greece", "/resources/gr.png"));
        questions.add(new Questions("Baghdad", "Iraq", "/resources/iq.png"));
        questions.add(new Questions("Tokyo", "Japan", "/resources/jp.png"));
        questions.add(new Questions("Kabul", "Afghanistan", "/resources/af.png"));
        questions.add(new Questions("Jerevan", "Armenia", "/resources/am.png"));
        questions.add(new Questions("Santiago de Chile", "Chile", "/resources/cl.png"));
        questions.add(new Questions("Guatemala City", "Guatemala", "/resources/gt.png"));
        questions.add(new Questions("Kishinev", "Moldova", "/resources/md.png"));
        questions.add(new Questions("Warsaw", "Poland", "/resources/pl.png"));
        questions.add(new Questions("Asunción", "Paraguay", "/resources/py.png"));
        questions.add(new Questions("Bern", "Switzerland", "/resources/ch.png"));
        questions.add(new Questions("Madrid", "Spain", "/resources/es.png"));
        questions.add(new Questions("Hanoi", "Vietnam", "/resources/vn.png"));
        questions.add(new Questions("Washington", "USA", "/resources/us.png"));
        questions.add(new Questions("Taipei", "Taiwan", "/resources/tw.png"));
        questions.add(new Questions("Ankara", "Turkey", "/resources/tr.png"));
        questions.add(new Questions("Tunis", "Tunisia", "/resources/tn.png"));
        questions.add(new Questions("Bangkok", "Thailand", "/resources/th.png"));
        questions.add(new Questions("Freetown", "Sierra Leone","/resources/sl.png"));
        questions.add(new Questions("Kigali", "Rwanda", "/resources/rw.png"));
        questions.add(new Questions("Doha", "Qatar","/resources/qa.png"));
        questions.add(new Questions("Lisboa", "Portugal", "/resources/pt.png"));
        questions.add(new Questions("Port Moresby", "Pappa New Guinea", "/resources/pg.png"));
        questions.add(new Questions("Panama City", "Panama", "/resources/pa.png"));
        questions.add(new Questions("Managua", "Nicaragua", "/resources/ni.png"));
        questions.add(new Questions("Maputo", "Mozambique", "/resources/mz.png"));
        questions.add(new Questions("Male", "Maldives", "/resources/mu.png"));
        questions.add(new Questions("Vientiane", "Laos", "/resources/la.png"));
        questions.add(new Questions("Amman", "Jordan", "/resources/jo.png"));
        Collections.shuffle(questions);
        //Adding Main music
        music = new ArrayList<>();
        music.add(Paths.get("resources/main.mp3").toUri().toString());
        music.add(Paths.get("resources/Old_Bossa.mp3").toUri().toString());
        music.add(Paths.get("resources/Soul_and_Mind.mp3").toUri().toString());
        music.add(Paths.get("resources/Where.mp3").toUri().toString());
        music.add(Paths.get("resources/Fortaleza.mp3").toUri().toString());
        Collections.shuffle(music);
        //Adding Intro music
        introMusic = new ArrayList<>();
        introMusic.add(Paths.get("resources/Ipanema_Daydream.mp3").toUri().toString());
        introMusic.add(Paths.get("resources/bensound-thejazzpiano.mp3").toUri().toString());
        introMusic.add(Paths.get("resources/bensound-jazzyfrenchy.mp3").toUri().toString());
        introMusic.add(Paths.get("resources/intro.mp3").toUri().toString());
        Collections.shuffle(introMusic);
    }
    //returns list with Questions
    public ArrayList<Questions> returnList(){
        return questions;
    }
    //returns list with music
    public ArrayList<String> returnMusic(){
        return music;
    }
    //returns list with intro music
    public ArrayList<String> returnIntroMusic(){
        return introMusic;
    }
}

