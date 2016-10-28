#INTELIER-5
Feature: Accommodation Rooms

  Background:
    Given Back-end Administrator has opened Room module

  @issue:INTELIER-80
  Scenario: Add new room
    And No rooms are in the room list
    When Back-end Administrator adds new room 'AutomationRoom'
    Then Back-end Administrator should see room 'AutomationRoom' in the room list

  @issue:INTELIER-80
  Scenario: Delete room
	And Room 'AutomationRoom' is in the room list
    When Back-end Administrator deletes room 'AutomationRoom'
    Then Back-end Administrator should not see room 'AutomationRoom' in the room list

  @issue:INTELIER-80
  Scenario: Cancel adding new room
  	And No rooms are in the room list
	When Back-end Administrator cancel adding new room 'AutomationRoomCancel'
	Then Back-end Administrator should not see room 'AutomationRoomCancel' in the room list

  @issue:INTELIER-80
  Scenario: Search room
	And Room 'AutomationRoom' is in the room list
	When Back-end Administrator searches for room 'AutomationRoom'
   	Then Back-end Administrator should see room 'AutomationRoom' in the room list
   	
  @issue:INTELIER-41
  @issue:INTELIER-81
  @debug
    Scenario: Edit room
	And Room 'AutomationRoom' is in the room list
	When Back-end Administrator edits room 'AutomationRoom' with default settings "1"
   	Then Back-end Administrator should save room 'AutomationRoom'
   	And Front-end User should see room 'AutomationRoom' settings

#   Scenario Outline: Edit room
#	And Room 'AutomationRoom' is in the room list
#	When Back-end Administrator edits room 'AutomationRoom' with default settings "<test-data>"
#   	Then Back-end Administrator should save room 'AutomationRoom' settings
#   	And Front-end User should see room 'AutomationRoom' settings
#
#  Examples:
#  |test-data|
#  |1|
#  |2|
   	
  @issue:INTELIER-80
   	Scenario: Sorting rooms
   	And No rooms are in the room list
   	When Back-end Administrator adds new room 'AutomationSortTest1'
   	And Back-end Administrator adds new room 'AutomationSortTest2'
   	And Back-end Administrator drag-and-drop room 'AutomationSortTest2' to room 'AutomationSortTest1'
   	Then Back-end Administrator should see room 'AutomationSortTest2' first in the room list
   	
  @issue:INTELIER-82
   	Scenario: Edit Room module settings for English language
   	When Back-end Administrator edits Room module settings for English language with default parameters
   	Then Back-end Administrator should save Room module parameters
   	   	
