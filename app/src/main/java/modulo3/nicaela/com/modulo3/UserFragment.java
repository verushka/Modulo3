package modulo3.nicaela.com.modulo3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import modulo3.nicaela.com.modulo3.adapter.UserAdapter;
import modulo3.nicaela.com.modulo3.network.UserAsyncTask;


public class UserFragment extends Fragment {

    private ListView listView;
    private UserAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user, container, false);

        listView = (ListView) view.findViewById(R.id.users_list_view);
        adapter = new UserAdapter(getActivity());
        listView.setAdapter(adapter);

        UserAsyncTask task = new UserAsyncTask(this);
        task.execute();

        return view;
    }

    public UserAdapter getAdapter(){
        return  adapter;
    }

}
