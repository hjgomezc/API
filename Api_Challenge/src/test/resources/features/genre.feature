Feature: genre
  As a user
  I want to search the song's by genre
  so that I can know the songs that belong to a genre

  Background:
    Given that I want to filter the songs by genre


  @HappyPath
  Scenario Outline: Songs from existent genre

    When I request to see the "<genres>" songs
    Then I can see the songs that belong to this genre

    Examples:
      | genres  |
      | punk    |
      | Hip Hop |
      | Punk    |

  @SadPath
  Scenario Outline: Songs from non existent genre
    When I request to see the "<genres>" songs
    Then I can see that there are no songs that belong to this genre

    Examples:
      | genres |
      | rock   |
      | rap    |


