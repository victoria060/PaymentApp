package com.anaistroncoso.paymentapp;

import org.junit.Before;
import org.mockito.MockitoAnnotations;


public abstract class BaseTest {

  @Before public void setUp() {
    MockitoAnnotations.initMocks(this);
  }
}