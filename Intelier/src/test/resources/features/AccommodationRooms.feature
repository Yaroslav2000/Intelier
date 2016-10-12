#INTELIER-5
Feature: Accommodation Rooms

  Background:
    Given Back-end Administrator has opened room module

  @issue:INTELIER-80
  Scenario: Add new room
    And No rooms are in the room list
    When Back-end Administrator adds new room 'AutomationRoom'
    Then Back-end Administrator should see room 'AutomationRoom' in the room list
    #And Front-end User should see room 'AutomationRoom' on the Rooms Page
	#Note: just adding a room into the room list is not enough, more actions have to be done before we can see the room of the web-site, TBD

  @issue:INTELIER-80
  Scenario: Cancel adding new room
    And No rooms are in the room list
	When Back-end Administrator cancel adding new room 'AutomationRoom'
	Then Back-end Administrator should not see room 'AutomationRoomCancel' in the room list

  @issue:INTELIER-80
  Scenario: Delete room
	And Room 'AutomationRoom' is in the room list
    When Back-end Administrator deletes room 'AutomationRoom'
    Then Back-end Administrator should not see room 'AutomationRoom' in the room list

  @issue:INTELIER-41
  Scenario: Edit room - General settings
	And Room 'AutomationRoom' is in the room list
	When Back-end Administrator edits room 'AutomationRoom' with default general settings
	#Note: the default settings TBD
   	Then Back-end Administrator should save room 'AutomationRoom' new settings
   	
  @issue:INTELIER-81
  Scenario: Edit room - Language-specific settings
	And Room 'AutomationRoom' is in the room list
	When Back-end Administrator edits room 'AutomationRoom' with default language-specific settings
	#Note: the default settings TBD
   	Then Back-end Administrator should save room 'AutomationRoom' new settings

  @issue:INTELIER-80
  Scenario: Search Room
	And Room 'AutomationRoom' is in the room list
	When Back-end Administrator searches for room 'AutomationRoom'
   	Then Back-end Administrator should see room 'AutomationRoom' in the room list
   	
  @issue:INTELIER-80
   	Scenario: Sorting rooms
   	And No rooms are in the room list
   	When Back-end Administrator adds new room 'AutomationSortTest1'
   	And Back-end Administrator adds new room 'AutomationSortTest2'
   	And Back-end Administrator drag-and-drop room 'AutomationSortTest2' to room 'AutomationSortTest1'
   	Then Back-end Administrator should see room 'AutomationSortTest2' first in the room list
   	
   	
   	
   	
   	
   	
