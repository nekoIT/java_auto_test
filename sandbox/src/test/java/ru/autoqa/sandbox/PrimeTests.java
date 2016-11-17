package ru.autoqa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {
    @Test
    public void testPrime(){
        Assert.assertTrue(Primes.isPrimeFor(Integer.MAX_VALUE));
    }
    @Test
    public void testNonPrime(){
        Assert.assertFalse(Primes.isPrimeFor(Integer.MAX_VALUE-2));
    }

    @Test(enabled = false)
    public void testPrimeLong(){
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrimeFor(n));
    }

}
