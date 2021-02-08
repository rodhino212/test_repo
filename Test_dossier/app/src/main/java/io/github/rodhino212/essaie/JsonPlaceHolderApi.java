package io.github.rodhino212.essaie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @GET("users")
    Call<List<User>> getUsers();

    @GET("op")
    Call<List<Operation>> getOperations();

    @FormUrlEncoded
    @POST("addOpe")
    Call<Operation> createOperation(
            @Field("op_description") String op_description,
            @Field("op_date") String op_date,
            @Field("op_montant") Float op_montant,
            @Field("pointee") String pointee,
            @Field("frequence") String frequence,
            @Field("type") String type,
            @Field("categorie") String categorie,
            @Field("user_id_op") int user_id_op);

    @FormUrlEncoded
    @POST("addUser")
    Call<User> createUser(
            @Field("user_name") String user_name,
            @Field("user_prenom") String user_pren);
}