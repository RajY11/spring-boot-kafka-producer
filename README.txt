Download Kafka .tar file from official website

First we have to edit sever.prop , zookeeper.prop files as needed.

start zookeeper as follows

>zookeeper-server-start.bat ./config/zookeeper.prop

start kafka as follows

>kafka-server-start.bat ./config/server.prop



Kafka topic creation through cmd line
>kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic TestTopic

To check list of topics available


>kafka-topics.bat --list --zookeeper localhost:2181

To create producer

>kafka-console-producer.bat --broker-list localhost:9092 --topic TestTopic

To create Consumer

>kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic TestTopic --from-beginning