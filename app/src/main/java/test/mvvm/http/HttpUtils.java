package test.mvvm.http;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import test.mvvm.bean.NewsBean;
import test.mvvm.constants.URLConstant;
import test.mvvm.retrofitInterface.RetrofitInterface;

/**
 * Company By SQ
 * Created Date By 2018/11/3 0003
 * Created Time By 下午 12:51
 * Provide Content By MVVM
 * Created by HeBing
 * Provide Content By test.mvvm.http
 */
public class HttpUtils {

    private static final int DEFAULT_TIMEOUT = 8;//链接超时时间

    private static final OkHttpClient client = new OkHttpClient.Builder().
            connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).
            readTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS).
            writeTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS).build();

    private static HttpUtils httpUtils;
    private static Retrofit retrofit;
    private static RetrofitInterface retrofitInterface;

    private synchronized static RetrofitInterface getRetrofit(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URLConstant.URL_BASE)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            retrofitInterface = retrofit.create(RetrofitInterface.class);
        }
        return  retrofitInterface;
    }

    public static Observable<NewsBean> getNewsData(){
        return getRetrofit().getNewsData();
    }
}
