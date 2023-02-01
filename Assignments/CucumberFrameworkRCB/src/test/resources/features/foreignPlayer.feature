Feature: Validation of the Team

  Scenario: Only four foreign player
    Given A file in Json Fromat with players details
    When I check the players country
    Then there should be only 4 foreign player
    
  
  Scenario: Atleast one Wicketkeeper
    Given A file in Json Fromat with players details
    When I check the players role
    Then there is atleast one wicketkeeper

    