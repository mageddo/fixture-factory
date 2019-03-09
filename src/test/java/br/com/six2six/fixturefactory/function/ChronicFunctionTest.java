package br.com.six2six.fixturefactory.function;

import br.com.six2six.fixturefactory.function.impl.ChronicFunction;
import com.mdimension.jchronic.Options;
import com.mdimension.jchronic.utils.Time;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Calendar;

public class ChronicFunctionTest {

	@Test
	public void testChronic() {
		ChronicFunction chronicFunction = new ChronicFunction("yesterday", new Options(Time.construct(2011, 10, 31, 14, 0, 0, 0)));
		Assert.assertEquals(Time.construct(2011, 10, 30, 12).getTime(), ((Calendar) chronicFunction.generateValue()).getTime());
	}

}
