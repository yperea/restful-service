package com.movieglu;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoviegluTest {

    @Test
    public void testGetMovies() throws IOException {

        Client client = ClientBuilder.newClient();
        String uri = "https://sandbox-healthservice.priaid.ch/symptoms";
        String token = "?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Inllc2lkLnBlcmVhQG91dGxvb2suY29tIiwicm9sZSI6IlVzZXIiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9zaWQiOiI0MTU5IiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy92ZXJzaW9uIjoiMjAwIiwiaHR0cDovL2V4YW1wbGUub3JnL2NsYWltcy9saW1pdCI6Ijk5OTk5OTk5OSIsImh0dHA6Ly9leGFtcGxlLm9yZy9jbGFpbXMvbWVtYmVyc2hpcCI6IlByZW1pdW0iLCJodHRwOi8vZXhhbXBsZS5vcmcvY2xhaW1zL2xhbmd1YWdlIjoiZW4tZ2IiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL2V4cGlyYXRpb24iOiIyMDk5LTEyLTMxIiwiaHR0cDovL2V4YW1wbGUub3JnL2NsYWltcy9tZW1iZXJzaGlwc3RhcnQiOiIyMDE4LTEwLTMxIiwiaXNzIjoiaHR0cHM6Ly9zYW5kYm94LWF1dGhzZXJ2aWNlLnByaWFpZC5jaCIsImF1ZCI6Imh0dHBzOi8vaGVhbHRoc2VydmljZS5wcmlhaWQuY2giLCJleHAiOjE1NDA5NTc3NjgsIm5iZiI6MTU0MDk1MDU2OH0.MSnwP0us8vljcbCuDU6hjox7QLBQn6_x9b0ULZZQYMs";
        String format = "&format=json";
        String language ="&language=en-gb";



        GET https://api-gate2.movieglu.com/filmsNowShowing/?n=10 HTTP/1.1
        Accept-Encoding: gzip,deflate
        Authorization: Basic TUFUQzpUdXdGUjkwanVSaTA=
                x-api-key: B0OPHicdT3atCMyqTYFHc9ZfK8VtP4N7afh6LHZ3
        client: MATC
        territory: US
        api-version: v200
        device-datetime: 2018-10-31T16:45:30.147Z
        geolocation: 43.0873315,-89.261245
        Host: api-gate2.movieglu.com
        Connection: Keep-Alive
        User-Agent: Apache-HttpClient/4.1.1 (java 1.5)



        WebTarget target = client.target(uri + token + format + language);

        target.

        String response = target.request(MediaType.APPLICATION_JSON).get(String.class).trim().replaceFirst("\ufeff", "");

        ObjectMapper mapper = new ObjectMapper();

        String jason = "[{\\\"ID\\\":10,\\\"Name\\\":\\\"Abdominal pain\\\"},{\\\"ID\\\":238,\\\"Name\\\":\\\"Anxiety\\\"},{\\\"ID\\\":104,\\\"Name\\\":\\\"Back pain\\\"},{\\\"ID\\\":75,\\\"Name\\\":\\\"Burning eyes\\\"},{\\\"ID\\\":46,\\\"Name\\\":\\\"Burning in the throat\\\"},{\\\"ID\\\":170,\\\"Name\\\":\\\"Cheek swelling\\\"},{\\\"ID\\\":17,\\\"Name\\\":\\\"Chest pain\\\"},{\\\"ID\\\":31,\\\"Name\\\":\\\"Chest tightness\\\"},{\\\"ID\\\":175,\\\"Name\\\":\\\"Chills\\\"},{\\\"ID\\\":139,\\\"Name\\\":\\\"Cold sweats\\\"},{\\\"ID\\\":15,\\\"Name\\\":\\\"Cough\\\"},{\\\"ID\\\":207,\\\"Name\\\":\\\"Dizziness\\\"},{\\\"ID\\\":244,\\\"Name\\\":\\\"Drooping eyelid\\\"},{\\\"ID\\\":273,\\\"Name\\\":\\\"Dry eyes\\\"},{\\\"ID\\\":87,\\\"Name\\\":\\\"Earache\\\"},{\\\"ID\\\":92,\\\"Name\\\":\\\"Early satiety\\\"},{\\\"ID\\\":287,\\\"Name\\\":\\\"Eye pain\\\"},{\\\"ID\\\":33,\\\"Name\\\":\\\"Eye redness\\\"},{\\\"ID\\\":153,\\\"Name\\\":\\\"Fast, deepened breathing\\\"},{\\\"ID\\\":76,\\\"Name\\\":\\\"Feeling of foreign body in the eye\\\"},{\\\"ID\\\":11,\\\"Name\\\":\\\"Fever\\\"},{\\\"ID\\\":57,\\\"Name\\\":\\\"Going black before the eyes\\\"},{\\\"ID\\\":9,\\\"Name\\\":\\\"Headache\\\"},{\\\"ID\\\":45,\\\"Name\\\":\\\"Heartburn\\\"},{\\\"ID\\\":122,\\\"Name\\\":\\\"Hiccups\\\"},{\\\"ID\\\":149,\\\"Name\\\":\\\"Hot flushes\\\"},{\\\"ID\\\":40,\\\"Name\\\":\\\"Increased thirst\\\"},{\\\"ID\\\":73,\\\"Name\\\":\\\"Itching eyes\\\"},{\\\"ID\\\":96,\\\"Name\\\":\\\"Itching in the nose\\\"},{\\\"ID\\\":35,\\\"Name\\\":\\\"Lip swelling\\\"},{\\\"ID\\\":235,\\\"Name\\\":\\\"Memory gap\\\"},{\\\"ID\\\":112,\\\"Name\\\":\\\"Menstruation disorder\\\"},{\\\"ID\\\":123,\\\"Name\\\":\\\"Missed period\\\"},{\\\"ID\\\":44,\\\"Name\\\":\\\"Nausea\\\"},{\\\"ID\\\":136,\\\"Name\\\":\\\"Neck pain\\\"},{\\\"ID\\\":114,\\\"Name\\\":\\\"Nervousness\\\"},{\\\"ID\\\":133,\\\"Name\\\":\\\"Night cough\\\"},{\\\"ID\\\":12,\\\"Name\\\":\\\"Pain in the limbs\\\"},{\\\"ID\\\":203,\\\"Name\\\":\\\"Pain on swallowing\\\"},{\\\"ID\\\":37,\\\"Name\\\":\\\"Palpitations\\\"},{\\\"ID\\\":140,\\\"Name\\\":\\\"Paralysis\\\"},{\\\"ID\\\":54,\\\"Name\\\":\\\"Reduced appetite\\\"},{\\\"ID\\\":14,\\\"Name\\\":\\\"Runny nose\\\"},{\\\"ID\\\":29,\\\"Name\\\":\\\"Shortness of breath\\\"},{\\\"ID\\\":124,\\\"Name\\\":\\\"Skin rash\\\"},{\\\"ID\\\":52,\\\"Name\\\":\\\"Sleeplessness\\\"},{\\\"ID\\\":95,\\\"Name\\\":\\\"Sneezing\\\"},{\\\"ID\\\":13,\\\"Name\\\":\\\"Sore throat\\\"},{\\\"ID\\\":64,\\\"Name\\\":\\\"Sputum\\\"},{\\\"ID\\\":179,\\\"Name\\\":\\\"Stomach burning\\\"},{\\\"ID\\\":28,\\\"Name\\\":\\\"Stuffy nose\\\"},{\\\"ID\\\":138,\\\"Name\\\":\\\"Sweating\\\"},{\\\"ID\\\":248,\\\"Name\\\":\\\"Swollen glands in the armpits\\\"},{\\\"ID\\\":169,\\\"Name\\\":\\\"Swollen glands on the neck\\\"},{\\\"ID\\\":211,\\\"Name\\\":\\\"Tears\\\"},{\\\"ID\\\":16,\\\"Name\\\":\\\"Tiredness\\\"},{\\\"ID\\\":115,\\\"Name\\\":\\\"Tremor at rest\\\"},{\\\"ID\\\":144,\\\"Name\\\":\\\"Unconsciousness, short\\\"},{\\\"ID\\\":101,\\\"Name\\\":\\\"Vomiting\\\"},{\\\"ID\\\":181,\\\"Name\\\":\\\"Vomiting blood\\\"},{\\\"ID\\\":56,\\\"Name\\\":\\\"weakness\\\"},{\\\"ID\\\":23,\\\"Name\\\":\\\"Weight gain\\\"},{\\\"ID\\\":30,\\\"Name\\\":\\\"Wheezing\\\"}]";
        List<Symptom> symptoms = mapper.readValue(response, new TypeReference<List<Symptom>>(){});

        //Symptoms symptoms = mapper.readValue(response, Symptoms.class);

        assertEquals("Abdominal pain", symptoms.get(0).getName());
    }

}
