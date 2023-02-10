package io.claiton;

import com.newrelic.api.agent.Trace;
import feign.Feign;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FeignClientTest {

    @Test
    @Trace(dispatcher = true)
    public void testEchoAPI() {
        EchoAPI api = Feign.builder().target(EchoAPI.class, "https://postman-echo.com");
        String response = api.echo("response body will be this");
        assert response.contains("response body will be this");
    }
}
