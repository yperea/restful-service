package co.yperea.google.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.geocoder.ErrorMessage;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGoogleMapApi {

    @Test
    public void testGoogleApiJSON() throws IOException {
        Client client = ClientBuilder.newClient();
        String expectedMessage = "Keyless access to Google Maps Platform is deprecated. "
                               + "Please use an API key with all your API calls to avoid service interruption. "
                               + "For further details please refer to http://g.co/dev/maps-no-account";
        WebTarget target =
                client.target("http://maps.googleapis.com/maps/api/geocode/json?" +
                        "address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&sensor=false");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class).trim().replaceFirst("\ufeff", "");
        ObjectMapper mapper = new ObjectMapper();

        ErrorMessage  errorMessage = mapper.readValue(response, ErrorMessage.class);

        assertEquals(expectedMessage, errorMessage.getErrorMessage());
    }
}

