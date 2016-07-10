package modulo3.nicaela.com.modulo3.network;

import java.util.List;

import modulo3.nicaela.com.modulo3.model.Post;
import modulo3.nicaela.com.modulo3.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PostService {
    @POST("login")
    Call<User> login(@Body User user);

    @GET("posts")
    Call<List<Post>> getPosts(@Query("user_id") int user_id);

    @GET("users")
    Call<List<User>> getUsers();

    @POST("posts")
    Call<Post> post(@Body Post post, @Query("user_id") int user_id);
}
