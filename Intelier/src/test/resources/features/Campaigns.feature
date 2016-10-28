Feature: Landing Pages Campaigns

  Background:
    Given Back-end Administrator has opened Landing Pages module

  @debug
  Scenario: Single-property, Single-offer campaign
    #And No campaign 'AutomationCampaign' is in the campaigns list
    When Back-end Administrator adds new single-property, single-offer campaign 'AutomationCampaign' with default settings
   	Then Back-end Administrator should save campaign 'AutomationCampaign'
   	And Front-end User should see campaign 'AutomationCampaign' settings