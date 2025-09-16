package nz.ac.myunitec.cs.assignment2ex21;

import android.util.Log;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JokeControllerRESTAPI implements Callback<List<Joke>> {

    private final String BASE_URL = "https://official-joke-api.appspot.com/";
    public List<Joke> jokesList;

    public void start() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JokesRESTAPI jokesRESTAPI = retrofit.create(JokesRESTAPI.class);
        Call<List<Joke>> call = jokesRESTAPI.getJokes();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Joke>> call, Response<List<Joke>> response) {
        try{
            if (response.isSuccessful()) {
                jokesList = response.body();  // 獲取數據並保存到實例變量
                if (jokesList != null && !jokesList.isEmpty()) {
                    Log.d("JOKE_INFO", "Jokes retrieved successfully, count: " + jokesList.size());
                } else {
                    Log.d("JOKE_INFO", "No jokes found.");
                }
            } else {
                Log.d("JOKE_INFO", "Response not successful. Status code: " + response.code() + " Message: " + response.message());
            }
        }catch (Exception e) {
            Log.e("JOKE_INFO", "Exception in onResponse: " + e.getMessage(), e);
        }
    }

    @Override
    public void onFailure(Call<List<Joke>> call, Throwable t) {
        t.printStackTrace();
        Log.d("JOKE_INFO", "Error getting Jokes: " + t.getMessage());
    }
}
