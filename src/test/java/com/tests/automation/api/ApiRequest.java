package com.tests.automation.api;

import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiRequest extends SpecBuilder {

	public static Response post(String endPoint, Map<String, Object> queryParams, Headers headers, Map<String, Object> formParams, Cookies cookies) {
		return given(getRequestSpec())
				.queryParams(queryParams)
				.headers(headers)
				.formParams(formParams)
				.cookies(cookies)
				.when()
				.post(endPoint)
				.then()
				.spec(getResponseSpec())
				.extract()
				.response();
	}

	public static Response get(String endPoint, Cookies cookies) {
        RequestSpecification request = given(getRequestSpec());

        if (cookies != null) {
            request.cookies(cookies);
        }

        return request
                .when()
                .get(endPoint)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
}
}
