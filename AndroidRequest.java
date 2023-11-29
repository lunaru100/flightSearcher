package com.example.wyszukiwarka_lotow.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AndroidRequest {
    int id;
    String dest;
    int price;
}
