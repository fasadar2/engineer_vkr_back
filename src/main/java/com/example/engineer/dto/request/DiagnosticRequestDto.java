package com.example.engineer.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class DiagnosticRequestDto {
    private int machine_id;
    private int user_id;
    private String date_end;
}
