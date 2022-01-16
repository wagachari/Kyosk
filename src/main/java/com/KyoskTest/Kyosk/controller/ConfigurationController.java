package com.KyoskTest.Kyosk.controller;

import com.KyoskTest.Kyosk.entity.Configuration;
import com.KyoskTest.Kyosk.model.request.ConfigurationRequestModel;
import com.KyoskTest.Kyosk.model.response.ConfigurationResponseModel;
import com.KyoskTest.Kyosk.service.ConfigurationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
public class ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;


    @GetMapping(value = "/configs", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<ConfigurationResponseModel>> List() {

        List<Configuration> configs = configurationService.getConfigs();


        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Type listType = new TypeToken<List<ConfigurationResponseModel>>() {
        }.getType();
        List<ConfigurationResponseModel> configurationDTOs = modelMapper.map(configs, listType);

        return ResponseEntity.status(HttpStatus.OK).body(configurationDTOs);
    }

    @PostMapping(value = "/configs", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ConfigurationResponseModel> Create(@RequestBody ConfigurationRequestModel configs) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Configuration configuration = modelMapper.map(configs, Configuration.class);
        Configuration newConfiguration = configurationService.createConfiguration(configuration);
        ConfigurationResponseModel responseBody = modelMapper.map(newConfiguration, ConfigurationResponseModel.class);

        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }


    @GetMapping(value = "/configs/{name}",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<ConfigurationResponseModel> Get(@PathVariable String name) {
        Configuration response = configurationService.getConfigurationByName(name);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
//        Type listType = new TypeToken<List<ConfigurationResponseModel>>(){}.getType();
        ConfigurationResponseModel configurationDTOs = modelMapper.map(response, ConfigurationResponseModel.class);

        return ResponseEntity.status(HttpStatus.OK).body(configurationDTOs);
    }

    @PutMapping(value = "/configs/{name}",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<ConfigurationResponseModel> Update(@RequestBody ConfigurationRequestModel configs, @PathVariable String name) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Configuration configuration = modelMapper.map(configs, Configuration.class);
        Configuration newConfigurations = configurationService.updateConfiguration(name,configuration);
        ConfigurationResponseModel responseBody = modelMapper.map(newConfigurations, ConfigurationResponseModel.class);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @DeleteMapping(value = "/configs/{name}",
            produces = "application/json")
    public String Delete(@PathVariable String name) {
        return name;
    }

    @GetMapping("/search")
    @ResponseBody
    public ResponseEntity<List<ConfigurationResponseModel>> Query(@RequestParam HashMap<String, String> metadata) {
        String metadataSearchParams = (String) (metadata.keySet().toArray())[0];

        List<Configuration> configs;

        if (metadataSearchParams.equalsIgnoreCase("metadata.monitoring.enabled")) {
            configs = configurationService.getConfigurationByMonitoringEnabled(metadata.get(metadataSearchParams));
        } else if (metadataSearchParams.equalsIgnoreCase("metadata.limits.cpu.enabled")) {
            configs = configurationService.getConfigurationByCpuEnabled(metadata.get(metadataSearchParams));
        } else if (metadataSearchParams.equalsIgnoreCase("metadata.limits.cpu.value")) {
            configs = configurationService.getConfigurationByCpuValue(metadata.get(metadataSearchParams));
        } else {
            configs = configurationService.getConfigs();
        }
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Type listType = new TypeToken<List<ConfigurationResponseModel>>() {
        }.getType();
        List<ConfigurationResponseModel> configurationDTOs = modelMapper.map(configs, listType);

        return ResponseEntity.status(HttpStatus.OK).body(configurationDTOs);
    }


}
