package com.gmail.alexei28.shortcut.algorithms.module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Task7Test {

    private Task7 task7;

    @BeforeEach
    void setUp() {
        task7 = new Task7();
    }

    @Test
    @DisplayName("Should remove trailing slash")
    void simplifyPath_WhenPathHasTrailingSlash_ShouldRemoveTrailingSlash() {
        // Arrange
        String path = "/home/";

        // Act
        String result = task7.simplifyPath(path);

        // Assert
        assertThat(result).isEqualTo("/home");
    }

    @Test
    @DisplayName("Should collapse multiple consecutive slashes")
    void simplifyPath_WhenPathHasMultipleSlashes_ShouldCollapseToSingleSlash() {
        // Arrange
        String path = "/home//foo/";

        // Act
        String result = task7.simplifyPath(path);

        // Assert
        assertThat(result).isEqualTo("/home/foo");
    }

    @Test
    @DisplayName("Should resolve parent directory navigation using double period")
    void simplifyPath_WhenPathContainsDoublePeriod_ShouldNavigateToParentDirectory() {
        // Arrange
        String path = "/home/user/Documents/../Pictures";

        // Act
        String result = task7.simplifyPath(path);

        // Assert
        assertThat(result).isEqualTo("/home/user/Pictures");
    }

    @Test
    @DisplayName("Should not navigate above root directory when extra double periods present")
    void simplifyPath_WhenDoublePeriodAtRoot_ShouldReturnRoot() {
        // Arrange
        String path = "/../";

        // Act
        String result = task7.simplifyPath(path);

        // Assert
        assertThat(result).isEqualTo("/");
    }

    @Test
    @DisplayName("Should treat triple periods and current directory dots as valid directory names")
    void simplifyPath_WhenPathContainsComplexPeriodsAndSlashes_ShouldSimplifyCorrectly() {
        // Arrange
        String path = "/.../a/../b/c/../d/./";

        // Act
        String result = task7.simplifyPath(path);

        // Assert
        assertThat(result).isEqualTo("/.../b/d");
    }

    @ParameterizedTest(name = "simplifyPath(\"{0}\") -> \"{1}\"")
    @CsvSource({
            "'/a/./b/../../c/', '/c'",
            "'/a/../../b/../c//.//', '/c'",
            "'/a//b//c──────/d', '/a/b/c──────/d'",
            "'/', '/'",
            "'/..../..../....', '/..../..../....'"
    })
    @DisplayName("Should handle additional edge cases correctly")
    void simplifyPath_ParameterizedEdgeCases(String inputPath, String expectedPath) {
        // Arrange
        // (Input provided by parameters)

        // Act
        String result = task7.simplifyPath(inputPath);

        // Assert
        assertThat(result).isEqualTo(expectedPath);
    }
}