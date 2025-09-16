package nz.ac.myunitec.cs.assignment2ex21;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private JokeControllerRESTAPI api;
    TextView btnLoad,btnDisplay;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnLoad = findViewById(R.id.load);
        btnDisplay = findViewById(R.id.display);
        recyclerView = findViewById(R.id.r_view);

        recyclerView = findViewById(R.id.r_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    api = new JokeControllerRESTAPI();
                    api.start();
                    Toast.makeText(MainActivity.this, "Loading Jokes...", Toast.LENGTH_SHORT).show();
                }catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error loading jokes", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if (api != null && api.jokesList != null && !api.jokesList.isEmpty()) {
                        RVAdapter adapter = new RVAdapter(api.jokesList, MainActivity.this);
                        recyclerView.setAdapter(adapter);
                    } else {
                        Toast.makeText(MainActivity.this, "No jokes loaded yet", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error displaying jokes", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}