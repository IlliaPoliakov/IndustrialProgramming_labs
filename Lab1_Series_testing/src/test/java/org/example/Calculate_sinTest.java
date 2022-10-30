package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Calculate_sinTest {
    @Test
    void SinOfZeroShouldEqualToZero(){
        var sin_ = new Calculate_sin();
        assertEquals(0, sin_.calculate_sin_of_x(0));
    }

    @Test
    void SinOfPiOverTwoShouldEqualOne(){
        var sin_ = new Calculate_sin();
        assertEquals(0.82687954053, sin_.calculate_sin_of_x(1000));


    }



    @Test
    void SinOfSixShouldNotEqualFive(){
        var sin_ = new Calculate_sin();
        assertNotEquals(5, sin_.calculate_sin_of_x(6));
    }

}