package com.github.yanzord.spacechallenge;

import com.github.yanzord.spacechallenge.exception.InvalidNumberException;
import com.github.yanzord.spacechallenge.service.SpaceUnitConverter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class SpaceUnitConverterTest {
    private SpaceUnitConverter spaceUnitConverter = new SpaceUnitConverter();

    @Test
    public void shouldProcessAnnotations() throws InvalidNumberException {
        List<String> expected = new ArrayList<>();
        expected.add("pish tegj glob glob is 42");
        expected.add("glob prok Silver is 68 Credits");
        expected.add("glob prok Gold is 57800 Credits");
        expected.add("glob prok Iron is 782 Credits");
        expected.add("I have no idea what you are talking about");

        List<String> actual = spaceUnitConverter.processAnnotations();

        assertEquals(expected, actual);
    }
}
