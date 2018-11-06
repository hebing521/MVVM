package test.mvvm.retrofitInterface;



import io.reactivex.Observable;
import retrofit2.http.GET;
import test.mvvm.bean.NewsBean;
import test.mvvm.constants.URLConstant;

/**
 * Company By SQ
 * Created Date By 2018/11/3 0003
 * Created Time By 下午 12:55
 * Provide Content By MVVM
 * Created by HeBing
 * Provide Content By test.mvvm.retrofitInterface
 */
public interface RetrofitInterface {

    @GET(URLConstant.URL_PATH)
    Observable<NewsBean> getNewsData();
}
