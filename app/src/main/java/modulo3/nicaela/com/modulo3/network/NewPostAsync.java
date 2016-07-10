package modulo3.nicaela.com.modulo3.network;

import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;

import modulo3.nicaela.com.modulo3.NewPostActivity;
import modulo3.nicaela.com.modulo3.model.Post;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nicaela on 9/7/16.
 */
public class NewPostAsync extends AsyncTask<Object, Void, Post>{

    private NewPostActivity postActivity;
    public NewPostAsync(NewPostActivity activity){
        postActivity = activity;
    }

    @Override
    protected Post doInBackground(Object... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dip-androiducbv2.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostService service = retrofit.create(PostService.class);
        Call<Post> call = service.post((Post) params[0], (Integer) params[1]);
        try {
            Response<Post> response = call.execute();
            Post post = response.body();
            return post;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Post post) {
        if (post == null){
            Toast.makeText(postActivity, "The post was not created", Toast.LENGTH_LONG).show();
        }else {
            System.out.println("The created post is " + postActivity.getTitle());
            Toast.makeText(postActivity, "The post was created correctly.", Toast.LENGTH_LONG).show();
        }
    }
}
