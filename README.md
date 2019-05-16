# SILVERSNUG

### Introduction
University Name: http://www.sjsu.edu/</br>
Students: </br>
[Anuradha Rajashekar](https://www.linkedin.com/in/anu-rajashekar-4b950092/)</br>
[Ashwini Shankar Narayan](https://www.linkedin.com/in/ashwinisnv/)</br>
[Sindhu Goudru Patil Shivanandappa](https://www.linkedin.com/in/sindhu-goudru-shivan-patil-09622181/)</br>
[Nidhi Jamar](https://www.linkedin.com/in/nidhijamar/)</br>

### Project Problem Statement:
With the progress of ageing society, more elderly people are living alone at home.  Due to work, school factors and social life of younger generation, they are not always available at home to take care of elders. With growing age, most elderly people experience physical weakness along with functional and cognitive decline that impacts quality of life and the independence of elderly people by increasing their dependence on caregivers or family members. 

### Proposed Solution:
The Silver Snug mobile application has one important feature called smart alerting system which is machine learning based. It acts as an alerting system to the caretakers of the elderly people in case of emergencies. Emergency voice panic detection, Emergency Panic Button and fall detection comes under this feature.
If there is any robbery or attack or any emergency health issue when elderly people are alone at home, emergency voice panic detection system identifies the emergency situation and dials the emergency contact number. This way, the elderly people are saved from dangerous situations. 
The Silver Snug mobile application has an emergency panic button integrated with it. Whenever elderly people are in emergency situations or dangerous situations and if they press the panic button, call will be dialed to the emergency contact number. This smart alerting feature in the mobile application ensures security and comfort to elderly people living alone at home.

### Architecture Diagram

<br/>![AWS Component Architecture](https://user-images.githubusercontent.com/31361652/57819204-4754e580-773c-11e9-8e0e-69f507f0f19b.png)<br/>

### Panic Detection Architecture Diagram
<br>![image](https://user-images.githubusercontent.com/31361652/57819622-2db49d80-773e-11e9-93d8-df59c6691b67.png)<br/>


Resources to be configured on AWS:
1. EC2
2. S3
3. Amazon Kinesis Stream
5. Amazon RDS
7. Cloudwatch, SQS, SES and SNS

Configuration/External Interfaces
Below are the software dependencies for the features:
1.	Microphone enabled smart phone
2.	Tensor flow
3. Tensor Flow lite
4. Android API level 26 or above
5.	Android Volley 
6. Java Spring
