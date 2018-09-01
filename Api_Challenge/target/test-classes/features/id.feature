Feature: id
  As a user
  I want to search songs by id
  so that i can see which song belong to an id

  Background:
    Given that I want to find a song by id

  @HappyPath
  Scenario Outline: Song request from existing ID "<ID>"
    When I request the song with the id "<ID>"
    Then I can see the song with the name "<name>"
  Examples:
    |ID| name|
    | 1 | Chemical Warfare     |
    | 2 | Animal               |
    | 3 | All Gone Dead        |
    | 4 | Fear Of God          |
    | 5 | Punks Not Dead       |
    | 6 | Three Strikes        |
    | 7 | Fight For Your Right |
    | 8 |  Oodles Of O's       |
    | 9 | Gangsta Gangsta      |
    | 10 | 911 Is A Joke       |
    | 11 | Fack                |
    | 12 | The Calling         |


    @SadPath
    Scenario Outline: Song request from not existing ID "<ID>"
      When I request the song with the id "<ID>"
      Then I can not see the song that belong to that id
      Examples:
        |ID|
        | 0 |
        | 13 |

