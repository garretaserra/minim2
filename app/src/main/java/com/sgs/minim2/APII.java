package com.sgs.minim2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APII {

    @GET("/books")
    Call<List<Book>> getBooks();

    @POST("/books")
    Call<String> addBook(@Body Book book);

    @GET("/books/{id}")
    Call<BookDetail> getBook(@Path("id") String id);

    @PUT("/books/{id}")
    Call<String> modifyBook(@Path("id") String id,
                            @Field("Book") Book book);

    @DELETE("/books/{id}")
    Call<String> deleteBook(@Path("id") String id);

}
