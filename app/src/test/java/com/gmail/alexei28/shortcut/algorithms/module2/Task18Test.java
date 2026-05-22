package com.gmail.alexei28.shortcut.algorithms.module2;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task18Test {

    private final Task18 task = new Task18();

    @Test
    void example_case_3_rows() {
        String result = task.convert("PAYPALISHIRING", 3);
        assertThat(result).isEqualTo("PAHNAPLSIIGYIR");
    }

    @Test
    void example_case_4_rows() {
        String result = task.convert("PAYPALISHIRING", 4);
        assertThat(result).isEqualTo("PINALSIGYAHRPI");
    }

    @Test
    void single_row_should_return_original_string() {
        String result = task.convert("ABCDEFG", 1);
        assertThat(result).isEqualTo("ABCDEFG");
    }

    @Test
    void numRows_greater_than_length() {
        String result = task.convert("ABC", 5);
        assertThat(result).isEqualTo("ABC");
    }

    @Test
    void two_rows_case() {
        String result = task.convert("PAYPALISHIRING", 2);
        assertThat(result).isEqualTo("PYAIHRNAPLSIIG");
    }

    @Test
    void empty_string() {
        String result = task.convert("", 3);
        assertThat(result).isEqualTo("");
    }

    @Test
    void null_safe_optional_behavior_if_supported() {
        // depending on implementation you may expect NPE or "".
        // adjust if your task requires explicit handling.
        String result = task.convert("", 1);
        assertThat(result).isEqualTo("");
    }
}