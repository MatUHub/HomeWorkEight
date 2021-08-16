package com.example.homeworkeight;

import android.os.Parcel;
import android.os.Parcelable;

public class Notes implements Parcelable {
    private String name;
    private String description;

    public Notes(String name, String description)  {
        this.name = name;
        this.description = description;
    }

    protected Notes(Parcel in) {
        name = in.readString();
        description = in.readString();
    }

    public static final Creator<Notes> CREATOR = new Creator<Notes>() {
        @Override
        public Notes createFromParcel(Parcel in) {
            return new Notes(in);
        }

        @Override
        public Notes[] newArray(int size) {
            return new Notes[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
    }
}
