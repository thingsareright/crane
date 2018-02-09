package com.example.crane.controller;

import com.example.crane.model.UploadPictureModel;
import com.example.crane.model.UserRegisterForgetPasswordModel;
import com.google.gson.Gson;
import com.squareup.okhttp.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.example.crane.test.RegisterTests.JSON;

@RestController
@RequestMapping("/test")
public class test {
    public static final OkHttpClient client = new OkHttpClient();

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    @RequestMapping("/postREsetPassword")
    public int postJson() throws IOException {

        UploadPictureModel model = new UploadPictureModel();
        model.setUserPhone("18838951998");
        model.setUserPassword("dsaasfasf");
        model.setBase64("hjdhhgkfklfgfdhgklfgjfgggfightuiguuhtgjlfhgljfgjkflgjklfgjkflgjfkglfjgk;gjk;gjk;gdsgjkd;sgjd;gjgk;sgjldsfl;dfksl;dfkdslff");

        Gson gson = new Gson();

        String json = gson.toJson(model);
        RequestBody requestBody = RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .url("http://127.0.0.1:5003/crane/UploadDeletePicture/uploadPicture")
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            System.out.println(response.body().string());
        } else {
            throw new IOException("Unexpected code " + response);
        }
        return 1;

    }
}
