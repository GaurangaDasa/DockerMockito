import static org.junit.Assert.*;
import junit.framework.TestCase;
import model.Person;
import org.junit.*;

public class PersonTest {
	
	Person person;
	
	@Before
	public void setUp() {
		person = new Person("gaurang",1991);
	}
	
	
	@Test
	public void testGetFirstName() {
		String fn = person.getFirstName();
		assertEquals("gaurang",fn);		
	}
	
	@Test
	public void testSetFirstName() {
		person.setFirstName("gaurang rathod");
		assertEquals("gaurang rathod",person.getFirstName());
	}
	
	@Test
	public void testGetYob() {
		int y = person.getYob();
		assertEquals(1991,y);
	}
	
	@Test
	public void testSetYob() {
		person = new Person();
		person.setYob(1992);
		assertEquals(1992,person.getYob());
	}
	
	
}
