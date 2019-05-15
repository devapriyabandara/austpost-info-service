#my local workspace

#AWS S3 bucket details
#ausipostspringbootprojects

#ARN
arn:aws:iam::609951387919:instance-profile/ausiposts3access
arn:aws:iam::609951387919:role/ausiposts3access

#security key for EC2 instance
ausipostspringbootprojects

#Start up EC2 instance
ssh -i ausipostspringbootprojects.pem ec2-user@ec2-13-55-199-102.ap-southeast-2.compute.amazonaws.com

#Jar path in S3
#make S3 bucket & Jar file public by granting access to public
https://s3-ap-southeast-2.amazonaws.com/ausipostspringbootprojects/location-info-service-0.0.1-SNAPSHOT.jar