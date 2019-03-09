package br.com.six2six.fixturefactory;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import br.com.six2six.fixturefactory.model.User;
import org.junit.BeforeClass;
import org.junit.Test;

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
		User user = Fixture.from(User.class).gimme("anyValidUser");
		assertNotNull("User should not be null", user);
	}

	@Test
	public void fixtureFemaleUser() {
		User user = Fixture.from(User.class).gimme("validFemaleUser");
		assertNotNull("User should not be null", user);
	}

	@Test
	public void fixtureValidWithRulesOutOfOrder() {
		User user = Fixture.from(User.class).gimme("validWithRulesOutOfOrder");
		assertNotNull("User should not be null", user);
		assertThat(user.getName(), is(equalTo(user.getLogin())));
		assertThat(user.getEmail(), containsString(user.getLogin()));
	}

}
