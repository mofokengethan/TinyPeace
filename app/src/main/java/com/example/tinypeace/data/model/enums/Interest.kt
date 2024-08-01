package com.example.tinypeace.model.enums

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.SportsBaseball
import androidx.compose.material.icons.outlined.SportsBasketball
import androidx.compose.material.icons.outlined.SportsFootball
import androidx.compose.material.icons.outlined.SportsHandball
import androidx.compose.material.icons.outlined.SportsSoccer

// Entertainment, Activities, Airports, Sports

enum class Entertainment(val emoji: String, val description: String) {
    STAND_UP_COMEDY("🎤", "Stand-up Comedy"),
    DJ("🎧", "DJ"),
    MUSIC_PRODUCTION("🎶", "Music Production"),
    BARS_CLUBS("🎧", "Bars Clubs"),
    MOVIES("🎥", "Movies"),
    TV_SHOWS("📺", "TV Shows"),
    DOCUMENTARIES("🎥", "Documentaries"),
    ANIME("📺", "Anime"),
    CART00NS("📺", "Cartoons"),
    STREAMING("📺", "Cartoons"),
    CINEMA("🎬", "Cinema"),
    FILM_HISTORY("🎬", "Film History"),
    ACTING("🎭", "Acting"),
    DIRECTING("🎬", "Directing"),
    SCREENWRITING("📜", "Screenwriting"),
    EDITING("✂️", "Editing"),
    SOUNDTRACKS("🎶", "Soundtracks"),
    COMEDY("🎭", "Comedy"),
    DRAMA("🎭", "Drama"),
    ACTION("🎬", "Action"),
    ROMANCE("💖", "Romance"),
    THRILLER("🎬", "Thriller"),
    HORROR("👻", "Horror"),
    SCI_FI("🚀", "Science Fiction"),
    FANTASY("🦄", "Fantasy"),
    MYSTERY("🔍", "Mystery"),
    WESTERN("🤠", "Western"),
    MUSICALS("🎵", "Musicals"),
    SUSPENSE("🎬", "Suspense"),
    DOCUMENTARY_FILMS("🎥", "Documentary Films"),
    REALITY_TV("📺", "Reality TV"),
    TALENT_SHOWS("🎤", "Talent Shows"),
    GAME_SHOWS("🎮", "Game Shows"),
    SOAP_OPERAS("📺", "Soap Operas"),
    MOVIE_GENRES("🎬", "Movie Genres"),
    CELEBRITY_CULTURE("📸", "Celebrity Culture"),
    RED_CARPET("📸", "Red Carpet"),
    MOVIE_REVIEWS("📝", "Movie Reviews"),
    MOVIE_THEATRES("🎭", "Movie Theatres")
}
enum class Activities(val emoji: String, val description: String) {
    TRAVEL("✈️", "Travel"),
    READING("📚", "Reading"),
    WRITING("✍️", "Writing"),
    BEER("🍺", "Beer"),
    WINE("🍷", "Wine"),
    VINTAGE_COLLECTING("🧸", "Vintage & Collecting"),
    DIY("🛠️", "DIY"),
    VOLUNTEERING("🤝", "Volunteering"),
    HISTORIC_SITES("🏛️", "Historic Sites"),
    MUSEUMS("🖼️", "Museums"),
    LANDMARKS("🗽", "Landmarks"),
    TOURS("🚌", "Tours"),
    THEATERS("🎭", "Theaters"),
    CONCERTS("🎶", "Concerts"),
    FESTIVALS("🎉", "Festivals"),
    NIGHTLIFE("🌃", "Nightlife"),
    PARKS("🌳", "Parks"),
    BEACHES("🏖️", "Beaches"),
    HIKING("🥾", "Hiking"),
    ZOOS("🐘", "Zoos"),
    BOTANICAL_GARDENS("🌺", "Botanical Gardens"),
    SHOPPING("🛍️", "Shopping"),
    RESTAURANTS("🍽️", "Restaurants"),
    FOOD_MARKETS("🍎", "Food Markets"),
    STREET_FOOD("🌭", "Street Food"),
    ART_GALLERIES("🖌️", "Art Galleries"),
    CULTURAL_FESTIVALS("🎭", "Cultural Festivals"),
    THEATRE_AND_PERFORMING_ARTS("🎤", "Theatre and Performing Arts"),
    AMUSEMENT_PARKS("🎢", "Amusement Parks"),
    WATER_SPORTS("🏄", "Water Sports"),
    ADVENTURE_SPORTS("🧗", "Adventure Sports"),
    SCIENCE_CENTERS("🔬", "Science Centers"),
    LIBRARIES("📚", "Libraries"),
    UNIVERSITY("🎓", "University"),
    SPAS("💆", "Spas"),
    YOGA("🧘", "Yoga")
}

enum class TimeZones(val description: String) {
    EST( "Eastern"),
    CST("Central"),
    MST( "Mountain"),
    PST("Pacific")
}
enum class Airports(val timeZone: TimeZones, val code: String, val airportName: String) {
    // PST
    LAX(TimeZones.PST, "LAX", "Los Angeles International Airport"),
    SFO(TimeZones.PST, "SFO", "San Francisco International Airport"),
    SEA(TimeZones.PST, "SEA", "Seattle-Tacoma International Airport"),
    SAN(TimeZones.PST, "SAN", "San Diego International Airport"),
    LAS(TimeZones.PST, "LAS", "McCarran International Airport"),
    PDX(TimeZones.PST, "PDX", "Portland International Airport"),
    // MST
    DEN(TimeZones.MST, "DEN", "Denver International Airport"),
    PHX(TimeZones.MST, "PHX", "Phoenix Sky Harbor International Airport"),
    SLC(TimeZones.MST, "SLC", "Salt Lake City International Airport"),
    ABQ(TimeZones.MST, "ABQ", "Albuquerque International Sunport"),
    COS(TimeZones.MST, "COS", "Colorado Springs Airport"),
    // CST
    ORD(TimeZones.CST, "ORD", "O'Hare International Airport"),
    MDW(TimeZones.CST, "MDW", "Midway International Airport"),
    DFW(TimeZones.CST, "DFW", "Dallas/Fort Worth International Airport"),
    DAL(TimeZones.CST, "DAL", "Dallas Love Field"),
    IAH(TimeZones.CST, "IAH", "George Bush Intercontinental Airport"),
    HOU(TimeZones.CST, "HOU", "William P. Hobby Airport"),
    MSP(TimeZones.CST, "MSP", "Minneapolis-Saint Paul International Airport"),
    MCI(TimeZones.CST, "MCI", "Kansas City International Airport"),
    MSY(TimeZones.CST, "MSY", "Louis Armstrong New Orleans International Airport"),
    STL(TimeZones.CST, "STL", "St. Louis Lambert International Airport"),
    // EST
    JFK(TimeZones.EST, "JFK", "John F. Kennedy International Airport"),
    LGA(TimeZones.EST, "LGA", "LaGuardia Airport"),
    EWR(TimeZones.EST, "EWR", "Newark Liberty International Airport"),
    YYZ(TimeZones.EST, "YYZ", "Toronto Pearson International Airport"),
    YTZ(TimeZones.EST, "YTZ", "Billy Bishop Toronto City Airport"),
    YUL(TimeZones.EST, "YUL", "Montréal-Pierre Elliott Trudeau International Airport"),
    PHL(TimeZones.EST, "PHL", "Philadelphia International Airport"),
    BOS(TimeZones.EST, "BOS", "Logan International Airport"),
    IAD(TimeZones.EST, "IAD", "Washington Dulles International Airport"),
    DCA(TimeZones.EST, "DCA", "Ronald Reagan Washington National Airport"),
    BWI(TimeZones.EST, "BWI", "Baltimore/Washington International Thurgood Marshall Airport"),
    ATL(TimeZones.EST, "ATL", "Hartsfield-Jackson Atlanta International Airport"),
    MIA(TimeZones.EST, "MIA", "Miami International Airport"),
    CLE(TimeZones.EST, "CLE", "Cleveland Hopkins International Airport"),
    DTW(TimeZones.EST, "DTW", "Detroit Metropolitan Wayne County Airport")
}

// Sport
enum class SportsLeague(val emoji: String, val description: String) {
    MLB("⚾", "Major League Baseball"),
    NBA("🏀", "National Basketball Association"),
    NFL("🏈", "National Football League"),
    MLS("⚽", "Major League Soccer")
}
data class Team(val league: SportsLeague, val name: String)
enum class City(val timeZone: TimeZones, val teams: List<Team>) {
    ATLANTA(TimeZones.EST, listOf(
        Team(SportsLeague.NBA, "Hawks"),
        Team(SportsLeague.MLS, "United"),
        Team(SportsLeague.MLB, "Braves"),
        Team(SportsLeague.NFL, "Falcons")
    )),
    BOSTON(TimeZones.EST, listOf(
        Team(SportsLeague.NBA, "Celtics"),
        Team(SportsLeague.MLB, "Red Sox"),
        Team(SportsLeague.NFL, "Patriots")
    )),
    BROOKLYN(TimeZones.EST, listOf(Team(SportsLeague.NBA, "Nets"))),
    CHARLOTTE(TimeZones.EST, listOf(
        Team(SportsLeague.NBA, "Hornets"),
        Team(SportsLeague.NFL, "Panthers")
    )),
    CHICAGO(TimeZones.CST, listOf(
        Team(SportsLeague.NBA, "Bulls"),
        Team(SportsLeague.MLS, "Fire"),
        Team(SportsLeague.MLB, "Cubs"),
        Team(SportsLeague.MLB, "White Sox"),
        Team(SportsLeague.NFL, "Bears")
    )),
    CINCINNATI(TimeZones.EST, listOf(
        Team(SportsLeague.MLS, "FC Cincinnati"),
        Team(SportsLeague.MLB, "Reds"),
        Team(SportsLeague.NFL, "Bengals")
    )),
    CLEVELAND(TimeZones.EST, listOf(
        Team(SportsLeague.NBA, "Cavaliers"),
        Team(SportsLeague.MLB, "Guardians"),
        Team(SportsLeague.NFL, "Browns")
    )),
    DALLAS(TimeZones.CST, listOf(
        Team(SportsLeague.NBA, "Mavericks"),
        Team(SportsLeague.MLS, "FC Dallas"),
        Team(SportsLeague.MLB, "Rangers"),
        Team(SportsLeague.NFL, "Cowboys")
    )),
    DENVER(TimeZones.MST, listOf(
        Team(SportsLeague.NBA, "Nuggets"),
        Team(SportsLeague.MLS, "Rapids"),
        Team(SportsLeague.MLB, "Rockies"),
        Team(SportsLeague.NFL, "Broncos")
    )),
    DETROIT(TimeZones.EST, listOf(
        Team(SportsLeague.NBA, "Pistons"),
        Team(SportsLeague.MLB, "Tigers"),
        Team(SportsLeague.NFL, "Lions")
    )),
    GOLDEN_STATE(TimeZones.PST, listOf(Team(SportsLeague.NBA, "Warriors"))),
    HOUSTON(TimeZones.CST, listOf(
        Team(SportsLeague.NBA, "Rockets"),
        Team(SportsLeague.MLS, "Dynamo"),
        Team(SportsLeague.MLB, "Astros"),
        Team(SportsLeague.NFL, "Texans")
    )),
    INDIANAPOLIS(TimeZones.EST, listOf(
        Team(SportsLeague.NBA, "Pacers"),
        Team(SportsLeague.NFL, "Colts")
    )),
    LOS_ANGELES(TimeZones.PST, listOf(
        Team(SportsLeague.NBA, "Lakers"),
        Team(SportsLeague.NBA, "Clippers"),
        Team(SportsLeague.MLS, "Galaxy"),
        Team(SportsLeague.MLS, "LAFC"),
        Team(SportsLeague.MLB, "Dodgers"),
        Team(SportsLeague.MLB, "Angels"),
        Team(SportsLeague.NFL, "Rams"),
        Team(SportsLeague.NFL, "Chargers")
    )),
    MIAMI(TimeZones.EST, listOf(
        Team(SportsLeague.NBA, "Heat"),
        Team(SportsLeague.MLS, "Inter Miami"),
        Team(SportsLeague.MLB, "Marlins"),
        Team(SportsLeague.NFL, "Dolphins")
    )),
    MILWAUKEE(TimeZones.CST, listOf(
        Team(SportsLeague.NBA, "Bucks"),
        Team(SportsLeague.MLB, "Brewers")
    )),
    MINNESOTA(TimeZones.CST, listOf(
        Team(SportsLeague.NBA, "Timberwolves"),
        Team(SportsLeague.MLS, "Minnesota United"),
        Team(SportsLeague.MLB, "Twins"),
        Team(SportsLeague.NFL, "Vikings")
    )),
    MONTREAL(TimeZones.EST, listOf(Team(SportsLeague.MLS, "CF Montreal"))),
    NEW_ORLEANS(TimeZones.CST, listOf(
        Team(SportsLeague.NBA, "Pelicans"),
        Team(SportsLeague.NFL, "Saints")
    )),
    NEW_YORK(TimeZones.EST, listOf(
        Team(SportsLeague.NBA, "Knicks"),
        Team(SportsLeague.MLS, "New York City FC"),
        Team(SportsLeague.MLB, "Yankees"),
        Team(SportsLeague.MLB, "Mets"),
        Team(SportsLeague.NFL, "Giants"),
        Team(SportsLeague.NFL, "Jets")
    )),
    OKLAHOMA_CITY(TimeZones.CST, listOf(Team(SportsLeague.NBA, "Thunder"))),
    ORLANDO(TimeZones.EST, listOf(
        Team(SportsLeague.NBA, "Magic"),
        Team(SportsLeague.MLS, "Orlando City")
    )),
    PHILADELPHIA(TimeZones.EST, listOf(
        Team(SportsLeague.NBA, "76ers"),
        Team(SportsLeague.MLS, "Union"),
        Team(SportsLeague.MLB, "Phillies"),
        Team(SportsLeague.NFL, "Eagles")
    )),
    PORTLAND(TimeZones.PST, listOf(
        Team(SportsLeague.NBA, "Trail Blazers"),
        Team(SportsLeague.MLS, "Timbers")
    )),
    SACRAMENTO(TimeZones.PST, listOf(Team(SportsLeague.NBA, "Kings"))),
    SAN_ANTONIO(TimeZones.CST, listOf(Team(SportsLeague.NBA, "Spurs"))),
    TORONTO(TimeZones.EST, listOf(
        Team(SportsLeague.NBA, "Raptors"),
        Team(SportsLeague.MLS, "Toronto FC"),
        Team(SportsLeague.MLB, "Blue Jays")
    )),
    UTAH(TimeZones.MST, listOf(
        Team(SportsLeague.NBA, "Jazz"),
        Team(SportsLeague.MLS, "Real Salt Lake")
    )),
    VANCOUVER(TimeZones.PST, listOf(Team(SportsLeague.MLS, "Whitecaps FC"))),
    WASHINGTON(TimeZones.EST, listOf(
        Team(SportsLeague.NBA, "Wizards"),
        Team(SportsLeague.MLS, "D.C. United"),
        Team(SportsLeague.MLB, "Nationals"),
        Team(SportsLeague.NFL, "Commanders")
    )),
    ST_LOUIS(TimeZones.CST, listOf(Team(SportsLeague.MLB, "Cardinals"))),
    NASHVILLE(TimeZones.CST, listOf(
        Team(SportsLeague.MLS, "Nashville SC"),
        Team(SportsLeague.NFL, "Titans")
    ))
}