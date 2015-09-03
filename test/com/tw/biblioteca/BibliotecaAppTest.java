package com.tw.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class BibliotecaAppTest {

    @Test
    public void shouldStartTheApplication() {
        BibliotecaApp bibliotecaApp = mock(BibliotecaApp.class);
        bibliotecaApp.start();
        Mockito.verify(bibliotecaApp, times(1)).start();
    }
}
