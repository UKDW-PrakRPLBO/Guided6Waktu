package com.rplbo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */

    private static ByteArrayOutputStream outputStreamCaptor;

    @BeforeAll
    public static void init() {
        System.out.println("Awal");
    }

    @AfterAll
    public static void destory() {
        System.out.println("AKHIRRR");

    }

    @BeforeEach
    public void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    private static Stream<Arguments> inputWaktu() {
        return Stream.of(
                Arguments.of("10:59:59", new Waktu(10, 59, 59)),
                Arguments.of("15:59:59", new Waktu( new Waktu(15, 59, 59))),
                Arguments.of("15:0:0", new Waktu( 15))
        );
    }

    @ParameterizedTest
    @MethodSource("inputWaktu")
    public void testOutput(String expected, Waktu waktu) {
        waktu.tampilWaktu();
        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    private static Stream<Arguments> addSecond() {
        return Stream.of(
                Arguments.of("10:59:55", new Waktu(10, 59, 50), 5),
                Arguments.of("11:0:0", new Waktu(10, 59, 55), 5)
        );
    }

    @ParameterizedTest
    @MethodSource("addSecond")
    public void testAddSecond(String expected, Waktu initWaktu, int addWaktu) {
        initWaktu.tambahDetik(addWaktu);
        initWaktu.tampilWaktu();
        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    private static Stream<Arguments> addMenit() {
        return Stream.of(
                Arguments.of("11:0:50", new Waktu(10, 59, 50), 1),
                Arguments.of("0:4:55", new Waktu(23, 59, 55), 5)
        );
    }

    @ParameterizedTest
    @MethodSource("addMenit")
    public void testaddMenit(String expected, Waktu initWaktu, int addWaktu) {
        initWaktu.tambahMenit(addWaktu);
        initWaktu.tampilWaktu();
        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    private static Stream<Arguments> addJam() {
        return Stream.of(
                Arguments.of("11:59:50", new Waktu(10, 59, 50), 1),
                Arguments.of("0:59:55", new Waktu(23, 59, 55), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("addJam")
    public void testAddJam(String expected, Waktu initWaktu, int addWaktu) {
        initWaktu.tambahJam(addWaktu);
        initWaktu.tampilWaktu();
        assertEquals(expected, outputStreamCaptor.toString().trim());
    }
}
