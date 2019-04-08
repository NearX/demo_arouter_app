package com.ybkj.agent.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.ybkj.agent.R;
import com.ybkj.agent.bean.ExampleData;
import com.ybkj.base.ui.adapter.XBaseAdapter;
import com.ybkj.base.ui.adapter.XBaseViewHolder;
import com.ybkj.project_base.utils.ImageLoadUtils;

/**
 * Description
 * Author Ren Xingzhi
 * Created on 2019/3/31.
 * Email 15384030400@163.com
 */
public class ListAdapter extends XBaseAdapter<ExampleData> {
    private Context mContext;

    public ListAdapter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.agent_recycler_item_list;
    }

    @Override
    protected void convert(XBaseViewHolder helper, ExampleData item) {
        ImageView image = helper.getView(R.id.image);
        ImageLoadUtils.loadUrlImage(mContext, item.getImage(), image);
        helper.setText(R.id.tv_name, item.getName());
    }
}
