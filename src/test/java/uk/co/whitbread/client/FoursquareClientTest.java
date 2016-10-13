package uk.co.whitbread.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;
import uk.co.whitbread.model.foursquare.Response;
import uk.co.whitbread.model.foursquare.VenuesExploreResponse;
import uk.co.whitbread.utils.UrlBuilder;

import java.util.Collections;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FoursquareClientTest {

    private FoursquareClient sut;

    @Mock
    private UrlBuilder mockUrlBuilder;

    @Mock
    private RestTemplate mockRestTemplate;

    @Mock
    private VenuesExploreResponse mockVenuesResponse;

    @Mock
    private Response mockResponse;

    @Test
    public void shouldCallRemoteService() throws Exception {
        //Given
        when(mockUrlBuilder.buildUrl(anyString())).thenReturn("url");
        when(mockResponse.getGroups()).thenReturn(Collections.emptyList());
        when(mockVenuesResponse.getResponse()).thenReturn(mockResponse);
        when(mockRestTemplate.getForObject(anyString(), any())).thenReturn(mockVenuesResponse);
        sut = new FoursquareClient(mockUrlBuilder, mockRestTemplate);
        String location = "location";

        //When
        sut.getRecommendedLocationFor(location);

        //Then
        verify(mockUrlBuilder).buildUrl(location);
        verify(mockRestTemplate).getForObject("url", VenuesExploreResponse.class);
    }

}