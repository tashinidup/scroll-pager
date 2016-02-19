# scroll-pager overview #

This is the small code snippet which provide page by page scrollable function for your Android application (ScrollView).


## What is this. ##

  1. Provides over-scroll function for your ScrollView.(like iPhone)
  1. And provides page by page scrollable function.


## How-to use. ##

### 1. built up layout.xml ###

Create ScrollView and one child view into your layout xml. (for awesomeness, the child view should have paddingTop 200dip and paddingBottom 200dip.(option))

```
<ScrollView
    android:id="@+id/scroll_view"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent">
  
    <LinearLayout
      android:id="@+id/content"
      android:layout_width="fill_parent"
      android:layout_height="fill_parent"
      android:orientation="vertical"
      android:paddingTop="200dip"
      android:paddingBottom="200dip">
      
      <TextView
        android:layout_width="fill_parent"
        android:layout_height="300dip"
        android:text="First Content."
        android:textSize="50dip"/>
      
      <TextView
        android:layout_width="fill_parent"
        android:layout_height="300dip"
        android:text="Second Content."
        android:textSize="50dip"/>
      
      <TextView
        android:layout_width="fill_parent"
        android:layout_height="300dip"
        android:text="Third Content."
        android:textSize="50dip"/>

    </LinearLayout>
</ScrollView>
```


### 2. Instantiates ScrollPager and setOnTouchListener ###

  1. Write code that instantiates ScrollPager (class this project provides).
  1. Set the instance of ScrollPager as OnTouchListener of your ScrollView via setOnTouchListener method.

```
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    
    scrollView = (ScrollView)findViewById(R.id.scroll_view);
    contentView = (LinearLayout)findViewById(R.id.content);
    
    scrollView.setOnTouchListener(new ScrollPager(scrollView, contentView));
}
```

### 3. make ScrollView suitable scrolled ###

Add codes that initialize your ScrollView as scrolled to height of paddingTop.

```
scrollView.post(new Runnable()
{
  public void run()
  {
    scrollView.scrollTo(0, contentView.getPaddingTop());
  }
});
```


## We needs. ##

Android 1.6+


## Function ##

### Over Scroll ###

First, touch and pull down the content-view.

![http://scroll-pager.googlecode.com/svn-history/r10/wiki/top_padding.png](http://scroll-pager.googlecode.com/svn-history/r10/wiki/top_padding.png)

Automatically scroll back as soon as your release finger.

![http://scroll-pager.googlecode.com/svn-history/r10/wiki/normal.png](http://scroll-pager.googlecode.com/svn-history/r10/wiki/normal.png)

and vice versa.

![http://scroll-pager.googlecode.com/svn-history/r10/wiki/bottom_padding.png](http://scroll-pager.googlecode.com/svn-history/r10/wiki/bottom_padding.png)


### scroll page by page ###

When you scroll content-view a half of display height and release your finger.

![http://scroll-pager.googlecode.com/svn-history/r10/wiki/paging.png](http://scroll-pager.googlecode.com/svn-history/r10/wiki/paging.png)

Automatically scrolled a page.

![http://scroll-pager.googlecode.com/svn-history/r10/wiki/paging_result.png](http://scroll-pager.googlecode.com/svn-history/r10/wiki/paging_result.png)