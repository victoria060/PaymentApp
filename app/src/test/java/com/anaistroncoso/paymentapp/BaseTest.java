package com.anaistroncoso.paymentapp;

import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.robolectric.annotation.Config;


@Config(manifest = Config.NONE)
public abstract class BaseTest {
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
}