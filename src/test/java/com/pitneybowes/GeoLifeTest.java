package com.pitneybowes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pb.geolife.Demographic;
import com.pb.locationintelligence.GeoLifeSample;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoLifeTest {

    private static  String LOCATION_INTELLIGENCE_API_URL_DEMOGRAPHICS = "https://api.pitneybowes.com/location-intelligence/";
    private static String API_FRAGMENT_DEMOGRAPHICS_V2 = "geolife/v2/demographics/";
    private static final String AUTH_HEADER = "Authorization";
    private String accessToken;

    @Test
    public void testGetDemographicByAddress() throws IOException {

        GeoLifeSample geoLife = new GeoLifeSample();
        accessToken = geoLife.acquireAuthToken();

        String uri = "https://api.pitneybowes.com/location-intelligence/geolife/v2/demographics/byaddress?";
        String address = "2935%20Broadbridge%20Ave%2C%20Stratford%2C%20CT";
        String country = "USA";
        String format = "Both";
        String level = "All";
        String profile = null;
        String filter = null;
        boolean responseTypeIsXml = false;

        String apiUrl = geoLife.getGeoLifeDemographicsByAddress(address, country, profile, filter, format, level);

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(LOCATION_INTELLIGENCE_API_URL_DEMOGRAPHICS+API_FRAGMENT_DEMOGRAPHICS_V2 + apiUrl);
        Invocation.Builder builder;

        if (responseTypeIsXml) {
            builder = target.request(MediaType.APPLICATION_XML).header(AUTH_HEADER, accessToken);
        } else {
            //builder = target.request(MediaType.APPLICATION_JSON).header(AUTH_HEADER, accessToken);
            builder = target.request(MediaType.APPLICATION_JSON).header(AUTH_HEADER, accessToken);
        }
        String response = builder.get(String.class);

        //WebTarget target = client.target(uri + address + country + format + level).request().header("Authorization", "{Bearer qYS1Y0aFZXOe40ah6x3hhY9Y5KnZ}");
        //String response = target.request(MediaType.APPLICATION_JSON).get(String.class).trim().replaceFirst("\ufeff", "");

        ObjectMapper mapper = new ObjectMapper();

        //String jason = "[{\\\"ID\\\":10,\\\"Name\\\":\\\"Abdominal pain\\\"},{\\\"ID\\\":238,\\\"Name\\\":\\\"Anxiety\\\"},{\\\"ID\\\":104,\\\"Name\\\":\\\"Back pain\\\"},{\\\"ID\\\":75,\\\"Name\\\":\\\"Burning eyes\\\"},{\\\"ID\\\":46,\\\"Name\\\":\\\"Burning in the throat\\\"},{\\\"ID\\\":170,\\\"Name\\\":\\\"Cheek swelling\\\"},{\\\"ID\\\":17,\\\"Name\\\":\\\"Chest pain\\\"},{\\\"ID\\\":31,\\\"Name\\\":\\\"Chest tightness\\\"},{\\\"ID\\\":175,\\\"Name\\\":\\\"Chills\\\"},{\\\"ID\\\":139,\\\"Name\\\":\\\"Cold sweats\\\"},{\\\"ID\\\":15,\\\"Name\\\":\\\"Cough\\\"},{\\\"ID\\\":207,\\\"Name\\\":\\\"Dizziness\\\"},{\\\"ID\\\":244,\\\"Name\\\":\\\"Drooping eyelid\\\"},{\\\"ID\\\":273,\\\"Name\\\":\\\"Dry eyes\\\"},{\\\"ID\\\":87,\\\"Name\\\":\\\"Earache\\\"},{\\\"ID\\\":92,\\\"Name\\\":\\\"Early satiety\\\"},{\\\"ID\\\":287,\\\"Name\\\":\\\"Eye pain\\\"},{\\\"ID\\\":33,\\\"Name\\\":\\\"Eye redness\\\"},{\\\"ID\\\":153,\\\"Name\\\":\\\"Fast, deepened breathing\\\"},{\\\"ID\\\":76,\\\"Name\\\":\\\"Feeling of foreign body in the eye\\\"},{\\\"ID\\\":11,\\\"Name\\\":\\\"Fever\\\"},{\\\"ID\\\":57,\\\"Name\\\":\\\"Going black before the eyes\\\"},{\\\"ID\\\":9,\\\"Name\\\":\\\"Headache\\\"},{\\\"ID\\\":45,\\\"Name\\\":\\\"Heartburn\\\"},{\\\"ID\\\":122,\\\"Name\\\":\\\"Hiccups\\\"},{\\\"ID\\\":149,\\\"Name\\\":\\\"Hot flushes\\\"},{\\\"ID\\\":40,\\\"Name\\\":\\\"Increased thirst\\\"},{\\\"ID\\\":73,\\\"Name\\\":\\\"Itching eyes\\\"},{\\\"ID\\\":96,\\\"Name\\\":\\\"Itching in the nose\\\"},{\\\"ID\\\":35,\\\"Name\\\":\\\"Lip swelling\\\"},{\\\"ID\\\":235,\\\"Name\\\":\\\"Memory gap\\\"},{\\\"ID\\\":112,\\\"Name\\\":\\\"Menstruation disorder\\\"},{\\\"ID\\\":123,\\\"Name\\\":\\\"Missed period\\\"},{\\\"ID\\\":44,\\\"Name\\\":\\\"Nausea\\\"},{\\\"ID\\\":136,\\\"Name\\\":\\\"Neck pain\\\"},{\\\"ID\\\":114,\\\"Name\\\":\\\"Nervousness\\\"},{\\\"ID\\\":133,\\\"Name\\\":\\\"Night cough\\\"},{\\\"ID\\\":12,\\\"Name\\\":\\\"Pain in the limbs\\\"},{\\\"ID\\\":203,\\\"Name\\\":\\\"Pain on swallowing\\\"},{\\\"ID\\\":37,\\\"Name\\\":\\\"Palpitations\\\"},{\\\"ID\\\":140,\\\"Name\\\":\\\"Paralysis\\\"},{\\\"ID\\\":54,\\\"Name\\\":\\\"Reduced appetite\\\"},{\\\"ID\\\":14,\\\"Name\\\":\\\"Runny nose\\\"},{\\\"ID\\\":29,\\\"Name\\\":\\\"Shortness of breath\\\"},{\\\"ID\\\":124,\\\"Name\\\":\\\"Skin rash\\\"},{\\\"ID\\\":52,\\\"Name\\\":\\\"Sleeplessness\\\"},{\\\"ID\\\":95,\\\"Name\\\":\\\"Sneezing\\\"},{\\\"ID\\\":13,\\\"Name\\\":\\\"Sore throat\\\"},{\\\"ID\\\":64,\\\"Name\\\":\\\"Sputum\\\"},{\\\"ID\\\":179,\\\"Name\\\":\\\"Stomach burning\\\"},{\\\"ID\\\":28,\\\"Name\\\":\\\"Stuffy nose\\\"},{\\\"ID\\\":138,\\\"Name\\\":\\\"Sweating\\\"},{\\\"ID\\\":248,\\\"Name\\\":\\\"Swollen glands in the armpits\\\"},{\\\"ID\\\":169,\\\"Name\\\":\\\"Swollen glands on the neck\\\"},{\\\"ID\\\":211,\\\"Name\\\":\\\"Tears\\\"},{\\\"ID\\\":16,\\\"Name\\\":\\\"Tiredness\\\"},{\\\"ID\\\":115,\\\"Name\\\":\\\"Tremor at rest\\\"},{\\\"ID\\\":144,\\\"Name\\\":\\\"Unconsciousness, short\\\"},{\\\"ID\\\":101,\\\"Name\\\":\\\"Vomiting\\\"},{\\\"ID\\\":181,\\\"Name\\\":\\\"Vomiting blood\\\"},{\\\"ID\\\":56,\\\"Name\\\":\\\"weakness\\\"},{\\\"ID\\\":23,\\\"Name\\\":\\\"Weight gain\\\"},{\\\"ID\\\":30,\\\"Name\\\":\\\"Wheezing\\\"}]";
        //List<Symptom> symptoms = mapper.readValue(response, new TypeReference<List<Symptom>>(){});

        //Symptoms symptoms = mapper.readValue(response, Symptoms.class);

        Demographic demographic = mapper.readValue(response, Demographic.class);

        //sertEquals("Abdominal pain", symptoms.get(0).getName());
        assertEquals("POPCY", demographic.getThemes().getPopulationTheme().getIndividualValueVariable().get(0).getName());
    }

}
