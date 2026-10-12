# Sử dụng Base Image JRE 17 siêu nhẹ trên nền tảng Alpine Linux
FROM eclipse-temurin:17-jre-alpine

# Thư mục làm việc trong container
WORKDIR /app

# Sao chép tệp JAR đã được Job test build và đóng gói
COPY build/libs/*.jar app.jar

# Khai báo cổng lắng nghe mặc định của Spring Boot
EXPOSE 8080

# Lệnh khởi chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
