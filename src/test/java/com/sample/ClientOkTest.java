package com.sample;

import org.jsmart.zerocode.core.domain.Scenario;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("servers/server.properties")
@RunWith(ZeroCodeUnitRunner.class)
public class ClientOkTest {
    @Test
    @Scenario("example/test_client_ok.json")
    public void testClientOk() {
        // run test with scenario steps in JSON
    }
}