package com.KyoskTest.Kyosk.model.response;

import com.KyoskTest.Kyosk.model.shared.Metadata;
import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurationResponseModel {
    private String name;
    private Metadata metadata;
}