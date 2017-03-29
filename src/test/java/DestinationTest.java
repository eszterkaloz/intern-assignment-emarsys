import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


public class DestinationTest {
    private Destination z, w, v, y, u, x;
    private HolidayPlanner planner;

    @Before
    public void setUp() throws Exception {
        planner = new HolidayPlanner();
        z = new Destination("z");
        w = new Destination("w");
        v = new Destination("v");
        y = new Destination("y");
        u = new Destination("u");
        x = new Destination("x");
    }

    @Test
    public void planDestination_SingleInput_WithoutDependencies() throws Exception {
        Assert.assertEquals(Arrays.asList("x"), planner.planDestination(x));
    }

    @Test
    public void planDestination_MultipleInput_WithoutDependencies() throws Exception {
        Assert.assertEquals(Arrays.asList("z", "y", "x"), planner.planDestination(x, y, z));
    }

    @Test
    public void planDestination_MultipleInput_WithSingleDependency() throws Exception {
        z.setDependencies(Arrays.asList(y));
        Assert.assertEquals(Arrays.asList("z", "y", "x"), planner.planDestination(x, y, z));
    }

    @Test
    public void planDestination_MultipleInput_WithDependencies() throws Exception {
        z.setDependencies(Arrays.asList(y, w));
        w.setDependencies(Arrays.asList(v));
        v.setDependencies(Arrays.asList(y));
        u.setDependencies(Arrays.asList(x));

        Assert.assertEquals(Arrays.asList("u", "z", "w", "v", "y", "x"), planner.planDestination(x, y, z, u, v, w));
    }

    @Test
    public void planDestination_MultipleInput_WithDependencies_2() throws Exception {
        z.setDependencies(Arrays.asList(y, w));
        w.setDependencies(Arrays.asList(v));
        v.setDependencies(Arrays.asList(y));
        u.setDependencies(Arrays.asList(x));

        Assert.assertEquals(Arrays.asList("z", "w", "v", "y", "u", "x"), planner.planDestination(u, v, w, y, z, x));
    }

    @Test(expected = Exception.class)
    public void planDestination_MultipleInput_WithCyclicDependencies() throws Exception {
        x.setDependencies(Arrays.asList(y));
        y.setDependencies(Arrays.asList(z));
        z.setDependencies(Arrays.asList(x));

        planner.planDestination(x, y, z);
    }

    @After
    public void tearDown() throws Exception {
        z = null;
        w = null;
        v = null;
        y = null;
        u = null;
        x = null;
        planner = null;
    }
}