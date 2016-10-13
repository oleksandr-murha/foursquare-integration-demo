package uk.co.whitbread.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.StringContains.containsString;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VenuesExploreControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldDisplayEmptyTableIfNoLocationProvided() throws Exception {
        //When
        String html = this.restTemplate.getForObject("/explore.html", String.class);
        int rowsInTable = StringUtils.countOccurrencesOf(html, "<td>");

        //Then
        assertThat(html, containsString("Please type location into search box"));
        assertThat(rowsInTable, is(0));

    }

    @Test
    public void shouldDisplayRecommendedPlacesAroundProvidedLocation() throws Exception {
        //Given
        String location = "Kings Cross";

        //When
        String html = this.restTemplate.getForObject("/explore.html?location="+location, String.class);
        int rowsInTable = StringUtils.countOccurrencesOf(html, "<td>");

        //Then
        assertThat(html, containsString("Recommended locations around Kings Cross!"));
        assertThat(rowsInTable, is(greaterThan(0)));
    }
}