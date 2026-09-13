package com.gmail.alexei28.shortcut.algorithms.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ExcelSheetColumnTitleTest {

    private ExcelSheetColumnTitle solution;

    @BeforeEach
    void setUp() {
        solution = new ExcelSheetColumnTitle();
    }

    @Test
    @DisplayName("Should convert single-letter column number (1 -> A)")
    void convertToTitle_singleLetter_returnsCorrectTitle() {
        // Arrange
        int columnNumber = 1;

        // Act
        String result = solution.convertToTitle(columnNumber);

        // Assert
        assertThat(result).isEqualTo("A");
    }

    @Test
    @DisplayName("Should convert boundary single-letter column number (26 -> Z)")
    void convertToTitle_boundarySingleLetter_returnsCorrectTitle() {
        // Arrange
        int columnNumber = 26;

        // Act
        String result = solution.convertToTitle(columnNumber);

        // Assert
        assertThat(result).isEqualTo("Z");
    }

    @Test
    @DisplayName("Should convert two-letter column number (28 -> AB)")
    void convertToTitle_twoLetters_returnsCorrectTitle() {
        // Arrange
        int columnNumber = 28;

        // Act
        String result = solution.convertToTitle(columnNumber);

        // Assert
        assertThat(result).isEqualTo("AB");
    }

    @Test
    @DisplayName("Should convert two-letter column ending with Z (701 -> ZY)")
    void convertToTitle_twoLettersEndingWithY_returnsCorrectTitle() {
        // Arrange
        int columnNumber = 701;

        // Act
        String result = solution.convertToTitle(columnNumber);

        // Assert
        assertThat(result).isEqualTo("ZY");
    }

    @Test
    @DisplayName("Should convert two-letter boundary column (702 -> ZZ)")
    void convertToTitle_twoLettersBoundary_returnsCorrectTitle() {
        // Arrange
        int columnNumber = 702;

        // Act
        String result = solution.convertToTitle(columnNumber);

        // Assert
        assertThat(result).isEqualTo("ZZ");
    }

    @Test
    @DisplayName("Should convert three-letter starting column (703 -> AAA)")
    void convertToTitle_threeLettersStart_returnsCorrectTitle() {
        // Arrange
        int columnNumber = 703;

        // Act
        String result = solution.convertToTitle(columnNumber);

        // Assert
        assertThat(result).isEqualTo("AAA");
    }

    @ParameterizedTest(name = "Column {0} should return \"{1}\"")
    @CsvSource({
            "1, A",
            "2, B",
            "26, Z",
            "27, AA",
            "28, AB",
            "701, ZY",
            "702, ZZ",
            "703, AAA",
            "2147483647, FXSHRXW"
    })
    @DisplayName("Parameterized verification for multiple Excel column numbers")
    void convertToTitle_parameterized_returnsExpectedTitle(int columnNumber, String expected) {
        // Arrange (handled by @CsvSource parameters)

        // Act
        String result = solution.convertToTitle(columnNumber);

        // Assert
        assertThat(result).isEqualTo(expected);
    }
}