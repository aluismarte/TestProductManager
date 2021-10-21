package org.aluismarte.test.auth.controller;

import org.aluismarte.test.auth.model.CreateProductRequest;
import org.aluismarte.test.auth.model.CreateProductResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by Aluis on 10/21/2021.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ProductControllerTest {

    private final String baseUrl = "http://localhost:8081/";

    @Test
    void login() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("scope", "read_profile_info");
        map.add("response_type", "code");
        map.add("client_id", "clientapp");
        map.add("username", "creator@aluis.com");
        map.add("password", "demo");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        String url = baseUrl + "oauth/authorize?client_id=clientapp&response_type=code&scope=read_profile_info";
//        String url = baseUrl + "login";

        System.out.println(url);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        System.out.println(response.getStatusCode());

    }


    @Test
    void listTest() {
        RestTemplate restTemplate = new RestTemplate();
        String forEntity = restTemplate.getForObject(baseUrl + "list", String.class);
        System.out.println(forEntity);
    }

    @Test
    void createProduct() {
        RestTemplate restTemplate = new RestTemplate();

        CreateProductRequest createProductRequest = new CreateProductRequest();
        createProductRequest.setName("Otro");
        createProductRequest.setPrice(20.0);

        ResponseEntity<CreateProductResponse> responseEntity = restTemplate.postForEntity(baseUrl + "create", createProductRequest, CreateProductResponse.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        CreateProductResponse createProductResponse = responseEntity.getBody();
        assertNotNull(createProductResponse);
    }

}