package com.investor;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.investor.adapters.InvestmentStatusAdapter;
import com.investor.adapters.NotificationAdapter;
import com.investor.models.InvestmentStatusList;
import com.investor.models.NotificationList;
import com.investor.presenter.NotificationsPresenter;
import com.investor.utils.BaseActivity;
import com.investor.view.NotificationsContractor;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Notifications extends BaseActivity implements NotificationsContractor.view {

    @BindView(R.id.na_rv_notificationlist)
    RecyclerView naRvNotificationlist;

    private static RecyclerView.Adapter notificationStatusAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<NotificationList> notificationList;
    private NotificationsPresenter presenter;

    @Override
    protected int setLayout() {
        return R.layout.activity_notifications;
    }

    @Override
    protected String setTitle() {
        return getResources().getString(R.string.lbl_notification_title);
    }

    @Override
    protected Boolean setNavigationDrawer() {
        return false;
    }

    @Override
    protected void intialize() {

        presenter = new NotificationsPresenter(this, this);
        presenter.getNotificationList();
      //  setContent();


    }

    private void setContent() {
        presenter.getNotificationList();

        naRvNotificationlist.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        naRvNotificationlist.setLayoutManager(layoutManager);
        naRvNotificationlist.setItemAnimator(new DefaultItemAnimator());


        notificationList = new ArrayList<NotificationList>();
        notificationList.add(new NotificationList(R.drawable.profile_3x, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", "Today"));
        notificationList.add(new NotificationList(R.drawable.profile_3x, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", "Today"));
        notificationList.add(new NotificationList(R.drawable.profile_3x, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", "Today"));
        notificationList.add(new NotificationList(R.drawable.profile_3x, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", "Today"));
        notificationStatusAdapter = new NotificationAdapter(notificationList, getApplicationContext(), this);
        naRvNotificationlist.setAdapter(notificationStatusAdapter);
    }


    @Override
    public void notificationList(ArrayList<NotificationList> notifications) {


        naRvNotificationlist.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        naRvNotificationlist.setLayoutManager(layoutManager);
        naRvNotificationlist.setItemAnimator(new DefaultItemAnimator());


        notificationStatusAdapter = new NotificationAdapter(notifications, getApplicationContext(), this);
        naRvNotificationlist.setAdapter(notificationStatusAdapter);
    }
}
