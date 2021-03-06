package com.ybkj.project_base.ui.dialog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ybkj.base.ui.dialog.BaseDialog;
import com.ybkj.base.ui.view.recyclerview.DividerItemDecoration;
import com.ybkj.base.utils.ResourcesUtil;
import com.ybkj.project_base.R;
import com.ybkj.project_base.ui.adapter.BottomSelectAdapter;

import java.util.List;

/**
 * - @Author:  Yi Shan Xiang
 * - @Description:  SelectBottomDialog
 * - @Time:  2018/10/23
 * - @Emaill:  380948730@qq.com
 */
public class SelectBottomDialog extends BaseDialog implements View.OnClickListener {
    private OnItemClickListener onItemClickListener;
    private OnCancelListener onCancelListener;
    private Context mContext;
    private List<String> recordList;
    private int selectPosition = -1;//当前选择的下标
    private String tittle;
    private BottomSelectAdapter bottomSelectAdapter;
    private TextView tittleTv;

    public SelectBottomDialog(Activity context, List<String> recordList, String tittle) {
        super(context, R.style.project_base_common_dialog, R.layout.project_base_dialog_bottom_select);
        this.mContext = context;
        this.recordList = recordList;
        this.tittle = tittle;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }

    public void setList(List<String> recordList) {
        if (bottomSelectAdapter != null) {
            bottomSelectAdapter.setNewData(recordList);
        }
    }

    public void setTittle(String tittleText) {
        tittle = tittleText;
        if (tittleTv != null) {
            tittleTv.setText(tittleText);
        }
    }

    /**
     * 设置当前选择的位置
     *
     * @param selectPosition
     */
    public void setSelectPosition(int selectPosition) {
        this.selectPosition = selectPosition;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(null);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        setAlertDialogGravity(Gravity.BOTTOM);
        initView();
        setAnimation(R.style.base_choose_item_dialog_animation);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        if (getWindow() != null) {
            lp.copyFrom(getWindow().getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            getWindow().setAttributes(lp);
        }
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();//关闭选择框
        if (i == R.id.bottom_dialog_close) {
            dismiss();

        }
    }

    protected void initView() {
        ImageView selectClose = (ImageView) findViewById(R.id.bottom_dialog_close);//选择界面关闭
        RecyclerView recycle = (RecyclerView) findViewById(R.id.deliver_select_recycle);
        tittleTv = (TextView) findViewById(R.id.bottom_dialog_tittle);
        tittleTv.setText(tittle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycle.setLayoutManager(layoutManager);
        //添加分割线
        recycle.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST, 0.5f,
                ResourcesUtil.getColor(R.color.base_color_line)));
        selectClose.setOnClickListener(this);

        bottomSelectAdapter = new BottomSelectAdapter(mContext);
        View emptyView = LayoutInflater.from(mContext).inflate(R.layout.project_base_empty_view, null);
        bottomSelectAdapter.setEmptyView(emptyView);
        bottomSelectAdapter.setNewData(recordList);
        bottomSelectAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                onItemClickListener.onItemClick(position);
//                if (selectPosition != -1) {
//                    recordList.get(selectPosition).setSelect(false);
//                }
//                recordList.get(position).setSelect(true);
                if (onCancelListener != null) {
                    onCancelListener.cancel();
                }
                selectPosition = position;
                dismiss();
            }
        });

        recycle.setAdapter(bottomSelectAdapter);

    }

    public interface OnCancelListener {
        void cancel();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
