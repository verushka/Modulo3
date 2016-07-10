package modulo3.nicaela.com.modulo3.network;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;

import modulo3.nicaela.com.modulo3.LoginActivity;
import modulo3.nicaela.com.modulo3.PostActivity;
import modulo3.nicaela.com.modulo3.R;
import modulo3.nicaela.com.modulo3.model.User;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginAsyncTask extends AsyncTask<User, Void, User> {
    private LoginActivity loginActivity;

    public LoginAsyncTask(LoginActivity activity) {
        loginActivity = activity;
    }

    @Override
    protected User doInBackground(User... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dip-androiducbv2.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostService service = retrofit.create(PostService.class);
        Call<User> call = service.login(params[0]);
        try {
            Response<User> response = call.execute();
            User user = response.body();
            return user;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(User user) {
        if (user == null) {
            Toast.makeText(loginActivity, "Username and Password invalid. Try again please.", Toast.LENGTH_LONG).show();
        } else {
            SharedPreferences sharedPreferences = loginActivity.getSharedPreferences(loginActivity.getString(R.string.app_name) , Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("user_id", user.getId());
            editor.commit();

            Intent intent = new Intent(loginActivity, PostActivity.class);
            loginActivity.startActivity(intent);
        }
    }


}