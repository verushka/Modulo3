package modulo3.nicaela.com.modulo3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import modulo3.nicaela.com.modulo3.adapter.PostAdapter;
import modulo3.nicaela.com.modulo3.network.PostAsyncTask;

public class PostFragmnet extends Fragment {

    private ListView listView;
    private PostAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View currentView = inflater.inflate(R.layout.fragment_post_fragmnet, container, false);

        listView = (ListView) currentView.findViewById(R.id.post_list_view_fragment);
        adapter = new PostAdapter(getActivity());
        listView.setAdapter(adapter);

        PostAsyncTask postAsyncTask = new PostAsyncTask(this);
        postAsyncTask.execute();

        return currentView;

    }

    public PostAdapter getAdapter() {
        return adapter;
    }
}
