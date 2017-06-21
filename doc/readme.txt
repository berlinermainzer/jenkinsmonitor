Jenkins Monitor
==========================

- Set truststore by passing -Djavax.net.ssl.trustStore=<TRUSTSTORE_PATH> -Djavax.net.ssl.trustStorePassword=<PWD> to VM properties

- Jenkins URL is specified as property "monitor.url" but can be overwritten by passing it as commandline paramter:
  --monitor.url=https://jenkins.qa.ubuntu.com/view/All/api/json?pretty=true&tree=jobs[displayName,color]
The tree=jobs[displayName,color] parameter is important as we only expect displayName and color when deserializing the JSON result.

- The embedded Tomcat uses port 8080 per default but can be configured by passing another port as commandline paramter:
  --server.port=9009

Example commandline to monitor Ubuntu using local port 9009:
  java -Djavax.net.ssl.trustStore=<TRUSTSTORE_PATH> -Djavax.net.ssl.trustStorePassword=<PWD> -jar jenkinsmonitor-0.0.1-SNAPSHOT.war "--monitor.url=https://jenkins.qa.ubuntu.com/view/All/api/json?pretty=true&tree=jobs[displayName,color]" --server.port=9009

The JenkinsMonitor will then be reachable under
  http://localhost:9009/pages/index.xhtml

