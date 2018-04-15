package sample;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Resources {
    private ArrayList<Questions> questions;
    //Adding resources to Object "Questions"
    public Resources() {
        questions = new ArrayList<>();
        questions.add(new Questions("Oslo", "Norway", Paths.get("src/resources/no.png").toUri().toString()));
        questions.add(new Questions("Stockholm", "Sweden", Paths.get("src/resources/se.png").toUri().toString()));
        questions.add(new Questions("Berlin", "Germany", Paths.get("src/resources/de.png").toUri().toString()));
        questions.add(new Questions("Athens", "Greece", Paths.get("src/resources/gr.png").toUri().toString()));
        questions.add(new Questions("Baghdad", "Iraq", Paths.get("src/resources/iq.png").toUri().toString()));
        questions.add(new Questions("Tokyo", "Japan", Paths.get("src/resources/jp.png").toUri().toString()));

        questions.add(new Questions("Kabul", "Afghanistan", Paths.get("src/resources/af.png").toUri().toString()));
        questions.add(new Questions("Jerevan", "Armenia", Paths.get("src/resources/am.png").toUri().toString()));

        questions.add(new Questions("Santiago de Chile", "Chile", Paths.get("src/resources/cl.png").toUri().toString()));
        questions.add(new Questions("Guatemala City", "Guatemala", Paths.get("src/resources/gt.png").toUri().toString()));
        questions.add(new Questions("Kishinev", "Moldova", Paths.get("src/resources/md.png").toUri().toString()));
        questions.add(new Questions("Warsaw", "Poland", Paths.get("src/resources/pl.png").toUri().toString()));

        questions.add(new Questions("Asunción", "Paraguay", Paths.get("src/resources/py.png").toUri().toString()));
        questions.add(new Questions("Bern", "Switzerland", Paths.get("src/resources/ch.png").toUri().toString()));
        questions.add(new Questions("Madrid", "Spain", Paths.get("src/resources/es.png").toUri().toString()));
        questions.add(new Questions("Hanoi", "Vietnam", Paths.get("src/resources/vn.png").toUri().toString()));
        questions.add(new Questions("Washington", "USA", Paths.get("src/resources/us.png").toUri().toString()));
        questions.add(new Questions("Taipei", "Taiwan", Paths.get("src/resources/tw.png").toUri().toString()));

        questions.add(new Questions("Ankara", "Turkey", Paths.get("src/resources/tr.png").toUri().toString()));
        questions.add(new Questions("Tunis", "Tunisia", Paths.get("/src/resources/tn.png").toUri().toString()));
        questions.add(new Questions("Bangkok", "Thailand", Paths.get("src/resources/th.png").toUri().toString()));
        questions.add(new Questions("Freetown", "Sierra Leone", Paths.get("src/resources/sl.png").toUri().toString()));
        questions.add(new Questions("Kigali", "Rwanda", Paths.get("src/resources/rw.png").toUri().toString()));
        questions.add(new Questions("Doha", "Qatar", Paths.get("src/resources/qa.png").toUri().toString()));
        questions.add(new Questions("Lisboa", "Portugal", Paths.get("src/resources/pt.png").toUri().toString()));

        questions.add(new Questions("Port Moresby", "Pappa New Guinea", Paths.get("src/resources/pg.png").toUri().toString()));
        questions.add(new Questions("Panama City", "Panama", Paths.get("src/resources/pa.png").toUri().toString()));
        questions.add(new Questions("Managua", "Nicaragua", Paths.get("src/resources/ni.png").toUri().toString()));
        questions.add(new Questions("Maputo", "Mozambique", Paths.get("src/resources/mz.png").toUri().toString()));
        questions.add(new Questions("Male", "Maldives", Paths.get("src/resources/mu.png").toUri().toString()));
        questions.add(new Questions("Vientiane", "Laos", Paths.get("src/resources/la.png").toUri().toString()));
        questions.add(new Questions("Amman", "Jordan", Paths.get("src/resources/jo.png").toUri().toString()));
        Collections.shuffle(questions);
    }
    //returns list with Qurstions
    public ArrayList<Questions> returnList(){
        return questions;
    }
}

