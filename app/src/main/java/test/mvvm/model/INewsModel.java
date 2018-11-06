package test.mvvm.model;

import test.mvvm.base.BaseLoadListener;
import test.mvvm.bean.SimpleNewsBean;

/**
 * Company By SQ
 * Created Date By 2018/11/2 0002
 * Created Time By 下午 5:22
 * Provide Content By MVVM
 * Created by HeBing
 * Provide Content By test.mvvm.model
 */
public interface INewsModel {
    /**
     * 加载资讯
     */
    void loadNewsData(int page, BaseLoadListener<SimpleNewsBean> loadListener);
}
