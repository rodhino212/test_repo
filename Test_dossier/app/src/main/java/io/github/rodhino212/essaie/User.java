package io.github.rodhino212.essaie;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {
    private int user_id;

    @SerializedName("user_nom")
    private String user_name;

    @SerializedName("user_prenom")
    private String user_pren;



    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pren() {
        return user_pren;
    }

    public void setUser_pren(String user_pren) {
        this.user_pren = user_pren;
    }

    /*public User() {
    }

    public User(String user_name, String user_pren) {
        this.user_name = user_name;
        this.user_pren = user_pren;
    }

    public User(int user_id, String user_name, String user_pren) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_pren = user_pren;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_pren='" + user_pren + '\'' +
                '}';
    }*/
}
