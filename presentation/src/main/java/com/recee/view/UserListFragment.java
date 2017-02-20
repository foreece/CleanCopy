package com.recee.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.recee.R;
import com.recee.presenter.UserListPresenter;

import java.util.List;

/**
 * @author Reece
 * @version V1.0
 * @Date 2/20/17
 * @Description
 */

public class UserListFragment extends BaseFragment implements IUserListView {
    private ProgressBar progressBar;
    UserListPresenter userListPresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        userListPresenter = new UserListPresenter(this);
        View view = inflater.inflate(R.layout.fragment_user_list, null, false);
        progressBar = (ProgressBar) view.findViewById(R.id.loading);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userListPresenter.loadData();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onLoadSuccess(List<String> userList) {
        Toast.makeText(getActivity(), "successful", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoadError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }
}
