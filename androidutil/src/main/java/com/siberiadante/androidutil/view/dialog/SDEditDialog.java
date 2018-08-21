package com.siberiadante.androidutil.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.siberiadante.androidutil.R;


/**
 * Created: SiberiaDante
 * Describe： 带EditText的确认or取消弹窗
 * Time: 2017/6/19
 * Email: 994537867@qq.com
 * GitHub: https://github.com/SiberiaDante
 */

public class SDEditDialog {
    private Context context;
    private Dialog dialog;
    private LinearLayout mLinearLayout;
    private TextView mTvTitle;
    private EditText mEdtContent;
    private Button btn_neg;
    private Button btn_pos;
    private Display display;

    public SDEditDialog(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null) {
            display = windowManager.getDefaultDisplay();
        }
    }

    public SDEditDialog builder() {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_alert_edit, null);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.linear_alert_dialog_bg);
        mTvTitle = (TextView) view.findViewById(R.id.tv_alert_dialog_title);
        mEdtContent = (EditText) view.findViewById(R.id.edt_alert_dialog_content);
        btn_neg = (Button) view.findViewById(R.id.btn_alert_dialog_cancel);
        btn_pos = (Button) view.findViewById(R.id.btn_alert_dialog_sure);
        dialog = new Dialog(context, R.style.CustomDialogStyle);
        dialog.setContentView(view);
        Point point = new Point();
        display.getSize(point);
        mLinearLayout.setLayoutParams(new FrameLayout.LayoutParams((int) (point.x * 0.85), LinearLayout.LayoutParams.WRAP_CONTENT));
        return this;
    }

    /**
     * @param title
     * @return
     */
    public SDEditDialog setTitle(String title) {
        if ("".equals(title)) {
            mTvTitle.setText("标题");
        } else {
            mTvTitle.setText(title);
        }
        return this;
    }

    /**
     * @param title
     * @param color
     * @param textSize
     * @return
     */
    public SDEditDialog setTitle(String title, int color, float textSize) {
        if ("".equals(title)) {
            mTvTitle.setText("标题");
        } else {
            mTvTitle.setText(title);
        }
        mTvTitle.setTextColor(color);
        mTvTitle.setTextSize(textSize);
        return this;
    }

    /**
     * @return
     */
    public String getMsg() {
        return mEdtContent.getText().toString();
    }

    /**
     * @param cancelable
     * @return
     */
    public SDEditDialog setCancelable(boolean cancelable) {
        dialog.setCancelable(cancelable);
        return this;
    }

    /**
     * @param text
     * @param listener
     * @return
     */
    public SDEditDialog setPositiveButton(String text, final View.OnClickListener listener) {
        if ("".equals(text)) {
            btn_pos.setText("确定");
        } else {
            btn_pos.setText(text);
        }
        btn_pos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    /**
     * @param text
     * @param color
     * @param textSize
     * @param listener
     * @return
     */
    public SDEditDialog setPositiveButton(String text, int color, float textSize, final View.OnClickListener listener) {
        if ("".equals(text)) {
            btn_pos.setText("确定");
        } else {
            btn_pos.setText(text);
        }
        btn_pos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        btn_pos.setTextColor(color);
        btn_pos.setTextSize(textSize);
        return this;
    }

    /**
     * @param text
     * @param listener
     * @return
     */
    public SDEditDialog setNegativeButton(String text,
                                          final View.OnClickListener listener) {
        if ("".equals(text)) {
            btn_neg.setText("取消");
        } else {
            btn_neg.setText(text);
        }
        btn_neg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    /**
     * @param text
     * @param color
     * @param textSize
     * @param listener
     * @return
     */
    public SDEditDialog setNegativeButton(String text, int color, float textSize,
                                          final View.OnClickListener listener) {
        if ("".equals(text)) {
            btn_neg.setText("取消");
        } else {
            btn_neg.setText(text);
        }
        btn_neg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        btn_neg.setTextColor(color);
        btn_neg.setTextSize(textSize);
        return this;
    }

    /**
     *
     */
    public void dismiss() {
        dialog.dismiss();
    }

    /**
     *
     */
    public void show() {
        dialog.show();
    }
}
