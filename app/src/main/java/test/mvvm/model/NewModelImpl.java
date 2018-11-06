package test.mvvm.model;

import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import test.mvvm.base.BaseLoadListener;
import test.mvvm.bean.NewsBean;
import test.mvvm.bean.SimpleNewsBean;
import test.mvvm.http.HttpUtils;

/**
 * Company By SQ
 * Created Date By 2018/11/3 0003
 * Created Time By 下午 12:49
 * Provide Content By MVVM
 * Created by HeBing
 * Provide Content By test.mvvm.model
 */
public class NewModelImpl implements INewsModel {

    private static final String TAG = "NewModelImpl";
    List<SimpleNewsBean> simpleNewsBeanList = new ArrayList<SimpleNewsBean>();

    @Override
    public void loadNewsData(final int page, final BaseLoadListener<SimpleNewsBean> loadListener) {
        HttpUtils.getNewsData()
                .flatMap(new Function<NewsBean, ObservableSource<NewsBean.TopStoriesBean>>() {
                    @Override
                    public ObservableSource<NewsBean.TopStoriesBean> apply(NewsBean newsBean) throws Exception {
                        return Observable.fromIterable(newsBean.getTop_stories());
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<NewsBean.TopStoriesBean>() {
                    @Override
                    public void onNext(NewsBean.TopStoriesBean othersBean) {
                        Log.i(TAG, "onNext:");


                        String thumbnail = othersBean.getImage();
                        String name = othersBean.getTitle();
                        String description = othersBean.getGa_prefix();
                        Log.i(TAG, "thumbnail:---->" + thumbnail);
                        Log.i(TAG, "name:---->" + name);
                        Log.i(TAG, "description:---->" + description);

                        //构造Adapter所需的数据源
                        SimpleNewsBean simpleNewsBean = new SimpleNewsBean();
                        simpleNewsBean.thumbnail.set(thumbnail);
                        simpleNewsBean.name.set(name);
                        simpleNewsBean.description.set(description);
                        simpleNewsBeanList.add(simpleNewsBean);

//                                if (page > 1) {
                        //这个接口暂时没有分页的数据，这里为了模拟分页，通过取第1条数据作为分页的数据


                    }

                    @Override
                    protected void onStart() {
                        super.onStart();
                        loadListener.loadStart();
                    }

                    @Override
                    public void onError(Throwable e) {
                        loadListener.loadFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete:");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                loadListener.loadSuccess(simpleNewsBeanList);
                                loadListener.loadComplete();
                            }
                        }, 2000);
                    }
                });
    }
}
