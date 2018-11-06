package test.mvvm.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import test.mvvm.R;
import test.mvvm.adapter.NewsAdapter;
import test.mvvm.databinding.ActivityIndexBinding;
import test.mvvm.helper.DialogHelper;
import test.mvvm.utils.ToastUtils;
import test.mvvm.viewmodel.NewsVM;

import static test.mvvm.constants.MainConstant.LoadData.FIRST_LOAD;

public class MainActivity extends AppCompatActivity implements INewsView, XRecyclerView.LoadingListener {


    private ActivityIndexBinding binding;
    private Context mContext;
    private NewsAdapter newsAdapter;
    private NewsVM newsVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_index);
        mContext = this;
        initRecyclerView();
        newsVM = new NewsVM(this, newsAdapter);
    }

    /**
     * 初始化Recycleview
     */
    private void initRecyclerView() {
        binding.newsRv.setRefreshProgressStyle(ProgressStyle.BallClipRotate);
        binding.newsRv.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate);
        binding.newsRv.setArrowImageView(R.drawable.pull_down_arrow);
        binding.newsRv.setLoadingListener(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.newsRv.setLayoutManager(linearLayoutManager);
        newsAdapter = new NewsAdapter(this);
        binding.newsRv.setAdapter(newsAdapter);

    }

    @Override
    public void onRefresh() {
        //下拉刷新
        newsVM.loadRefreshData();
    }

    @Override
    public void onLoadMore() {
        //上拉加载更多
        newsVM.loadMoreData();
    }

    @Override
    public void loadStart(int loadType) {
        if(loadType==FIRST_LOAD){
            DialogHelper.getInstance().show(mContext,"加载中。。。");
        }
    }

    @Override
    public void loadComplete() {

        DialogHelper.getInstance().close();
        binding.newsRv.loadMoreComplete();
        binding.newsRv.refreshComplete();
    }

    @Override
    public void loadFailure(String message) {

        DialogHelper.getInstance().close();
        binding.newsRv.loadMoreComplete();
        binding.newsRv.refreshComplete();
        ToastUtils.show(mContext,message);
    }
}
