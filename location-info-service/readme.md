# Australia Post Location Service

This project facilitate 3 springboot REST apis to inquire suburb by passing post code, post code by passing suburb 
and secure api to add suburb and post code combination

## Getting Started

[These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 
See deployment for notes on how to deploy the project on a live system.]

### Prerequists

```
JDK 1.8.0
Maven 3.6.1
IntelliJ IDEA CE 2019
Putty / SSH client
Github access
```

### My local workspaces

Following are the local workspaces I have worked in windows and mac environment 
```
C:\Users\devapriya\Documents\Personal\austpost-info-service\location-info-service
/dbherath/Development/workspace/intellij~workspace/austpost-info-service/location-info-service
```

### Steps of project creation

Use following steps create Spring boot REST API application and build it using maven

```
1. Created new repository call <austpost-info-service> under github account <devapriyabandara>
    https://github.com/devapriyabandara/austpost-info-service
2. Created new springboot application with web dependencies call <location-info-service>
3. Import <location-info-service> project into intellij-idea CE as a maven project
4. Create simple REST api to accept string parameter as a name and return with "Hello <input parameter>" message
5. Write Unit test scripts and perform unit testing - PENDING
6. Set application server port to 8085 to avoid any conflicts with default tomcat port
7. Test the application in local environment
8. Make changes in pom.xml to support generation of executable jar file
9. Run "mvn clean install" inside <location-info-service> folder to get the
    ex: generated executable jar will find in target directory <location-info-service-0.0.1-SNAPSHOT.jar>
```

### AWS environment preparation

Use following steps create AWS EC2 instance, S3 bucket, IAM role, policy and Security Group, etc

```
1. Create S3 bucket with butcket name <ausipostspringbootprojects>
2. Upload <location-info-service-0.0.1-SNAPSHOT.jar> jar file into S3 bucket
3. Grant public access to S3 bucket and <location-info-service-0.0.1-SNAPSHOT.jar> jar file using ACL option under 
   Permissions tab
4. Create new EC2 IAM role & policy for S3 as <ausiposts3access>
   ex: https://docs.databricks.com/administration-guide/cloud-configurations/aws/iam-roles.html
5. Create Security Group <ausipostapipublicaccess> and open TCP port 8085 for inbound traffic
6. Create new EC2 instance <ausipostspringbootprojects> with Amazon Linux AMI 2018.03.0 (HVM)
7. Attach IAM role <ausiposts3access> to this EC2 instance
8. Attach previously created Security Group <ausipostapipublicaccess> to this EC2 instance
9. Generate a key pair with name <ausipostspringbootprojects> and download it to local pc <ausipostspringbootprojects.pem>.
10. Review and complete EC2 instance creation.
11. AWS RDS MySQL DB instance create to host the sample data base <locationdb>
    ex : url=jdbc:mysql://mydbinstance.ce9thc9invqv.ap-southeast-2.rds.amazonaws.com:3306/locationsdb
         user=root
         password=mydbinstance
12. Open up the security groups and change the inbound traffic to allow all traffic for RDS instance

```

### Deployment

Use following steps to deploy springboot REST api into AWS EC2 environment and start it

```
1. Use downloaded <ausipostspringbootprojects.pem> key pair to generate private PPK for putty in order to connect to
   AWS EC2 environment through SSH
2. Using following command connect to EC2 instance
   ssh -i ausipostspringbootprojects.pem ec2-user@ec2-13-55-199-102.ap-southeast-2.compute.amazonaws.com
3. Ensure Java 8 installed in EC2 instance and remove Java 7
   sudo yum install java-1.8.0
   sudo yum remove java-1.7.0-openjdk
4. Copy <location-info-service-0.0.1-SNAPSHOT.jar> jar file from S3 bucket to EC2 instance using following command
   wget https://s3-ap-southeast-2.amazonaws.com/ausipostspringbootprojects/location-info-service-0.0.1-SNAPSHOT.jar
5. Start Application in background using following command 
   java -jar location-info-service-0.0.1-SNAPSHOT.jar &
```

#### ARN
arn:aws:iam::609951387919:instance-profile/ausiposts3access
arn:aws:iam::609951387919:role/ausiposts3access
