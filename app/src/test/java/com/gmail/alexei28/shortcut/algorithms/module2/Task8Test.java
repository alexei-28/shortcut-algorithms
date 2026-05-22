package com.gmail.alexei28.shortcut.algorithms.module2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Task8Test {
    private Task8.LinkedList linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new Task8.LinkedList();
    }

    @Test
    @DisplayName("Should append elements correctly")
    void shouldAppendElements() {
        linkedList.append("A");
        linkedList.append("B");

        assertThat(toList(linkedList))
                .hasSize(2)
                .containsExactly("A", "B");
    }

    @Test
    @DisplayName("Should delete the head element (index 0)")
    void shouldDeleteHead() {
        linkedList.append("A");
        linkedList.append("B");
        linkedList.append("C");

        linkedList.deleteAtIndex(0);

        // assert
        List<String> actualList = toList(linkedList);
        assertThat(actualList)
                .containsExactly("B", "C")
                .doesNotContain("A");
    }

    @Test
    @DisplayName("Should delete an element in the middle")
    void shouldDeleteMiddleElement() {
        // arrange
        linkedList.append("A");
        linkedList.append("B");
        linkedList.append("C");

        // act
        linkedList.deleteAtIndex(1);

        // assert
        List<String> actualList = toList(linkedList);
        assertThat(actualList)
                .containsExactly("A", "C")
                .hasSize(2);
    }

    @Test
    @DisplayName("Should delete the last element")
    void shouldDeleteTail() {
        linkedList.append("A");
        linkedList.append("B");
        linkedList.append("C");

        linkedList.deleteAtIndex(2);

        assertThat(toList(linkedList))
                .containsExactly("A", "B")
                .hasSize(2);
    }

    @Test
    @DisplayName("Should handle out of bounds index gracefully")
    void shouldHandleOutOfBounds() {
        linkedList.append("A");

        // Deleting index that doesn't exist shouldn't crash
        linkedList.deleteAtIndex(5);
        linkedList.deleteAtIndex(-1);

        assertThat(toList(linkedList)).containsExactly("A");
    }


    @Test
    @DisplayName("Should not find index in empty list")
    void shouldNotFindIndexInEmptyList() {
        // act
        int actualIndex = linkedList.findIndex("A");

        // assert
        assertThat(actualIndex).isEqualTo(-1);
    }

    @Test
    @DisplayName("Should not find index of non exist element")
    void shouldNotFindIndex() {
        linkedList.append("A");
        linkedList.append("B");
        linkedList.append("C");

        // act
        int actualIndex = linkedList.findIndex("Z");

        // assert
        assertThat(actualIndex).isEqualTo(-1);
    }


    @Test
    @DisplayName("Should find index of head element (index 0)")
    void shouldFindHeadIndex() {
        linkedList.append("A");
        linkedList.append("B");
        linkedList.append("C");

        int actualIndex = linkedList.findIndex("A");

        // assert
        assertThat(actualIndex).isZero();
    }

    @Test
    @DisplayName("Should find index of element in the middle")
    void shouldFindMiddleElementIndex() {
        // arrange
        linkedList.append("A");
        linkedList.append("B");
        linkedList.append("C");

        // act
        int actualIndex = linkedList.findIndex("B");

        // assert
        assertThat(actualIndex).isEqualTo(1);
    }

    @Test
    @DisplayName("Should find index of last element")
    void shouldFindTailIndex() {
        linkedList.append("A");
        linkedList.append("B");
        linkedList.append("C");

        // act
        int actualIndex = linkedList.findIndex("C");

        // assert
        assertThat(actualIndex).isEqualTo(2);
    }

    /**
     * Helper method to convert the internal LinkedList state to a Java List
     * to facilitate AssertJ assertions.
     */
    private List<String> toList(Task8.LinkedList linkedList) {
        List<String> result = new ArrayList<>();
        // Note: Using reflection or a getter would be needed if head is strictly private.
        // For this test, we assume we can traverse it via a helper within the same package.
        try {
            var headField = Task8.LinkedList.class.getDeclaredField("head");
            headField.setAccessible(true);
            Object current = headField.get(linkedList);

            while (current != null) {
                var dataField = current.getClass().getDeclaredField("data");
                var nextField = current.getClass().getDeclaredField("next");
                dataField.setAccessible(true);
                nextField.setAccessible(true);

                result.add((String) dataField.get(current));
                current = nextField.get(current);
            }
        } catch (Exception e) {
            throw new RuntimeException("Could not access list nodes", e);
        }
        return result;
    }
}