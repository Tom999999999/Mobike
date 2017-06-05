package com.yiwen.mobike.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.yiwen.mobike.R;
import com.yiwen.mobike.views.MySettingView;
import com.yiwen.mobike.views.MyToolBar;
import com.yiwen.mobike.views.NumberAnimTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;


public class UserActivity extends AppCompatActivity {

    @BindView(R.id.iv_avatar)
    CircleImageView         mIvAvatar;
    @BindView(R.id.tv_phone)
    TextView                mTvPhone;
    @BindView(R.id.tv_credit)
    TextView                mTvCredit;
    @BindView(R.id.tv_ride)
    NumberAnimTextView      mTvRide;
    @BindView(R.id.tv_save)
    NumberAnimTextView      mTvSave;
    @BindView(R.id.tv_kaluli)
    NumberAnimTextView      mTvKaluli;
    @BindView(R.id.tv_my_money)
    MySettingView           mTvMyMoney;
    @BindView(R.id.tv_my_youhui)
    MySettingView           mTvMyYouhui;
    @BindView(R.id.tv_my_distance)
    MySettingView           mTvMyDistance;
    @BindView(R.id.tv_my_mymassege)
    MySettingView           mTvMyMymassege;
    @BindView(R.id.tv_my_invent)
    MySettingView           mTvMyInvent;
    @BindView(R.id.tv_my_guide)
    MySettingView           mTvMyGuide;
    @BindView(R.id.tv_my_setting)
    MySettingView           mTvMysetting;
    @BindView(R.id.toolbar_use)
    MyToolBar               mToolbar_use;
    @BindView(R.id.collapsinglayout)
    CollapsingToolbarLayout mCollapsinglayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
        initView();
        initData();
        initEvent();
    }


    private void initEvent() {

        mToolbar_use.setOnLeftButtonClickListener(new MyToolBar.OnLeftButtonClickListener() {
            @Override
            public void onClick() {
                UserActivity.this.finish();
            }
        });


    }

    private void initData() {
    }

    private void initView() {
        initToolbar();
        mTvRide.setNumberString(mTvRide.getText().toString());
        mTvSave.setNumberString(mTvSave.getText().toString());
        mTvKaluli.setNumberString(mTvKaluli.getText().toString());
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar_use);
        //        ActionBar actionBar = getSupportActionBar();
        //        if (actionBar != null) {
        //            actionBar.setDisplayHomeAsUpEnabled(true);
        //        }
        //        mToolbar_use.setNavigationIcon(R.drawable.up_arrow);
        //        mCollapsinglayout.setTitleEnabled(false);
        //        mCollapsinglayout.setCollapsedTitleGravity(Gravity.CENTER_HORIZONTAL);//收
        //        mCollapsinglayout.setExpandedTitleGravity(Gravity.CENTER_HORIZONTAL|Gravity.TOP);
        //        mCollapsinglayout.setTitle("个人中心");
    }

    @OnClick({R.id.iv_avatar, R.id.tv_credit, R.id.tv_my_money, R.id.tv_my_youhui,
            R.id.tv_my_distance, R.id.tv_my_mymassege, R.id.tv_my_invent,
            R.id.tv_my_guide,R.id.tv_my_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_avatar:
                Go2Activity(UserDetailActivity.class);
                break;
            case R.id.tv_credit:
                Go2Activity(MyCreditActivity.class);
                break;
            case R.id.tv_my_money:
                Go2Activity(WalletActivity.class);
                break;
            case R.id.tv_my_youhui:
                Go2Activity(MyCouponsActivity.class);
                break;
            case R.id.tv_my_distance:
                Go2Activity(MyTripsActivity.class);
                break;
            case R.id.tv_my_mymassege:
                Go2Activity(MyMessagesActivity.class);
                break;
            case R.id.tv_my_invent:
                Go2Activity(InviteFriendActivity.class);
                break;
            case R.id.tv_my_guide:
                Go2Activity(UserManuelActivity.class);
                break;
            case R.id.tv_my_setting:
                Go2Activity(SettingsActivity.class);
                break;
        }
    }

    private void Go2Activity(Class c) {
        Intent intent=new Intent(UserActivity.this,c);
        startActivity(intent);
    }

}
