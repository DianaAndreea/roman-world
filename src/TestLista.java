import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestLista {
    private ArrayList<String> mockedArray;

    @Before
    public void setUp() {
        mockedArray = new ArrayList<>();
        mockedArray.add("a");
        mockedArray.add("a");
        mockedArray.add("b");
        mockedArray.add("c");
        mockedArray.add("d");
        mockedArray.add("e");
        mockedArray.add("f");
        mockedArray.add("g");
        mockedArray.add("h");
        mockedArray.add("i");
    }

    @Test
    public void addTest(){
        mockedArray.add("asd");

        assertEquals(11, mockedArray.size());
    }
    @Test
    public void removeTest(){
        mockedArray.remove(5);

        assertEquals(9, mockedArray.size());
    }

	@SuppressWarnings("unchecked")
	@Test
	public void mockGetMethod(){
        mockedArray = mock(ArrayList.class);
		when(mockedArray.get(anyInt())).thenReturn("Metoda get() din clasa ArrayList a fost apelata");


		assertEquals("Metoda get() din clasa ArrayList a fost apelata", mockedArray.get(0));
	}
}
