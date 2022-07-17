# spring cloud config server 
* We need to add `spring-boot-starter-actuator`  and `spring-cloud-config-server` dependency for spring cloud config server.
* Then we need to annotate main application with `@EnableConfigServer`
* Then We have to create the git repository for config server. I have created  `cloud-config-props` for configuration.
* Once we add the configuration data in application.properties or application.yaml we can check git config properties data using endpoint as {application}/{profile}/{label}:
    > http://localhost:8090/config-server/default
  
* Once we add the configuration to the configClient bootstrap.yaml with config url and profile we can access the configServer data with git config properties using url:
  > http://localhost:8081/info
  
* The profile is use to change the different configuration from prod or dev or other environment. If we don't specify the profile it will take default.
* If we change on the `cloud-config-props` it must update the data in runtime but it will not happen automatically. To do automatically update the data in runtime we can do by 2 ways:
  1. @ConfiguraionProperties -  /refresh[POST]
  2. @Value - /refresh[POST]+@RefreshScope(per class)
  
* We have to include refresh in actuator endpoint in bootstrap.yaml
* When we do post method on `http://localhost:8081/actuator/refresh` it will show which data are changed in config props. 
* For actuators :
  > http://localhost:8081/actuator
### Difference between bootstrap.yml and application.yml
* bootstrap.yml is loaded before application.yml.
* It is typically used for the following:
  1. When using Spring Cloud Config Server, you should specify spring.application.name and spring.cloud.config.server.git.uri inside bootstrap.yml
  2. Some encryption/decryption information

* Technically, bootstrap.yml is loaded by a parent Spring ApplicationContext. That parent ApplicationContext is loaded before the one that uses application.yml.