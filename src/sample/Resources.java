package sample;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Resources {
    private ArrayList<Questions> questions;
    //Adding resources to Object "Questions"
    public Resources() {
        questions = new ArrayList<>();
        questions.add(new Questions("Oslo", "Norway", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/no.png").toUri().toString()));
        questions.add(new Questions("Stockholm", "Sweden", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/se.png").toUri().toString()));
        questions.add(new Questions("Berlin", "Germany", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/de.png").toUri().toString()));
        questions.add(new Questions("Athens", "Greece", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/gr.png").toUri().toString()));
        questions.add(new Questions("Baghdad", "Iraq", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/iq.png").toUri().toString()));
        questions.add(new Questions("Tokyo", "Japan", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/jp.png").toUri().toString()));

        questions.add(new Questions("Kabul", "Afghanistan", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/af.png").toUri().toString()));
        questions.add(new Questions("Jerevan", "Armenia", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/am.png").toUri().toString()));

        questions.add(new Questions("Santiago de Chile", "Chile", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/cl.png").toUri().toString()));
        questions.add(new Questions("Guatemala City", "Guatemala", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/gt.png").toUri().toString()));
        questions.add(new Questions("Kishinev", "Moldova", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/md.png").toUri().toString()));
        questions.add(new Questions("Warsaw", "Poland", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/pl.png").toUri().toString()));

        questions.add(new Questions("Asunción", "Paraguay", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/py.png").toUri().toString()));
        questions.add(new Questions("Bern", "Switzerland", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/ch.png").toUri().toString()));
        questions.add(new Questions("Madrid", "Spain", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/es.png").toUri().toString()));
        questions.add(new Questions("Hanoi", "Vietnam", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/vn.png").toUri().toString()));
        questions.add(new Questions("Washington", "USA", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/us.png").toUri().toString()));
        questions.add(new Questions("Taipei", "Taiwan", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/tw.png").toUri().toString()));

        questions.add(new Questions("Ankara", "Turkey", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/tr.png").toUri().toString()));
        questions.add(new Questions("Tunis", "Tunisia", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/tn.png").toUri().toString()));
        questions.add(new Questions("Bangkok", "Thailand", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/th.png").toUri().toString()));
        questions.add(new Questions("Freetown", "Sierra Leone", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/sl.png").toUri().toString()));
        questions.add(new Questions("Kigali", "Rwanda", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/rw.png").toUri().toString()));
        questions.add(new Questions("Doha", "Qatar", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/qa.png").toUri().toString()));
        questions.add(new Questions("Lisboa", "Portugal", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/pt.png").toUri().toString()));

        questions.add(new Questions("Port Moresby", "Pappa New Guinea", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/pg.png").toUri().toString()));
        questions.add(new Questions("Panama City", "Panama", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/pa.png").toUri().toString()));
        questions.add(new Questions("Managua", "Nicaragua", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/ni.png").toUri().toString()));
        questions.add(new Questions("Maputo", "Mozambique", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/mz.png").toUri().toString()));
        questions.add(new Questions("Male", "Maldives", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/mu.png").toUri().toString()));
        questions.add(new Questions("Vientiane", "Laos", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/la.png").toUri().toString()));
        questions.add(new Questions("Amman", "Jordan", Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled12/src/resources/jo.png").toUri().toString()));
        Collections.shuffle(questions);
    }
    //returns list with Qurstions
    public ArrayList<Questions> returnList(){
        return questions;
    }
}

