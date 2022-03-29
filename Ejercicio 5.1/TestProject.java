

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestProject.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestProject
{
    /**
     * Default constructor for test class TestProject
     */
    public TestProject()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testCase01()
    {
        Termino termino1 = new Termino(3, 2);
        assertEquals(75.0, termino1.evalua(5), 0.1);
    }

    @Test
    public void testCase02()
    {
        Termino termino1 = new Termino(3, 2);
        assertEquals("3.0x^2", termino1.toString());
    }

    @Test
    public void testCase03()
    {
        Termino termino1 = new Termino(3, 2);
        assertEquals(3.0, termino1.getCoeficiente(), 0.1);
    }

    @Test
    public void testCase04()
    {
        Polinomio polinomi1 = new Polinomio(3);
        Termino termino1 = new Termino(3, 2);
        polinomi1.agregaTermino(termino1);
        assertEquals(75.0, termino1.evalua(5), 0.1);
    }



    @Test
    public void testCase05()
    {
        Polinomio polinomi2 = new Polinomio(4);
        Termino termino2 = new Termino(2, 2);
        polinomi2.agregaTermino(termino2);
        assertEquals("y=+2.0x^2", polinomi2.toString());
    }

    @Test
    public void testCase06()
    {
        Polinomio polinomi1 = new Polinomio(4);
        Termino termino1 = new Termino(2, 2);
        Termino termino2 = new Termino(2, 1);
        polinomi1.agregaTermino(termino1);
        polinomi1.agregaTermino(termino2);
        assertEquals("y=+2.0x^2+2.0x^1", polinomi1.toString());
    }
}







