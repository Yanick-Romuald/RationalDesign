/*
The RationalNumberTest class is a unit test class for the RationalNumber class. It uses JUnit 5 for testing.
 */
package com.mycompany;

import com.mycompany.rationaldesign.RationalNumber;
import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Test class for RationalNumber.
 */
public class RationalNumberTest {
/*
    @BeforeAll
    public static void setUpClass() {
        // Code to run before all tests start
    }

    @AfterAll
    public static void tearDownClass() {
        // Code to run after all tests finish
    }

    @BeforeEach
    public void setUp() {
        // Code to run before each test
    }

    @AfterEach
    public void tearDown() {
        // Code to run after each test
    }
*/




/*
basic functionality:        This test checks if the addition of two RationalNumber instances is correct.
*/
    
        @BeforeEach
    public void setUp() {
        RationalNumber num1 = new RationalNumber(1, 2);       //  1/2
        RationalNumber num2 = new RationalNumber(1, 3);       //  1/3
        //RationalNumber onzero = new RationalNumber(2,0);    //  2/0
        RationalNumber autoNum=new RationalNumber();     //  1/0
        RationalNumber bigNum1=new RationalNumber(36,126);//  36/126
        RationalNumber bignum2=new RationalNumber(125);
    }
    
    
    
    
    
/*
basic functionality:        This test checks if the addition of two RationalNumber instances is correct.
*/      
    @Test                                           //GOOD
    public void testAdd() {
        RationalNumber r1 = new RationalNumber(1, 2);  // Suppose 1/2
        RationalNumber r2 = new RationalNumber(1, 3);  // Suppose 1/3
        RationalNumber expected = new RationalNumber(5, 6);
        RationalNumber result = RationalNumber.add(r1, r2);
        assertEquals(expected, result);  // Compare if 1/2 + 1
    }
    
    
    @Test                                           //basic functionality:        GOOD
    public void pgcdTest(){
        int a=28;
        int b=91;
        int expected=7;
        int result=RationalNumber.pgcd(a,b);
        assertEquals(expected,result);
    }
    
    
  /*      @Test(expected =   IllegalArgumentExeption.class)
    public void denominatoNulTest(){
        int a=28;
        int b=0;
        RationalNumber result= new RationalNumber(a,b);
    }*/
  @Test                                           //Java exceptions:        GOOD
    public void testDenominatorZeroException() {
        int a = 28;
        int b = 0;
        assertThrows(IllegalArgumentException.class, () -> new RationalNumber(a, b));
    }
    
    @Test                                           //Java exceptions:        GOOD
    public void testConstructorException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new RationalNumber(1, 0);
        });
        assertEquals("The denominator must not be 0!", exception.getMessage());
    }
    
    
    
    @Test                                           //GOOD
    public void testSimplify(){
        RationalNumber r=new RationalNumber(4,6);
        RationalNumber expected = new RationalNumber(2,3);
        RationalNumber result= new RationalNumber();
        result= RationalNumber.simplify(r);
        assertEquals(expected,result);
    }
    
    @Test                                           //Very GOOD
    public void testCompare(){
        RationalNumber r=new RationalNumber(1,2);
        RationalNumber s=new RationalNumber(2,4);
        boolean result = r.equals(s);
        boolean expected =true;
        assertEquals(result, expected);
        
        
    }

    // Additional test methods can be added here
    
    
    @ParameterizedTest                                           //parametrized unit tests:        Nice
    @MethodSource("additionProvider")
    public void testAdditionParametrized(RationalNumber a, RationalNumber b, RationalNumber expected) {
        RationalNumber result = RationalNumber.add(a, b);
        assertEquals(expected, result);
    }
/*@ParameterizedTest
@MethodSource("additionProvider")
public void testAdditionParametrized(RationalNumber a, RationalNumber b, RationalNumber expected) {
    RationalNumber result = RationalNumber.add(a, b);
    // Utiliser la méthode equals pour comparer les objets RationalNumber
    assertTrue(result.equals(expected));
}*/
    
    
    
    private static Collection<Object[]> additionProvider() {
        return Arrays.asList(new Object[][]{
            { new RationalNumber(1, 2), new RationalNumber(1, 2), new RationalNumber(1, 1) },
            { new RationalNumber(1, 3), new RationalNumber(2, 3), new RationalNumber(1, 1) },
            { new RationalNumber(1, 4), new RationalNumber(3, 4), new RationalNumber(1, 1) },
            { new RationalNumber(1, 2), new RationalNumber(1, 3), new RationalNumber(5, 6) }
        });
    }
}
