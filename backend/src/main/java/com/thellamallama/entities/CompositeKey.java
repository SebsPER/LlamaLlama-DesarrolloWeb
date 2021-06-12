package com.thellamallama.entities;

import java.io.Serializable;
import com.thellamallama.entities.Compra;
import com.thellamallama.entities.Producto;
import lombok.Data;

@Data
public class CompositeKey implements Serializable {
    private Long compra;
    private Long producto;
}