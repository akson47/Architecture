package com.androidarchitectureproject.helper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.androidarchitectureproject.R;
import com.androidarchitectureproject.activity.BaseActivity;

/**
 * Created by @yaksonn on 22.3.2018.
 */

public class DialogHelper {

    private static MaterialDialog loadingDialog;

    public static void showDialogWithPositiveButton(String message) {
        showDialogWithPositiveButton("", message);
    }

    public static void showDialogWithPositiveButton(String title, String message) {

        if(title.isEmpty())
            title = BaseActivity.currentActivity.getString(R.string.app_name);

        new MaterialDialog.Builder(BaseActivity.currentActivity)
                .title(title)
                .content(message)
                .titleColorRes(R.color.colorPrimary)
                .contentColorRes(R.color.navy)
                .positiveText(R.string.ok)
                .positiveColor(ContextCompat.getColor(BaseActivity.currentActivity, R.color.colorPrimary))
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        //BaseActivity.currentActivity.onBackPressed();
                        dialog.dismiss();
                    }
                })
                .show();

    }


    public static void showAlertDialog(String content) {

        new MaterialDialog.Builder(BaseActivity.currentActivity)
                .title(R.string.alert)
                .content(content)
                .titleColorRes(R.color.colorPrimary)
                .contentColorRes(R.color.navy)
                .positiveText(R.string.ok)
                .positiveColor(ContextCompat.getColor(BaseActivity.currentActivity, R.color.colorPrimary))
                .show();
    }

    public static void showFailedDialog() {

        new MaterialDialog.Builder(BaseActivity.currentActivity)
                .title(R.string.alert)
                .content(BaseActivity.currentActivity.getString(R.string.failed))
                .titleColorRes(R.color.colorPrimary)
                .contentColorRes(R.color.navy)
                .positiveText(R.string.ok)
                .positiveColor(ContextCompat.getColor(BaseActivity.currentActivity, R.color.colorPrimary))
                .show();
    }

    public static void showNoNetworkDialog() {

        new MaterialDialog.Builder(BaseActivity.currentActivity)
                .title(R.string.alert)
                .content(BaseActivity.currentActivity.getString(R.string.no_network_message))
                .titleColorRes(R.color.colorPrimary)
                .contentColorRes(R.color.navy)
                .positiveText(R.string.ok)
                .positiveColor(ContextCompat.getColor(BaseActivity.currentActivity, R.color.colorPrimary))
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        BaseActivity.currentActivity.finishAffinity();
                    }
                })
                .show();
    }

    public static void showLoadingDialog(){
        if(loadingDialog != null && loadingDialog.isShowing())
            return;
        loadingDialog = new MaterialDialog.Builder(BaseActivity.currentActivity)
                .content(BaseActivity.currentActivity.getString(R.string.loading))
                .titleColorRes(R.color.colorPrimary)
                .contentColorRes(R.color.navy)
                .cancelable(false)
                .progress(true, 0)
                .progressIndeterminateStyle(true)
                .show();
    }

    public static void hideLoadingDialog(){
        if(loadingDialog != null && loadingDialog.isShowing()){
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }
}
