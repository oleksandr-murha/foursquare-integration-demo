package uk.co.whitbread.utils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.whitbread.properties.FoursquareProperties;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UrlBuilderTest {

    private UrlBuilder sut;

    @Mock
    private FoursquareProperties foursquareProperties;

    @Before
    public void setUp() throws Exception {
        when(foursquareProperties.getBaseUrl()).thenReturn("http://api.api.com/v2/explore?client_id=%s&client_secret=%s&near=%s&v=%s&m=%s");
        when(foursquareProperties.getClientId()).thenReturn("clientId");
        when(foursquareProperties.getClientSecret()).thenReturn("clientSecret");
        when(foursquareProperties.getMode()).thenReturn("mode");
        when(foursquareProperties.getVersion()).thenReturn("version");
        sut = new UrlBuilder(foursquareProperties);
    }

    @Test
    public void shouldBuildUrlForGivenLocation() throws Exception {
        //Given
        String location = "location";

        //When
        String url = sut.buildUrl(location);

        //Then
        assertThat(url, is(equalTo("http://api.api.com/v2/explore?client_id=clientId&client_secret=clientSecret&near=location&v=version&m=mode")));
    }
}
