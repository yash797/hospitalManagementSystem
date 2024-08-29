package com.hsbc.hospitalmanagement.services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class CountryService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${countryUrl}")
    private String countryUrl;

    public List<String> getCountryNames() {
        ResponseEntity responseEntity = restTemplate.getForEntity(countryUrl, List.class);
        List<Object> countryList = (List<Object>) responseEntity.getBody();
//        countryList.stream().forEach(System.out::println);
        JSONObject jsonObject = null;
        List<String> countryNames = new ArrayList<>();
        for (Object object : countryList) {
            jsonObject = new JSONObject((Map) object);

//            To print the keys of the JSON object
//            for (String key : jsonObject.keySet()) {
//                System.out.println(key);
//            }
            countryNames.add(jsonObject.get("name").toString());
//            System.out.println(jsonObject.get("name"));
        }
        return countryNames;
    }

}
