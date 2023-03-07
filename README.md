# 김대웅
#  박상채
#  홍서연
#
#

## Model
www.msaez.io/#/storming/e9c2e0dc3267d7467d074ea6dc9a3833

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd kafka
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services




See the README.md files inside the each microservices directory:

- order
- cafemanagement
- payment
- customermanagement
- dashboard


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- order
```
TODO: NEED orderId auto increase
http POST :8081/orders productId="10" qty="1" customerId="cdgri" amount="2" status="ordered" pickupTime="20230306150010" orderId="2" 

http GET :8081/orders	
```
- cafemanagement
```
 http GET :8082/orderManagements
```
- payment
```
 http GET :8083/pays
```
- customermanagement
```
 http GET :8084/pushMessages
```
- dashboard
```
TODO: how to use this service?
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

