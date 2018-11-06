package test.mvvm.base;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Company By SQ
 * Created Date By 2018/11/3 0003
 * Created Time By 上午 10:13
 * Provide Content By MVVM
 * Created by HeBing
 * Provide Content By test.mvvm.base
 */
public class BaseViewHolder<S extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private S mBinding;

    public BaseViewHolder(S mBinding) {
        super(mBinding.getRoot());
        this.mBinding = mBinding;
    }

    public S getmBinding() {
        return mBinding;
    }
}
