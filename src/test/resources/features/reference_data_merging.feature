Feature: As the reference data system I need to receive instrument ref-data for different exchanges and present them to consumers
  The following assumptions are made:
  - There are multiple inbound instrument streams
  - Basic validation/ mapping of the inbound instrument 'message' has already been performed as part of deserialization (not included due to libs restriction)
  - An 'in-memory' publisher is sufficient for testing purposes
  - To simplify debugging/ testing, all scenarios are single-threaded unless explicitly stated otherwise
  - The system can be scaled-out Active/ Active with eventual consistency across the cluster (achieved via parallel instances that hold all state in memory)
  - Any load balancing/ fail-over would be the responsibility of the client and is outside the scope of this exercise

  To run this feature from within intelliJ use the 'RunBddTest' junit test

  Scenario: The application should publish nothing where there is no input
    Then the application publishes nothing internally

  Scenario: The application should publish the common representation of an LME instrument
    Given the LME instrument PB_03_2018:
      | Last Trading Date | Delivery Date | Market | Label              |
      | 15-03-2018        | 17-03-2018    | PB     | Lead 13 March 2018 |
    When LME publishes instrument PB_03_2018
    Then the application publishes the following instrument internally:
      | Last Trading Date | Delivery Date | Market | Label              | Tradable |
      | 15-03-2018        | 17-03-2018    | PB     | Lead 13 March 2018 | true     |

  Scenario: The application should publish multiple LME instruments
    Given the LME instrument PB_03_2018:
      | Last Trading Date | Delivery Date | Market | Label              |
      | 15-03-2018        | 17-03-2018    | PB     | Lead 13 March 2018 |
    And the LME instrument PB_04_2018:
      | Last Trading Date | Delivery Date | Market | Label              |
      | 16-03-2018        | 18-03-2018    | UK     | Lead 16 March 2018 |
    When LME publishes instrument PB_03_2018
    And LME publishes instrument PB_04_2018
    Then the application publishes the following instrument internally:
      | Last Trading Date | Delivery Date | Market | Label              | Tradable |
      | 15-03-2018        | 17-03-2018    | PB     | Lead 13 March 2018 | true     |
      | 16-03-2018        | 18-03-2018    | UK     | Lead 16 March 2018 | true     |

