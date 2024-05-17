package com.example.engineer.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class MachineRequest {
    private String serialNumber;
    private String inventoryNumber;
    private int machineType_id;
    private int functionalType_id;
    private int model_id;
    private int organization_id;
    private String dateOfRelease;
}
