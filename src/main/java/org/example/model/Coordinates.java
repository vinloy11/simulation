package org.example.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Coordinates {
    private int x;
    private int y;
}
