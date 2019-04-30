package alpha.org.alphawallet.ui.base;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import alpha.org.alphawallet.AlphaApplication;
import alpha.org.alphawallet.module.AlphaModule;

/**
 * Created by kaali on 6/29/17.
 */

public class BaseFragment extends Fragment {

    protected AlphaApplication alphaApplication;
    protected AlphaModule alphaModule;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        alphaApplication = AlphaApplication.getInstance();
        alphaModule = alphaApplication.getModule();
    }

    protected boolean checkPermission(String permission) {
        int result = ContextCompat.checkSelfPermission(getActivity(),permission);
        return result == PackageManager.PERMISSION_GRANTED;
    }
}
