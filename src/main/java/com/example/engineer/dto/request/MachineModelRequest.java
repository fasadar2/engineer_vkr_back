package com.example.engineer.dto.request;

import com.example.engineer.entity.Country;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class MachineModelRequest {
    private String modelName;
    private Integer manufacturer_id;
}
