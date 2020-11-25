# spring cloud demo
#--------------------------------  
cloud:  		    Hoxton.SR1  
boot:   		    2.2.2.RELEASE  
cloud alibaba:  2.1.0.RELEASE  
java:			      8  
maven:			    >=3.5  
mysql:			    >=5.7  
#--------------------------------  


# rabbitmq docker-compose
#--------------------------------
version: '3'  

services:  
  hawk_rabbit:  
    image: rabbitmq:management  
    ports:  
      - "5672:5672"  
      - "15672:15672"  
    environment:  
      - RABBITMQ_DEFAULT_USER=hawk  
      - RABBITMQ_DEFAULT_PASS=hawk  
    restart: always  
# ---------------------------------
# zipkin
#--------------------------------
version: '3'  

services:  
  hawk_zipkin:  
    image: openzipkin/zipkin  
    container_name: hawk_zipkin  
    ports:  
      - 9411:9411  
    restart: always  
#--------------------------------
