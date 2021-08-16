package com.example.homeworkeight;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FragmentDescription extends Fragment {


    public static String KEY_NOTES = "notes";
    private Notes notes;

    public static FragmentDescription newInstance(Notes notes) {
        FragmentDescription fragmentDescription = new FragmentDescription();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_NOTES,notes);
        fragmentDescription.setArguments(bundle);
        return fragmentDescription;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      if(getArguments() != null);
        this.notes = getArguments().getParcelable(KEY_NOTES);
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description, container,false);
        TextView textView1 = view.findViewById(R.id.textView1);
        textView1.setText(this.notes.getName());

        return view;
    }
}
