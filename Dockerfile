FROM eclipse-temurin:21
LABEL authors="anais.bonin"
ADD square_games/target/square_games-0.0.1-SNAPSHOT.jar square_games-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "square_games-0.0.1-SNAPSHOT.jar"]