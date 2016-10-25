Feature: Landing Pages Campaigns

  Background:
    Given Back-end Administrator has opened Landing Pages module

  @debug
  Scenario: Add new campaign
    #And No campaign 'AutomationCampaign' is in the campaigns list
    When Back-end Administrator adds new campaign 'AutomationCampaign' with default settings
   	Then Back-end Administrator should save campaign 'AutomationCampaign' new settings
   	And Front-end User should see campaign 'AutomationCampaign' new settings