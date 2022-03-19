import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DependencyTest {

    @Mock
    private SubDependency subDependency;

    private Dependency dependency;

    @Before
    public void setupMock() {
        subDependency = mock(SubDependency.class);
        dependency = new Dependency(subDependency);
    }

    @Test
    public void testDependency() {
        when(subDependency.getClassName()).thenReturn("hi there 2");

        assertEquals("hi there 2", dependency.getSubdepedencyClassName());
    }



}