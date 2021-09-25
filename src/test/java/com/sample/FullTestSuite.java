package com.sample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@SuiteClasses({ClientOkTest.class, ClientFalseTest.class})
@RunWith(Suite.class)
public class FullTestSuite {
}