package com.pb.locationintelligence;

import lombok.Data;
import org.glassfish.jersey.internal.util.Base64;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.*;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.StringReader;

@Data
public class GeoLifeSample {

        // FIXME Assign your Client Id here
        private static String API_KEY = "wy1x4xqTBh0fny2T74fS0rxxP6cqk7Dj";

        // FIXME Assign your Secret here
        private static String SECRET = "w2NStAMZjmsNeoGK";

        private static String API_FRAGMENT_DEMOGRAPHICS_V2 = "geolife/v2/demographics/";

        private static  String OAUTH2_TOKEN_URL = "https://api.pitneybowes.com/oauth/token";
        private static  String LOCATION_INTELLIGENCE_API_URL_DEMOGRAPHICS = "https://api.pitneybowes.com/location-intelligence/";

        private static String API_FRAGMENT_SEGMENTATION = "geolife/v1/segmentation/";
        private static  String LOCATION_INTELLIGENCE_API_URL_SEGMENTATION = "https://api.pitneybowes.com/location-intelligence/"+API_FRAGMENT_SEGMENTATION;

        private static final String ACCESS_TOKEN = "access_token";

        private static final String BEARER = "Bearer ";

        private static final String BASIC = "Basic ";

        private static final String CLIENT_CREDENTIALS = "client_credentials";

        private static final String GRANT_TYPE = "grant_type";

        private static final String AUTH_HEADER = "Authorization";

        private static final String COLON = ":";

        private String accessToken;

        /**
         * @param args
         */
        public static void main(String[] args) {

            // Acquires OAuth2 token
            //acquireAuthToken();

            // Gets Segmentation by Address in XML format
            //getGeoLifeSegmentationByAddress(true, "1%20Global%20View,%20Troy,%20NY", "USA");

            // Gets Segmentation by Address in JSON format
            //getGeoLifeSegmentationByAddress(false, "1%20Global%20View,%20Troy,%20NY", "USA");

            // Gets Segmentation by Location in XML format
            //getGeoLifeSegmentationByLocation(true, "35.0118", "-81.9571");

            // Gets Segmentation by Location in JSON format
            //getGeoLifeSegmentationByLocation(false, "35.0118", "-81.9571");


            // Gets getGeoLifeDemographicsByAddress Variables by Address in XML format
            getGeoLifeDemographicsByAddress(true, "1%20Global%20View,%20Troy,%20NY","USA","top3Ascending","expendituretheme","perCentasAVailable","detailed");

            // Gets GeoDemographicsV2 Variables by Address in JSON format
            getGeoLifeDemographicsByAddress(false, "1%20Global%20View,%20Troy,%20NY","USA","top3Ascending","expendituretheme","perCentasAVailable","detailed");

            // Gets GeoDemographicsV2 Variables by Location in XML format
            getGeoLifeByDemographicsLocation(true, "35.0118", "-81.9571", "top3Ascending","expendituretheme","perCentasAVailable","detailed");

            // Gets GeoDemographicsV2 Variables by Location in JSON format
            getGeoLifeByDemographicsLocation(false, "35.0118", "-81.9571", "top3Ascending","expendituretheme","perCentasAVailable","detailed");
        }

        private static void getGeoLifeByDemographicsLocation(boolean responseTypeIsXml, String latitude, String longitude, String profile, String filter, String valueFormat, String variableLevel) {
            String apiUrl = "bylocation?latitude=" + latitude + "&longitude="
                    + longitude;
            if (filter != null || filter != "") {
                apiUrl += "&filter=" + filter;
            }
            if (profile != null || profile != "") {
                apiUrl += "&profile=" + profile;
            }
            if (valueFormat != null || valueFormat != "") {
                apiUrl += "&valueFormat=" + valueFormat;
            }
            if (variableLevel != null || variableLevel != "") {
                apiUrl += "&variableLevel=" + variableLevel;
            }
            //processRequestDemographicsV2(responseTypeIsXml, apiUrl);

        }

        private static void getGeoLifeDemographicsByAddress(boolean responseTypeIsXml, String address, String country, String profile, String filter, String valueFormat, String variableLevel) {

            String apiUrl = "byaddress?address=" + address;
            if (filter != null || filter != "") {
                apiUrl += "&filter=" + filter;
            }
            if (profile != null || profile != "") {
                apiUrl += "&profile=" + profile;
            }
            if (country != null || country != "") {
                apiUrl += "&country=" + country;
            }
            if (valueFormat != null || valueFormat != "") {
                apiUrl += "&valueFormat=" + valueFormat;
            }
            if (variableLevel != null || variableLevel != "") {
                apiUrl += "&variableLevel=" + variableLevel;
            }
            //processRequestDemographicsV2(responseTypeIsXml, apiUrl);
        }


        public String getGeoLifeDemographicsByAddress(String address, String country, String profile, String filter, String valueFormat, String variableLevel) {

            String apiUrl = "byaddress?address=" + address;
            if (filter != null && filter != "") {
                apiUrl += "&filter=" + filter;
            }
            if (profile != null && profile != "") {
                apiUrl += "&profile=" + profile;
            }
            if (country != null && country != "") {
                apiUrl += "&country=" + country;
            }
            if (valueFormat != null && valueFormat != "") {
                apiUrl += "&valueFormat=" + valueFormat;
            }
            if (variableLevel != null && variableLevel != "") {
                apiUrl += "&variableLevel=" + variableLevel;
            }
            return apiUrl;
        }


/*        private static void processRequestDemographicsV2(boolean responseTypeIsXml, String apiUrl) {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(LOCATION_INTELLIGENCE_API_URL_DEMOGRAPHICS+API_FRAGMENT_DEMOGRAPHICS_V2 + apiUrl);
            Invocation.Builder builder;
            if (responseTypeIsXml) {
                builder = target.request(MediaType.APPLICATION_XML).header(
                        AUTH_HEADER, accessToken);
            } else {
                builder = target.request(MediaType.APPLICATION_JSON).header(
                        AUTH_HEADER, accessToken);
            }
            System.out.println(builder.get(String.class));

        }*/

        /**
         * Acquires OAuth2 token for accessing Location Intelligence APIs
         */
/*
        private void acquireAuthToken() {
            String authHeader = BASIC
                    + Base64.encodeAsString(API_KEY + COLON + SECRET);

            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(OAUTH2_TOKEN_URL);

            Builder builder = target.request().header(AUTH_HEADER, authHeader);
            Form form = new Form();
            form.param(GRANT_TYPE, CLIENT_CREDENTIALS);
            Response response = builder.post(Entity.entity(form,
                    MediaType.APPLICATION_FORM_URLENCODED));
            String jsonResponse = response.readEntity(String.class);

            JsonReader jsonReader = Json
                    .createReader(new StringReader(jsonResponse));
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            accessToken = jsonObject.getString(ACCESS_TOKEN);
            accessToken = BEARER + accessToken;
        }
*/

        public String acquireAuthToken() {
            String authHeader = BASIC
                    + Base64.encodeAsString(API_KEY + COLON + SECRET);

            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(OAUTH2_TOKEN_URL);

            Builder builder = target.request().header(AUTH_HEADER, authHeader);
            Form form = new Form();
            form.param(GRANT_TYPE, CLIENT_CREDENTIALS);
            Response response = builder.post(Entity.entity(form,
                    MediaType.APPLICATION_FORM_URLENCODED));
            String jsonResponse = response.readEntity(String.class);

            JsonReader jsonReader = Json
                    .createReader(new StringReader(jsonResponse));
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            accessToken = jsonObject.getString(ACCESS_TOKEN);
            accessToken = BEARER + accessToken;

            return accessToken;
        }



        /**
         * Generic client request processor that makes a Rest call to Location Intelligence APIs and prints response in XML or JSON formats.
         * @param responseTypeIsXml
         * @param apiUrl
         */
/*
        private static void processRequestSegmentation(boolean responseTypeIsXml, String apiUrl) {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(LOCATION_INTELLIGENCE_API_URL_SEGMENTATION + apiUrl);
            Builder builder;
            if (responseTypeIsXml) {
                builder = target.request(MediaType.APPLICATION_XML).header(AUTH_HEADER, accessToken);
            } else {
                builder = target.request(MediaType.APPLICATION_JSON).header(AUTH_HEADER, accessToken);
            }
            System.out.println(builder.get(String.class));
        }
*/


        /**
         * Returns Segmentation by address in XML or JSON formats
         * @param responseTypeIsXml
         * @param address
         * @param country
         */
/*        private static void getGeoLifeSegmentationByAddress(boolean responseTypeIsXml, String address, String country) {
            String apiUrl = "byaddress?address=" + address;

            if (country != null) {
                apiUrl += "&country=" + country;
            }

            processRequestSegmentation(responseTypeIsXml, apiUrl);
        }*/

        /**
         * Returns Segmentation by location in XML or JSON formats
         * @param responseTypeIsXml
         * @param latitude
         * @param longitude
         */
/*        private static void getGeoLifeSegmentationByLocation(boolean responseTypeIsXml, String latitude, String longitude) {
            String apiUrl = "bylocation?latitude=" + latitude + "&longitude=" + longitude;
            processRequestSegmentation(responseTypeIsXml, apiUrl);
        }*/

}