package com.apimedic;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.crypto.provider.HmacMD5;
import org.apache.commons.lang.StringEscapeUtils;
import org.glassfish.jersey.internal.util.Base64;
import org.junit.jupiter.api.Test;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SymptomTest {

    // FIXME Assign your Client Id here
    private static String API_KEY = "yesid.perea@outlook.com";

    // FIXME Assign your Secret here
    private static String SECRET = "Ls23AyHp8b7R5Mjq6";

    private static  String AUTH_TOKEN_URL = "https://sandbox-authservice.priaid.ch/login";

    private static final String ACCESS_TOKEN = "access_token";

    private static final String BEARER = "Bearer ";

    private static final String BASIC = "Basic ";

    private static final String CLIENT_CREDENTIALS = "client_credentials";

    private static final String GRANT_TYPE = "grant_type";

    private static final String AUTH_HEADER = "Authorization";

    private static final String COLON = ":";

    @Test
    public void testGetSymptoms() throws IOException, NoSuchAlgorithmException, InvalidKeyException {


/*
        String authHeader = sStringToHMACMD5(ACCESS_TOKEN, SECRET);


        //String authHeader = BASIC + Base64.encodeAsString(API_KEY + COLON + SECRET);

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(AUTH_TOKEN_URL);

        Invocation.Builder builder = target.request().header(AUTH_HEADER, authHeader);
        Form form = new Form();
        form.param(GRANT_TYPE, CLIENT_CREDENTIALS);
        Response response = builder.post(Entity.entity(form,
                MediaType.APPLICATION_FORM_URLENCODED));
        String jsonResponse = response.readEntity(String.class);

        JsonReader jsonReader = Json
                .createReader(new StringReader(jsonResponse));
        JsonObject jsonObject = jsonReader.readObject();
        jsonReader.close();
        String accessToken = jsonObject.getString(ACCESS_TOKEN);
        accessToken = BEARER + accessToken;

*/


        Client client = ClientBuilder.newClient();
        String uri = "https://sandbox-healthservice.priaid.ch/symptoms";
        String token = "?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Inllc2lkLnBlcmVhQG91dGxvb2suY29tIiwicm9sZSI6IlVzZXIiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9zaWQiOiI0MTU5IiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy92ZXJzaW9uIjoiMjAwIiwiaHR0cDovL2V4YW1wbGUub3JnL2NsYWltcy9saW1pdCI6Ijk5OTk5OTk5OSIsImh0dHA6Ly9leGFtcGxlLm9yZy9jbGFpbXMvbWVtYmVyc2hpcCI6IlByZW1pdW0iLCJodHRwOi8vZXhhbXBsZS5vcmcvY2xhaW1zL2xhbmd1YWdlIjoiZW4tZ2IiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL2V4cGlyYXRpb24iOiIyMDk5LTEyLTMxIiwiaHR0cDovL2V4YW1wbGUub3JnL2NsYWltcy9tZW1iZXJzaGlwc3RhcnQiOiIyMDE4LTEwLTMxIiwiaXNzIjoiaHR0cHM6Ly9zYW5kYm94LWF1dGhzZXJ2aWNlLnByaWFpZC5jaCIsImF1ZCI6Imh0dHBzOi8vaGVhbHRoc2VydmljZS5wcmlhaWQuY2giLCJleHAiOjE1NDEzNzU3MzYsIm5iZiI6MTU0MTM2ODUzNn0.dWYZVrptLRd-Xj9Xq-lBMoSnfY0oWnvwDbVK1ExJW3c";
        String format = "&format=json";
        String language ="&language=en-gb";

        WebTarget target = client.target(uri + token + format + language);
        //target = client.target(uri + token + format + language);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class).trim().replaceFirst("\ufeff", "");
        //String response2 = target.request(MediaType.APPLICATION_JSON).get(String.class).trim().replaceFirst("\ufeff", "");

        ObjectMapper mapper = new ObjectMapper();

        List<Symptom> symptoms = mapper.readValue(response, new TypeReference<List<Symptom>>(){});

        //Symptoms symptoms = mapper.readValue(response, Symptoms.class);

        assertEquals("Abdominal pain", symptoms.get(0).getName());
    }

    public static String sStringToHMACMD5(String s, String keyString)
    {
        String sEncodedString = null;
        try
        {
            SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"), "HmacMD5");
            Mac mac = Mac.getInstance("HmacMD5");
            mac.init(key);

            byte[] bytes = mac.doFinal(s.getBytes("ASCII"));

            StringBuffer hash = new StringBuffer();

            for (int i=0; i<bytes.length; i++) {
                String hex = Integer.toHexString(0xFF &  bytes[i]);
                if (hex.length() == 1) {
                    hash.append('0');
                }
                hash.append(hex);
            }
            sEncodedString = hash.toString();
        }
        catch(UnsupportedEncodingException e) {}
        catch(InvalidKeyException e){}
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sEncodedString;
    }
}