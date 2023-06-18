package com.aopprac.service;

import com.aopprac.helper.HttpHelpers;
import com.aopprac.model.MailFormat;
import com.aopprac.model.UserDto;
import com.aopprac.service.EmailService;
import com.aopprac.service.UserService;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.ClientResourcesBuilderCustomizer;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class UserServiceImpl implements UserService {
    @Value("${wsHost}")
    private String wsHost;
    @Autowired
    private EmailService emailService;



    public HttpPost sendPostRequestTO(String targetPoint) {
        HttpPost httpPost = new HttpPost(wsHost + targetPoint);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        return httpPost;
    }

    public HttpGet sendGetRequestTo(String targetPoint) {
        HttpGet httpGet = new HttpGet(wsHost + targetPoint);
        httpGet.setHeader("Accept", "application/json");
        httpGet.setHeader("Content-Type", "application/json");
        return httpGet;
    }


    public HttpPut sendPutRequestTo(String targetPoint) {
        HttpPut httpPut = new HttpPut(wsHost + targetPoint);
        httpPut.setHeader("Accept", "application/json");
        httpPut.setHeader("Content-Type", "application/json");
        return httpPut;
    }

    public HttpDelete sendDeleteRequestTo(String targetPoint) {
        HttpDelete httpDelete = new HttpDelete(wsHost + targetPoint);
        httpDelete.setHeader("Accept", "application/json");
        httpDelete.setHeader("Content-Type", "application/json");
        return httpDelete;
    }

    @Override
    public UserDto saveUser(UserDto user) {
        UserDto user1 = new UserDto();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", user.getId());
        jsonObject.put("firstName", user.getFirstName());
        jsonObject.put("lastName", user.getLastName());
        jsonObject.put("middleName", user.getMiddleName());
        jsonObject.put("email", user.getEmail());
        jsonObject.put("password", user.getPassword());
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost post = this.sendPostRequestTO("saveUser");
//            HttpPost post = new HttpPost(wsHost+"saveUser");
//            post.setHeader("Accept", "application/json");
//            post.setHeader("Content-Type", "application/json");
            StringEntity entity = new StringEntity(jsonObject.toString());
            post.setEntity(entity);
            CloseableHttpResponse response = httpClient.execute(post);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder content = new StringBuilder();
            String line;
            while (null != (line = bufferedReader.readLine())) {
                content.append(line);
            }
            JSONObject jsonObject1 = new JSONObject(content.toString());
            user1.setId(jsonObject1.optLong("id"));
            user1.setFirstName(jsonObject1.optString("firstName"));
            user1.setMiddleName(jsonObject1.optString("middleName"));
            user1.setLastName(jsonObject1.optString("lastName"));
            user1.setEmail(jsonObject1.optString("email"));
            user1.setPassword(jsonObject1.optString("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user1;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        JSONObject jsonObject = new JSONObject();
        UserDto userDto = new UserDto();
        jsonObject.put("email",email);
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();

            HttpGet httpGet = this.sendGetRequestTo("getUserByEmail");
            StringEntity entity = new StringEntity(jsonObject.toString());
            httpGet.setEntity(entity);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder content = new StringBuilder();
            String line;
            while (null != (line = bufferedReader.readLine())) {
                content.append(line);
            }
            JSONObject jsonObject1 = new JSONObject(content.toString());
            userDto.setId(jsonObject1.optLong("id"));
            userDto.setFirstName(jsonObject1.optString("firstName"));
            userDto.setMiddleName(jsonObject1.optString("middleName"));
            userDto.setLastName(jsonObject1.optString("lastName"));
            userDto.setEmail(jsonObject1.optString("email"));
            userDto.setPassword(jsonObject1.optString("password"));

        }catch (Exception e){
            e.printStackTrace();
        }
        return userDto;
    }
}
