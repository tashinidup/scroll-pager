package com.tomoki.iwai;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ScrollView;

public class Main extends Activity
{
	private ScrollView scrollView;
	private ViewGroup contentView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		scrollView = (ScrollView) findViewById(R.id.scroll_view);
		contentView = (ViewGroup) findViewById(R.id.content);

		scrollView.setOnTouchListener(new ScrollPager(scrollView, contentView));
		scrollView.post(new Runnable()
		{
			public void run()
			{
				scrollView.scrollTo(0, contentView.getPaddingTop());
			}
		});
	}
}