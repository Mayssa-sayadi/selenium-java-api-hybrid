#language: en
@users
Feature: Users API

  @get_users
  Scenario: Get all users
    When I send a GET request to "/users"
    Then the response status code should be 200


  @post_users
  Scenario: Create a post
    When I send a POST request to "/users"
    Then The response status code should be 201