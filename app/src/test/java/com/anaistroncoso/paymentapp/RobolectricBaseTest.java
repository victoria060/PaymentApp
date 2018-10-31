package com.anaistroncoso.paymentapp;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public abstract class RobolectricBaseTest {
    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule();
}
