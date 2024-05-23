package com.example.engineer.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ReturnWithoutProblemRequestDTO {
    private int diagnostic_id;
    private String result_text;

}
