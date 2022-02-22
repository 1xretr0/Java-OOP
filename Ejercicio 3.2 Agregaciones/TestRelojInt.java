

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestRelojInt.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestRelojInt
{
    /**
     * Default constructor for test class TestRelojInt
     */
    RelojInternacional reloj;
    
    @Before
    public void setup()
    {

    }

   
    @Test
    public void testCase01()
    {
        reloj = new RelojInternacional(1,11,12);
        assertEquals(reloj.getGMT(), "1:11:12 AM");
    }
    
    @Test
    public void testCase02()
    {
        reloj = new RelojInternacional(1,11,12);
        assertEquals(reloj.getCST(), "7:11:12 PM");
    }
    
    @Test
    public void testCase03()
    {
        reloj = new RelojInternacional(1,11,12);
        assertEquals(reloj.getAST(), "9:11:12 PM");
    }
    
    @Test
    public void testCase04()
    {
        reloj = new RelojInternacional(1,11,12);
        assertEquals(reloj.getPST(), "5:11:12 PM");
    }
    
        @Test
    public void testCase05()
    {
        reloj = new RelojInternacional(1,11,12);
        assertEquals(reloj.getCET(), "2:11:12 AM");
    }
    
    @Test
    public void testCase06()
    {
        reloj = new RelojInternacional(1,11,12);
        reloj.setGMT(19,11,12);
        assertEquals(reloj.getGMT(), "7:11:12 PM");
    }
    
    @Test
    public void testCase07()
    {
        reloj = new RelojInternacional(1,11,12);
        reloj.setGMT(12,11,12);
        assertEquals(reloj.getCST(), "6:11:12 AM");
    }
    
    @Test
    public void testCase08()
    {
        reloj = new RelojInternacional(1,11,12);
        reloj.setGMT(12,11,12);
        assertEquals(reloj.getAST(), "8:11:12 AM");
    }
    
    @Test
    public void testCase09()
    {
        reloj = new RelojInternacional(1,11,12);
        reloj.setGMT(12,11,12);
        assertEquals(reloj.getPST(), "4:11:12 AM");
    }
    
        @Test
    public void testCase10()
    {
        reloj = new RelojInternacional(1,11,12);
        reloj.setGMT(12,11,12);
        assertEquals(reloj.getCET(), "1:11:12 PM");
    }
    
        @Test
    public void testCase11()
    {
        reloj = new RelojInternacional(18,40,00);
        assertEquals(reloj.toString(), "GMT 6:40:00 PM, CST 12:40:00 PM, AST 2:40:00 PM, PST 10:40:00 AM, CET 7:40:00 PM");
    }
}
