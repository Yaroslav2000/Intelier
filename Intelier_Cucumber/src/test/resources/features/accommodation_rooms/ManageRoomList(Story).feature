#INTELIER-80
Feature: Manage Room List (Story)
As an...
editorial user

I can...
manage a list of rooms within my property or organization

So that...
I can quickly view, sort and edit each room.

  Background:
    Given Back-end Administrator has opened Room module
  
  Scenario: Add new room
    And Should be able to add new room 'AutomationRoom'
#    When Back-end Administrator adds new room 'AutomationRoom'
#    Then Back-end Administrator should see room 'AutomationRoom' in the room list table

  Scenario: Edit room
  	And Should be able to edit room 'AutomationRoom' with default settings
#    When Back-end Administrator edits room 'AutomationRoom' with default settings
#    Then Back-end Administrator should save room 'AutomationRoom' new settings
    
  Scenario: Delete room
   	And Should be able to delete room 'AutomationRoom'
#    When Back-end Administrator deletes room 'AutomationRoom'
#    Then Back-end Administrator should not see room 'AutomationRoom' in the room list table
    