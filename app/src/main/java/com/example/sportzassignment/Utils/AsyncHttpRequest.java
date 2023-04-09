package com.example.sportzassignment.Utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class AsyncHttpRequest {

    public interface HttpRequestListener {
        void onSuccess(String response);
        void onError(int responseCode, String error);
    }

    public static void sendRequestAsync(String method, String url, HttpRequestListener listener) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .method(method, null)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onError(-1, e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        String responseString = responseBody.string();
                        listener.onSuccess(responseString);
                    } else {
                        int responseCode = response.code();
                        listener.onError(responseCode, "Response code is not OK");
                    }
                } catch (IOException e) {
                    listener.onError(-1, e.getMessage());
                }
            }
        });
    }
}
