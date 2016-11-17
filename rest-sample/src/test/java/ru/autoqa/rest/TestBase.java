package ru.autoqa.rest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;

import java.util.Objects;

public class TestBase {

    @BeforeClass
    public void init() {
        RestAssured.authentication = RestAssured.basic("LSGjeU4yP1X493ud1hNniA==", "");
    }

    boolean isIssueOpen(int issueId) {
        String json = RestAssured
                .given()
                .pathParam("issueId", issueId)
                .get("http://demo.bugify.com/api/issues/{issueId}.json")
                .asString();
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        JsonArray issues = jsonObject.get("issues").getAsJsonArray();
        JsonObject issue = issues.get(0).getAsJsonObject();
        return !Objects.equals(issue.get("state").getAsInt(), 3);
    }

    public void skipIfNotFixed(int issueId) {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }
}
