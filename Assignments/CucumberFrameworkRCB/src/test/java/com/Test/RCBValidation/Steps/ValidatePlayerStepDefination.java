package com.Test.RCBValidation.Steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.testng.Assert;

import com.Test.RCBValitation.Utiles.Basic;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ValidatePlayerStepDefination {

	Basic basic = new Basic();
	List<String> country = new ArrayList<String>();
	List<String> role = new ArrayList<String>();

	@Given("A file in Json Fromat with players details")
	public void i_give_a_json_file_in() throws FileNotFoundException, IOException, ParseException {
		basic.ReadJson();
	}

	@When("I check the players country")
	public void i_check_the_players_country() {
		country = basic.getCountry();
	}

	@Then("there should be only {int} foreign player")
	public void there_should_be_only_foreign_player(Integer int1) {
		int cnt = 0;
		int excnt = int1;
		for (String c : country) {
			if (!c.equalsIgnoreCase("India")) {
				cnt++;
			}
		}
		Assert.assertEquals(cnt, excnt, "Team has more then 4 foriegn players");
	}

	@When("I check the players role")
	public void i_check_the_players_role() {
		role = basic.getRole();
	}

	@Then("there is atleast one wicketkeeper")
	public void there_atleast_one_wicketkeeper() {
		if (!role.contains("Wicket-keeper")) {
			Assert.fail("Team does not have a Wicket-Keeper");
		}
	}

}
