Feature: Landing Pages Campaigns

  Background:
    Given Back-end Administrator has opened Landing Pages module

  @debug
  Scenario: Single-property, single-offer
    #And No campaign 'AutomationCampaign' is in the campaigns list
    When Back-end Administrator adds new single-property, single-offer 'AutomationCampaign' with default settings
   	Then Back-end Administrator should save campaign 'AutomationCampaign'
   	And Front-end User should see campaign 'AutomationCampaign' settings

  @debug
  Scenario: Single-property, multi-offer (5 offers)
    #And No campaign 'AutomationCampaign' is in the campaigns list
    When Back-end Administrator adds new single-property, multi-offer 'AutomationCampaign' with default settings
   	Then Back-end Administrator should save campaign 'AutomationCampaign'
   	And Front-end User should see campaign 'AutomationCampaign' settings

   	