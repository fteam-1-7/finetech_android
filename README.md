# finetech_android

![image](https://user-images.githubusercontent.com/104723328/203627869-5e886ec2-9096-4b8b-84c2-b3ff04354b2e.png)

FIREBASE AUTHENTICATION
A mobile payment that does the transfer of money from one currency to another currency rides can be summarized as followed....

User Authentication ==> deposit/withdraw money (credit/debit) ==> conversion of the money to the currency you want to transfer the money to (the rates changes daily) ==> transaction initiated to the beneficiary's account ==> transaction completed and beneficiary receives payment.

BACKGROUND
Technology is one of the liveliest exposure that have happened to man. It keeps looking for ways to make human's life easy.

Mobile Payment Platform is a P2P (person to person) transaction solution. It handles deposit/credit of money into the holder's account.

PROJECT COMPONENT
*Android Application
*Firebase: API & Authentication
*VM to host the Application
*Google Cloud Platform
*Stripe

**ANDROID APPLICATION
The Android Application is built and compiled by Kotlin. It will be deployed/hosted on a VM in our GCP environment. The application is an interface for the users (registered or new) to access his account.

The application has various interface that contains the sign up page, the login page, user's personal transaction page, and so on. Screenshots of the application interface will be shared below.

**Firebase: API & Authentication
Firebase is a Google Cloud Platform resource that handles authentication, troubleshooting and monitoring amongst others. The authentication integration of the Application to the firebase authentitication service is going to be implemented via .................

**Google Cloud Platform
No solution will exist independently off an infrastructure - private or cloud solution. Mobile Payment System will be hosted on pne of the best cloud solution - Google Cloud Platform (GCP). We will also host our CI/CD (Continuos integration and continuos deployment) model on GCP to facilitate a seamless integration/deployment of our solution to the resource hosting our solution.

**Stripe
