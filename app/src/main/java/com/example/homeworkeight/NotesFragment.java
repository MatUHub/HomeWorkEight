package com.example.homeworkeight;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class NotesFragment extends Fragment {

    com.example.homeworkeight.Notes currentNotes;
    boolean isLandScape;

    public static NotesFragment newInstance() {
        return new NotesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);
        LinearLayout linearLayout = (LinearLayout) view;
        String[] notes = getResources().getStringArray(R.array.notes);
        for (int i = 0; i < notes.length; i++) {
            String name = notes[i];
            TextView textView = new TextView(getContext());
            textView.setText(name);
            textView.setTextSize(40);
            linearLayout.addView(textView);
            int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    currentNotes = new com.example.homeworkeight.Notes(getResources().getStringArray(R.array.description)[finalI], "i");
                    isLandScape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
                    showDescripton();
                }
            });
        }
        return view;
    }

    private void showDescripton() {
        if (isLandScape) {
            showDescriptionPort();
        } else {
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.notes_container, com.example.homeworkeight.FragmentDescription.newInstance(currentNotes))
                    .addToBackStack("")
                    .commit();
        }
    }

    private void showDescriptionPort() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.description_container, com.example.homeworkeight.FragmentDescription.newInstance(currentNotes))
                .commit();
    }
}
