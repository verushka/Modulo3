package modulo3.nicaela.com.modulo3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import modulo3.nicaela.com.modulo3.model.User;
import modulo3.nicaela.com.modulo3.network.LoginAsyncTask;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.login_username);
        password = (EditText) findViewById(R.id.login_password);

    }

    public void login(View view) {

        Toast.makeText(LoginActivity.this, username.getText().toString(), Toast.LENGTH_SHORT).show();
        String name = username.getText().toString();
        String pass = password.getText().toString();
        User user = new User();
        user.setUsername(name);
        user.setPassword(pass);

        LoginAsyncTask task = new LoginAsyncTask(this);
        task.execute(user);

    }
}
