FROM openjdk
WORKDIR /app
COPY . .
WORKDIR /app/src/main/java
RUN ["javac", "Main.java"]
CMD ["java", "Main"]