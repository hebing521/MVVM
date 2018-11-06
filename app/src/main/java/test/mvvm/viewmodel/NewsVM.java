package test.mvvm.viewmodel;

import java.util.List;

import test.mvvm.adapter.NewsAdapter;
import test.mvvm.base.BaseLoadListener;
import test.mvvm.bean.SimpleNewsBean;
import test.mvvm.constants.MainConstant;
import test.mvvm.model.INewsModel;
import test.mvvm.model.NewModelImpl;
import test.mvvm.view.INewsView;

/**
 * Company By SQ
 * Created Date By 2018/11/3 0003
 * Created Time By 上午 9:51
 * Provide Content By MVVM
 * Created by HeBing
 * Provide Content By test.mvvm.viewmodel
 */
public class NewsVM implements BaseLoadListener<SimpleNewsBean> {

    private static final String TAG = "NewsVM";
    private INewsModel mNewsModel;
    private INewsView mNewsView;
    private NewsAdapter mAdapter;
    private int currPage = 1;//当前页数
    private int loadType ;//加载数据的类型

    public NewsVM(INewsView mNewsView, NewsAdapter mAdapter) {
        this.mNewsView = mNewsView;
        this.mAdapter = mAdapter;
        mNewsModel = new NewModelImpl();
        getNewsData();
    }

    /**
     * 第一次获取数据
     */
    private void getNewsData(){
        loadType = MainConstant.LoadData.FIRST_LOAD;
        mNewsModel.loadNewsData(currPage,this);
    }

    /**
     * 获取下拉刷新数据
     */
    public void loadRefreshData(){
        loadType = MainConstant.LoadData.REFRESH;
        currPage = 1;
        mNewsModel.loadNewsData(currPage,this);
    }

    public void loadMoreData(){
        loadType = MainConstant.LoadData.LOAD_MORE;
        currPage++;
        mNewsModel.loadNewsData(currPage,this);

    }

    @Override
    public void loadSuccess(List<SimpleNewsBean> list) {
        if(currPage>1){
            //上拉加载的数据
            mAdapter.loadMore(list);
        }else{
            //第一次加载或者下拉刷新的数据
            mAdapter.refreshData(list);
        }
    }

    @Override
    public void loadFailure(String message) {
        if(currPage>1){
            currPage--;
        }
        mNewsView.loadFailure(message);
    }

    @Override
    public void loadStart() {

        mNewsView.loadStart(loadType);
    }

    @Override
    public void loadComplete() {

        mNewsView.loadComplete();
    }
}
