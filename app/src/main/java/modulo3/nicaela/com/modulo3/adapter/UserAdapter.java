package modulo3.nicaela.com.modulo3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import modulo3.nicaela.com.modulo3.R;
import modulo3.nicaela.com.modulo3.model.User;

/**
 * Created by nicaela on 9/7/16.
 */
public class UserAdapter extends ArrayAdapter<User> {
    public UserAdapter(Context context) {
        super(context, R.layout.user_item_layout);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = getItem(position);
        View currentView;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            currentView = inflater.inflate(R.layout.user_item_layout, parent, false);
        }else{
            currentView = convertView;
        }
        TextView usernameTextView = (TextView) currentView.findViewById(R.id.username_text_view);
        TextView emailTextView = (TextView) currentView.findViewById(R.id.email_text_view);

        usernameTextView.setText(user.getUsername());
        emailTextView.setText(user.getEmail());

        return currentView;
    }
}
