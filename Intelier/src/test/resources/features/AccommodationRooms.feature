#INTELIER-5
Feature: Accommodation Rooms

  Background:
    Given Back-end Administrator has opened room module

  @issue:INTELIER-80
  Scenario: Add new room
    And No rooms are in the room list
    When Back-end Administrator adds new room 'AutomationRoom'
    Then Back-end Administrator should see room 'AutomationRoom' in the room list

  @issue:INTELIER-80
  Scenario: Cancel adding new room
    And No rooms are in the room list
	When Back-end Administrator cancel adding new room 'AutomationRoom'
	Then Back-end Administrator should not see room 'AutomationRoomCancel' in the room list

  @issue:INTELIER-80
  Scenario: Delete room
	And 'AutomationRoom' room is in the room list
    When Back-end Administrator deletes room 'AutomationRoom'
    Then Back-end Administrator should not see room 'AutomationRoom' in the room list

  @issue:INTELIER-41
  Scenario: Edit room - General settings
	And 'AutomationRoom' room is in the room list
	When Back-end Administrator edits room 'AutomationRoom' with default general settings
   	Then Back-end Administrator should save room 'AutomationRoom' new settings
   	
  @issue:INTELIER-81
  @debug
  Scenario: Edit room - Language-specific settings
	And 'AutomationRoom' room is in the room list
	When Back-end Administrator edits room 'AutomationRoom' with default language-specific settings
   	Then Back-end Administrator should save room 'AutomationRoom' new settings


