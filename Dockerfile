FROM openjdk:8
#-jdk-alpine
#за основу взята 8 версия джавы
# внешний порт, по которому наше приложение будет доступно извне
EXPOSE 8080
# указываем, где в нашем приложении лежит джарник
ARG JAR_FILE=target/spb-request.jar
# добавляем джарник в образ с именем
ADD ${JAR_FILE} spb-request.jar
# команда запуска джарника
ENTRYPOINT ["java","-jar","/spb-request.jar"]