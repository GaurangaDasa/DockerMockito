import model.Person;
import model.StorageService;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.*;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class StorageServiceTest {

	public List<Person> myList = new ArrayList<Person>();
	public Person myPerson = new Person("gaurang",1991);
	
	@Mock
	Person person;
	/*@Mock
	ArrayList<Person> db;*/
	
	@InjectMocks
	StorageService sut;
	
	@Test
	public void testGetAllPersons() {
		//given
	//	willCallRealMethod().given(db).add(new Person("name",1234));
	//	willCallRealMethod().given(db).toString();
	//	willAnswer(myProcessing()).given(sut.db).add(new Person("gaurang",1991));
		willReturn(person.firstName).given(person).getFirstName();
		willReturn(person.yob).given(person).getYob();
		willAnswer(new Answer() {

			public Object answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				String name = (String)invocation.getArguments()[0];
				person.firstName = name;
				return null;
			}
		}).given(person).setFirstName(anyString());
	//	System.out.println(list);
		
		willAnswer(new Answer() {

			public Object answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				int year = (Integer)invocation.getArguments()[0];
				person.yob= year;
				return null;
			}}).given(person).setYob(anyInt());
		
		
		
		
		//when
		sut.add(myPerson);
		
		
		
		
		//then
		System.out.println(sut.db.get(0).getFirstName());
		assertEquals("gaurang",sut.getAllPersons().get(0).getFirstName());
	}
}
