FROM openjdk:18
WORKDIR /app
COPY ./target/Home_Loan_System-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "Home_Loan_System-0.0.1-SNAPSHOT.jar"]