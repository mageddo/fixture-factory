package br.com.six2six.fixturefactory;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JavaVersionTest {

	@Test
	public void java6(){

		// arrange

		// act
		final JavaVersion javaVersion = new JavaVersion("1.6");

		// assert
		assertEquals(1, javaVersion.getMajor());
		assertEquals(6, javaVersion.getMinor());
	}

	@Test
	public void java11(){

		// arrange

		// act
		final JavaVersion javaVersion = new JavaVersion("11.0.1");

		// assert
		assertEquals(11, javaVersion.getMajor());
		assertEquals(0, javaVersion.getMinor());
	}

	@Test
	public void java12EarlierAccess(){

		// arrange

		// act
		final JavaVersion javaVersion = new JavaVersion("12-ea");

		// assert
		assertEquals(12, javaVersion.getMajor());
		assertEquals(0, javaVersion.getMinor());
	}

}
