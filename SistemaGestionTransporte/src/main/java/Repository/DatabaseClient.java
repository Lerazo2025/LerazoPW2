package Repository;

import com.google.gson.GsonBuilder;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.HTTP;

import java.util.concurrent.TimeUnit;

public class DatabaseClient {

    private Retrofit retrofit;

    //intercepta error e imprime errores
    private HttpLoggingInterceptor interceptor;
    public DatabaseClient(String url,Long timeout) {
        interceptor= new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client=new OkHttpClient().newBuilder()
                .addInterceptor(interceptor)
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .readTimeout(timeout, TimeUnit.SECONDS)
                .writeTimeout(timeout,TimeUnit.SECONDS)
                .build();
        retrofit=new Retrofit.Builder()
                .client(client)
                .baseUrl("https://apex.oracle.com/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create()))
                .build();
    }
    public DatabaseRepository getInstance() {
        return retrofit.create(DatabaseRepository.class);
    }
}
