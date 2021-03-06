package com.mygt.vrapp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CycleDot extends View {

	private int pageCount; // 总页数
	
	private int pageSelected; // 当前页
	
	private int radius = 5; // 半径
	
	private int stokenWidth = 2; // 边框宽度
	
	private int gap = 3; // 间隔
	
	private Paint mPaint;

	
	public CycleDot(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
		init();
	}

	public CycleDot(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();
	}

	public CycleDot(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
		
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setStrokeWidth(stokenWidth);
		mPaint.setColor(Color.WHITE);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(measureWidth(), measureHeight());
	}

	protected int measureWidth() {
		return ( radius + stokenWidth ) * 2 * pageCount + gap * ( pageCount - 1 );
	}

	protected int measureHeight() {
		return ( radius + stokenWidth ) * 2;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		drawDot(canvas);
	}
	
	private void drawDot(Canvas canvas) {
		
		for(int i=0;i<pageCount;i++) {
			
			if(i == pageSelected)
				mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
			else
				mPaint.setStyle(Paint.Style.STROKE);
			
			canvas.drawCircle(( radius + stokenWidth ) * ( 2 * i + 1 ) + gap * i , radius + stokenWidth , radius, mPaint); 
		}
	}
	
	public void setPageCount(int count){
		this.pageCount = count;
		this.requestLayout();
	}
	
	public void onPageSelected(int index){
		this.pageSelected = index;
		this.postInvalidate();
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getStokenWidth() {
		return stokenWidth;
	}

	public void setStokenWidth(int stokenWidth) {
		this.stokenWidth = stokenWidth;
	}

	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}
	
	
}
