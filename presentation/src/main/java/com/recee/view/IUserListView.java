package com.recee.view;

import java.util.List;

/**
 * @author Reece
 * @version V1.0
 * @Date 2/20/17
 * @Description
 */

public interface IUserListView {
    void showLoading();
    void dismissLoading();
    void onLoadSuccess(List<String> userList);
    void onLoadError(String message);
}
