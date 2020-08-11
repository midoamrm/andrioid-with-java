package com.example.movieshow;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import model.Move;
import contorel.Movieadpter;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    private List<Move> listmove=new ArrayList<>();
    private RecyclerView recyclerView;
    private Movieadpter movieadpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rw);
        movieadpter=new Movieadpter(this,listmove);
           RecyclerView.LayoutManager  layoutManager=new LinearLayoutManager(getApplicationContext());
           recyclerView.setLayoutManager(layoutManager);
           recyclerView.setItemAnimator(new DefaultItemAnimator());

           recyclerView.setAdapter(movieadpter);
        movedata();






    }

    private void movedata() {

        Move move1=new Move("underground 6","actiom and comdey","2019",R.drawable.a8,"Peak Bay. The story is, frankly, difficult to parse, but focuses on six specially skilled people tasked with taking down a dictator in the Middle East. ... Instead, 6 Underground is defined by its 15-minute chase scene, an exuberant number of explosions, self-satirizing quips, and parkour","https://lack.egybest.org/movie/6-underground-2019/?ref=actor");
        listmove.add(move1); Move move2=new Move("It","horror","2017",R.drawable.a5,"The film tells the story of seven children in Derry, Maine, who are terrorized by the eponymous being, only to face their own personal demons in the process. The film is also known as It: Part 1 – The Losers' Club. The film is directed by Andy Muschietti and written by Chase Palmer, Cary Fukunaga and Gary Dauberman ","https://yale.egybest.network/movie/it-2017/?ref=search-p1");
        listmove.add(move2); Move move3=new Move("Code 8","Action, Crime, Drama ","2019",(R.drawable.a1),"Code 8 is a 2019 Canadian science fiction action superhero film written and directed by Jeff Chan, about a man with superpowers who works with a group of criminals to raise money to help his sick mother. The film is a feature-length version of the 2016 short film of the same name. "," https://yale.egybest.network/movie/code-8-2019/?ref=search-p1");
        listmove.add(move3); Move move4=new Move("happydeath day 2 ","Comedy, Horror, Mystery ","2019",(R.drawable.a3),"Summaries. Tree Gelbman discovers that dying over and over was surprisingly easier  than the dangers that lie ahead. Having survived the farcical but utterly life-threatening events in Happy Death Day (2017), the feisty sorority sister, Tree Gelbman, finds herself in the same college dorm, thankful to be alive "," https://yale.egybest.network/movie/happy-death-day-2u-2019/");
        listmove.add(move4); Move move5=new Move("Avengers Endgame.","Action, Adventure, Drama ","2019",(R.drawable.a4),"Avengers: Endgame is a 2019 American superhero film based on the Marvel Comics superhero team the Avengers, produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures. ... The film serves as a conclusion to the story of the MCU up to that point, ending the story arcs for several main characters ","https://yale.egybest.network/movie/avengers-endgame-2019/ ");
        listmove.add(move5); Move move6=new Move("Spiderman Far From Home"," Action, Adventure","2019",(R.drawable.a7),"In Spider-Man: Far From Home, Parker is recruited by Nick Fury and Mysterio to face the Elementals while he is on a school trip to Europe. Discussions for a sequel to Spider-Man: Homecoming began by October 2016, and the project was confirmed later that year ","https://yale.egybest.network/movie/spider-man-far-from-home-2019/ ");
        listmove.add(move6); Move move7=new Move("Joker","Drama","2019",(R.drawable.a6)," joker is a 2019 American psychological thriller film directed and produced by Todd Phillips, who co-wrote the screenplay with Scott Silver.","https://yale.egybest.network/movie/joker-2019/ ");
        listmove.add(move7); Move move8=new Move(" badboys"," Action, Comedy, Crime |","1995",(R.drawable.a2),"Summaries. Two hip detectives protect a witness to a murder while investigating a case of stolen heroin from the evidence storage room from their police precinct. Marcus Burnett is a hen-pecked family man. ... 100 million dollars in heroin, from the biggest drug bust of their careers, is stolen from police headquarters ","https://yale.egybest.network/movie/bad-boys-for-life-2020/ ");
        listmove.add(move8);
        movieadpter.notifyDataSetChanged();




    }
}