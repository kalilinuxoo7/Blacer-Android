package alpha.org.alphawallet.ui.splash_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.os.Handler;
import alpha.org.alphawallet.AlphaApplication;
import alpha.org.alphawallet.R;
import alpha.org.alphawallet.ui.start_activity.StartActivity;
import alpha.org.alphawallet.ui.wallet_activity.WalletActivity;

/**
 * Created by Neoperol on 6/13/17.
 */

public class SplashActivity extends AppCompatActivity {
    ImageView imageView;
    private boolean ispaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                jump();
            }
        }, 3500);

        //jump();

    }


    private void jump() {

        if (AlphaApplication.getInstance().getAppConf().isAppInit()){
            Intent intent = new Intent(this, WalletActivity.class);
            startActivity(intent);
        }else {
            // Jump to your Next Activity or MainActivity
            Intent intent = new Intent(this, StartActivity.class);
            startActivity(intent);
        }
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ispaused = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ispaused) {
            jump();
        }

    }
}
