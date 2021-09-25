package com.sample;

import org.jsmart.zerocode.core.domain.Scenario;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("servers/server.properties")
@RunWith(ZeroCodeUnitRunner.class)
public class ClientFalseTest {
    @Test
    @Scenario("example/test_client_false.json")
    public void testClientFalse() {
        // run test with scenario steps in JSON
    }
}