package com.anaistroncoso.paymentapp.common.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.anaistroncoso.paymentapp.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        onInject();
        setContentView(getLayoutId());
        onBindViews();
        onPrepareActivity();
    }

    protected void onPrepareActivity() {
    }

    protected void onBindViews() {
        unbinder = ButterKnife.bind(this);
    }

    protected void onInject() {
    }

    protected abstract int getLayoutId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected abstract int getContainerViewId();

}
