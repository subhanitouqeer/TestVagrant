package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RunWith(SerenityRunner.class)
public class BaseStepDefinition {
    public JSONObject response;
    public static final Logger logger = LoggerFactory.getLogger(BaseStepDefinition.class);

    @Given("^The response is read from the JSON file for further validations$")
    public void testSetUpToReadFromJSONFile() throws IOException {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\dataFiles\\sampleResponse.json";
        String data = new String(Files.readAllBytes(Paths.get(filePath)));

        response = new JSONObject(data);
    }

    @Given("^The user validates the team has only \"(.*?)\" foreign players$")
    public void theUserValidatesTheTeamHasOnlyForeignPlayers(int numberOfForeignPlayers) {
        int count = 0;
        JSONArray players = (JSONArray) response.get("player");
        for (int i = 0; i < players.length(); i++) {
            JSONObject object = (JSONObject) players.get(i);
            String country = object.get("country").toString();
            if(!country.equalsIgnoreCase("India"))
                count = count + 1;
        }
        if(count == numberOfForeignPlayers)
            logger.info("The team has the required number of foreign players :" + numberOfForeignPlayers);
        else{
            logger.info("Test Case failed as the number of foreign players is more than " + numberOfForeignPlayers);
            Assert.fail("The number of foreign players is more than " + numberOfForeignPlayers + " and hence Test Case is failed");
        }

    }

    @Then("^The user tries to verify that there is at least one \"(.*?)\" in the team$")
    public void theUserTriesToVerifyThatThereIsAtLeastOneInTheTeam(String roleInTeam) {
        JSONArray players = (JSONArray) response.get("player");
        for (int i = 0; i < players.length(); i++) {
            JSONObject object = (JSONObject) players.get(i);
            String role = object.get("role").toString();
            if (role.equalsIgnoreCase(roleInTeam)) {
                logger.info("Role of " + roleInTeam + " was found !");
                return;
            }
        }
        logger.info("Test Case failed since the role of " + roleInTeam + " was not found");
        Assert.fail("The role of " + roleInTeam + " was not found");
    }
}
