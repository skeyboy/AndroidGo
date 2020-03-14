package com.example.androidgo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.text.DecimalFormat;

public class CirCleView extends View {

    float backCircleWidth, outerCircleWidth, mPadding, currentPercent;
    int backCircleColor, outerCircleColor, titleTextColor;
    int width, height;

    float titleTextSize;

    String title;
    Paint backCirclePaint, outerCirclePaint, mTitlePaint;


    public CirCleView(Context context) {
        this(context, null);
    }

    public CirCleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CirCleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public CirCleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CirCleView);

        backCircleWidth = typedArray.getDimension(R.styleable.CirCleView_mBackCircleWidth, 1);
        backCircleColor = typedArray.getColor(R.styleable.CirCleView_mBackCircleColor, Color.parseColor("#ff0000"));

        outerCircleColor = typedArray.getColor(R.styleable.CirCleView_mOuterCircleColor, Color.parseColor("#00ff00"));
        outerCircleWidth = typedArray.getDimension(R.styleable.CirCleView_mOuterCircleColorWitdth, 2);

        mPadding = typedArray.getDimension(R.styleable.CirCleView_mPadding, 0);

        String mPercent = typedArray.getString(R.styleable.CirCleView_mPercent);
        currentPercent = Float.parseFloat(mPercent);


        title = typedArray.getString(R.styleable.CirCleView_mTitle);
        titleTextColor = typedArray.getColor(R.styleable.CirCleView_mTitleTextColor, Color.parseColor("#ffffff"));
        titleTextSize = typedArray.getDimension(R.styleable.CirCleView_mTitleTextSize, 20);

        backCirclePaint = new Paint();
        backCirclePaint.setColor(backCircleColor);
        backCirclePaint.setAntiAlias(true);
        backCirclePaint.setStrokeWidth(backCircleWidth);
        backCirclePaint.setStyle(Paint.Style.STROKE);


        outerCirclePaint = new Paint();
        outerCirclePaint.setColor(outerCircleColor);
        outerCirclePaint.setAntiAlias(true);
        outerCirclePaint.setStrokeWidth(outerCircleWidth);
        outerCirclePaint.setStyle(Paint.Style.STROKE);
        outerCirclePaint.setStrokeCap(Paint.Cap.ROUND);


        mTitlePaint = new Paint();
        mTitlePaint.setTextSize(titleTextSize);
        mTitlePaint.setColor(titleTextColor);

        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

//        画圆
        float backCircleR = (Math.min(width, height) - 2 * mPadding) / 2;
        canvas.drawCircle(width / 2, height / 2, backCircleR, backCirclePaint);


        //画进度圆弧
        RectF rectF = new RectF(mPadding, mPadding, width - mPadding, height - mPadding);
        //顺时针走，从水平最左侧开始也就是3点钟方位为0起点
        canvas.drawArc(rectF, -90, 360 * currentPercent, false, outerCirclePaint);

        Rect titleRect = new Rect();
        mTitlePaint.getTextBounds(title, 0, title.length(), titleRect);
        canvas.drawText(title, width / 2 - titleRect.width() / 2, height / 4 + titleRect.height() / 2, mTitlePaint);

        DecimalFormat df = new DecimalFormat("#%");//乘以100后以百分比形式输出,此处输出"12%"

        String percentMsg =  df.format(currentPercent);
        percentMsg = String.valueOf(currentPercent * 100) + "%";

        mTitlePaint.getTextBounds(percentMsg, 0, percentMsg.length(), titleRect);
        canvas.drawText(percentMsg, width / 2 - titleRect.width() / 2, height / 2 + titleRect.height() / 2, mTitlePaint);
    }
}
