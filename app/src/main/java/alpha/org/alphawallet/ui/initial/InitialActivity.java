package alpha.org.alphawallet.ui.initial;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import alpha.org.alphawallet.AlphaApplication;
import alpha.org.alphawallet.ui.splash_activity.SplashActivity;
import alpha.org.alphawallet.ui.wallet_activity.WalletActivity;
import alpha.org.alphawallet.utils.AppConf;

/**
 * Created by kaali on 8/19/17.
 */

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlphaApplication alphaApplication = AlphaApplication.getInstance();
        AppConf appConf = alphaApplication.getAppConf();
        // show report dialog if something happen with the previous process
        Intent intent;
        if (!appConf.isAppInit() || appConf.isSplashSoundEnabled()){
            intent = new Intent(this, SplashActivity.class);
        }else {
            intent = new Intent(this, WalletActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
