package com.recee.view;

import android.os.Bundle;

import com.recee.R;

/**
 * @author Reece
 * @version V1.0
 * @Date 2/20/17
 * @Description
 */

public class UserListActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        getSupportFragmentManager().beginTransaction().add(R.id.container, new UserListFragment()).commit();
    }
}
