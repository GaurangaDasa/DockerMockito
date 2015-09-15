

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import control.GreetingServlet;


@RunWith(MockitoJUnitRunner.class)
public class GreetingServletTest {

	@Mock
	HttpServletRequest stubHttpServletRequest;
	@Mock
	HttpServletResponse stubHttpServletResponse;
		
	StringWriter sw = new StringWriter();
	PrintWriter pw = new PrintWriter(sw);
	
	@InjectMocks
	GreetingServlet sut;
	
	
	@Test
	public void testDoGet() throws ServletException, IOException {
		
		//given
		willReturn(pw).given(stubHttpServletResponse).getWriter();
		//when(stubHttpServletResponse.getWriter()).thenReturn(pw);
		
		//when
		sut.doGet(stubHttpServletRequest,stubHttpServletResponse);
		
		//then
		String result = sw.getBuffer().toString().trim();
		System.out.println("result is "+result);
		assertEquals("hello user",result);
	}
}
