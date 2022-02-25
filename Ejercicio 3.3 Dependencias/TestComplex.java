
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestComplex.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestComplex
{
    /**
     * Default constructor for test class TestComplex
     */
    Complex complex1, complex2;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @Test
    public void testCase1()
    {
        complex1 = new Complex(3,5);
        assertEquals(complex1.toString(), "(3, 5i)");
    }
    
    @Test
    public void testCase2()
    {
        complex1 = new Complex(3,5);
        complex1.setReal(20);
        assertEquals(complex1.toString(), "(20, 5i)");
    }
    
    @Test
    public void testCase3()
    {
        complex1 = new Complex(3,5);
        complex2 = new Complex(9,-2);
        assertEquals(complex2.toString(), "(9, -2i)");
    }
    
    @Test
    public void testCase4()
    {
        complex1 = new Complex(3,5);
        complex2 = new Complex(9,-2);
        assertEquals(complex2.suma(complex1).toString(), "(12, 3i)");
    }
    
    @Test
    public void testCase5()
    {
        complex1 = new Complex(3,5);
        complex2 = new Complex(9,-2);
        assertEquals(complex1.suma(complex2).toString(), "(12, 3i)");
    }
    
    @Test
    public void testCase6()
    {
        complex1 = new Complex(3,5);
        complex2 = new Complex(9,-2);
        assertEquals(complex2.resta(complex1).toString(), "(6, -7i)");
    }
    
    @Test
    public void testCase7()
    {
        complex1 = new Complex(3,5);
        complex2 = new Complex(9,-2);
        assertEquals(complex1.resta(complex2).toString(), "(-6, 7i)");
    }
    
    @Test
    public void testCase8()
    {
        complex1 = new Complex(3,5);
        complex2 = new Complex(9,-2);
        complex1.resta(complex2);
        assertEquals(complex1.toString(), "(3, 5i)");
    }
    
    @Test
    public void testCase9()
    {
        complex1 = new Complex(3,5);
        assertEquals(complex1.resta(complex1).toString(), "(0, 0i)");
    }
    
    @Test
    public void testCase10()
    {
        complex1 = new Complex(3,5);
        assertEquals(complex1.suma(complex1).toString(), "(6, 10i)");
    }
}