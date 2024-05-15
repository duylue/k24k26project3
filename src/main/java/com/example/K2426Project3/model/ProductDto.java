package com.example.K2426Project3.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private int pid;
    private float price;
    private int cid;
    private String pname;
    private String cname;
}
