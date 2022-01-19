package com.KyoskTest.Kyosk.entity;
import lombok.*;

import javax.persistence.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name= "configs")
public class Configuration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long Id;

    public String name;
    public String monitoringEnabled;
    public String  cpuEnabled;
    public String cpuValue;

}
