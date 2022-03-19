import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.*;

public class DependencyVerifyTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Dependency dependency;

    @Test
    public void testSimpleVerify(){
        verify(dependency, never()).getClassNameUpperCase();
        dependency.getClassNameUpperCase();

        verify(dependency, times(1)).getClassNameUpperCase();

        verify(dependency, atLeast(1)).getClassNameUpperCase();
        dependency.getClassNameUpperCase();

        verify(dependency, atMost(2)).getClassNameUpperCase();
    }

    @Test
    public void testParameters(){
        dependency.addTwo(3);

        verify(dependency, times(1)).addTwo(3);
        dependency.addTwo(4);

        verify(dependency, times(2)).addTwo((anyInt()));
    }
}
