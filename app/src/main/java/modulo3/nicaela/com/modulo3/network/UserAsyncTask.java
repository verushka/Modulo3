package modulo3.nicaela.com.modulo3.network;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modulo3.nicaela.com.modulo3.UserFragment;
import modulo3.nicaela.com.modulo3.model.Post;
import modulo3.nicaela.com.modulo3.model.User;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nicaela on 9/7/16.
 */
public class UserAsyncTask extends AsyncTask<Void, Void, List<User>>{
    private UserFragment fragment;

    public UserAsyncTask(UserFragment userFragment) {
        this.fragment = userFragment;
    }

    @Override
    protected List<User> doInBackground(Void... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dip-androiducbv2.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostService service = retrofit.create(PostService.class);
        Call<List<User>> call = service.getUsers();
        try {
            Response<List<User>> response = call.execute();
            return response.body();
        }catch (IOException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    protected void onPostExecute(List<User> users) {
        fragment.getAdapter().clear();
        fragment.getAdapter().addAll(users);
    }
}

