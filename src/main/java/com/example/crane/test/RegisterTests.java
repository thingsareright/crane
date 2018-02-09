package com.example.crane.test;


import com.example.crane.model.UserRegisterForgetPasswordModel;
import com.google.gson.Gson;
import com.squareup.okhttp.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterTests {

    public final static int CONNECT_TIMEOUT = 60;
    public final static int READ_TIMEOUT = 100;
    public final static int WRITE_TIMEOUT = 60;
    public static final OkHttpClient client = new OkHttpClient();

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    @Test
    public void postJson() throws IOException {

        UserRegisterForgetPasswordModel model = new UserRegisterForgetPasswordModel();
        model.setTokenCode("012476");
        model.setUserPassword("dsaasfasf");
        model.setUserPhone("18838951998");

        Gson gson = new Gson();

        String json = gson.toJson(model);
        RequestBody requestBody = RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .url("http://19w2493s42.iok.la:19938/crane/user/register")
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            System.out.println(response.body().string());
        }else {
            throw new IOException("Unexpected code " + response);
        }
    }


}
