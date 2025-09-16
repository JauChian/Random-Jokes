package nz.ac.myunitec.cs.assignment2ex21;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RVHolder extends RecyclerView.ViewHolder {
    TextView id,type,setup,punchline;


    public RVHolder(@NonNull View itemView) {
        super(itemView);

        id = itemView.findViewById(R.id.id);
        type = itemView.findViewById(R.id.type);
        setup = itemView.findViewById(R.id.setup);
        punchline = itemView.findViewById(R.id.punchline);

    }
}
