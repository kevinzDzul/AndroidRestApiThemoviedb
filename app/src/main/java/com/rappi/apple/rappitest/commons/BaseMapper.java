package com.rappi.apple.rappitest.commons;

public interface BaseMapper<A,B> {
    B mapFrom(A type);
}
