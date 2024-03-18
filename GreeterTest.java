import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
// test the code
public class GreeterTest {

    @Test
    public void testThatGreeterReturnsTheCorrectGreeting() {
        assertThat(new Greeter().getGreeting()).isEqualTo("Hello, World!");
    }

}
