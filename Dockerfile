FROM tomcat
WORKDIR /usr/local/tomcat/
ENV DB_NAME lastmileangles 
ENV DB_SERVER localhost 
ENV DB_PORT 3306
ENV DB_USER devops 
ENV DB_PASS redhat123
COPY tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
COPY context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml
RUN chmod 777 /usr/local/tomcat/webapps
COPY target/services-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/lastmileangles.war
EXPOSE 8081 
RUN sh /usr/local/tomcat/bin/startup.sh