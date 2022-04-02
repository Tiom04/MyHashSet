package test;

import com.endava.internship.collections.MyHashSet;
import com.endava.internship.collections.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyHashSetTest {

    private MyHashSet<Integer> myHashSet;

    @BeforeAll
    public void initialize() {
        myHashSet = new MyHashSet();
    }

    @ParameterizedTest
    @ValueSource(ints = {12, 13, 14})
    public void addElementToSet_setContainsValueNotEmpty(int source) {
        myHashSet.add(source);
        assertThat(myHashSet).contains(source);
        assertThat(myHashSet).isNotEmpty();
    }

    @Test
    public void removeElementFromSet() {
        myHashSet.add(12);
        assertThat(myHashSet).contains(12);
        myHashSet.remove(12);
        assertFalse(myHashSet.contains(12));
    }

    @Test
    public void sizeReturnsCorrectValue() {
        int setSize = 5;
        assertThat(myHashSet).isEmpty();
        assertEquals(0, myHashSet.size());
        for (int i = 0; i < setSize; i++) {
            myHashSet.add(i);
        }
        assertEquals(myHashSet.size(), setSize);
    }

    @Test
    public void iteratorHasNextWithEmptySetShouldReturnFalse() {
        Iterator iterator = myHashSet.iterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void iteratorNextWithEmptySetShouldThrowException() {
        Iterator iterator = myHashSet.iterator();
        assertThrows(NoSuchElementException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void toArrayMethodShouldReturnAllElements_ReturnArraySizeShouldBeReal() {
        myHashSet.add(3);
        myHashSet.add(5);
        myHashSet.add(7);
        Object[] integers = myHashSet.toArray();
        assertTrue(myHashSet.containsAll(Arrays.asList(integers)));
        assertEquals(myHashSet.size(), integers.length);
    }

    @Test
    public void toArrayGenericMethodShouldCastCorrectly() {
        myHashSet.add(190);
        myHashSet.add(124);
        myHashSet.add(140);
        Integer[] integers = new Integer[3];//becomes null if size is smaller
        myHashSet.toArray(integers);
        assertThat(integers[0]).isInstanceOf(Integer.class);
        myHashSet.clear();//added not to affect other tests
    }

    @Test
    public void sizeOfSetAfterClearShouldBeZero() {
        myHashSet.add(28);
        myHashSet.add(34);
        myHashSet.add(39);
        myHashSet.add(60);
        assertTrue(myHashSet.size() == 4);
        myHashSet.clear();
        assertThat(myHashSet).isEmpty();
    }

    @Test
    public void addAllShouldReturnTrueIfSetModifiedElseFalse() {
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(36);
        integerSet.add(39);
        integerSet.add(38);
        myHashSet.add(36);
        assertTrue(myHashSet.addAll(integerSet));
        assertFalse(myHashSet.addAll(integerSet));
    }

    @Test
    public void containsAllShouldReturnTrueIfAllElementsCoincide() {
        Set<Integer> integers = new HashSet<>();
        integers.add(36);
        integers.add(39);
        integers.add(38);
        myHashSet.addAll(integers);
        assertTrue(myHashSet.containsAll(integers));
    }

    @Test
    public void retainAllShouldReturnTrueIfSetIsModified() {
        Set<Integer> integers = new HashSet<>();
        integers.add(36);
        integers.add(39);
        integers.add(38);
        myHashSet.clear();
        myHashSet.addAll(integers);
        assertFalse(myHashSet.retainAll(integers));
        myHashSet.add(32);
        myHashSet.add(65);
        assertTrue(myHashSet.retainAll(integers));
    }

    @Test
    public void removeAllShouldReturnTrueIfSetIsModidified() {
        Set<Integer> integers = new HashSet<>();
        integers.add(36);
        integers.add(39);
        integers.add(38);
        myHashSet.clear();
        myHashSet.addAll(integers);
        assertTrue(myHashSet.removeAll(integers));
        assertTrue(myHashSet.isEmpty());
    }
}
