## For this project the Riot API was used.
A project was created in order to be able to communicate microservices using `restTemplate`.

## Development environment.
[![IntelliJ IDEA](https://img.shields.io/badge/intelliJIDEA-black?style=for-the-badge&logo=openjdk)](https://github.com/JulianRivers)
[![Java](https://img.shields.io/badge/java-black?style=for-the-badge&logo=openjdk)](https://github.com/JulianRivers)
[![Springboot](https://img.shields.io/badge/springboot-black?style=for-the-badge&logo=springboot)](https://github.com/JulianRivers)

## Enpoint created
| Enpoint | Description |
| --- | --- |
| GET AccountPlayer | http://localhost:8080/account/{name-player} |
| GET LeagueEntry | http://localhost:8080/{name-player} |
| GET SummaryDamage | http://localhost:8080/summary-damage/{StartTimestamp} |
| GET lastMatch | http://localhost:8080/last-matches |

## Preview
- AccountPlayer  [name-player = Runas]
~~~
{
    "id": "JJXcXq2qyGm9Er5zDEWRjQLccPo8lSr0Dqxdc5EWTvApTA",
    "puuid": "s1lw082rabHOCW1iWjnAjucoYkXjdWNYNYt75gTSvb4EToi7ztUPckK_HTE0Y59wy88wwFY_GDQb8g",
    "name": "runas",
    "profileIconId": 4571,
    "summonerLevel": 67,
    "linkIcono": "http://ddragon.leagueoflegends.com/cdn/13.21.1/img/profileicon/4571.png"
}
~~~
