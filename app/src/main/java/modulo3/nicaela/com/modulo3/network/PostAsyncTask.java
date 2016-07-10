package modulo3.nicaela.com.modulo3.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modulo3.nicaela.com.modulo3.PostFragmnet;
import modulo3.nicaela.com.modulo3.R;
import modulo3.nicaela.com.modulo3.model.Post;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostAsyncTask extends AsyncTask<Void, Void, List<Post>> {
    private PostFragmnet fragment;
    private int user_id;

    public PostAsyncTask(PostFragmnet postFragmnet) {
        fragment = postFragmnet;

        SharedPreferences sharedPreferences = fragment.getActivity().getSharedPreferences(fragment.getActivity().getString(R.string.app_name) , Context.MODE_PRIVATE);
        user_id = sharedPreferences.getInt("user_id", -1);
    }

    @Override
    protected List<Post> doInBackground(Void... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dip-androiducbv2.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostService service = retrofit.create(PostService.class);
        Call<List<Post>> call = service.getPosts(user_id);

        try {
            Response<List<Post>> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    protected void onPostExecute(List<Post> posts) {
        fragment.getAdapter().clear();
        fragment.getAdapter().addAll(posts);
    }
}
