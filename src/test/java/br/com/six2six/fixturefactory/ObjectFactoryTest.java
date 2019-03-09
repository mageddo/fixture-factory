package br.com.six2six.fixturefactory;

import br.com.six2six.fixturefactory.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.Answer;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ObjectFactoryTest {

	private TemplateHolder templateHolder;
	private ObjectFactory objectFactory;
	
	@Before
	public void setUp() {
		templateHolder = mockTemplateHolder();
		objectFactory = new ObjectFactory(templateHolder);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionForGimmeWithQuantityAndWrongNumberOfTemplates() {
		objectFactory.gimme(3, Arrays.asList("template1", "template2"));
	}
	
	//hack to workaround Mockito error when trying to return a Class<?>
	private TemplateHolder mockTemplateHolder() {
		TemplateHolder templateHolder = mock(TemplateHolder.class);
		final Class<?> clazz = User.class;
		when(templateHolder.getClazz()).thenAnswer((Answer<Class<?>>) invocation -> clazz);
		return templateHolder;
	}
	
}
