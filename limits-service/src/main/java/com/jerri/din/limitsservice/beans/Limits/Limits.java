package com.jerri.din.limitsservice.beans.Limits;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Limits {
    private int minimum;
    private int maximum;

}
