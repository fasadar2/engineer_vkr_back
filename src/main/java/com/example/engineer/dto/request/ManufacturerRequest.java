package com.example.engineer.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ManufacturerRequest {
    private String name;
    private int country_id;
}
