package com.recee.presenter;

import com.recee.data.UserDataRepository;
import com.recee.domain.GetUserList;
import com.recee.view.IUserListView;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author Reece
 * @version V1.0
 * @Date 2/20/17
 * @Description
 */

public class UserListPresenter extends BasePresenter {
    private GetUserList getUserList;
    private IUserListView userListView;
    public UserListPresenter(IUserListView view) {
        this.userListView = view;
        getUserList = new GetUserList(new UserDataRepository());
    }
    public void loadData() {
        getUserList.users()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new UserListObserver());
    }
    private final class UserListObserver implements Observer<List<String>> {

        @Override
        public void onCompleted() {
            userListView.dismissLoading();
        }

        @Override
        public void onError(Throwable e) {
            userListView.dismissLoading();
            userListView.onLoadError("error");
        }

        @Override
        public void onNext(List<String> strings) {
            userListView.onLoadSuccess(strings);
        }
    }
}
