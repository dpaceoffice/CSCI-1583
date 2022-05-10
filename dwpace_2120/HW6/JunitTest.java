import static org.junit.Assert.*;
import org.junit.*;

public class JunitTest {
	
	LinkedList<Dog> myDogList;

	@Before
	public void setupLinkedList() {
		Dog fifi = new Dog("Fifi", 12, 8);
        Dog butch = new Dog("Butch", 10, 10);
        Dog leonard = new Dog("Leonard", 22, 13);
        Dog spot = new Dog("Spot", 17, 9);

        myDogList = new LinkedList<Dog>();
        
        myDogList.add(fifi);
        myDogList.add(butch);
        myDogList.add(leonard);
        myDogList.add(spot);
	}
	
	@Test
	public void addToEnd() {
		Dog dexter = new Dog("dexter", 100, 100);
		myDogList.add(dexter, 4);
		Dog dog = myDogList.get(4);
		assertEquals(dexter, dog);
	}
	
	@Test
	public void addToBeginning() {
		Dog dexter = new Dog("dexter", 100, 100);
		myDogList.add(dexter, 0);
		Dog dog = myDogList.get(0);
		assertEquals(dexter, dog);
	}
	
	@Test
	public void addToMiddle() {
		Dog dexter = new Dog("dexter", 100, 100);
		myDogList.add(dexter, 2);
		Dog dog = myDogList.get(2);
		assertEquals(dexter, dog);
	}
	
	@Test
	public void testContains() {
		Dog dexter = new Dog("dexter", 100, 100);
		myDogList.add(dexter);
		assertTrue(myDogList.contains(dexter));
	}
	
	@Test
	public void testIteratorAt() {
		Dog dexter = new Dog("dexter", 100, 100);
		myDogList.add(dexter);
		assertTrue(myDogList.iteratorAt(dexter) != null);
	}
	
	@Test
	public void testIndexOf() {
		Dog dexter = new Dog("dexter", 100, 100);
		myDogList.add(dexter, 3);
		int io = myDogList.indexOf(dexter);
		assertEquals(io, 3);
	}
	
	@Test
	public void testIterator() {
		Iterator<Dog> it = myDogList.getIterator();
        it.setToEnd();
        int index = 0;
        while (it.hasPrior()) {
            Dog dog = it.prior();
            if(index == 0)
            	assertTrue(dog.getName().equals("Spot"));
            else if(index == 1)
            	assertTrue(dog.getName().equals("Leonard"));
            else if(index == 2)
            	assertTrue(dog.getName().equals("Butch"));
            else if(index == 3)
            	assertTrue(dog.getName().equals("Fifi"));
            index ++;
        }
	}

}
