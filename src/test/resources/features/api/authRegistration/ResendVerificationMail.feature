Feature: API - Register as a direct user

  As a new user
  I want to get regsitered on marketcube
  but i after registration i want to resend resend verification mail link
  So that I am able to access the platform and manage my inventory

  Scenario: New Vendor wants to resend verification mail link
    When User request to get registered into the system
      |email    | password      |
      |user+    | 123456789     |
    Then User should be registered successfully into the system
    When New Vendor request to get registered into the system by resend verification mail link
      |  email         |
      |                |
    Then New Vendor should get message as a Mail Sent Successfully.