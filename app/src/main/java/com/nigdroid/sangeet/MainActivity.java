package com.nigdroid.sangeet;


import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        String []arr={
                "SAMJHO  NA  NASAMAJH",
                "Chahun  Main Ya  Naa ",

                "GULI MATA SONG ",
                "Sun_Saathiya SONG",
                "Samayama Song  Hi_Nanna__",
                "Hasi Imran",
                "Illahi_-_Yeh_Jawaani_Hai_Deewani",
                "Jhol___",
                "Jhoome Jo Pathaan ",
                "Jo_Meri_Manzilon_Ko_Jati_Hai_",
                "KAUN_TUJHE_",
                "LO_MAAN_LIYA_HUM_Ne",
                "Kasturi___Amar_Prem_Ki_Prem_Kahani",
                "Na_Roja_Nuvve_-_Video_Song___Kushi_",
                "Pal_Lyric_Video_-_Jalebi",
                "Paro__",
                "Sanam_Teri_Kasam_movie_actress_and_actor_",
                "Tofa_Chandini_re___",
                "ଚିରିଙ୍ଗ_ଚିରିଙ୍ଗ___Chiring_Chiring_",
                "Megha_ru_tu_jharilu_Na..",
                "ଲାଲ୍_ଟହ_ଟହ___Lal_Taha_Taha__",
                "Akhiyaan_Gulaab__",
                "Dulhan_Banami__Sambalpuri_",
                "Nigam_tune"





        };

//        toolbar=findViewById(R.id.toolbar);
        listView=findViewById(R.id.listView);

        Nigam ad=new Nigam(this,R.layout.my_nigam,arr);

        listView.setAdapter(ad);

    }


}