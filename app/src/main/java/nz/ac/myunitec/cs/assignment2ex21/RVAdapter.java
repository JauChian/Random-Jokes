package nz.ac.myunitec.cs.assignment2ex21;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVHolder> {
    private List<Joke> jokesData;
    private Context context;

    public RVAdapter(List<Joke> usersData, Context context) {
        this.jokesData = usersData;
        this.context = context;
    }

    @NonNull
    @Override
    public RVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_joke, parent, false);
        return new RVHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolder holder, int position) {
        Joke joke = jokesData.get(position);

        holder.id.setText(String.valueOf(joke.getId()));
        holder.type.setText(joke.getType());
        holder.setup.setText(joke.getSetup());
        holder.punchline.setText(joke.getPunchline());
    }

    @Override
    public int getItemCount() {

        return jokesData.size();
    }
}
