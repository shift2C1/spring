package com.pipichao.spring.core.aop.aspecj_support;

import java.util.Collection;

public interface Sample<T> {
    void sampleGenericMethod(T param);
    void sampleGenericCollectionMethod(Collection<T> param);
}
