package nz.ac.myunitec.cs.assignment2ex21;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JokesRESTAPI {
    @GET("random_ten")
    Call<List<Joke>> getJokes();
}
