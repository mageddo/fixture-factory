package br.com.six2six.fixturefactory;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import br.com.six2six.fixturefactory.model.User;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static br.com.six2six.fixturefactory.Fixture.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class FixtureUserTest {

	@BeforeClass
	public static void setUp() {
		FixtureFactoryLoader.loadTemplates("br.com.six2six.template");
	}

	@Test
	public void fixtureAnyUser() {
		User user = from(User.class).gimme("anyValidUser");
		assertNotNull("User should not be null", user);
	}

	@Test
	public void fixtureFemaleUser() {
		User user = from(User.class).gimme("validFemaleUser");
		assertNotNull("User should not be null", user);
	}

	@Test
	public void fixtureValidWithRulesOutOfOrder() {
		User user = from(User.class).gimme("validWithRulesOutOfOrder");
		assertNotNull("User should not be null", user);
		assertThat(user.getName(), is(equalTo(user.getLogin())));
		assertThat(user.getEmail(), containsString(user.getLogin()));
	}

	/**
	 * This will also be useful to work with java 11 var statement
	 */
	@Test
	public void shouldInferListType() {
		validate(Arrays.asList(from(User.class).gimme("validFemaleUser")));
	}

	private void validate(List<User> users) {}

}
