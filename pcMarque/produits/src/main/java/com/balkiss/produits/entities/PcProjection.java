package com.balkiss.produits.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomPc", types = { Pc.class })
public interface PcProjection {
public String getNomPc();
}
