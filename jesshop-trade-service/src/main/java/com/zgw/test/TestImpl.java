package com.zgw.test;

import org.springframework.stereotype.Service;

/**
 * Created by tommy on 17/5/26.
 */
@Service
public class TestImpl implements Test {
    @Override
    public void hello() {
        System.out.println("aadd hello");
    }
}
