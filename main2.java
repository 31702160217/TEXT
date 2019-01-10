package com.example.jrz.android_shixun;

/**
 * Created by jrz on 2019/1/5.
 */
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;   // 注意这里导入的V4的包，不要导成app的包了
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class main2 extends FragmentActivity implements View.OnClickListener{

    // 初始化顶部栏显示
    private ImageView titleLeftImv;
    private TextView titleTv;

    // 定义4个Fragment对象
    private FirstFragment1 fg1;
    private FirstFragment2 fg2;
    private FirstFragment3 fg3;
    private FirstFragment4 fg4;

    // 帧布局对象，用来存放Fragment对象
    private FrameLayout frameLayout;

    // 定义每个选项中的相关控件
    private RelativeLayout firstLayout;
    private RelativeLayout secondLayout;
    private RelativeLayout thirdLayout;
    private RelativeLayout fourthLayout;

    private ImageView firstImage;
    private ImageView secondImage;
    private ImageView thirdImage;
    private ImageView fourthImage;

    private TextView firstText;
    private TextView secondText;
    private TextView thirdText;
    private TextView fourthText;

    // 定义几个颜色
    private int whirt = 0xFFFFFFFF;
    private int gray = 0xFF7597B3;
    private int dark = 0xff000000;

    // 定义FragmentManager对象管理器
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);
        //v-4包下支持的Fragment以及app包下的Fragment，
        // 这两个包下的FragmentManager获取方式有点区别
        fragmentManager = getSupportFragmentManager();//获取
        initView(); // 初始化界面控件

        setChioceItem(0);   // 初始化页面加载时显示第一个选项卡
    }

    /**
     * 初始化页面
     */
    private void initView() {

        // 初始化底部导航栏的控件
        firstImage = findViewById(R.id.first_image);
        secondImage =  findViewById(R.id.second_image);
        thirdImage =  findViewById(R.id.third_image);
        fourthImage =  findViewById(R.id.fourth_image);

        firstText =  findViewById(R.id.first_text);
        secondText = findViewById(R.id.second_text);
        thirdText =  findViewById(R.id.third_text);
        fourthText =  findViewById(R.id.fourth_text);

        firstLayout =  findViewById(R.id.first_layout);
        secondLayout =  findViewById(R.id.second_layout);
        thirdLayout =  findViewById(R.id.third_layout);
        fourthLayout =  findViewById(R.id.fourth_layout);

        firstLayout.setOnClickListener(main2.this);
        secondLayout.setOnClickListener(main2.this);
        thirdLayout.setOnClickListener(main2.this);
        fourthLayout.setOnClickListener(main2.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first_layout:
                setChioceItem(0);
                break;
            case R.id.second_layout:
                setChioceItem(1);
                break;
            case R.id.third_layout:
                setChioceItem(2);
                break;
            case R.id.fourth_layout:
                setChioceItem(3);
                break;
            default:
                break;
        }

    }


    private void setChioceItem(int index) {
        //主要的操作都是FragmentTransaction的方法
        //benginTransatcion();//开启一个事务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        clearChioce(); // 清空, 重置选项, 隐藏所有Fragment
        hideFragments(fragmentTransaction);

        switch (index) {
            case 0:
                firstImage.setImageResource(R.drawable.wechat);
                firstText.setTextColor(dark);
                firstLayout.setBackgroundColor(gray);

                // 如果fg1为空，则创建一个并添加到界面上
                if (fg1 == null) {
                    fg1 = new FirstFragment1();
                    fragmentTransaction.add(R.id.content, fg1);
                } else {
                    // 如果不为空，则直接将它显示出来
                    fragmentTransaction.show(fg1);
                }

                break;

            case 1:
                secondImage.setImageResource(R.drawable.addressbook);
                secondText.setTextColor(dark);
                secondLayout.setBackgroundColor(gray);

                if (fg2 == null) {
                    fg2 = new FirstFragment2();
                    fragmentTransaction.add(R.id.content, fg2);
                } else {
                    fragmentTransaction.show(fg2);
                }

                break;

            case 2:
                thirdImage.setImageResource(R.drawable.found);
                thirdText.setTextColor(dark);
                thirdLayout.setBackgroundColor(gray);

                if (fg3 == null) {
                    fg3 = new FirstFragment3();
                    fragmentTransaction.add(R.id.content, fg3);
                } else {
                    fragmentTransaction.show(fg3);
                }

                break;

            case 3:
              fourthImage.setImageResource(R.drawable.meblack);
                fourthText.setTextColor(dark);
                fourthLayout.setBackgroundColor(gray);

                if (fg4 == null) {
                    fg4 = new FirstFragment4();
                    fragmentTransaction.add(R.id.content, fg4);
                } else {
                    fragmentTransaction.show(fg4);
                }

                break;
        }

        fragmentTransaction.commit();   // 提交

    }

    /**
     * 当选中其中一个选项卡时，其他选项卡重置为默认
     */
    private void clearChioce() {
        firstImage.setImageResource(R.drawable.wechat);
        firstText.setTextColor(gray);
        firstLayout.setBackgroundColor(whirt);

        secondImage.setImageResource(R.drawable.addressbook);
        secondText.setTextColor(gray);
        secondLayout.setBackgroundColor(whirt);

        thirdImage.setImageResource(R.drawable.found);
        thirdText.setTextColor(gray);
        thirdLayout.setBackgroundColor(whirt);

        fourthImage.setImageResource(R.drawable.meblack);
        fourthText.setTextColor(gray);
        fourthLayout.setBackgroundColor(whirt);
    }

    /**
     * 隐藏Fragment
     *
     * @param fragmentTransaction
     */
    private void hideFragments(FragmentTransaction fragmentTransaction) {
        if (fg1 != null) {
            fragmentTransaction.hide(fg1);
        }

        if (fg2 != null) {
            fragmentTransaction.hide(fg2);
        }

        if (fg3 != null) {
            fragmentTransaction.hide(fg3);
        }

        if (fg4 != null) {
            fragmentTransaction.hide(fg4);
        }
    }

}

