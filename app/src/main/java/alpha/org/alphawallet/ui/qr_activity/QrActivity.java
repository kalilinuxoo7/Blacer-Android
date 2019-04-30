package alpha.org.alphawallet.ui.qr_activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import alpha.org.alphawallet.R;
import alpha.org.alphawallet.ui.base.BaseActivity;
import alpha.org.alphawallet.utils.NavigationUtils;

/**
 * Created by kaali on 6/8/17.
 */

public class QrActivity extends BaseActivity {

    private View root;

    @Override
    protected void onCreateView(Bundle savedInstanceState, ViewGroup container) {
        super.onCreateView(savedInstanceState, container);;
        root = getLayoutInflater().inflate(R.layout.qr_activity,container,true);
        setTitle(R.string.my_address);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        NavigationUtils.goBackToHome(this);
    }

}
