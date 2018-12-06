package com.androidarchitectureproject.api;

import com.androidarchitectureproject.R;
import com.androidarchitectureproject.activity.BaseActivity;
import com.androidarchitectureproject.helper.DialogHelper;

import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by @yaksonn on 22.3.2018.
 */

public class ApiErrorUtils {

    public static void parseError(Response<?> response) {
        Converter<ResponseBody, ApiError> converter = ApiService.retrofit.responseBodyConverter(ApiError.class, new Annotation[0]);
        ApiError error = new ApiError();
        error.setStatusCode(response.code());
        try {
            error = converter.convert(response.errorBody());
            error.setStatusCode(response.code());

            if(error.getMessage() != null && !error.getMessage().isEmpty()){
                DialogHelper.showAlertDialog(error.getMessage());
            }
            else if(error.getError() != null && !error.getError().isEmpty()){
                DialogHelper.showAlertDialog(error.getError());
            }
            else{
                DialogHelper.showAlertDialog(BaseActivity.currentActivity.getString(R.string.general_error_message));
            }
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.showAlertDialog(BaseActivity.currentActivity.getString(R.string.general_error_message));
        }
    }
}

