package com.example.engineer.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ServiceRequestDTO {
    private int diagnostic_id;
    private String result_text;
    private String date_end;
    private int user_id;
}
