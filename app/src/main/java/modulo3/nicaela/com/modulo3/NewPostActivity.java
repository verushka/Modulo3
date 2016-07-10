package modulo3.nicaela.com.modulo3;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import modulo3.nicaela.com.modulo3.model.Post;
import modulo3.nicaela.com.modulo3.network.NewPostAsync;

public class NewPostActivity extends AppCompatActivity {

    private EditText titlePost;
    private  EditText contentPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        titlePost = (EditText) findViewById(R.id.title_post);
        contentPost = (EditText) findViewById(R.id.content_post);
    }

    public void savePost(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.app_name) , Context.MODE_PRIVATE);
        int user_id = sharedPreferences.getInt("user_id", -1);

        Post post = new Post();
        post.setTitle(titlePost.getText().toString());
        post.setContent(contentPost.getText().toString());

        NewPostAsync newPostAsync = new NewPostAsync(this);
        newPostAsync.execute(post, user_id);

        finish();
    }
}
