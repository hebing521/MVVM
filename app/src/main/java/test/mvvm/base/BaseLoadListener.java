package test.mvvm.base;

import java.util.List;

/**
 * Company By SQ
 * Created Date By 2018/11/3 0003
 * Created Time By 上午 9:40
 * Provide Content By MVVM
 * Created by HeBing
 * Provide Content By test.mvvm.base
 */
public interface BaseLoadListener<T> {

    /**
     * 加载数据成功
     * @param list
     */
    void loadSuccess(List<T> list);

    /**
     * 加载失败
     * @param message
     */
    void loadFailure(String message);

    /**
     * 开始加载
     */
    void loadStart();


    /**
     * 加载结束
     */
    void loadComplete();
}
