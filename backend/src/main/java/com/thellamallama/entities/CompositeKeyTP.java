package com.thellamallama.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class CompositeKeyTP implements Serializable {
    private Long producto;
    private Long tienda;
}
