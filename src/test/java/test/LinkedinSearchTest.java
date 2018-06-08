package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinSearchResults;

import java.util.List;

public class LinkedinSearchTest extends LinkedinBaseTest {

    @Test
    public void basicSearchTest(){
        String searchTerm ="HR";
        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login("postoltest@gmail.com","P@ssword123");
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "Login-Submit Page is not loaded");


        LinkedinSearchResults linkedinSearchResults = linkedinHomePage.search(searchTerm);
        Assert.assertTrue(linkedinSearchResults.isPageLoaded(),
                "SearchResults Page is not loaded.");

        List<String> searchResultsList = linkedinSearchResults.getSearchResults();
        Assert.assertEquals(searchResultsList.size(), 10, "Count of search result items is wrong.");

        for (String searchResult:searchResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "Searchterm"+searchTerm+"was not found in: \n"+searchResult);
        }


    }
}